package covers1624.legacyfarms.init;

import covers1624.legacyfarms.block.BlockHarvester;
import covers1624.legacyfarms.block.BlockPlanter;
import covers1624.legacyfarms.item.ItemBlockHarvester;
import covers1624.legacyfarms.item.ItemBlockPlanter;
import covers1624.legacyfarms.tile.harvester.TileHarvester;
import covers1624.legacyfarms.tile.planter.TilePlanterNetherwarts;
import covers1624.legacyfarms.tile.planter.TilePlanterSapling;
import cpw.mods.fml.common.registry.GameRegistry;
import forestry.core.config.ForestryBlock;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class ModBlocks {

	public static BlockHarvester blockHarvester;
	public static BlockPlanter blockPlanter;

	public static Block blockSapling = Blocks.sapling;
	public static Block forestrySoil = ForestryBlock.soil.block();

	public static void init() {
		blockHarvester = new BlockHarvester();
		GameRegistry.registerBlock(blockHarvester, ItemBlockHarvester.class, blockHarvester.getUnlocalizedName());

		blockPlanter = new BlockPlanter();
		GameRegistry.registerBlock(blockPlanter, ItemBlockPlanter.class, blockPlanter.getUnlocalizedName());
		initPlanterTiles();
	}

	private static void initPlanterTiles() {
		blockPlanter.addSubItemAndTileAndRegister(0, "arbouretum", TilePlanterSapling.class);
		blockPlanter.addSubItemAndTileAndRegister(6, "infernalFarm", TilePlanterSapling.class);
	}

}
