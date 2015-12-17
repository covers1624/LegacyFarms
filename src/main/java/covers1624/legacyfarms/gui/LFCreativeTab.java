package covers1624.legacyfarms.gui;

import covers1624.legacyfarms.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LFCreativeTab extends CreativeTabs {

	public LFCreativeTab() {
		super("legacyFarms");
	}

	@Override
	public Item getTabIconItem() {
		return null;
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(ModBlocks.blockHarvester);
	}

}
