package covers1624.legacyfarms.init;

import cpw.mods.fml.common.registry.GameRegistry;
import forestry.core.config.ForestryItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by covers1624 on 12/14/2015.
 */
public class Recipes {

	public static void init(){
		//Planters.
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockPlanter, 1, 0), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryItem.tubes.item(), 1, 4), 'C', ForestryItem.sturdyCasing.item(), 'B', new ItemStack(ForestryItem.circuitboards.item(), 1, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockPlanter, 1, 1), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryItem.tubes.item(), 1, 2), 'C', ForestryItem.sturdyCasing.item(), 'B', new ItemStack(ForestryItem.circuitboards.item(), 1, 0));
		//GameRegistry.addRecipe(new ItemStack(ModBlocks.blockPlanter, 1, 2), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryItem.tubes.item(), 1, 2), 'C', ForestryItem.sturdyCasing.item(), 'B', new ItemStack(ForestryItem.circuitboards.item(), 1, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockPlanter, 1, 3), "MGP", "GAG", "PGM", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockPlanter, 1, 0), 'C', ForestryItem.sturdyCasing.item(), 'M', Blocks.melon_block, 'P', Blocks.pumpkin);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockPlanter, 1, 4), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryItem.tubes.item(), 1, 0), 'C', ForestryItem.sturdyCasing.item(), 'B', new ItemStack(ForestryItem.circuitboards.item(), 1, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockPlanter, 1, 5), "BGR", "GAG", "RGB", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockPlanter, 1, 0), 'C', ForestryItem.sturdyCasing.item(), 'B', Blocks.brown_mushroom, 'R', Blocks.red_mushroom);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockPlanter, 1, 6), "NGN", "GAG", "NGN", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockPlanter, 1, 0), 'C', ForestryItem.sturdyCasing.item(), 'N', Items.nether_wart);

		//Harvesters.
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 0), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryItem.tubes.item(), 1, 5), 'C', ForestryItem.sturdyCasing.item(), 'B', new ItemStack(ForestryItem.circuitboards.item(), 1, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 1), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryItem.tubes.item(), 1, 3), 'C', ForestryItem.sturdyCasing.item(), 'B', new ItemStack(ForestryItem.circuitboards.item(), 1, 0));
		//GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 2), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryItem.tubes.item(), 1, 5), 'C', ForestryItem.sturdyCasing.item(), 'B', new ItemStack(ForestryItem.circuitboards.item(), 1, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 3), "MGP", "GAG", "PGM", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockHarvester, 1, 0), 'C', ForestryItem.sturdyCasing.item(), 'M', Blocks.melon_block, 'P', Blocks.pumpkin);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 4), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryItem.tubes.item(), 1, 1), 'C', ForestryItem.sturdyCasing.item(), 'B', new ItemStack(ForestryItem.circuitboards.item(), 1, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 5), "NGN", "GAG", "NGN", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockHarvester, 1, 0), 'C', ForestryItem.sturdyCasing.item(), 'N', Blocks.cactus);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 6), "BGR", "GAG", "RGB", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockHarvester, 1, 0), 'C', ForestryItem.sturdyCasing.item(), 'B', Blocks.brown_mushroom, 'R', Blocks.red_mushroom);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 7), "RGR", "GAG", "RGR", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockHarvester, 1, 0), 'C', ForestryItem.sturdyCasing.item(), 'R', Items.reeds);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 8), "NGN", "GAG", "NGN", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockHarvester, 1, 0), 'C', ForestryItem.sturdyCasing.item(), 'N', Items.nether_wart);
	}


	private static void addRecipe(ItemStack output, Object... inputs){
		GameRegistry.addRecipe(new ShapedOreRecipe(output, inputs));
	}

}
