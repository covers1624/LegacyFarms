package covers1624.legacyfarms.utils;

import buildcraft.api.core.Position;
import buildcraft.api.transport.IPipe;
import buildcraft.api.transport.IPipeConnection;
import covers1624.legacyfarms.handler.CropHandler;
import covers1624.lib.util.BlockPosition;
import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BlockUtils {

	public static ArrayList<ItemStack> getBlockDrops(World world, BlockPosition pos) {

		Block block = pos.getBlock(world);
		int meta = pos.getBlockMeta(world);
		return block.getDrops(world, pos.x, pos.y, pos.z, meta, 0);
	}

	public static ForgeDirection[] getPipeDirections(World world, BlockPosition blockPos, ForgeDirection from) {
		LinkedList<ForgeDirection> possiblePipes = new LinkedList<ForgeDirection>();

		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			if (from != ForgeDirection.UNKNOWN && from != dir.getOpposite()) {
				continue;
			}

			Position posPipe = new Position(blockPos.x, blockPos.y, blockPos.z, dir);
			posPipe.moveForwards(1.0);

			TileEntity pipeEntry = world.getTileEntity((int) posPipe.x, (int) posPipe.y, (int) posPipe.z);

			if (pipeEntry instanceof IPipe && ((IPipe) pipeEntry).getTile().canInjectItems(from)) {
				if (from != ForgeDirection.UNKNOWN && pipeEntry instanceof IPipeConnection) {
					if (((IPipe) pipeEntry).getTile().isPipeConnected(from)) {
						possiblePipes.add(dir);
					}
				} else {
					possiblePipes.add(dir);
				}
			}
		}

		return possiblePipes.toArray(new ForgeDirection[possiblePipes.size()]);

	}

	public static IInventory[] getAdjacentInventories(World world, BlockPosition blockPos, ForgeDirection from) {
		ArrayList<IInventory> inventories = new ArrayList<IInventory>();

		for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
			if (from != ForgeDirection.UNKNOWN && from != dir.getOpposite()) {
				continue;
			}
			blockPos.step(dir);
			TileEntity entity = blockPos.getTileEntity(world);
			if (entity != null) {
				if (entity instanceof IInventory) {
					inventories.add((IInventory) entity);
				}
			}
			blockPos.step(dir.getOpposite());
		}
		return inventories.toArray(new IInventory[inventories.size()]);
	}

	public static ForgeDirection[] filterPipeDirections(ForgeDirection[] all, ForgeDirection[] exclude) {
		LinkedList<ForgeDirection> filtered = new LinkedList<ForgeDirection>();
		ArrayList<ForgeDirection> excludeList = new ArrayList<ForgeDirection>(Arrays.asList(exclude));

		for (int i = 0; i < all.length; i++) {
			if (!excludeList.contains(all[i])) {
				filtered.add(all[i]);
			}
		}

		return filtered.toArray(new ForgeDirection[filtered.size()]);

	}

	public static void putFromStackIntoPipe(TileEntity tile, ForgeDirection[] pipes, ItemStack stack) {

		if (stack == null) {
			return;
		}
		if (stack.stackSize <= 0) {
			return;
		}
		if (pipes.length <= 0) {
			return;
		}

		int choice = tile.getWorldObj().rand.nextInt(pipes.length);

		Position itemPos = new Position(tile.xCoord, tile.yCoord, tile.zCoord, pipes[choice]);

		itemPos.x += 0.5;
		itemPos.y += 0.25;
		itemPos.z += 0.5;
		itemPos.moveForwards(0.5);

		Position pipePos = new Position(tile.xCoord, tile.yCoord, tile.zCoord, pipes[choice]);
		pipePos.moveForwards(1.0);

		IPipe pipe = (IPipe) tile.getWorldObj().getTileEntity((int) pipePos.x, (int) pipePos.y, (int) pipePos.z);

		ItemStack payload = stack.splitStack(1);
		pipe.getTile().injectItem(payload, true, itemPos.orientation, null);
	}

	public static boolean shouldBlueprintBreakBlock(World world, BlockPosition blockPosition) {
		Block block = blockPosition.getBlock(world);
		int meta = blockPosition.getBlockMeta(world);
		if (CropHandler.blueprintWhitelistedBlocks.contains(new ItemStack(block, 1, meta))) {
			return false;
		}
		if (CropHandler.blueprintBlacklistedBlocks.contains(new ItemStack(block, 1, meta))) {
			return true;
		}
		if (block.hasTileEntity(meta)) {
			return false;
		}
		return true;
	}

	public static IInventory getChest(IInventory inventory) {
		if (!(inventory instanceof TileEntityChest)) {
			return inventory;
		}

		TileEntityChest chest = (TileEntityChest) inventory;

		BlockPosition[] adjacent = new BlockPosition[] { new BlockPosition(chest.xCoord + 1, chest.yCoord, chest.zCoord), new BlockPosition(chest.xCoord - 1, chest.yCoord, chest.zCoord), new BlockPosition(chest.xCoord, chest.yCoord, chest.zCoord + 1), new BlockPosition(chest.xCoord, chest.yCoord, chest.zCoord - 1) };

		for (BlockPosition pos : adjacent) {
			TileEntity otherChest = chest.getWorldObj().getTileEntity(pos.x, pos.y, pos.z);
			if (otherChest instanceof TileEntityChest) {
				return new InventoryLargeChest("", chest, (TileEntityChest) otherChest);
			}
		}

		return inventory;
	}
}
