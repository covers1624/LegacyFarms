package covers1624.legacyfarms.crop.providers;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.legacyfarms.crop.ICropProvider;
import covers1624.legacyfarms.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

public class CropProviderSapling implements ICropProvider {

	@Override
	public boolean isGermling(ItemStack germling) {
		return germling.isItemEqual(new ItemStack(Blocks.sapling));
	}

	@Override
	public boolean isCrop(World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		return block == ModBlocks.blockSapling || block == Blocks.sapling || block == Blocks.log;
	}

	@Override
	public ItemStack[] getWindfall() {
		ArrayList<ItemStack> windfall = new ArrayList<ItemStack>();
		windfall.add(new ItemStack(Blocks.sapling, 1, 0));
		windfall.add(new ItemStack(Blocks.sapling, 1, 1));
		windfall.add(new ItemStack(Blocks.sapling, 1, 2));
		windfall.add(new ItemStack(Blocks.sapling, 1, 3));

		if (true) {
			windfall.add(new ItemStack(Items.apple));
			windfall.add(new ItemStack(Items.golden_apple));
		}
		// for (ItemStack fruit : ForestryAPI.loggerWindfall) {
		// windfall.add(fruit);
		// }

		return windfall.toArray(new ItemStack[0]);
	}

	@Override
	public boolean doPlant(ItemStack germling, World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);

		// Target block needs to be empty
		if (block != Blocks.air) {
			return false;
		}

		// Can only plant on soulsand
		Block below = world.getBlock(x, y - 1, z);
		int meta = world.getBlockMetadata(x, y - 1, z);
		if (below != ModBlocks.forestrySoil || meta != 0) {
			return false;
		}

		world.setBlock(x, y, z, ModBlocks.blockSapling, germling.getItemDamage(), 3);
		return true;
	}

	@Override
	public ICropEntity getCrop(World world, int x, int y, int z) {
		return new CropSapling(world, x, y, z);
	}
}
