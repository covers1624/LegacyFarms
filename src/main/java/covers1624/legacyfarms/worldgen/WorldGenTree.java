package covers1624.legacyfarms.worldgen;

import forestry.core.config.ForestryBlock;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;

import java.util.Random;

public class WorldGenTree extends WorldGenTrees {

	private int metaWood = 0;
	private int metaLeaves = 0;

	public WorldGenTree(boolean flag) {
		this(flag, 0, 0);
	}

	public WorldGenTree(boolean flag, int metaWood, int metaLeaves) {
		super(flag);
		this.metaWood = metaWood;
		this.metaLeaves = metaLeaves;
	}

	@Override
	public boolean generate(World world, Random random, int i, int j, int k) {
		int l;
		boolean flag;
		label0:
		{
			l = random.nextInt(3) + 4;
			flag = true;
			if (j >= 1) {
				world.getClass();
				if (j + l + 1 <= 256) {
					break label0;
				}
			}
			return false;
		}
		label1:
		{
			for (int i1 = j; i1 <= j + 1 + l; i1++) {
				byte byte0 = 1;
				if (i1 == j) {
					byte0 = 0;
				}
				if (i1 >= (j + 1 + l) - 2) {
					byte0 = 2;
				}
				for (int i2 = i - byte0; i2 <= i + byte0 && flag; i2++) {
					for (int l2 = k - byte0; l2 <= k + byte0 && flag; l2++) {
						if (i1 >= 0) {
							world.getClass();
							if (i1 < 256) {
								Block block = world.getBlock(i2, i1, l2);
								if (block != Blocks.air && block != Blocks.leaves) {
									flag = false;
								}
								continue;
							}
						}
						flag = false;
					}
				}

			}

			if (!flag) {
				return false;
			}
			Block j1 = world.getBlock(i, j - 1, k);
			if (j1 == ForestryBlock.soil.block()) {
				world.getClass();
				if (j < 256 - l - 1) {
					break label1;
				}
			}
			return false;
		}
		world.setBlock(i, j - 1, k, Blocks.sand);
		for (int k1 = (j - 3) + l; k1 <= j + l; k1++) {
			int j2 = k1 - (j + l);
			int i3 = 1 - j2 / 2;
			for (int k3 = i - i3; k3 <= i + i3; k3++) {

				int l3 = k3 - i;
				for (int i4 = k - i3; i4 <= k + i3; i4++) {
					int j4 = i4 - k;
					if ((Math.abs(l3) != i3 || Math.abs(j4) != i3 || random.nextInt(2) != 0 && j2 != 0) && !world.getBlock(k3, k1, i4).isOpaqueCube()) {
						world.setBlock(k3, k1, i4, Blocks.leaves, this.metaLeaves, 3);
					}
				}

			}

		}

		for (int l1 = 0; l1 < l; l1++) {
			Block block = world.getBlock(i, j + l1, k);
			if (block == Blocks.air || block == Blocks.leaves) {
				world.setBlock(i, j + l1, k, Blocks.log, this.metaWood, 3);
				// generateFirefly(world, random, i, j + l1, k);

			}
		}

		return true;
	}

}
