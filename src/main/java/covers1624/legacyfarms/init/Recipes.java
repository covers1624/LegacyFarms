package covers1624.legacyfarms.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by covers1624 on 12/14/2015.
 */
public class Recipes {

	public static void init() {
		//Planters.
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockPlanter, 1, 0), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryProxy.tubes, 1, 4), 'C', ForestryProxy.sturdyCasing, 'B', new ItemStack(ForestryProxy.circuitBards, 1, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockPlanter, 1, 1), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryProxy.tubes, 1, 2), 'C', ForestryProxy.sturdyCasing, 'B', new ItemStack(ForestryProxy.circuitBards, 1, 0));
		//GameRegistry.addRecipe(new ItemStack(ModBlocks.blockPlanter, 1, 2), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryItem.tubes.item(), 1, 2), 'C', ForestryProxy.sturdyCasing, 'B', new ItemStack(ForestryItem.circuitboards.item(), 1, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockPlanter, 1, 3), "MGP", "GAG", "PGM", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockPlanter, 1, 0), 'C', ForestryProxy.sturdyCasing, 'M', Blocks.melon_block, 'P', Blocks.pumpkin);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockPlanter, 1, 4), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryProxy.tubes, 1, 0), 'C', ForestryProxy.sturdyCasing, 'B', new ItemStack(ForestryProxy.circuitBards, 1, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockPlanter, 1, 5), "BGR", "GAG", "RGB", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockPlanter, 1, 0), 'C', ForestryProxy.sturdyCasing, 'B', Blocks.brown_mushroom, 'R', Blocks.red_mushroom);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockPlanter, 1, 6), "NGN", "GAG", "NGN", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockPlanter, 1, 0), 'C', ForestryProxy.sturdyCasing, 'N', Items.nether_wart);

		//Harvesters.
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 0), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryProxy.tubes, 1, 5), 'C', ForestryProxy.sturdyCasing, 'B', new ItemStack(ForestryProxy.circuitBards, 1, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 1), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryProxy.tubes, 1, 3), 'C', ForestryProxy.sturdyCasing, 'B', new ItemStack(ForestryProxy.circuitBards, 1, 0));
		//GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 2), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryProxy.tubes, 1, 5), 'C', ForestryProxy.sturdyCasing, 'B', new ItemStack(ForestryItem.circuitboards.item(), 1, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 3), "MGP", "GAG", "PGM", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockHarvester, 1, 0), 'C', ForestryProxy.sturdyCasing, 'M', Blocks.melon_block, 'P', Blocks.pumpkin);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 4), "GTG", "TCT", "GBG", 'G', Blocks.glass, 'T', new ItemStack(ForestryProxy.tubes, 1, 1), 'C', ForestryProxy.sturdyCasing, 'B', new ItemStack(ForestryProxy.circuitBards, 1, 0));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 5), "NGN", "GAG", "NGN", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockHarvester, 1, 0), 'C', ForestryProxy.sturdyCasing, 'N', Blocks.cactus);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 6), "BGR", "GAG", "RGB", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockHarvester, 1, 0), 'C', ForestryProxy.sturdyCasing, 'B', Blocks.brown_mushroom, 'R', Blocks.red_mushroom);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 7), "RGR", "GAG", "RGR", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockHarvester, 1, 0), 'C', ForestryProxy.sturdyCasing, 'R', Items.reeds);
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 8), "NGN", "GAG", "NGN", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockHarvester, 1, 0), 'C', ForestryProxy.sturdyCasing, 'N', Items.nether_wart);

		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockMill, 1, 0), "DGD", "GPG", "DGD", 'G', Blocks.glass, 'D', Items.diamond, 'P', new ItemStack(ModBlocks.blockPlanter));

		GameRegistry.addRecipe(new ItemStack(ModItems.itemCatalyst, 3), "CCC", "FBF", 'C', ForestryProxy.waxCapsuleEmpty, 'B', Items.bone, 'F', ForestryProxy.fertilizerCompound);
		GameRegistry.addRecipe(new ItemStack(ModItems.itemCatalyst, 3), "CCC", "FBF", 'C', ForestryProxy.emptyCan, 'B', Items.bone, 'F', ForestryProxy.fertilizerCompound);

		if (ForestryProxy.moduleApicultureEnabled){
			GameRegistry.addRecipe(new ItemStack(ModItems.itemCatalyst, 3), "CCC", "PBP", 'C', ForestryProxy.waxCapsuleEmpty, 'B', Items.bone, 'P', ForestryProxy.pollenCluster);
			GameRegistry.addRecipe(new ItemStack(ModItems.itemCatalyst, 3), "CCC", "PBP", 'C', ForestryProxy.emptyCan, 'B', Items.bone, 'P', ForestryProxy.pollenCluster);
			GameRegistry.addRecipe(new ItemStack(ModItems.itemCatalyst), "HHH", "FCF", "HHH", 'H', ForestryProxy.honeyDrop, 'F', ForestryProxy.fertilizerCompound, 'C', ForestryProxy.waxCapsuleEmpty);
			GameRegistry.addRecipe(new ItemStack(ModItems.itemCatalyst), "HHH", "FCF", "HHH", 'H', ForestryProxy.honeyDrop, 'F', ForestryProxy.fertilizerCompound, 'C', ForestryProxy.emptyCan);
			GameRegistry.addRecipe(new ItemStack(ModItems.itemCatalyst), "HHH", "PCP", "HHH", 'H', ForestryProxy.honeyDrop, 'P', ForestryProxy.pollenCluster, 'C', ForestryProxy.waxCapsuleEmpty);
			GameRegistry.addRecipe(new ItemStack(ModItems.itemCatalyst), "HHH", "PCP", "HHH", 'H', ForestryProxy.honeyDrop, 'P', ForestryProxy.pollenCluster, 'C', ForestryProxy.emptyCan);

		}
	}

	private static void addRecipe(ItemStack output, Object... inputs) {
		GameRegistry.addRecipe(new ShapedOreRecipe(output, inputs));
	}

}
