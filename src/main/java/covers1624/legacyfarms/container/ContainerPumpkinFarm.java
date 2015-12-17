package covers1624.legacyfarms.container;

import covers1624.legacyfarms.slot.InputSlot;
import covers1624.legacyfarms.slot.OutputSlot;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.lib.inventory.InventoryUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class ContainerPumpkinFarm extends Container {

	private TilePlanter planter;
	private static ArrayList<ItemStack> seeds = new ArrayList<ItemStack>();

	static {
		seeds.add(new ItemStack(Items.melon_seeds));
		seeds.add(new ItemStack(Items.pumpkin_seeds));
	}

	public ContainerPumpkinFarm(InventoryPlayer inventoryPlayer, TilePlanter planter) {
		this.planter = planter;
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 0, 19, 35, new ItemStack(Blocks.dirt)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 1, 37, 35, new ItemStack(Blocks.dirt)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 2, 19, 53, new ItemStack(Blocks.dirt)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 3, 37, 53, new ItemStack(Blocks.dirt)));

		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 4, 71, 35, seeds));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 5, 89, 35, seeds));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 6, 71, 53, seeds));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 7, 89, 53, seeds));

		InventoryUtils.addSlotToContainer(this, new OutputSlot(planter, 8, 123, 35));
		InventoryUtils.addSlotToContainer(this, new OutputSlot(planter, 9, 141, 35));
		InventoryUtils.addSlotToContainer(this, new OutputSlot(planter, 10, 123, 53));
		InventoryUtils.addSlotToContainer(this, new OutputSlot(planter, 11, 141, 53));

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
