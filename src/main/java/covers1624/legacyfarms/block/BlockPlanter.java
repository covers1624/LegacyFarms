package covers1624.legacyfarms.block;

import covers1624.legacyfarms.proxy.ClientProxy;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockPlanter extends BlockBase {

	public BlockPlanter() {
		super(Material.rock);
		setHardness(1.5F);
		setBlockName("planter");
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getRenderType() {
		return ClientProxy.lfRenderId;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int facing, float facingX, float facingY, float facingZ) {
		if (player.isSneaking()) {
			return false;
		}
		TilePlanter tile = (TilePlanter) world.getTileEntity(x, y, z);
		tile.openGui(player);
		return true;
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		if (!world.isRemote) {
			return;
		}
		super.onBlockAdded(world, x, y, z);
		setDefaultDirection(world, x, y, z);
	}

	private void setDefaultDirection(World world, int x, int y, int z) {
		// Don't execute in multiplayer world
		if (!world.isRemote) {
			return;
		}

		TilePlanter tile = (TilePlanter) world.getTileEntity(x, y, z);
		Block l = world.getBlock(x, y, z - 1);
		Block i1 = world.getBlock(x, y, z + 1);
		Block j1 = world.getBlock(x - 1, y, z);
		Block k1 = world.getBlock(x + 1, y, z);
		tile.setFacing(ForgeDirection.WEST);
		if (l.isOpaqueCube() && !i1.isOpaqueCube()) {
			tile.setFacing(ForgeDirection.WEST);
		}
		if (i1.isOpaqueCube() && !l.isOpaqueCube()) {
			tile.setFacing(ForgeDirection.NORTH);
		}
		if (j1.isOpaqueCube() && !k1.isOpaqueCube()) {
			tile.setFacing(ForgeDirection.SOUTH);
		}
		if (k1.isOpaqueCube() && !j1.isOpaqueCube()) {
			tile.setFacing(ForgeDirection.EAST);
		}
	}
}
