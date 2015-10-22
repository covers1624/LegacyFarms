package covers1624.legacyfarms.crop.providers;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.legacyfarms.crop.ICropProvider;
import covers1624.legacyfarms.init.ModBlocks;

import covers1624.lib.util.ItemUtils;
import covers1624.lib.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

public class CropProviderSapling implements ICropProvider {

	@Override
	public boolean isGermling(ItemStack germling) {
		if (germling != null){
			return ItemUtils.matchItemStackOre(germling, new ItemStack(Blocks.sapling));
		}
		return false;
	}

	@Override
	public boolean isCrop(World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		//if (ItemUtils.getOreClassSafe(new ItemStack(block, 1, meta)).equals("treeSapling") || ItemUtils.getOreClassSafe(new ItemStack(block, 1, meta)).equals("logWood")) {
		//	return true;
		//}
		if (new ItemStack(block, 1, meta).isItemEqual(new ItemStack(Blocks.sapling)) || new ItemStack(block, 1, meta).isItemEqual(new ItemStack(Blocks.log))){
			return true;
		}
		return false;
	}

	@Override
	public ItemStack[] getWindfall() {
		ArrayList<ItemStack> windfall = new ArrayList<ItemStack>();
		windfall.add(new ItemStack(Blocks.sapling, 1, 0));
		windfall.add(new ItemStack(Blocks.sapling, 1, 1));
		windfall.add(new ItemStack(Blocks.sapling, 1, 2));
		windfall.add(new ItemStack(Blocks.sapling, 1, 3));

		//if (true) {
		windfall.add(new ItemStack(Items.apple));
		windfall.add(new ItemStack(Items.golden_apple));
		//}
		// for (ItemStack fruit : ForestryAPI.loggerWindfall) {
		// windfall.add(fruit);
		// }

		return windfall.toArray(new ItemStack[windfall.size()]);
	}

	@Override
	public boolean doPlant(ItemStack germling, World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		Block below = world.getBlock(x, y - 1, z);
		int meta = world.getBlockMetadata(x, y - 1, z);
		if (block != Blocks.air || below != ModBlocks.forestrySoil || meta != 0) {
			return false;
		}
		if (!(germling.getItem() instanceof ItemBlock)) {
			return false;
		}

		Block toPlace = Block.getBlockFromItem(germling.getItem());

		world.setBlock(x, y, z, toPlace, germling.getItemDamage(), 3);
		return true;
	}

	@Override
	public ICropEntity getCrop(World world, int x, int y, int z) {
		return new CropSapling(world, x, y, z);
	}
}
