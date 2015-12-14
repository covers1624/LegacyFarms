package covers1624.legacyfarms.container;

import covers1624.legacyfarms.slot.InputSlot;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.lib.inventory.InventoryUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

/**
 * Created by covers1624 on 12/14/2015.
 */
public class ContainerFarm extends Container{

	private TilePlanter planter;

	public ContainerFarm(InventoryPlayer inventoryPlayer, TilePlanter planter){
		this.planter = planter;

		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 0, 34, 35, new ItemStack(Blocks.dirt)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 1, 52, 35, new ItemStack(Blocks.dirt)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 2, 34, 53, new ItemStack(Blocks.dirt)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 3, 52, 53, new ItemStack(Blocks.dirt)));

		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 4, 107, 35, new ItemStack(Items.wheat_seeds)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 5, 125, 35, new ItemStack(Items.wheat_seeds)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 6, 107, 53, new ItemStack(Items.wheat_seeds)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 7, 125, 53, new ItemStack(Items.wheat_seeds)));

		InventoryUtils.bindPlayerInventory(this, inventoryPlayer, 8, 84);
	}


	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return planter.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
		return InventoryUtils.transferStackInSlot(this, player, slot);
	}
}
