package covers1624.legacyfarms.intermods.agricraft;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.handler.ConfigurationHandler;
import covers1624.legacyfarms.init.ModBlocks;
import covers1624.legacyfarms.tile.harvester.intermods.TileHarvesterAgriCraft;

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
}
