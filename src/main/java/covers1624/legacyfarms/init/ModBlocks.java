package covers1624.legacyfarms.init;

import covers1624.legacyfarms.block.BlockHarvester;
import covers1624.legacyfarms.block.BlockMill;
import covers1624.legacyfarms.block.BlockPlanter;
import covers1624.legacyfarms.item.ItemBlockHarvester;
import covers1624.legacyfarms.item.ItemBlockPlanter;
import covers1624.legacyfarms.tile.harvester.*;
import covers1624.legacyfarms.tile.mill.TileMill;
import covers1624.legacyfarms.tile.planter.*;
import covers1624.lib.item.MultiTileItem;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class ModBlocks {

	public static BlockHarvester blockHarvester;
	public static BlockPlanter blockPlanter;
	public static BlockMill blockMill;

	public static Block blockSapling = Blocks.sapling;

	public static void init() {
		//blockSapling = new BlockSaplingPhantom();
		//GameRegistry.registerBlock(blockSapling, blockSapling.getUnlocalizedName());
		//ItemUtils.readOres();
		blockHarvester = new BlockHarvester();
		GameRegistry.registerBlock(blockHarvester, ItemBlockHarvester.class, blockHarvester.getUnlocalizedName());
		initHarvesterTiles();

		blockPlanter = new BlockPlanter();
		GameRegistry.registerBlock(blockPlanter, ItemBlockPlanter.class, blockPlanter.getUnlocalizedName());
		initPlanterTiles();

		blockMill = new BlockMill();
		GameRegistry.registerBlock(blockMill, MultiTileItem.class, blockMill.getUnlocalizedName());
		blockMill.addSubItemAndTileAndRegister(0, "forester", TileMill.class);//TODO
	}

	private static void initPlanterTiles() {
		blockPlanter.addSubItemAndTileAndRegister(0, "arboretum", TilePlanterSapling.class);
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
		blockHarvester.addSubItemAndTileAndRegister(5, "cactiHarvester", TileHarvesterCacti.class);
		blockHarvester.addSubItemAndTileAndRegister(6, "mushroomPicker", TileHarvesterMushroom.class);
		blockHarvester.addSubItemAndTileAndRegister(7, "sugarCaneHarvester", TileHarvesterReeds.class);
		blockHarvester.addSubItemAndTileAndRegister(8, "infernalCombine", TileHarvesterNetherwart.class);
	}
}
