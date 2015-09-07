package covers1624.legacyfarms.tile;

import forestry.core.inventory.TileInventoryAdapter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;

public abstract class TileInventory extends TileBase implements ISidedInventory {

	protected TileInventoryAdapter<? extends TileInventory> inventory;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TileInventory() {
		inventory = new TileInventoryAdapter(this, 12, "Items");
	}

	public abstract void openGui(EntityPlayer player);

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		if (worldObj.getTileEntity(xCoord, yCoord, zCoord) != this)
			return false;

		return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public int getSizeInventory() {
		if (inventory != null) {
			return inventory.getSizeInventory();
		}
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {

		return null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int ammount) {
		if (inventory != null) {
			inventory.decrStackSize(slot, ammount);
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (inventory != null) {
			inventory.getStackInSlotOnClosing(slot);
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemStack) {
		if (inventory != null) {
			inventory.setInventorySlotContents(slot, itemStack);
		}

	}

	@Override
	public String getInventoryName() {
		if (inventory != null) {
			return inventory.getInventoryName();
		}
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		if (inventory != null) {
			return inventory.hasCustomInventoryName();
		}
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		if (inventory != null) {
			return inventory.getInventoryStackLimit();
		}
		return 0;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
		if (inventory != null) {
			return inventory.isItemValidForSlot(slot, itemStack);
		}
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		if (inventory != null) {

		}
		return null;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
		if (inventory != null) {

		}
		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		if (inventory != null) {
		}
		return false;
	}
}
