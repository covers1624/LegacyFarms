package covers1624.legacyfarms.tile.harvester;

import covers1624.legacyfarms.crop.CropProviders;
import net.minecraft.entity.player.EntityPlayer;

public class TileHarvesterHerbaceous extends TileHarvester {

	public TileHarvesterHerbaceous() {
		super(CropProviders.herbaceousCrops);
	}

	@Override
	public void openGui(EntityPlayer player) {

	}
}
