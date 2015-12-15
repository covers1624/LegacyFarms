package covers1624.legacyfarms.block;

import covers1624.legacyfarms.proxy.ClientProxy;
import net.minecraft.block.material.Material;

/**
 * Created by covers1624 on 12/15/2015.
 */
public class BlockMill extends BlockBase{

	public BlockMill() {
		super(Material.rock);
		setBlockName("mill");//TODO change this.
		setHardness(1.5F);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getRenderType() {
		return ClientProxy.lfRenderId;
	}
}