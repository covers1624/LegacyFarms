package covers1624.legacyfarms.client.render;

import net.minecraft.tileentity.TileEntity;

public interface IBlockRenderer {

	void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f);

	void inventoryRender(double x, double y, double z, float f, float f1);

}
