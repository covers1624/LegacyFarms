package covers1624.legacyfarms.inventory;

import covers1624.legacyfarms.network.INetworkTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class MachineInventory<T extends TileEntity> implements ISidedInventory, INetworkTile {

	private T tile;
	private ItemStack[] items;
	private int invSize;
	private int stackLimit;
	private String name;

	public MachineInventory(int sise, T tile, String name, int stackLimit) {
		this.tile = tile;
		items = new ItemStack[sise];
		invSize = sise;
		this.stackLimit = stackLimit;
		this.name = name;
	}

	@Override
	public int getSizeInventory() {
		return invSize;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		// If slot is out of bounds we return null else we don't care if the slot is null just return it.
		if (slot > invSize) {
			return null;
		} else {
			return items[slot];
		}
	}

	@Override
	public ItemStack decrStackSize(int slot, int ammount) {
		if (slot > invSize) {
			return null;
		} else {
			if (items[slot] != null) {

				if (items[slot].stackSize <= ammount) {
					ItemStack itemStack = items[slot].copy();
					items[slot] = null;
					return itemStack;
				} else {
					ItemStack itemStack = items[slot].splitStack(ammount);
					if (items[slot].stackSize == 0) {
						items[slot] = null;
					}
					return itemStack;
				}
			}
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		return getStackInSlot(slot);
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemStack) {
		items[slot] = itemStack;

		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
			items[slot].stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return name;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return stackLimit;
	}

	@Override
	public void markDirty() {
		tile.markDirty();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
		return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		return null;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
		return true;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		return true;
	}

	@Override
	public void readNetData(NBTTagCompound tagCompound) {
		stackLimit = tagCompound.getInteger("StackLimit");
		invSize = tagCompound.getInteger("Size");
		name = tagCompound.getString("Name");

		NBTTagList nbttaglist = tagCompound.getTagList("Items", 10);
		items = new ItemStack[getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); i++) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 0xff;

			if (j >= 0 && j < items.length) {
				items[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}

	@Override
	public void writeNetData(NBTTagCompound tagCompound) {
		tagCompound.setInteger("StackLimit", stackLimit);
		tagCompound.setInteger("Size", invSize);
		tagCompound.setString("Name", name);

		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				items[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		tagCompound.setTag("Items", nbttaglist);
	}

	public int addStack(ItemStack stack, int startSlot, int slots, boolean all, boolean doAdd) {

		int added = 0;
		// Add to existing stacks first
		for (int i = startSlot; i < startSlot + slots; i++) {

			// Empty slot. Add
			if (getStackInSlot(i) == null) {
				/* if (doAdd) { setInventorySlotContents(i, stack.copy()); } return stack.stackSize; */
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

		if (added >= stack.stackSize)
			return added;

		for (int i = startSlot; i < startSlot + slots; i++) {
			if (getStackInSlot(i) != null)
				continue;

			if (doAdd) {
				setInventorySlotContents(i, stack.copy());
				getStackInSlot(i).stackSize = stack.stackSize - added;
			}
			return stack.stackSize;

		}

		return added;

	}

}
