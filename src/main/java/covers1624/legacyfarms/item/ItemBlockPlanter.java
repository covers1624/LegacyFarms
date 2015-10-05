package covers1624.legacyfarms.item;

import covers1624.legacyfarms.block.BlockPlanter;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBlockPlanter extends ItemBlock {

	public ItemBlockPlanter(Block block) {
		super(block);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return BlockPlanter.getUnlocFromMeta(stack.getItemDamage());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTabs, List subTypes) {
		for (int i = 0; i < 7; i++) {
			subTypes.add(new ItemStack(item, 1, i));
		}
	}

}
