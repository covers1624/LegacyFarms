package covers1624.legacyfarms.crop;

import net.minecraft.item.ItemStack;

public class Overgrowth {
	public final ItemStack crop;
	public final ItemStack ripe;

	public Overgrowth(ItemStack crop, ItemStack ripe) {
		this.crop = crop;
		this.ripe = ripe;
	}

	public boolean hasCrop(ItemStack other) {
		return crop.isItemEqual(new ItemStack(other.getItem(), 1, 0));
	}

	public boolean hasRipe(ItemStack other) {
		return ripe.isItemEqual(new ItemStack(other.getItem(), 1, 0));
	}

}
