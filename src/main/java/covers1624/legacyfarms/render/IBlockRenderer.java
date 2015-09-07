package covers1624.legacyfarms.render;

import net.minecraft.tileentity.TileEntity;

public interface IBlockRenderer {

	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f);

	public void inventoryRender(double x, double y, double z, float f, float f1);

}
