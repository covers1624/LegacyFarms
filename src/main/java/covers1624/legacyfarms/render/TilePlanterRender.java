package covers1624.legacyfarms.render;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.block.BlockPlanter;
import covers1624.legacyfarms.reference.Reference;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import java.util.HashMap;

public class TilePlanterRender extends TileEntitySpecialRenderer {



	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double d, double d1, double d2, float f) {
		int meta = tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
		if (tileEntity instanceof TilePlanter) {
			LegacyFarms.proxy.getPlanterRenderer(meta).renderTileEntityAt(tileEntity, d, d1, d2, f);
		}
	}

}
