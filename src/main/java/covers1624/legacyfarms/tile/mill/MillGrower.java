package covers1624.legacyfarms.tile.mill;

import covers1624.legacyfarms.crop.Overgrowth;
import covers1624.lib.util.BlockPosition;

import forestry.core.inventory.InventoryAdapterTile;
import forestry.core.tiles.TileMill;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by covers1624 on 12/15/2015.
 */
public abstract class MillGrower extends TileMill{

	public final ItemStack catalyst;
	private ArrayList<ItemStack> validCropIds = new ArrayList<ItemStack>();
	private ArrayList<Overgrowth> validOvergrowth = new ArrayList<Overgrowth>();

	public MillGrower(ItemStack catalyst){
		super(null);
		this.catalyst = catalyst;
		setInternalInventory(new InventoryAdapterTile<MillGrower>(this, 1, "Items"));
	}

	protected void putOvergrowth(Overgrowth overgrowth){
		validCropIds.add(overgrowth.crop);
		validOvergrowth.add(overgrowth);
	}

	public boolean hasOvergrowthByCropId(ItemStack stack){
		return validCropIds.contains(stack);
	}

	public Overgrowth getOvergrowthByCrop(ItemStack stack){
		for (Overgrowth overgrowth : validOvergrowth){
			if (overgrowth.hasCrop(stack)){
				return overgrowth;
			}
		}
		return null;
	}

	public abstract void growCrop(World world, ItemStack itemStack, BlockPosition blockPos);

	private InventoryAdapterTile<MillGrower> inventory;

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

	private int getFreeCatalystSlot(){
		for (int i = 0; i < 1; i++) {
			if (inventory.getStackInSlot(i) == null){
				return i;
			}
			if (inventory.getStackInSlot(i).isItemEqual(catalyst) && inventory.getStackInSlot(i).stackSize < inventory.getStackInSlot(i).getMaxStackSize()){
				return i;
			}
		}
		return -1;
	}
}
