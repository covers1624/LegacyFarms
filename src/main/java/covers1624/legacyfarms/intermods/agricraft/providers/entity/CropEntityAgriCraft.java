package covers1624.legacyfarms.intermods.agricraft.providers.entity;

import com.InfinityRaider.AgriCraft.api.v2.ICrop;
import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.lib.util.BlockPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class CropEntityAgriCraft implements ICropEntity {

	private World world;
	private BlockPosition blockPos;

	public CropEntityAgriCraft(World world, BlockPosition blockPosition) {
		this.world = world;
		this.blockPos = blockPosition.copy();
	}

	@Override
	public boolean isHarvestable() {
		TileEntity tileEntity = blockPos.getTileEntity(world);
		if (tileEntity instanceof ICrop) {
			ICrop crop = (ICrop) tileEntity;
			if (crop.isMature()) {
				List<BlockPosition> adjacent = blockPos.getAdjacent(false);
				for (BlockPosition position : adjacent) {
					TileEntity adjacentTile = position.getTileEntity(world);
					if (adjacentTile instanceof ICrop) {
						ICrop adjacentCrop = (ICrop) adjacentTile;
						if (adjacentCrop.isCrossCrop()) {
							return false;
						}
					}
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public int[] getNextPosition() {
		return new int[0];
	}

	@Override
	public ArrayList<ItemStack> doHarvest() {
		ICrop crop = (ICrop) blockPos.getTileEntity(world);
		ArrayList<ItemStack> drops = crop.getPlant().getFruitsOnHarvest(crop.getGain(), world.rand);
		ArrayList<ItemStack> harvest = new ArrayList<ItemStack>();
		for (ItemStack drop : drops) {
			if (drop == null || drop.getItem() == null) {
				continue;
			}
			harvest.add(drop);
		}
		world.setBlockMetadataWithNotify(blockPos.x, blockPos.y, blockPos.z, 2, 2);
		return harvest;
	}
}
