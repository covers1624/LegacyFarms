package covers1624.legacyfarms.crop.providers.entity;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.lib.util.BlockPosition;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

/**
 * Created by covers1624 on 11/30/2015.
 */
public class CropMushroom implements ICropEntity {

	private World world;
	private BlockPosition blockPos;
	private Block block;

	public CropMushroom(World world, BlockPosition blockPosition) {
		this.world = world;
		this.blockPos = blockPosition.copy();
		block = blockPos.getBlock(world);
	}

	@Override
	public boolean isHarvestable() {
		return block == Blocks.brown_mushroom_block || block == Blocks.red_mushroom_block;
	}

	@Override
	public int[] getNextPosition() {
		int[] next = null;
		BlockPosition cleanBlockPos = blockPos.copy();
		cleanBlockPos.orientation = ForgeDirection.UP;
		cleanBlockPos.moveForwards(1);
		Block suspect = cleanBlockPos.getBlock(world);

		while (suspect == Blocks.brown_mushroom_block || suspect == Blocks.red_mushroom_block) {
			next = new int[] { cleanBlockPos.x, cleanBlockPos.y, cleanBlockPos.z };
			cleanBlockPos.moveForwards(1);
			suspect = cleanBlockPos.getBlock(world);
		}

		if (next != null) {
			return next;
		}

		cleanBlockPos = blockPos.copy();
		cleanBlockPos.orientation = ForgeDirection.DOWN;
		cleanBlockPos.moveForwards(1);
		suspect = cleanBlockPos.getBlock(world);

		while (suspect == Blocks.brown_mushroom_block || suspect == Blocks.red_mushroom_block) {
			next = new int[] { cleanBlockPos.x, cleanBlockPos.y, cleanBlockPos.z };
			cleanBlockPos.moveForwards(1);
			suspect = cleanBlockPos.getBlock(world);
		}
		return next;
	}

	@Override
	public ArrayList<ItemStack> doHarvest() {
		int meta = blockPos.getBlockMeta(world);
		ArrayList<ItemStack> harvest;
		if (block == Blocks.brown_mushroom_block) {
			harvest = Blocks.brown_mushroom_block.getDrops(world, blockPos.x, blockPos.y, blockPos.z, meta, 0);
		} else {
			harvest = Blocks.red_mushroom_block.getDrops(world, blockPos.x, blockPos.y, blockPos.z, meta, 0);
		}
		return harvest;
	}
}
