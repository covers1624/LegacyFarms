package covers1624.legacyfarms.crop.providers;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.legacyfarms.crop.ICropProvider;
import covers1624.legacyfarms.init.ModBlocks;
import covers1624.lib.util.BlockPosition;
import covers1624.lib.util.ItemUtils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

public class CropProviderSapling implements ICropProvider {

	@Override
	public boolean isGermling(ItemStack germling) {
		return germling != null && validPlants.contains(ItemUtils.copyStack(germling, 1));
	}

	@Override
	public boolean isCrop(World world, BlockPosition blockPos) {
		Block block = blockPos.getBlock(world);
		int meta = blockPos.getBlockMeta(world);
		//if (ItemUtils.getOreClassSafe(new ItemStack(block, 1, meta)).equals("treeSapling") || ItemUtils.getOreClassSafe(new ItemStack(block, 1, meta)).equals("logWood")) {
		//	return true;
		//}
		if (new ItemStack(block, 1, meta).isItemEqual(new ItemStack(Blocks.sapling)) || new ItemStack(block, 1, meta).isItemEqual(new ItemStack(Blocks.log))) {
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
	public boolean doPlant(ItemStack germling, World world, BlockPosition blockPos) {
		Block block = blockPos.getBlock(world);
		blockPos.step(ForgeDirection.DOWN);
		Block below = blockPos.getBlock(world);
		int meta = blockPos.getBlockMeta(world);
		blockPos.step(ForgeDirection.UP);
		if (block != Blocks.air || below != ModBlocks.forestrySoil || meta != 0 || !(germling.getItem() instanceof ItemBlock)) {
			return false;
		}

		Block toPlace = Block.getBlockFromItem(germling.getItem());
		blockPos.setBlock(world, toPlace, germling.getItemDamage());
		return true;
	}

	@Override
	public ICropEntity getCrop(World world, BlockPosition blockPos) {
		return new CropSapling(world, blockPos);
	}

	static {
		validPlants.add(new ItemStack(ModBlocks.blockSapling));
	}
}
