package covers1624.legacyfarms.crop.providers.entity;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.lib.util.BlockPosition;
import forestry.core.proxy.Proxies;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

public class CropSapling implements ICropEntity {

	private World world;
	private int xCoord;
	private int yCoord;
	private int zCoord;
	private Block block;
	private int meta;

	public CropSapling(World world, BlockPosition blockPos) {
		this.world = world;
		this.xCoord = blockPos.x;
		this.yCoord = blockPos.y;
		this.zCoord = blockPos.z;
		this.block = blockPos.getBlock(world);
		this.meta = blockPos.getBlockMeta(world);
	}

	@Override
	public boolean isHarvestable() {
		return block == Blocks.log;
	}

	@Override
	public int[] getNextPosition() {
		int[] next = null;

		int count = 1;
		Block block = world.getBlock(xCoord, yCoord + count, zCoord);
		while (block == Blocks.log) {
			next = new int[] { xCoord, yCoord + count, zCoord };
			count++;
			block = world.getBlock(xCoord, yCoord + count, zCoord);
		}

		if (next != null) {
			return next;
		}

		count = -1;
		block = world.getBlock(xCoord, yCoord + count, zCoord);
		while (block == Blocks.log) {
			next = new int[] { xCoord, yCoord + count, zCoord };
			count--;
			block = world.getBlock(xCoord, yCoord + count, zCoord);
		}

		return next;
	}

	@Override
	public ArrayList<ItemStack> doHarvest() {
		ArrayList<ItemStack> harvest = Blocks.log.getDrops(world, xCoord, yCoord, zCoord, meta, 0);
		Proxies.common.addBlockDestroyEffects(world, xCoord, yCoord, zCoord, block, 0);
		world.setBlockToAir(xCoord, yCoord, zCoord);
		return harvest;
	}
}
