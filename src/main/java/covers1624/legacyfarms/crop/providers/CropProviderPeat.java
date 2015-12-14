package covers1624.legacyfarms.crop.providers;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.legacyfarms.crop.ICropProvider;
import covers1624.legacyfarms.crop.providers.entity.CropPeat;
import covers1624.legacyfarms.init.ForestryProxy;
import covers1624.lib.util.BlockPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by covers1624 on 11/30/2015.
 */
public class CropProviderPeat implements ICropProvider {
	@Override
	public boolean isGermling(ItemStack germling) {
		return false;
	}

	@Override
	public boolean isCrop(World world, BlockPosition blockPos) {
		return blockPos.getBlock(world) == ForestryProxy.soil && blockPos.getBlockMeta(world) == 13;
	}

	@Override
	public void addWindfall(ArrayList<ItemStack> windfall) {

	}

	@Override
	public boolean doPlant(ItemStack germling, World world, BlockPosition blockPos) {
		return false;
	}

	@Override
	public ICropEntity getCrop(World world, BlockPosition blockPos) {
		return new CropPeat(world, blockPos);
	}
}
