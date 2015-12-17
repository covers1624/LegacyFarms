package covers1624.legacyfarms.tile;

import forestry.core.inventory.InventoryAdapterTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;

public abstract class TileInventory extends TileBase implements ISidedInventory {

	protected InventoryAdapterTile<? extends TileInventory> inventory;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TileInventory(int size) {
		inventory = new InventoryAdapterTile(this, size, "Items");
	}

	public TileInventory() {
		this(12);
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
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;

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
		if (inventory != null) {
			return inventory.getStackInSlot(slot);
		}
		return null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (inventory != null) {
			inventory.decrStackSize(slot, amount);
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
		return inventory != null && inventory.hasCustomInventoryName();
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
			switch (side) {
			case 0:
			case 1:
				return new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
			case 2:
			case 3:
			case 4:
			case 5:
				return new int[] { 8, 9, 10, 11 };
			}
		}
		return null;
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack itemStack, int side) {
		if (inventory != null) {
			inventory.canInsertItem(slot, itemStack, side);
		}
		return false;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack itemStack, int side) {
		if (inventory != null) {
			canExtractItem(slot, itemStack, side);
		}
		return false;
	}
}
