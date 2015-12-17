package covers1624.legacyfarms.crop.providers.entity;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.lib.util.BlockPosition;
import forestry.core.proxy.Proxies;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

public class CropCacti implements ICropEntity {

	private World world;
	private BlockPosition blockPos;

	public CropCacti(World world, BlockPosition blockPosition) {
		this.world = world;
		this.blockPos = blockPosition.copy();
	}

	@Override
	public boolean isHarvestable() {
		return blockPos.copy().step(ForgeDirection.DOWN).getBlock(world) == Blocks.cactus && blockPos.copy().step(ForgeDirection.DOWN, 2).getBlock(world) == Blocks.cactus;
	}

	@Override
	public int[] getNextPosition() {
		return null;
	}

	@Override
	public ArrayList<ItemStack> doHarvest() {
		ArrayList<ItemStack> harvest = Blocks.cactus.getDrops(world, blockPos.x, blockPos.y, blockPos.z, 0, 0);
		Proxies.common.addBlockDestroyEffects(world, blockPos.x, blockPos.y, blockPos.z, Blocks.cactus, 0);
		blockPos.setBlock(world, Blocks.air);
		return harvest;
	}
}
