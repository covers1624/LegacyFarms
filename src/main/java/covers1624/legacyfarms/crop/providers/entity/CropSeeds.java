package covers1624.legacyfarms.crop.providers.entity;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.lib.util.BlockPosition;
import forestry.core.proxy.Proxies;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

public class CropSeeds implements ICropEntity {

	private World world;
	private BlockPosition blockPos;
	private int meta;

	public CropSeeds(World world, BlockPosition blockPosition) {
		this.world = world;
		blockPos = new BlockPosition(blockPosition);
		meta = blockPos.getBlockMeta(world);
	}

	@Override
	public boolean isHarvestable() {
		return meta >= 7;
	}

	@Override
	public int[] getNextPosition() {
		return null;
	}

	@Override
	public ArrayList<ItemStack> doHarvest() {
		ArrayList<ItemStack> harvest = Blocks.wheat.getDrops(world, blockPos.x, blockPos.y, blockPos.z, meta, 0);
		blockPos.setBlock(world, Blocks.air);
		Proxies.common.addBlockDestroyEffects(world, blockPos.x, blockPos.y, blockPos.z, Blocks.wheat, meta);
		return harvest;
	}
}
