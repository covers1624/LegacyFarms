package covers1624.legacyfarms.tile.harvester;

import covers1624.legacyfarms.crop.CropProviders;
import covers1624.lib.util.BlockPosition;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by covers1624 on 12/14/2015.
 */
public class TileHarvesterCacti extends  TileHarvester{

	public TileHarvesterCacti(){
		super(CropProviders.succulentCrops);
		area = new BlockPosition(21, 6, 21);
		isSideSensitive = false;
	}

	@Override
	public void openGui(EntityPlayer player) {

	}
}
