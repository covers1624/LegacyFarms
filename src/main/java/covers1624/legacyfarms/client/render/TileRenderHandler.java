package covers1624.legacyfarms.client.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TileRenderHandler extends TileEntitySpecialRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float partialTicks) {
		IBlockRenderer render = RenderingHandler.getIBlockRenderFromBlockAndMeta(tileEntity.getWorldObj().getBlock(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord), tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord));
		if (render != null) {
			render.renderTileEntityAt(tileEntity, x, y, z, partialTicks);
		}

	}

}
