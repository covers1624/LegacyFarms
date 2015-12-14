package covers1624.legacyfarms.init;

import covers1624.legacyfarms.item.ItemCatalyst;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by covers1624 on 12/15/2015.
 */
public class ModItems {

	public static ItemCatalyst itemCatalyst;

	public static void init(){
		itemCatalyst = new ItemCatalyst();
		GameRegistry.registerItem(itemCatalyst, "itemCatalyst");
	}
}
