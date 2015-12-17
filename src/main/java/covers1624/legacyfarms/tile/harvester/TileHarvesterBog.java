package covers1624.legacyfarms.tile.harvester;

import covers1624.legacyfarms.crop.providers.CropProviderPeat;
import covers1624.lib.util.BlockPosition;
import net.minecraft.entity.player.EntityPlayer;

public class TileHarvesterBog extends TileHarvester {

	public TileHarvesterBog() {
		super(new CropProviderPeat());
		this.area = new BlockPosition(21, 6, 21);
		this.isSideSensitive = true;
	}

	@Override
	public void openGui(EntityPlayer player) {

	}
}
