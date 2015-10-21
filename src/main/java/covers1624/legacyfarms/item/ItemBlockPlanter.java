package covers1624.legacyfarms.item;

import covers1624.lib.item.MultiTileItem;
import net.minecraft.block.Block;

public class ItemBlockPlanter extends MultiTileItem {

	public ItemBlockPlanter(Block block) {
		super(block);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

	//@Override
	//public String getUnlocalizedName(ItemStack stack) {
	//	return BlockPlanter.getUnlocFromMeta(stack.getItemDamage());
	//}

	//@SuppressWarnings({ "rawtypes", "unchecked" })
	//@Override
	//public void getSubItems(Item item, CreativeTabs creativeTabs, List subTypes) {
	//	for (int i = 0; i < 7; i++) {
	//		subTypes.add(new ItemStack(item, 1, i));
	//	}
	//}
}
