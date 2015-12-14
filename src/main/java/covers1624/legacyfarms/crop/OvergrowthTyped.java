package covers1624.legacyfarms.crop;

import net.minecraft.item.ItemStack;

/**
 * Created by covers1624 on 12/15/2015.
 */
public class OvergrowthTyped extends Overgrowth {
	public OvergrowthTyped(ItemStack crop, ItemStack ripe) {
		super(crop, ripe);
	}

	@Override
	public boolean hasCrop(ItemStack other) {
		if (crop.getItemDamage() >= 0){
			ItemStack detyped = new ItemStack(other.getItem(), 1, other.getItemDamage() & 0x03);
			return crop.isItemEqual(detyped);
		} else {
			return crop.getItem() == other.getItem();
		}
	}
}
