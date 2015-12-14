package covers1624.legacyfarms.init;

import covers1624.legacyfarms.LegacyFarms;
import cpw.mods.fml.common.registry.GameRegistry;
import forestry.core.blocks.BlockSoil;
import forestry.core.circuits.ItemCircuitBoard;
import forestry.core.items.ItemBlockTyped;
import forestry.core.items.ItemElectronTube;
import forestry.core.items.ItemForestry;
import forestry.core.utils.StringUtil;
import forestry.farming.blocks.BlockMushroom;
import forestry.plugins.PluginCore;
import forestry.plugins.PluginFarming;
import forestry.plugins.PluginManager;

import java.util.EnumSet;

/**
 * Created by covers1624 on 12/15/2015.
 */
public class ForestryProxy {

	public static ItemForestry peat = PluginCore.items.peat;
	public static ItemForestry sturdyCasing = PluginCore.items.sturdyCasing;
	public static ItemElectronTube tubes = PluginCore.items.tubes;
	public static ItemCircuitBoard circuitBards = PluginCore.items.circuitboards;

	public static BlockMushroom mushroom;
	public static BlockSoil soil = PluginCore.blocks.soil;


	//Make sure mushrooms are always registered.
	public static void sanityCheckForestry() {
		EnumSet<PluginManager.Module> loadedModules = PluginManager.getLoadedModules();
		boolean farmingExists = false;
		for (PluginManager.Module module : loadedModules) {
			if (module.ordinal() == PluginManager.Module.FARMING.ordinal()) {
				LegacyFarms.logger.info("Found Farming module of Forestry.");
				farmingExists = true;
				mushroom = PluginFarming.blocks.mushroom;
				break;
			}
		}
		if (!farmingExists) {
			LegacyFarms.logger.info("Unable to find Farming module of Forestry.. Injecting Fake Mushroom Block..");
			BlockMushroom mush = new BlockMushroom();
			mush.setBlockName("for.mushroom");
			GameRegistry.registerBlock(mush, ItemBlockTyped.class, StringUtil.cleanBlockName(mush));
			mushroom = mush;
		}
	}
 }
