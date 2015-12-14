package covers1624.legacyfarms.handler;

import covers1624.legacyfarms.init.ForestryProxy;
import covers1624.legacyfarms.utils.TreeGrowObjectHolder;
import covers1624.lib.util.BlockPosition;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.terraingen.SaplingGrowTreeEvent;

import java.util.ArrayList;

public class LFEventHandler {

	private static ArrayList<TreeGrowObjectHolder> trees = new ArrayList<TreeGrowObjectHolder>();
	private static ArrayList<TreeGrowObjectHolder> finishedTrees = new ArrayList<TreeGrowObjectHolder>();

	// Sand under sapling grow, TODO tree generator for small trees, or ASM vanilla tree gen.
	@SubscribeEvent
	public void saplingGrowEvent(SaplingGrowTreeEvent event) {
		BlockPosition blockPosition = new BlockPosition(event.x, event.y, event.z);
		blockPosition.step(ForgeDirection.DOWN);
		Block underSapling = blockPosition.getBlock(event.world);
		if (underSapling == ForestryProxy.soil) {
			trees.add(new TreeGrowObjectHolder(blockPosition.step(ForgeDirection.UP), event.world.provider.dimensionId, 100));
		}
	}

	@SubscribeEvent
	public void tickEvent(WorldTickEvent event) {
		if (event.phase == Phase.END) {
			if (!trees.isEmpty()) {
				for (TreeGrowObjectHolder objectHolder : trees) {
					// Make sure we are in the right dim.
					if (event.world.provider.dimensionId != objectHolder.getDimId()) {
						continue;
					}
					objectHolder.tick(); // No sense ticking the object if it
					// isn't in the correct world.
					if (!objectHolder.shouldChangeBlock()) {
						finishedTrees.add(objectHolder);
					}
					Block block = objectHolder.getBlockPosition().getBlock(event.world);
					int meta = objectHolder.getBlockPosition().getBlockMeta(event.world);
					if (CropHandler.containsLog(new ItemStack(block, 1, meta))) {
						objectHolder.getBlockPosition().step(ForgeDirection.DOWN);
						objectHolder.getBlockPosition().setBlock(event.world, Blocks.sand);
						objectHolder.getBlockPosition().step(ForgeDirection.UP);
						finishedTrees.add(objectHolder);
					}

				}
			}

			// Avoid ConcurrentModificationException
			if (!finishedTrees.isEmpty()) {
				for (TreeGrowObjectHolder objectHolder : finishedTrees) {
					if (trees.contains(objectHolder)) {
						trees.remove(objectHolder);
					}
				}
				finishedTrees.clear();
			}
		}
	}

}
