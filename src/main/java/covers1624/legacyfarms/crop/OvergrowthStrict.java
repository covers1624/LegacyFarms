package covers1624.legacyfarms.crop;

import net.minecraft.item.ItemStack;

public class OvergrowthStrict extends Overgrowth {
	public OvergrowthStrict(ItemStack crop, ItemStack ripe) {
		super(crop, ripe);
	}

	@Override
	public boolean hasCrop(ItemStack other) {
		return crop.isItemEqual(other);
	}

	@Override
	public boolean hasRipe(ItemStack other) {
		return crop.isItemEqual(other);
	}
}
