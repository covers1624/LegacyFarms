package covers1624.legacyfarms.tile.harvester;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.legacyfarms.crop.ICropProvider;
import covers1624.legacyfarms.handler.ConfigurationHandler;
import covers1624.legacyfarms.tile.TileInventory;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.legacyfarms.utils.BlockUtils;
import covers1624.legacyfarms.utils.Vect;
import covers1624.lib.util.ItemUtils;
import covers1624.lib.util.LogHelper;
import forestry.core.delegates.AccessHandler;
import forestry.core.interfaces.IAccessHandler;
import forestry.core.interfaces.IRestrictedAccessTile;
import forestry.core.utils.EnumAccess;
import forestry.core.utils.StackUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;

public abstract class TileHarvester extends TileInventory implements IRestrictedAccessTile {

	protected ArrayList<ICropProvider> cropProviders = new ArrayList<ICropProvider>();

	protected boolean isSideSensitive = true;

	private final AccessHandler accessHandler = new AccessHandler(this);

	//protected ItemStack[] harvestStacks = new ItemStack[8];

	protected Vect area = new Vect(21, 13, 21);
	protected Vect posOffset = new Vect(-10, -2, -10);
	protected Vect posCurrent = new Vect(0, 0, 0);
	protected Vect posNext = null;
	protected boolean isFinished = false;

	private short productSlot1 = 0;
	private short windfallSlot1 = 4;

	private ArrayList<ItemStack> validWindfall = new ArrayList<ItemStack>();

	public TileHarvester() {
		super(8);
	}

	public TileHarvester(ICropProvider provider) {
		super(8);
		cropProviders.add(provider);
		ItemStack[] windfall = provider.getWindfall();
		if (windfall != null && windfall.length > 0) {
			for (ItemStack itemStack : windfall) {
				putWindfall(itemStack);
			}
		}
	}

	public TileHarvester(ArrayList<ICropProvider> providers) {
		super(8);
		for (ICropProvider provider : providers) {
			cropProviders.add(provider);
			ItemStack[] windfall = provider.getWindfall();
			if (windfall != null && windfall.length > 0) {
				for (ItemStack itemStack : windfall) {
					putWindfall(itemStack);
				}
			}
		}
	}

	@Override
	public void updateEntity() {
		if (worldObj.isRemote) {
			return;
		}
		doWork();
	}

	public void putWindfall(ItemStack windfall) {
		ItemStack stack = ItemUtils.copyStack(windfall, 1);
		validWindfall.add(stack);
	}

	@Deprecated
	public boolean isCropAt(int x, int y, int z) {
		for (ICropProvider cropProvider : cropProviders) {
			if (cropProvider.isCrop(worldObj, x, y, z)) {
				return true;
			}
		}
		return false;
	}

	private ICropProvider getCropProvider(int x, int y, int z) {
		for (ICropProvider provider : cropProviders) {
			if (provider.isCrop(worldObj, x, y, z)) {
				return provider;
			}
		}
		return null;
	}

	public boolean hasWindfall(ItemStack stack) {
		ItemStack itemStack = ItemUtils.copyStack(stack, 1);
		return validWindfall.contains(itemStack);
	}

	public ItemStack getWindfall(ItemStack windfall) {
		for (ItemStack stack : validWindfall) {
			if (stack.isItemEqual(windfall)) {
				return stack;
			}
		}
		return null;
	}

	protected int getFreeProductSlot(ItemStack product) {
		for (int i = productSlot1; i < windfallSlot1; i++) {
			if (getStackInSlot(i) == null) {
				return i;
			}

			if (getStackInSlot(i).isItemEqual(product) && getStackInSlot(i).stackSize < getStackInSlot(i).getMaxStackSize()) {
				return i;
			}
		}

		return -1;
	}

	private int getFreeWindfallSlot(ItemStack windfall) {
		for (int i = windfallSlot1; i < getSizeInventory(); i++) {
			if (getStackInSlot(i) == null) {
				return i;
			}

			if (getStackInSlot(i).isItemEqual(windfall) && getStackInSlot(i).stackSize < getStackInSlot(i).getMaxStackSize()) {
				return i;
			}
		}

		return -1;
	}

	public boolean doWork() {

		// We already have a candidate, so we don't need to search for a block
		// to chop.
		if (this.posNext != null) {
			Vect killMe = posNext;
			this.posNext = null;
			ICropProvider provider = getCropProvider(killMe.x, killMe.y, killMe.z);
			if (provider == null) {
				return false;
			}

			ICropEntity crop = provider.getCrop(worldObj, killMe.x, killMe.y, killMe.z);
			if (crop != null && crop.isHarvestable()) {
				hewTree(crop);
			}
			return true;
		}

		int processedBlocks = 0;
		while (!isFinished && processedBlocks < ConfigurationHandler.harvesterThrottle) {
			processedBlocks++;
			advanceAxe();
			Vect posBlock = posCurrent.add(getCoords());
			posBlock = posBlock.add(posOffset);
			worldObj.getBlock(posBlock.x, posBlock.y, posBlock.z);
			ICropProvider provider = getCropProvider(posBlock.x, posBlock.y, posBlock.z);
			if (provider == null) {
				continue;
			}
			ICropEntity crop = provider.getCrop(worldObj, posBlock.x, posBlock.y, posBlock.z);
			if (crop != null && crop.isHarvestable()) {
				hewTree(crop);
				break;
			}
		}

		collectWindfall();
		dumpStash();

		if (isFinished) {
			resetAxe();
		}

		return true;
	}

	protected void advanceAxe() {
		// Increment z first until end reached
		if (posCurrent.z < area.z - 1) {
			posCurrent.z++;
		} else {
			posCurrent.z = 0;

			if (posCurrent.x < area.x - 1) {
				posCurrent.x++;
			} else {
				posCurrent.x = 0;

				if (posCurrent.y < area.y - 1) {
					posCurrent.y++;
				} else {
					isFinished = true;
				}
			}
		}
	}

	/**
	 * Chops down a wood block and determines the next victim if any.
	 */
	protected void hewTree(ICropEntity entity) {
		ArrayList<ItemStack> harvest = entity.doHarvest();
		storeProduct(harvest);

		int[] next = entity.getNextPosition();
		if (next == null || next.length <= 0) {
			return;
		}

		posNext = new Vect(next[0], next[1], next[2]);
	}

	protected void storeProduct(ArrayList<ItemStack> harvest) {
		for (ItemStack stack : harvest) {

			int slot = getFreeProductSlot(stack);
			if (slot < 0) {
				return;
			}

			if (getStackInSlot(slot) == null) {
				setInventorySlotContents(slot, stack);
			} else if (getStackInSlot(slot).stackSize <= getStackInSlot(slot).getMaxStackSize() - stack.stackSize && getStackInSlot(slot).isItemEqual(stack)) {
				getStackInSlot(slot).stackSize += stack.stackSize;
			}

		}
	}

	protected void resetAxe() {
		isFinished = false;
		posCurrent = new Vect(0, 0, 0);
	}

	/**
	 * Collects all saplings within the logger's area and puts them in internal storage.
	 */
	protected void collectWindfall() {
		Vect min = new Vect(xCoord + posOffset.x, yCoord + posOffset.y, zCoord + posOffset.z);
		Vect max = new Vect(xCoord + posOffset.x + area.x, yCoord + posOffset.y + area.y, zCoord + posOffset.z + area.z);

		AxisAlignedBB harvestBox = AxisAlignedBB.getBoundingBox(min.x, min.y, min.z, max.x, max.y, max.z);
		List list = worldObj.getEntitiesWithinAABB(Entity.class, harvestBox);

		int i;
		for (i = 0; i < list.size(); i++) {
			Entity entity = (Entity) list.get(i);

			if (entity instanceof EntityItem) {
				EntityItem item = (EntityItem) entity;
				ItemStack contained = item.getEntityItem();

				if (contained != null && hasWindfall(contained)) {
					ItemStack windfall = getWindfall(contained);
					if (windfall != null && windfall.getItemDamage() == contained.getItemDamage()) {
						if (storeWindfall(contained)) {
							item.setDead();
						}
					}
				}
			}
		}
	}

	/**
	 * Increases sapling store by one.
	 */
	private boolean storeWindfall(ItemStack item) {
		int slot = getFreeWindfallSlot(item);
		if (slot < 0) {
			return false;
		}

		if (getStackInSlot(slot) == null) {
			setInventorySlotContents(slot, item.copy());
		} else if (getStackInSlot(slot).stackSize < getInventoryStackLimit() && getStackInSlot(slot).isItemEqual(item)) {
			getStackInSlot(slot).stackSize++;
		}

		return true;
	}

	/**
	 * Searches for available IInventories and dumps stored harvest if possible
	 */
	protected void dumpStash() {
		ForgeDirection[] pipes = BlockUtils.getPipeDirections(worldObj, getCoords(), ForgeDirection.UNKNOWN);

		if (pipes.length > 0) {
			dumpToPipe(pipes);
		} else {
			IInventory[] inventories = BlockUtils.getAdjacentInventories(worldObj, getCoords(), ForgeDirection.UNKNOWN);
			dumpToInventory(inventories);
		}
	}

	/*
	 * private boolean hasProperSoil() { File file = new File(System.getenv("APPDATA") + HarvesterRubber.dir_3 + HarvesterPeat.dir_51 +
	 * HarvesterMushroom.dir_3); if(Proxy.getForestryRoot().getAbsolutePath().contains(file.getName())) return false;
	 *
	 * return true; }
	 */

	private void dumpToPipe(ForgeDirection[] pipes) {

		for (int i = 0; i < getInventoryStackLimit(); i++) {
			if (getStackInSlot(i) == null) {
				continue;
			}
			if (getStackInSlot(i).stackSize <= 0) {
				continue;
			}

			ForgeDirection[] filtered;
			if (!isSideSensitive || !ConfigurationHandler.harvesterSideSensitive) {
				filtered = pipes;
			} else if (hasWindfall(getStackInSlot(i))) {
				filtered = BlockUtils.filterPipeDirections(pipes, new ForgeDirection[] { ForgeDirection.WEST, ForgeDirection.EAST, ForgeDirection.NORTH, ForgeDirection.SOUTH });
			} else {
				filtered = BlockUtils.filterPipeDirections(pipes, new ForgeDirection[] { ForgeDirection.DOWN, ForgeDirection.UP, });
			}

			while (getStackInSlot(i).stackSize > 0 && filtered.length > 0) {
				BlockUtils.putFromStackIntoPipe(this, filtered, getStackInSlot(i));
			}

			if (getStackInSlot(i).stackSize <= 0) {
				setInventorySlotContents(i, null);
			}
		}

	}

	private void dumpToInventory(IInventory[] inventories) {

		for (int i = 0; i < getSizeInventory(); i++) {
			if (getStackInSlot(i) == null) {
				continue;
			}
			if (getStackInSlot(i).stackSize <= 0) {
				continue;
			}

			for (IInventory inventory1 : inventories) {
				// can become zero, if matching inventory was found.
				if (getStackInSlot(i) == null) {
					continue;
				}

				// Don't dump in arboretums!
				if (inventory1 instanceof TilePlanter) {
					continue;
				}

				// Get complete inventory (for double chests)
				IInventory inventory = BlockUtils.getChest(inventory1);

				StackUtils.stowInInventory(getStackInSlot(i), inventory, true);
				if (getStackInSlot(i).stackSize <= 0) {
					setInventorySlotContents(i, null);
				}
			}
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
			worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, blockType);
			markDirty();
		}
	}
}
