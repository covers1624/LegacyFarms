package covers1624.legacyfarms.tile.harvester;

import java.util.ArrayList;

import covers1624.legacyfarms.tile.TileBase;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public abstract class TileHarvester extends TileBase {//implements IInventory {

	private ArrayList<ItemStack> validWindfall = new ArrayList<ItemStack>();

	public void putWindfall() {

	}
}
