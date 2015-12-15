package covers1624.legacyfarms.tile.harvester.intermods;

import covers1624.legacyfarms.intermods.agricraft.providers.CropProviderAgriCraft;
import covers1624.legacyfarms.tile.harvester.TileHarvester;
import covers1624.lib.util.BlockPosition;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by covers1624 on 12/16/2015.
 */
public class TileHarvesterAgriCraft extends TileHarvester {

	public TileHarvesterAgriCraft() {
		super(new CropProviderAgriCraft());
		area = new BlockPosition(9, 4, 9);
		posOffset = new BlockPosition(-4, -2, -4);
	}

	@Override
	public void openGui(EntityPlayer player) {

	}
}
