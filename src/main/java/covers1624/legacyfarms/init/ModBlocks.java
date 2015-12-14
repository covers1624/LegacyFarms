package covers1624.legacyfarms.init;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.block.BlockHarvester;
import covers1624.legacyfarms.block.BlockPlanter;
import covers1624.legacyfarms.item.ItemBlockHarvester;
import covers1624.legacyfarms.item.ItemBlockPlanter;
import covers1624.legacyfarms.tile.harvester.*;
import covers1624.legacyfarms.tile.planter.*;
import cpw.mods.fml.common.registry.GameRegistry;
import forestry.core.config.ForestryBlock;
import forestry.core.items.ItemTypedBlock;
import forestry.farming.gadgets.BlockMushroom;
import forestry.plugins.PluginManager;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

import java.util.EnumSet;

public class ModBlocks {

	public static BlockHarvester blockHarvester;
	public static BlockPlanter blockPlanter;

	public static Block blockSapling = Blocks.sapling;
	public static Block forestrySoil = ForestryBlock.soil.block();

	public static void init() {
		sanityCheckForestry();
		//blockSapling = new BlockSaplingPhantom();
		//GameRegistry.registerBlock(blockSapling, blockSapling.getUnlocalizedName());
		//ItemUtils.readOres();
		blockHarvester = new BlockHarvester();
		GameRegistry.registerBlock(blockHarvester, ItemBlockHarvester.class, blockHarvester.getUnlocalizedName());
		initHarvesterTiles();

		blockPlanter = new BlockPlanter();
		GameRegistry.registerBlock(blockPlanter, ItemBlockPlanter.class, blockPlanter.getUnlocalizedName());
		initPlanterTiles();


	}

	private static void initPlanterTiles() {
		blockPlanter.addSubItemAndTileAndRegister(0, "arbouretum", TilePlanterSapling.class);
		blockPlanter.addSubItemAndTileAndRegister(1, "farm", TilePlanterSeeds.class);
		blockPlanter.addSubItemAndTileAndRegister(3, "pumpkinFarm", TilePlanterHerbaceous.class);
		blockPlanter.addSubItemAndTileAndRegister(4, "peatBog", TilePlanterBog.class);
		blockPlanter.addSubItemAndTileAndRegister(5, "mushroomFarm", TilePlanterMushroom.class);
		blockPlanter.addSubItemAndTileAndRegister(6, "infernalFarm", TilePlanterNetherwarts.class);
	}

	private static void initHarvesterTiles() {
		blockHarvester.addSubItemAndTileAndRegister(0, "logger", TileHarvesterSapling.class);
		blockHarvester.addSubItemAndTileAndRegister(1, "combine", TileHarvesterSeeds.class);
		blockHarvester.addSubItemAndTileAndRegister(3, "pumpkinHarvester", TileHarvesterHerbaceous.class);
		blockHarvester.addSubItemAndTileAndRegister(4, "turbary", TileHarvesterBog.class);
		blockHarvester.addSubItemAndTileAndRegister(6, "mushroomPicker", TileHarvesterMushroom.class);
		blockHarvester.addSubItemAndTileAndRegister(8, "infernalCombine", TileHarvesterNetherwart.class);
	}

	//Make sure mushrooms are always registered.
	private static void sanityCheckForestry(){
		EnumSet<PluginManager.Module> loadedModules = PluginManager.getLoadedModules();
		boolean farmingExists = false;
		for (PluginManager.Module module: loadedModules){
			if(module.ordinal() == PluginManager.Module.FARMING.ordinal()){
				LegacyFarms.logger.info("Found Farming module of Forestry.");
				farmingExists = true;
				break;
			}
		}
		if(!farmingExists){
			LegacyFarms.logger.info("Unable to find Farming module of Forestry.. Injecting Fake Mushroom Block..");
			ForestryBlock.mushroom.registerBlock(new BlockMushroom(), ItemTypedBlock.class, "mushroom");
		}
	}

}
