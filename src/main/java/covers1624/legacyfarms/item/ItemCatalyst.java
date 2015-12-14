package covers1624.legacyfarms.item;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

/**
 * Created by covers1624 on 12/15/2015.
 */
public class ItemCatalyst extends Item {

	public ItemCatalyst(){
		setCreativeTab(LegacyFarms.creativeTab);
		setUnlocalizedName("vialCatalyst");
	}

	@Override
	public void registerIcons(IIconRegister iIconRegister) {
		itemIcon = iIconRegister.registerIcon(Reference.MOD_PREFIX + getUnlocalizedName());
	}
}
