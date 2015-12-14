package covers1624.legacyfarms.tile.harvester;

import covers1624.legacyfarms.crop.CropProviders;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by covers1624 on 12/14/2015.
 */
public class TileHarvesterSeeds extends TileHarvester{

	public TileHarvesterSeeds(){
		super(CropProviders.cerealCrops);
		isSideSensitive = false;
	}

	@Override
	public void openGui(EntityPlayer player) {

	}
}
