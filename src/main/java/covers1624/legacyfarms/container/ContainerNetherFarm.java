package covers1624.legacyfarms.container;

import covers1624.legacyfarms.slot.InputSlot;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.lib.inventory.InventoryUtils;
import forestry.core.gui.ContainerForestry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ContainerNetherFarm extends ContainerForestry {

	private TilePlanter planter;

	public ContainerNetherFarm(InventoryPlayer playerInventory, TilePlanter planter) {
		this.planter = planter;

		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 0, 34, 35, new ItemStack(Blocks.soul_sand)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 1, 52, 35, new ItemStack(Blocks.soul_sand)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 2, 34, 53, new ItemStack(Blocks.soul_sand)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 3, 52, 53, new ItemStack(Blocks.soul_sand)));

		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 4, 107, 35, new ItemStack(Items.nether_wart)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 5, 125, 35, new ItemStack(Items.nether_wart)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 6, 107, 53, new ItemStack(Items.nether_wart)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 7, 125, 53, new ItemStack(Items.nether_wart)));

		InventoryUtils.bindPlayerInventory(this, playerInventory, 8, 84);
	}

	@Override
	protected boolean canAccess(EntityPlayer player) {
		return true;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.planter.isUseableByPlayer(player);
	}

}
