package covers1624.legacyfarms.container;

import covers1624.legacyfarms.slot.InputSlot;
import covers1624.legacyfarms.slot.OutputSlot;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.lib.inventory.InventoryUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class ContainerMushroomFarm extends Container {

	public TilePlanter planter;
	public static ArrayList<ItemStack> mushrooms = new ArrayList<ItemStack>();

	static {
		mushrooms.add(new ItemStack(Blocks.brown_mushroom));
		mushrooms.add(new ItemStack(Blocks.red_mushroom));
	}

	public ContainerMushroomFarm(InventoryPlayer inventoryPlayer, TilePlanter planter) {

		this.planter = planter;

		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 0, 19, 35, new ItemStack(Blocks.mycelium)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 1, 37, 35, new ItemStack(Blocks.mycelium)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 2, 19, 53, new ItemStack(Blocks.mycelium)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 3, 37, 53, new ItemStack(Blocks.mycelium)));

		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 4, 71, 35, mushrooms));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 5, 89, 35, mushrooms));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 6, 71, 53, mushrooms));
		InventoryUtils.addSlotToContainer(this, new InputSlot(planter, 7, 89, 53, mushrooms));

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
	public ItemStack transferStackInSlot(EntityPlayer player, int p_82846_2_) {
		return InventoryUtils.transferStackInSlot(this, player, p_82846_2_);
	}
}
