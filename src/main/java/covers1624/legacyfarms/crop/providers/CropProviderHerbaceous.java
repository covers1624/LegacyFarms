package covers1624.legacyfarms.crop.providers;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.legacyfarms.crop.ICropProvider;
import covers1624.legacyfarms.crop.providers.entity.CropHerbaceous;
import covers1624.lib.util.BlockPosition;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

/**
 * Created by covers1624 on 11/30/2015.
 */
public class CropProviderHerbaceous implements ICropProvider {
	@Override
	public boolean isGermling(ItemStack germling) {
		return germling.isItemEqual(new ItemStack(Items.melon_seeds)) || germling.isItemEqual(new ItemStack(Items.pumpkin_seeds));
	}

	@Override
	public boolean isCrop(World world, BlockPosition blockPos) {
		return blockPos.getBlock(world) == Blocks.pumpkin || blockPos.getBlock(world) == Blocks.melon_block;
	}

	@Override
	public void addWindfall(ArrayList<ItemStack> windfall) {
	}

	@Override
	public boolean doPlant(ItemStack germling, World world, BlockPosition blockPos) {
		if (blockPos.getBlock(world) == Blocks.air || blockPos.copy().step(ForgeDirection.DOWN).getBlock(world) != Blocks.farmland) {
			return false;
		}
		if (germling.isItemEqual(new ItemStack(Items.pumpkin_seeds))) {
			blockPos.setBlock(world, Blocks.pumpkin_stem);
		} else {
			blockPos.setBlock(world, Blocks.melon_stem);
		}
		return true;
	}

	@Override
	public ICropEntity getCrop(World world, BlockPosition blockPos) {
		return new CropHerbaceous(world, blockPos);
	}
}
