package covers1624.legacyfarms.intermods.IC2.providers.entity;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.lib.util.BlockPosition;
import ic2.api.crops.ICropTile;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;

public class CropEntityIC2 implements ICropEntity {

	private World world;
	private BlockPosition blockPos;

	public CropEntityIC2(World world, BlockPosition blockPosition) {
		this.world = world;
		this.blockPos = blockPosition.copy();
	}

	@Override
	public boolean isHarvestable() {
		TileEntity tileEntity = blockPos.getTileEntity(world);
		if (tileEntity instanceof ICropTile) {
			ICropTile crop = (ICropTile) tileEntity;
			if (crop.getCrop() != null && crop.getCrop().canBeHarvested(crop)) {
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
		ICropTile crop = (ICropTile) blockPos.getTileEntity(world);
		ItemStack[] drops = crop.harvest_automated(false);
		ArrayList<ItemStack> harvest = new ArrayList<ItemStack>();
		for (ItemStack drop : drops) {
			if (drop == null || drop.getItem() == null) {
				continue;
			}
			harvest.add(drop);
		}
		return harvest;
	}
}
