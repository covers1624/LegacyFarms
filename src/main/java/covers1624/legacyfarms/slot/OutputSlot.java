package covers1624.legacyfarms.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class OutputSlot extends covers1624.lib.inventory.OutputSlot {

	public OutputSlot(IInventory iInventory, int slotIndex, int xPos, int yPos) {
		super(iInventory, slotIndex, xPos, yPos);
	}

	@Override
	public boolean isItemValid(ItemStack p_75214_1_) {
		return false;
	}

}
