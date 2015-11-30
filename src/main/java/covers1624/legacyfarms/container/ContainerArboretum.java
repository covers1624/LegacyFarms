package covers1624.legacyfarms.container;

import covers1624.legacyfarms.init.ModBlocks;
import covers1624.legacyfarms.slot.InputSlot;
import covers1624.legacyfarms.slot.OutputSlot;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.lib.inventory.InventoryUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class ContainerArboretum extends Container {

	private TilePlanter arboretum;
	private static ArrayList<ItemStack> soil = new ArrayList<ItemStack>();
	private static ArrayList<ItemStack> saplings = OreDictionary.getOres("treeSapling");

	static {
		soil.add(new ItemStack(ModBlocks.forestrySoil));
	}

	public ContainerArboretum(InventoryPlayer playerInventory, TilePlanter arboretum) {
		this.arboretum = arboretum;
		InventoryUtils.addSlotToContainer(this, new InputSlot(arboretum, 0, 19, 35, new ItemStack(ModBlocks.forestrySoil)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(arboretum, 1, 37, 35, new ItemStack(ModBlocks.forestrySoil)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(arboretum, 2, 19, 53, new ItemStack(ModBlocks.forestrySoil)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(arboretum, 3, 37, 53, new ItemStack(ModBlocks.forestrySoil)));

		InventoryUtils.addSlotToContainer(this, new InputSlot(arboretum, 4, 71, 35, new ItemStack(ModBlocks.blockSapling)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(arboretum, 5, 89, 35, new ItemStack(ModBlocks.blockSapling)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(arboretum, 6, 71, 53, new ItemStack(ModBlocks.blockSapling)));
		InventoryUtils.addSlotToContainer(this, new InputSlot(arboretum, 7, 89, 53, new ItemStack(ModBlocks.blockSapling)));

		InventoryUtils.addSlotToContainer(this, new OutputSlot(arboretum, 8, 123, 35));
		InventoryUtils.addSlotToContainer(this, new OutputSlot(arboretum, 9, 141, 35));
		InventoryUtils.addSlotToContainer(this, new OutputSlot(arboretum, 10, 123, 53));
		InventoryUtils.addSlotToContainer(this, new OutputSlot(arboretum, 11, 141, 53));

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
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
		return InventoryUtils.transferStackInSlot(this, player, slotIndex);
	}
}
