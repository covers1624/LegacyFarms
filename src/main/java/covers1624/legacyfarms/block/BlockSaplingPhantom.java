package covers1624.legacyfarms.block;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.worldgen.WorldGenTree;
import net.minecraft.block.BlockSapling;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockSaplingPhantom extends BlockSapling {

	private WorldGenerator[] generators;
	private ItemStack[] drops;

	public BlockSaplingPhantom() {
		setHardness(0.0f);
		setCreativeTab(LegacyFarms.creativeTab);
		setBlockName("phantomSapling");
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}

	private void setupGenerators() {
		generators = new WorldGenerator[4];
		drops = new ItemStack[4];
		for (int i = 0; i < 4; i++) {
			generators[i] = new WorldGenTree(true, i, i);
			drops[i] = new ItemStack(Blocks.sapling, 1, i);
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return null;// super.getIcon(side, meta);
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		int type = metadata & 0x03;
		ret.add(drops[type]);

		return ret;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		if (world.isRemote) {
			return;
		}

		int meta = world.getBlockMetadata(x, y, z);
		int type = meta & 0x03;
		int maturity = meta >> 2;

		tickSapling(world, x, y, z, random, type, maturity);
	}

	private void tickSapling(World world, int x, int y, int z, Random random, int type, int maturity) {
		int lightvalue = world.getBlockLightValue(x, y + 1, z);

		int growchance = 15;

		if (lightvalue >= 9 && random.nextInt(growchance) == 0) {
			if (maturity != 3) {
				maturity = 3;
				int matX = maturity << 2;
				int meta = (matX | type);

				world.setBlockMetadataWithNotify(x, y, z, meta, 3);
			} else {
				growTree(world, x, y, z, random);
			}
		}
	}

	private void growTree(World world, int x, int y, int z, Random random) {
		int type = world.getBlockMetadata(x, y, z) & 0x03;

		world.setBlockToAir(x, y, z);
		if (!generators[type].generate(world, random, x, y, z)) {
			world.setBlock(x, y, z, this, type, 3);
		}
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs p_149666_2_, List list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
		list.add(new ItemStack(item, 1, 2));
		list.add(new ItemStack(item, 1, 3));
	}

}
