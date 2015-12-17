package covers1624.legacyfarms.crop.providers.entity;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.lib.util.BlockPosition;
import forestry.core.proxy.Proxies;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

public class CropHerbaceous implements ICropEntity {

	private World world;
	private BlockPosition blockPos;
	private Block block;

	public CropHerbaceous(World world, BlockPosition blockPosition) {
		this.world = world;
		this.blockPos = blockPosition.copy();
		block = blockPos.getBlock(world);
	}

	@Override
	public boolean isHarvestable() {
		return true;
	}

	@Override
	public int[] getNextPosition() {
		return null;
	}

	@Override
	public ArrayList<ItemStack> doHarvest() {
		ArrayList<ItemStack> harvest = null;
		if (block == Blocks.pumpkin) {
			harvest = Blocks.pumpkin.getDrops(world, blockPos.x, blockPos.y, blockPos.z, 0, 0);
		} else if (block == Blocks.melon_block) {
			harvest = Blocks.melon_block.getDrops(world, blockPos.x, blockPos.y, blockPos.z, 0, 0);
		}
		blockPos.setBlock(world, Blocks.air);
		Proxies.common.addBlockDestroyEffects(world, blockPos.x, blockPos.y, blockPos.z, block, 0);
		return harvest;
	}
}
