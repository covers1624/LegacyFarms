package covers1624.legacyfarms.tile.harvester;

import covers1624.legacyfarms.crop.CropProviders;
import net.minecraft.entity.player.EntityPlayer;

public class TileHarvesterMushroom extends TileHarvester {

	public TileHarvesterMushroom() {
		super(CropProviders.fungalCrops);
		this.isSideSensitive = false;
	}

	@Override
	public void openGui(EntityPlayer player) {

	}
}
