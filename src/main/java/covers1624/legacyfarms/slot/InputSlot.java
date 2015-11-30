package covers1624.legacyfarms.slot;

import covers1624.legacyfarms.utils.ItemUtils;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

/**
 * Created by covers1624 on 10/15/2015}.
 * If AllowedItems is null it will always allow the item in the slot.
 */
public class InputSlot extends Slot {

	private ArrayList<ItemStack> allowedItems;

	public InputSlot(IInventory inventory, int slotIndex, int xPos, int yPos, ArrayList<ItemStack> allowedItems) {
		super(inventory, slotIndex, xPos, yPos);
		this.allowedItems = allowedItems;
	}

	public InputSlot(IInventory inventory, int slotIndex, int xPos, int yPos, ItemStack allowedItem) {
		super(inventory, slotIndex, xPos, yPos);
		if (allowedItem != null) {
			allowedItems = new ArrayList<ItemStack>();
			allowedItems.add(allowedItem);
		}
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		if (allowedItems != null) {
			for (ItemStack itemStack : allowedItems) {
				if (ItemUtils.areStacksSameType(itemStack, stack)) {
					return true;
				}
			}
			return false;
		}
		return true;
	}
}
