package covers1624.legacyfarms.tile.harvester;

import covers1624.legacyfarms.crop.CropProviders;
import net.minecraft.entity.player.EntityPlayer;

public class TileHarvesterNetherwart extends TileHarvester {

	public TileHarvesterNetherwart() {
		super(CropProviders.infernalCrops);
	}

	@Override
	public void openGui(EntityPlayer player) {

	}
}
