package covers1624.legacyfarms.crop.providers.entity;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.lib.util.BlockPosition;
import forestry.core.proxy.Proxies;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by covers1624 on 11/30/2015.
 */
public class CropPotato implements ICropEntity {

	private World world;
	private BlockPosition blockPos;
	private int meta;

	public CropPotato(World world, BlockPosition blockPosition) {
		this.world = world;
		this.blockPos = blockPosition.copy();
		this.meta = blockPos.getBlockMeta(world);
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
		ArrayList<ItemStack> harvest = Blocks.potatoes.getDrops(world, blockPos.x, blockPos.y, blockPos.z, meta, 0);
		blockPos.setBlock(world, Blocks.air);
		Proxies.common.addBlockDestroyEffects(world,blockPos.x, blockPos.y, blockPos.z,Blocks.potatoes, meta);
		return harvest;
	}
}
