package covers1624.legacyfarms.tile.planter;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyReceiver;
import covers1624.legacyfarms.blueprint.StructureBlueprint;
import covers1624.legacyfarms.blueprint.StructureConstruction;
import covers1624.legacyfarms.crop.ICropProvider;
import covers1624.legacyfarms.handler.ConfigurationHandler;
import covers1624.legacyfarms.tile.TileInventory;
import covers1624.legacyfarms.utils.BlockUtils;
import covers1624.lib.util.BlockPosition;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestry.core.EnumErrorCode;
import forestry.core.delegates.AccessHandler;
import forestry.core.interfaces.IAccessHandler;
import forestry.core.interfaces.IRestrictedAccessTile;
import forestry.core.utils.EnumAccess;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;

public abstract class TilePlanter extends TileInventory implements IRestrictedAccessTile, IEnergyReceiver {

	// / CONSTANTS
	public static final short SLOT_SOIL_1 = 0;
	public static final short SLOT_GERMLING_1 = 4;
	public static final short SLOT_WASTE_1 = 8;
	public static final short SLOT_COUNT_PART = 4;

	// Blueptint stuff
	public StructureBlueprint site;
	public BlockPosition siteOffset;
	public StructureBlueprint soil;
	public BlockPosition soilOffset;
	public StructureBlueprint plantation;
	public BlockPosition plantationOffset;

	protected StructureConstruction templateArboretum;
	protected StructureConstruction templateSoil;
	protected StructureConstruction templateWater; // carbon copy of
	// templateSoil
	protected StructureConstruction templatePlantation;

	protected boolean requiresSoil = true;
	protected boolean requiresGermling = false;

	public ItemStack validSoil; // Block or item that can be used to create the ground to plant on
	public ItemStack validGround; // Block that can be planted on
	public ItemStack validWaste; // Block that is waste to be collected
	public ItemStack validDisposal; // Block that is put into inventory when waste is collected

	protected boolean isCleared = false; // Whether the arboretum area has been cleared.
	protected boolean isUnbroken = false; // Whether the arboretum has already been fully built

	private final AccessHandler accessHandler = new AccessHandler(this);

	protected ArrayList<ICropProvider> cropProviders = new ArrayList<ICropProvider>();

	private EnergyStorage energyStorage = new EnergyStorage(ConfigurationHandler.planterMaxRF);

	public TilePlanter() {
		super();
	}

	public TilePlanter(ICropProvider provider) {
		super();
		cropProviders.add(provider);
	}

	public TilePlanter(ArrayList<ICropProvider> providers) {
		super();
		for (ICropProvider provider : providers) {
			cropProviders.add(provider);
		}
	}

	@Override
	public IAccessHandler getAccessHandler() {
		return accessHandler;
	}

	@Override
	public ChunkCoordinates getCoordinates() {
		return new ChunkCoordinates(xCoord, yCoord, zCoord);
	}

	@Override
	public void onSwitchAccess(EnumAccess oldAccess, EnumAccess newAccess) {
		if (oldAccess == EnumAccess.SHARED || newAccess == EnumAccess.SHARED) {
			// Pipes
			worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, blockType);
			markDirty();
		}
	}

	@Override
	public void updateEntity() {
		if (worldObj.isRemote) {
			return;
		}
		if (ConfigurationHandler.planterUseRF) {
			if (energyStorage.getEnergyStored() >= 30) {
				if (doWork()) {
					energyStorage.extractEnergy(30, false);
				} else {
					energyStorage.extractEnergy(5, false);
				}
			}
		} else {
			doWork();
		}
		isInited = true;
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		isCleared = tagCompound.getBoolean("IsCleared");
		isUnbroken = tagCompound.getBoolean("IsBuilt");
		if (inventory != null) {
			inventory.readFromNBT(tagCompound);
		}
		if (accessHandler != null) {
			accessHandler.readFromNBT(tagCompound);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		tagCompound.setBoolean("IsCleared", isCleared);
		tagCompound.setBoolean("IsBuilt", isUnbroken);
		if (inventory != null) {
			inventory.writeToNBT(tagCompound);
		}
		if (accessHandler != null) {
			accessHandler.writeToNBT(tagCompound);
		}
	}

	@Override
	public void readNetData(NBTTagCompound tagCompound) {
		super.readNetData(tagCompound);

		isCleared = tagCompound.getBoolean("IsCleared");
		isUnbroken = tagCompound.getBoolean("IsBuilt");

		inventory.readFromNBT(tagCompound);

		if (tagCompound.hasKey("TemplateArboretum")) {
			templateArboretum = new StructureConstruction();
			NBTTagList nbtTagListStructure = tagCompound.getTagList("TemplateArboretum", 10);
			templateArboretum.readFromNBT(nbtTagListStructure.getCompoundTagAt(0));
		}
		if (tagCompound.hasKey("TemplateSoil")) {
			templateSoil = new StructureConstruction();
			templateWater = new StructureConstruction();
			NBTTagList nbtTagListStructure = tagCompound.getTagList("TemplateSoil", 10);
			templateSoil.readFromNBT(nbtTagListStructure.getCompoundTagAt(0));
			templateWater.readFromNBT(nbtTagListStructure.getCompoundTagAt(0));
		}
		if (tagCompound.hasKey("TemplatePlantation")) {
			templatePlantation = new StructureConstruction();
			NBTTagList nbtTagListStructure = tagCompound.getTagList("TemplatePlantation", 10);
			templatePlantation.readFromNBT(nbtTagListStructure.getCompoundTagAt(0));
		}
	}

	@Override
	public void writeNetData(NBTTagCompound tagCompound) {
		super.writeNetData(tagCompound);

		tagCompound.setBoolean("IsCleared", isCleared);
		tagCompound.setBoolean("IsBuilt", isUnbroken);

		inventory.writeToNBT(tagCompound);

		NBTTagList nbttaglistStructure;
		NBTTagCompound nbttagcompoundStructure;
		if (templateArboretum != null) {
			nbttaglistStructure = new NBTTagList();
			nbttagcompoundStructure = new NBTTagCompound();
			templateArboretum.writeToNBT(nbttagcompoundStructure);
			nbttaglistStructure.appendTag(nbttagcompoundStructure);
			tagCompound.setTag("TemplateArboretum", nbttaglistStructure);
		}

		if (templateSoil != null) {
			nbttaglistStructure = new NBTTagList();
			nbttagcompoundStructure = new NBTTagCompound();
			templateSoil.writeToNBT(nbttagcompoundStructure);
			nbttaglistStructure.appendTag(nbttagcompoundStructure);
			tagCompound.setTag("TemplateSoil", nbttaglistStructure);
		}

		if (templatePlantation != null) {
			nbttaglistStructure = new NBTTagList();
			nbttagcompoundStructure = new NBTTagCompound();
			templatePlantation.writeToNBT(nbttagcompoundStructure);
			nbttaglistStructure.appendTag(nbttagcompoundStructure);
			tagCompound.setTag("TemplatePlantation", nbttaglistStructure);
		}
	}

	public boolean hasGermlingBySeed(ItemStack germling) {
		for (ICropProvider provider : cropProviders) {
			if (provider.isGermling(germling)) {
				return true;
			}
		}
		return false;
	}

	private ICropProvider getCropProvider(ItemStack germling) {
		for (ICropProvider provider : cropProviders) {
			if (provider.isGermling(germling)) {
				return provider;
			}
		}
		return null;
	}

	protected boolean isSoilSlot(int i) {
		return i < 4;
	}

	protected boolean isGermlingSlot(int i) {
		return i >= 4 || i < 8;
	}

	protected boolean isDisposalSlot(int i) {
		return i >= 8;
	}

	/**
	 * Get a valid soil stack.
	 *
	 * @return id of the slot if available. -1 otherwise.
	 */
	protected int getSoilStack() {
		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			if (!isSoilSlot(i)) {
				continue;
			}

			if (inventory.getStackInSlot(i) == null) {
				continue;
			}

			if (inventory.getStackInSlot(i).isItemEqual(validSoil)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Get a valid germling stack.
	 *
	 * @return id of the slot if available. -1 otherwise.
	 */
	protected int getGermlingStack() {
		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			if (isGermlingStack(i)) {
				return i;
			}
		}

		return -1;
	}

	protected boolean isGermlingStack(int i) {
		return isGermlingSlot(i) && inventory.getStackInSlot(i) != null && hasGermlingBySeed(inventory.getStackInSlot(i));
	}

	/**
	 * Get a valid waste stack.
	 *
	 * @return id of the slot if available. -1 otherwise.
	 */
	protected int getDisposalStack() {
		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			if (!isDisposalSlot(i)) {
				continue;
			}

			if (inventory.getStackInSlot(i) == null) {
				continue;
			}

			if (inventory.getStackInSlot(i).isItemEqual(validDisposal)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Returns the next free waste slot.
	 */
	protected int getFreeSoilSlot() {
		for (int i = 0; i < 4; i++) {
			if (inventory.getStackInSlot(i) == null) {
				return i;
			}

			if (inventory.getStackInSlot(i).isItemEqual(validSoil) && inventory.getStackInSlot(i).stackSize < inventory.getStackInSlot(i).getMaxStackSize()) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Returns the next free germling slot.
	 */
	protected int getFreeGermlingSlot(ItemStack germling) {
		for (int i = 4; i < 8; i++) {
			if (inventory.getStackInSlot(i) == null) {
				return i;
			}

			if (inventory.getStackInSlot(i).isItemEqual(germling) && inventory.getStackInSlot(i).stackSize < inventory.getStackInSlot(i).getMaxStackSize()) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Returns the next free waste slot.
	 */
	protected int getFreeDisposalSlot() {
		for (int i = 8; i < inventory.getSizeInventory(); i++) {
			if (inventory.getStackInSlot(i) == null) {
				return i;
			}

			if (inventory.getStackInSlot(i).isItemEqual(validDisposal) && inventory.getStackInSlot(i).stackSize < inventory.getStackInSlot(i).getMaxStackSize()) {
				return i;
			}
		}

		return -1;
	}

	public void updateServerSide() {
		if (worldObj.getWorldTime() % 20 * 10 != 0) {
			return;
		}
		boolean errorNoResource = requiresSoil && getSoilStack() < 0 || requiresGermling && getGermlingStack() < 0;
		boolean errorNoDisposal = getFreeDisposalSlot() < 0;
		errorLogic.setCondition(errorNoResource, EnumErrorCode.NORESOURCE);
		errorLogic.setCondition(errorNoDisposal, EnumErrorCode.NODISPOSAL);
	}

	/**
	 * Return false for no operation, true for any operation.
	 */
	public boolean doWork() {
		boolean hasOpHappened = false;
		// LogHelper.info("Work!");
		if (templateArboretum == null) {
			templateArboretum = new StructureConstruction(site, getCoords(), siteOffset);
		}

		if (soil != null && templateSoil == null) {
			templateSoil = new StructureConstruction(soil, getCoords(), soilOffset);
			templateWater = new StructureConstruction(soil, getCoords(), soilOffset);
		}
		if (plantation != null && templatePlantation == null) {
			templatePlantation = new StructureConstruction(plantation, getCoords(), plantationOffset);
		}
		if (!isCleared) {
			return clearArea();
		}
		if (maintainWater()) {
			hasOpHappened = true;
		}
		if (maintainSoil()) {
			hasOpHappened = true;
		} else if (templateSoil.isFinished) {
			if (maintainVegetation()) {
				hasOpHappened = true;
			}
		}

		dumpStash();
		return hasOpHappened;
	}

	private boolean clearArea() {
		if (templateArboretum.isFinished) {
			isCleared = true;
			templateArboretum.reset();
			return false;
		}
		int blocksChanged = 0;
		Block curBlock = Blocks.air;
		while (curBlock == Blocks.air && !templateArboretum.isFinished) {
			BlockPosition curPos = new BlockPosition(templateArboretum.getCurrentX(), templateArboretum.getCurrentY(), templateArboretum.getCurrentZ());
			curBlock = worldObj.getBlock(curPos.x, curPos.y, curPos.z);

			if (curBlock != Blocks.air && BlockUtils.shouldBlueprintBreakBlock(worldObj, curPos) && !isSpecialBlock(worldObj.getBlock(curPos.x, curPos.y, curPos.z), worldObj.getBlockMetadata(curPos.x, curPos.y, curPos.z)) && curBlock != null) {
				ArrayList<ItemStack> items = BlockUtils.getBlockDrops(worldObj, curPos);

				worldObj.setBlockToAir(curPos.x, curPos.y, curPos.z);
				blocksChanged++;

				// Only drop the blocks if the config is on.
				if (ConfigurationHandler.planterDropBlocks) {
					if (items != null) {
						for (ItemStack item : items) {
							if (item == null || item.getItem() == null) {
								continue;
							}

							if (item.stackSize > 0) {
								EntityItem entityItem = new EntityItem(worldObj, curPos.x, curPos.y, curPos.z, item);
								worldObj.spawnEntityInWorld(entityItem);
							}
						}
					}
				}
			}
			templateArboretum.advanceStep();
		}
		return blocksChanged > 0;
	}

	private boolean maintainSoil() {
		if (templateSoil.isFinished) {
			templateSoil.reset();
		}
		int processedBlocks = 0;
		while (!templateSoil.isFinished && processedBlocks < ConfigurationHandler.planterThrottle) {
			processedBlocks++;
			if (templateSoil.getCurrentBlock() == Block.getBlockFromItem(validGround.getItem())) {
				BlockPosition pos = templateSoil.getCurrentPos();

				Block block = worldObj.getBlock(pos.x, pos.y, pos.z);
				Block above = worldObj.getBlock(pos.x, pos.y, pos.z);
				if (!(block != null && block.getBlockHardness(worldObj, pos.x, pos.y, pos.z) < 0) && !validGround.isItemEqual(new ItemStack(block)) && (above == Blocks.air || above == Blocks.snow_layer)) {
					if (validWaste != null) {
						if (validWaste.isItemEqual(new ItemStack(block))) {
							collectSand(pos);
						}

						if (validWaste.isItemEqual(new ItemStack(Blocks.dirt)) && block == Blocks.grass) {
							collectSand(pos);
						}
					}
					return fillBlock(pos);
				}
			}
			templateSoil.advanceStep();
		}
		isUnbroken = true;
		return false;
	}

	private boolean maintainWater() {
		if (templateWater.isFinished) {
			templateWater.reset();
		}

		while (!templateWater.isFinished) {
			// Place water if required
			if (templateWater.getCurrentBlock() == Blocks.water) {
				BlockPosition pos = templateWater.getCurrentPos();
				boolean skip = false;

				Block block = worldObj.getBlock(pos.x, pos.y, pos.z);
				if (block != Blocks.water) {
					// Make sure we are contained
					Block[] neighbours = new Block[] { worldObj.getBlock(pos.x - 1, pos.y, pos.z), worldObj.getBlock(pos.x + 1, pos.y, pos.z), worldObj.getBlock(pos.x, pos.y, pos.z - 1), worldObj.getBlock(pos.x, pos.y, pos.z + 1) };
					for (Block neighbour : neighbours) {
						if (!validGround.isItemEqual(new ItemStack(neighbour)) && !validWaste.isItemEqual(new ItemStack(neighbour))) {
							skip = true;
							break;
						}
					}
					if (!skip) {
						return waterBlock(templateWater.getCurrentPos());
					}
				}
			}
			templateWater.advanceStep();
		}
		return false;
	}

	private void collectSand(BlockPosition blockPos) {
		worldObj.setBlockToAir(blockPos.x, blockPos.y, blockPos.z);

		int slot = this.getFreeDisposalSlot();
		if (slot >= 0) {
			if (inventory.getStackInSlot(slot) == null) {
				inventory.setInventorySlotContents(slot, validDisposal.copy());
			} else {
				inventory.getStackInSlot(slot).stackSize++;
			}
		}
	}

	protected boolean maintainVegetation() {
		// Not every planter has vegetation
		if (templatePlantation == null) {
			return false;
		}

		if (templatePlantation.isFinished) {
			templatePlantation.reset();
		}

		int processedBlocks = 0;
		while (!templatePlantation.isFinished && processedBlocks < ConfigurationHandler.planterThrottle) {
			processedBlocks++;
			if (templatePlantation.getCurrentBlock() == Blocks.sapling) {
				if (plantSapling(templatePlantation.getCurrentPos())) {
					templatePlantation.advanceStep();
					return true;
				}
			}
			templatePlantation.advanceStep();
		}
		return false;
	}

	/**
	 * Are resources available to perform earthworks (replace other blocks with
	 * humus)?
	 */
	private boolean canFill() {
		return (this.getSoilStack() >= 0);
	}

	/**
	 * Decreases a soil stack
	 */
	private void decrSoilStack(int n) {
		int i = this.getSoilStack();
		if (i < 0) {
			return;
		}

		inventory.decrStackSize(i, n);

	}

	/**
	 * Decreases a sapling stack
	 */
	protected void decrSaplingStack(int i, int n) {
		if (i < 0) {
			return;
		}

		inventory.decrStackSize(i, n);

	}

	/**
	 * Places a water block.
	 *
	 * @param pos Location to place water block.
	 * @return see World.setBlock.
	 */
	private boolean waterBlock(BlockPosition pos) {
		return pos.setBlock(worldObj, Blocks.water);
	}

	/**
	 * Replaces a single block with a humus block. Consumes one humus block from
	 * an item stack.
	 */
	private boolean fillBlock(BlockPosition pos) {
		if (!this.canFill()) {
			return false;
		}

		pos.setBlock(worldObj, Block.getBlockFromItem(validGround.getItem()), validGround.getItemDamage());

		// Only decrease stash if replacing was successful
		Block block = pos.getBlock(worldObj);
		if (validGround.isItemEqual(new ItemStack(block))) {
			this.decrSoilStack(1); // decrease stash by one
		}
		return true;
	}

	/**
	 * Plants next possible sapling.
	 *
	 * @return True if a sapling was successfully planted. False otherwise.
	 */
	protected boolean plantSapling(BlockPosition blockPos) {
		for (int stack = 0; stack < inventory.getSizeInventory(); stack++) {
			if (isGermlingStack(stack)) {
				// Can't plant without germling
				// if (stack <= 0)
				// return false;

				// Don't continue if no provider for some reason
				// TODO, make the planter place down all saplings.
				ICropProvider provider = getCropProvider(inventory.getStackInSlot(stack));
				if (provider == null) {
					continue;
				}
				if (provider.isGermling(inventory.getStackInSlot(stack))) {
					if (provider.doPlant(inventory.getStackInSlot(stack), worldObj, blockPos)) {
						this.decrSaplingStack(stack, 1); // decrease stash by one
						return true;
					}
				}
			}
		}
		return false;
	}

	private void dumpStash() {
		ForgeDirection[] pipes = BlockUtils.getPipeDirections(worldObj, getCoords(), ForgeDirection.UNKNOWN);

		if (pipes.length > 0) {
			dumpToPipe(pipes);
		} else {
			IInventory[] inventories = BlockUtils.getAdjacentInventories(worldObj, getCoords(), ForgeDirection.UNKNOWN);
			dumpToInventory(inventories);
		}
	}

	private void dumpToPipe(ForgeDirection[] pipes) {
		for (int i = 8; i < inventory.getSizeInventory(); i++) {
			if (inventory.getStackInSlot(i) == null) {
				continue;
			}
			if (inventory.getStackInSlot(i).stackSize <= 0) {
				continue;
			}

			ForgeDirection[] filtered;
			if (!ConfigurationHandler.planterSideSensitive) {
				filtered = pipes;
			} else {
				filtered = BlockUtils.filterPipeDirections(pipes, new ForgeDirection[] { ForgeDirection.DOWN, ForgeDirection.UP });
			}

			while (inventory.getStackInSlot(i).stackSize > 0 && filtered.length > 0) {
				BlockUtils.putFromStackIntoPipe(this, filtered, inventory.getStackInSlot(i));
			}

			if (inventory.getStackInSlot(i).stackSize <= 0) {
				inventory.setInventorySlotContents(i, null);
			}
		}
	}

	private void dumpToInventory(IInventory[] inventories) {
		for (int i = 8; i < inventory.getSizeInventory(); i++) {
			if (inventory.getStackInSlot(i) == null) {
				continue;
			}
			if (inventory.getStackInSlot(i).stackSize <= 0) {
				continue;
			}

			for (IInventory inventory1 : inventories) {
				// can become zero, if matching inventory was found.
				if (inventory.getStackInSlot(i) == null) {
					continue;
				}

				// Don't dump in arboretums!
				if (inventory1 instanceof TilePlanter) {
					continue;
				}

				for (int k = 0; k < inventory1.getSizeInventory(); k++) {
					ItemStack stack = inventory1.getStackInSlot(k);
					if (stack == null) {
						inventory1.setInventorySlotContents(k, inventory.getStackInSlot(i));
						inventory.setInventorySlotContents(i, null);
						break;
					}

					if (stack != inventory.getStackInSlot(i)) {
						continue;
					}

					int available = inventory1.getInventoryStackLimit() - stack.stackSize;
					if (available <= 0) {
						continue;
					}

					if (available >= inventory.getStackInSlot(i).stackSize) {
						stack.stackSize += inventory.getStackInSlot(i).stackSize;
						inventory.setInventorySlotContents(i, null);
						break;
					} else {
						stack.stackSize = inventory1.getInventoryStackLimit();
						inventory.getStackInSlot(i).stackSize -= available;
					}
				}
			}
		}
	}

	public boolean isWorking() {
		return true;
	}

	public boolean hasResourcesMin(float percentage) {
		int max = 0;
		int avail = 0;

		for (int i = 4; i < 8; i++) {
			max += 64;
			if (inventory.getStackInSlot(i) == null) {
				continue;
			}
			avail += inventory.getStackInSlot(i).stackSize;
		}

		return ((float) avail / (float) max) > percentage;
	}

	public boolean hasFuelMin(float percentage) {
		int max = 0;
		int avail = 0;

		for (int i = 0; i < 4; i++) {
			max += 64;
			if (inventory.getStackInSlot(i) == null) {
				continue;
			}
			avail += inventory.getStackInSlot(i).stackSize;
		}

		return ((float) avail / (float) max) > percentage;
	}

	// ISPECIALINVENTORY IMPLEMENTATION

	/**
	 * Adds humus and saplings to the appropriate free slots of the arboretum.
	 * Does not care where the stuff comes from.
	 */

	public int addItem(ItemStack stack, boolean doAdd, ForgeDirection from) {

		// Humus
		if (stack.isItemEqual(validSoil)) {
			return addStack(stack, SLOT_SOIL_1, SLOT_COUNT_PART, false, doAdd);
		}

		if (hasGermlingBySeed(stack)) {
			return addStack(stack, SLOT_GERMLING_1, SLOT_COUNT_PART, false, doAdd);
		}

		return 0;
	}

	public ItemStack[] extractItem(boolean doRemove, ForgeDirection from, int maxItemCount) {
		for (int i = 8; i < inventory.getSizeInventory(); i++) {
			if (inventory.getStackInSlot(i) == null) {
				continue;
			}

			// Only sand can be extracted
			if (!inventory.getStackInSlot(i).isItemEqual(validDisposal)) {
				continue;
			}

			ItemStack product = validDisposal.copy();
			if (doRemove) {
				decrStackSize(i, 1);
			}
			return new ItemStack[] { product };
		}

		return new ItemStack[0];
	}

	// IINVENTORY/ISIDEDINVENTORY IMPLEMENTATION
	@Override
	public int getSizeInventory() {
		return inventory.getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return inventory.getStackInSlot(i);
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		inventory.setInventorySlotContents(i, itemstack);
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		return inventory.decrStackSize(i, j);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		return inventory.getStackInSlotOnClosing(slot);
	}

	/**
	 * Waste can be extracted from the sides, raw materials are added from top
	 * or bottom.
	 */
	public int getStartInventorySide(int side) {
		if (side == 0) {
			return SLOT_SOIL_1;
		} else if (side == 1) {
			return SLOT_GERMLING_1;
		} else {
			return SLOT_WASTE_1;
		}
	}

	public int getSizeInventorySide(int side) {
		return 4;
	}

	@Override
	public int getInventoryStackLimit() {
		return inventory.getInventoryStackLimit();
	}

	@Override
	public String getInventoryName() {
		return inventory.getInventoryName();
	}

	@Override
	public void markDirty() {
		//inventory.markDirty();
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
		return inventory.isItemValidForSlot(slot, itemStack);
	}

	public int addStack(ItemStack stack, int startSlot, int slots, boolean all, boolean doAdd) {

		int added = 0;
		// Add to existing stacks first
		for (int i = startSlot; i < startSlot + slots; i++) {

			// Empty slot. Add
			if (getStackInSlot(i) == null) {
			    /* if (doAdd) { setInventorySlotContents(i, stack.copy()); }
			     * return stack.stackSize; */
				continue;
			}

			// Already occupied by different item, skip this slot.
			if (!getStackInSlot(i).isItemEqual(stack)) {
				continue;
			}
			if (!ItemStack.areItemStackTagsEqual(getStackInSlot(i), stack)) {
				continue;
			}

			int remain = stack.stackSize - added;
			int space = getStackInSlot(i).getMaxStackSize() - getStackInSlot(i).stackSize;
			// No space left, skip this slot.
			if (space <= 0) {
				continue;
			}
			// Enough space
			if (space >= remain) {
				if (doAdd) {
					getStackInSlot(i).stackSize += remain;
				}
				return stack.stackSize;
			}

			// Not enough space
	        /* if (all) { continue; } */

			if (doAdd) {
				getStackInSlot(i).stackSize = getStackInSlot(i).getMaxStackSize();
			}

			added += space;
		}

		if (added >= stack.stackSize) {
			return added;
		}

		for (int i = startSlot; i < startSlot + slots; i++) {
			if (getStackInSlot(i) != null) {
				continue;
			}

			if (doAdd) {
				setInventorySlotContents(i, stack.copy());
				getStackInSlot(i).stackSize = stack.stackSize - added;
			}
			return stack.stackSize;

		}
		return added;
	}

	/**
	 * Needs to be implemented by all Planters, should return true if the block is special, that means the block wont be broken by the planter when clearing an area.
	 */
	public abstract boolean isSpecialBlock(Block block, int meta);

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		return energyStorage.receiveEnergy(maxReceive, simulate);
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		return energyStorage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return energyStorage.getMaxEnergyStored();
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return true;
	}

	@SideOnly(Side.CLIENT)
	public void addWailaInfo(List<String> info) {
		info.add("Cleared: " + isCleared);
		info.add("");
		info.add("Soil: " + validSoil.getDisplayName());
	}
}
