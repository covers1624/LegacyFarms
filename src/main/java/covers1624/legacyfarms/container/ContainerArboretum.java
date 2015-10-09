package covers1624.legacyfarms.container;

import covers1624.legacyfarms.gui.OutputSlot;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.lib.inventory.InventoryUtils;
import forestry.core.gui.ContainerForestry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerArboretum extends ContainerForestry {

	private TilePlanter arboretum;

	public ContainerArboretum(InventoryPlayer playerInventory, TilePlanter arboretum) {
		this.arboretum = arboretum;

		addSlotToContainer(new Slot(arboretum, 0, 19, 35));
		addSlotToContainer(new Slot(arboretum, 1, 19, 53));
		addSlotToContainer(new Slot(arboretum, 2, 37, 35));
		addSlotToContainer(new Slot(arboretum, 3, 37, 53));

		addSlotToContainer(new Slot(arboretum, 4, 71, 35));
		addSlotToContainer(new Slot(arboretum, 5, 71, 53));
		addSlotToContainer(new Slot(arboretum, 6, 89, 35));
		addSlotToContainer(new Slot(arboretum, 7, 89, 53));

		addSlotToContainer(new OutputSlot(arboretum, 8, 123, 35));
		addSlotToContainer(new OutputSlot(arboretum, 9, 123, 53));
		addSlotToContainer(new OutputSlot(arboretum, 10, 141, 35));
		addSlotToContainer(new OutputSlot(arboretum, 11, 141, 53));

		InventoryUtils.bindPlayerInventory(this, playerInventory, 8, 84);
		//int var3;
		//for (var3 = 0; var3 < 3; ++var3) {
		//	for (int var4 = 0; var4 < 9; ++var4) {
		//		addSlotToContainer(new Slot(playerInventory, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
		//	}
		//}
		//
		//for (var3 = 0; var3 < 9; ++var3) {
		//	addSlotToContainer(new Slot(playerInventory, var3, 8 + var3 * 18, 142));
		//}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.arboretum.isUseableByPlayer(player);
	}

	@Override
	protected boolean canAccess(EntityPlayer player) {
		return true;
	}

}
