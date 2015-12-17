package covers1624.legacyfarms.container;

import covers1624.legacyfarms.init.ForestryProxy;
import covers1624.legacyfarms.slot.InputSlot;
import covers1624.legacyfarms.slot.OutputSlot;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.lib.inventory.InventoryUtils;
import forestry.core.gui.ContainerForestry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public class ContainerPeatBog extends ContainerForestry {

	private TilePlanter planter;

	public ContainerPeatBog(InventoryPlayer playerInventory, TilePlanter tilePlanter) {
		this.planter = tilePlanter;

		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 0, 34, 35, new ItemStack(ForestryProxy.soil, 1, 1)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 1, 52, 35, new ItemStack(ForestryProxy.soil, 1, 1)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 2, 34, 53, new ItemStack(ForestryProxy.soil, 1, 1)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 3, 52, 53, new ItemStack(ForestryProxy.soil, 1, 1)));

		InventoryUtils.addSlotToContainer(this, new OutputSlot(planter, 4, 107, 35));
		InventoryUtils.addSlotToContainer(this, new OutputSlot(planter, 5, 125, 35));
		InventoryUtils.addSlotToContainer(this, new OutputSlot(planter, 6, 107, 53));
		InventoryUtils.addSlotToContainer(this, new OutputSlot(planter, 7, 125, 53));

		InventoryUtils.bindPlayerInventory(this, playerInventory, 8, 84);
	}

	@Override
	protected boolean canAccess(EntityPlayer entityPlayer) {
		return true;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return planter.isUseableByPlayer(player);
	}
}
