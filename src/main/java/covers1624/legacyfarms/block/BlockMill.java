package covers1624.legacyfarms.block;

import covers1624.legacyfarms.proxy.ClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;

public class BlockMill extends BlockBase {

	public BlockMill() {
		super(Material.rock);
		setBlockName("mill");//TODO change this.
		setHardness(1.5F);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getRenderType() {
		return ClientProxy.lfRenderId;
	}
}
