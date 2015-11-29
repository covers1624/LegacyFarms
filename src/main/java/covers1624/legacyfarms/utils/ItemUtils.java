package covers1624.legacyfarms.utils;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by covers1624 on 10/15/2015}.
 */
public class ItemUtils {

	/**
	 * Returns true if the items match, will ignore metadata if one or both items have the wildcard value as their metadata.
	 *
	 * @param stack1
	 * @param stack2
	 * @return
	 */
	public static boolean areStacksSameType(ItemStack stack1, ItemStack stack2) {
		boolean ignoreMeta = false;
		if (stack1.getItemDamage() == OreDictionary.WILDCARD_VALUE || stack2.getItemDamage() == OreDictionary.WILDCARD_VALUE) {
			ignoreMeta = true;
		}
		if (stack1.getItem() == stack2.getItem()) {
			if (!ignoreMeta) {
				return stack1.getItemDamage() == stack2.getItemDamage();
			}
			return true;
		}
		return false;
	}

}
