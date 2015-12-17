package covers1624.legacyfarms.tile.harvester.intermods;

import covers1624.legacyfarms.crop.CropProviders;
import covers1624.legacyfarms.tile.harvester.TileHarvester;
import covers1624.lib.util.BlockPosition;
import net.minecraft.entity.player.EntityPlayer;

public class TileCropStickHarvester extends TileHarvester {

	public TileCropStickHarvester() {
		super(CropProviders.cropSticksCrops);
		area = new BlockPosition(9, 4, 9);
		posOffset = new BlockPosition(-4, -2, -4);
	}

	@Override
	public void openGui(EntityPlayer player) {

	}
}
