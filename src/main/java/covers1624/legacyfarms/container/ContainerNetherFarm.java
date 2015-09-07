package covers1624.legacyfarms.container;

import covers1624.legacyfarms.tile.planter.TilePlanter;
import forestry.core.gui.ContainerForestry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;

public class ContainerNetherFarm extends ContainerForestry {

	private TilePlanter planter;

	public ContainerNetherFarm(InventoryPlayer playerInventory, TilePlanter planter) {
		this.planter = planter;
		addSlotToContainer(new Slot(planter, 0, 34, 35));
		addSlotToContainer(new Slot(planter, 1, 34, 53));
		addSlotToContainer(new Slot(planter, 2, 52, 35));
		addSlotToContainer(new Slot(planter, 3, 52, 53));

		addSlotToContainer(new Slot(planter, 4, 107, 35));
		addSlotToContainer(new Slot(planter, 5, 107, 53));
		addSlotToContainer(new Slot(planter, 6, 125, 35));
		addSlotToContainer(new Slot(planter, 7, 125, 53));

		int var3;
		for (var3 = 0; var3 < 3; ++var3) {
			for (int var4 = 0; var4 < 9; ++var4) {
				addSlotToContainer(new Slot(playerInventory, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3) {
			addSlotToContainer(new Slot(playerInventory, var3, 8 + var3 * 18, 142));
		}
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
