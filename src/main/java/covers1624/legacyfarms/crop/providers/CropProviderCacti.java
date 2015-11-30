package covers1624.legacyfarms.crop.providers;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.legacyfarms.crop.ICropProvider;
import covers1624.legacyfarms.crop.providers.entity.CropCacti;
import covers1624.lib.util.BlockPosition;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by covers1624 on 11/30/2015.
 */
public class CropProviderCacti implements ICropProvider {
	@Override
	public boolean isGermling(ItemStack germling) {
		return false;
	}

	@Override
	public boolean isCrop(World world, BlockPosition blockPos) {
		return blockPos.getBlock(world) == Blocks.cactus;
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
		return new CropCacti(world, blockPos);
	}
}
