package covers1624.legacyfarms.intermods.agricraft;

import com.InfinityRaider.AgriCraft.init.Items;
import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.handler.ConfigurationHandler;
import covers1624.legacyfarms.init.ModBlocks;
import covers1624.legacyfarms.tile.harvester.intermods.TileHarvesterAgriCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * Created by covers1624 on 12/16/2015.
 */
public class AgricraftModule {

	public static void init(){
		if (ConfigurationHandler.agricraftSupport){
			LegacyFarms.logger.info("Agricraft support initialized..");
			ModBlocks.blockHarvester.addSubItemAndTileAndRegister(9, "agricraftHarvester", TileHarvesterAgriCraft.class);
		} else {
			LegacyFarms.logger.trace("AgriCraft support disabled.");
		}
	}

	public static void initRecipes(){
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 9), "SGS", "GAG", "SGS", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockHarvester, 1, 0), 'S', Items.crops);
	}
}
