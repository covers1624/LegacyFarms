package covers1624.legacyfarms.tile.mill;

import covers1624.legacyfarms.crop.Overgrowth;
import covers1624.lib.util.BlockPosition;
import forestry.core.errors.EnumErrorCode;
import forestry.core.inventory.InventoryAdapterTile;
import forestry.core.tiles.TileMill;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by covers1624 on 12/15/2015.
 */
public abstract class TileMillGrower extends TileMill {

	public final ItemStack catalyst;
	private ArrayList<ItemStack> validCropIds = new ArrayList<ItemStack>();
	private ArrayList<Overgrowth> validOvergrowth = new ArrayList<Overgrowth>();

	public TileMillGrower(ItemStack catalyst) {
		super(null);
		this.catalyst = catalyst;
		setInternalInventory(new InventoryAdapterTile<TileMillGrower>(this, 1, "Items"));
	}

	protected void putOvergrowth(Overgrowth overgrowth) {
		validCropIds.add(overgrowth.crop);
		validOvergrowth.add(overgrowth);
	}

	public boolean hasOvergrowthByCropId(ItemStack stack) {
		return validCropIds.contains(stack);
	}

	public Overgrowth getOvergrowthByCrop(ItemStack stack) {
		for (Overgrowth overgrowth : validOvergrowth) {
			if (overgrowth.hasCrop(stack)) {
				return overgrowth;
			}
		}
		return null;
	}

	public abstract void growCrop(ItemStack itemStack, BlockPosition blockPos);

	private InventoryAdapterTile<TileMillGrower> inventory;

	private BlockPosition area = new BlockPosition(21, 3, 21);
	private BlockPosition posOffset = new BlockPosition(-10, -1, -10);
	private BlockPosition posCurrent = new BlockPosition(0, 0, 0);
	private boolean isFinished = false;

	@Override
	public void readFromNBT(NBTTagCompound data) {
		super.readFromNBT(data);

		inventory.readFromNBT(data);
		isFinished = data.getBoolean("IsFinished");

		charge = data.getInteger("Charge");
		progress = data.getFloat("Progress");
		stage = data.getInteger("Stage");
	}

	@Override
	public void writeToNBT(NBTTagCompound data) {
		super.writeToNBT(data);

		inventory.writeToNBT(data);
		data.setBoolean("IsFinished", isFinished);
		data.setInteger("Charge", charge);
		data.setFloat("Progress", progress);
		data.setInteger("Stage", stage);
	}

	private int getFreeCatalystSlot() {
		for (int i = 0; i < 1; i++) {
			if (inventory.getStackInSlot(i) == null) {
				return i;
			}
			if (inventory.getStackInSlot(i).isItemEqual(catalyst) && inventory.getStackInSlot(i).stackSize < inventory.getStackInSlot(i).getMaxStackSize()) {
				return i;
			}
		}
		return -1;
	}

	public void resetProgress() {
		isFinished = false;
		posCurrent = new BlockPosition(0, 0, 0);
	}

	private void advanceProgress() {
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

	@Override
	protected void activate() {
		//TODO
		//float f = xCoord + 0.5F;
		//float f1 = yCoord + 0.5F + (worldObj.rand.nextFloat() * 6F) / 16F;
		//float f2 = zCoord + 0.5F;
		//float f3 = 0.52F;
		//float f4 = worldObj.rand.nextFloat() * 0.6F - 0.3F;

		//Proxies.common.addEntityBiodustFX(tile.worldObj, (f - f3), f1, (f2 + f4), 0F, 0F, 0F);
		//Proxies.common.addEntityBiodustFX(tile.worldObj, (f + f3), f1, (f2 + f4), 0F, 0F, 0F);
		//Proxies.common.addEntityBiodustFX(tile.worldObj, (f + f4), f1, (f2 - f3), 0F, 0F, 0F);
		//Proxies.common.addEntityBiodustFX(tile.worldObj, (f + f4), f1, (f2 + f3), 0F, 0F, 0F);

		if (!worldObj.isRemote) {
			catalyze();
			charge = 0;
			//TODO move to our own packet system.
			sendNetworkUpdate();
		}
	}

	public void catalyze() {
		while (!isFinished && canCatalyze()) {
			advanceProgress();
			BlockPosition blockPos = posCurrent.add(new BlockPosition(xCoord, yCoord, zCoord));
			blockPos.add(posOffset);
			if (hasOvergrowthByCropId(blockPos.getWorldItemStack(worldObj))){
				if(applyCatalyst(blockPos)){
					decrStackSize(0, 1);
					break;
				}
			}
		}
	}

	public boolean doWork() {
		if (!worldObj.isRemote) {
			return false;
		}
		if (charge != 0) {
			return false;
		}

		if (canCatalyze()) {
			getErrorLogic().clearErrors();
		} else {
			getErrorLogic().setCondition(true, EnumErrorCode.NO_RESOURCE);
		}

		return true;
	}

	public boolean isWorking() {
		return charge != 0 || canCatalyze();
	}

	private boolean canCatalyze() {
		return inventory.getStackInSlot(0) != null && inventory.getStackInSlot(0).isItemEqual(catalyst) && inventory.getStackInSlot(0).stackSize > 0;

	}

	private boolean applyCatalyst(BlockPosition blockPos){
		ItemStack crop = blockPos.getWorldItemStack(worldObj);
		Overgrowth growth = getOvergrowthByCrop(crop);
		if(growth == null){
			return false;
		}
		growCrop(crop, blockPos.copy());

		ItemStack result = blockPos.getWorldItemStack(worldObj);
		return growth.hasRipe(result);
	}
}
