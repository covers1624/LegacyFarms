package covers1624.legacyfarms.crop.providers.entity;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.legacyfarms.init.ForestryProxy;
import covers1624.lib.util.BlockPosition;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by covers1624 on 11/30/2015.
 */
public class CropPeat implements ICropEntity {

	private World world;
	private BlockPosition blockPos;
	private int meta;

	public CropPeat(World world, BlockPosition blockPosition){
		this.world = world;
		this.blockPos = blockPosition.copy();
		meta = blockPos.getBlockMeta(this.world);
	}

	@Override
	public boolean isHarvestable() {
		return meta == 13;
	}

	@Override
	public int[] getNextPosition() {
		return null;
	}

	@Override
	public ArrayList<ItemStack> doHarvest() {
		ArrayList<ItemStack> harvest = new ArrayList<ItemStack>();
		harvest.add(new ItemStack(ForestryProxy.peat));
		blockPos.setBlock(world, Blocks.dirt);
		return harvest;
	}
}
