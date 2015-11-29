package covers1624.legacyfarms.tile.harvester;

import covers1624.legacyfarms.crop.CropProviders;
import net.minecraft.entity.player.EntityPlayer;

public class TileHarvesterSapling extends TileHarvester {

	public TileHarvesterSapling() {
		super(CropProviders.arborealCrops);
	}

	@Override
	public void openGui(EntityPlayer player) {

	}
}
