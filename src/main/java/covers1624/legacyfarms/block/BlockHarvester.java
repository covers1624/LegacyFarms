package covers1624.legacyfarms.block;

import covers1624.legacyfarms.reference.Reference;
import covers1624.legacyfarms.tile.harvester.TileHarvesterSapling;
import covers1624.legacyfarms.utils.HarvesterUtils;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockHarvester extends BlockBase {

	private IIcon[] topIcons;
	private IIcon[] sideIcons;
	private IIcon[] blankIcons;

	public BlockHarvester() {
		super(Material.rock);
		setHardness(1.5F);
		setBlockName("harvester");
		topIcons = new IIcon[9];
		sideIcons = new IIcon[9];
		blankIcons = new IIcon[9];
	}

	@Override
	public void registerBlockIcons(IIconRegister iIconRegister) {
		for (int i = 0; i < 9; i++) {
			topIcons[i] = iIconRegister.registerIcon(Reference.MOD_PREFIX + HarvesterUtils.getNameFromMeta(i) + "Top");
			sideIcons[i] = iIconRegister.registerIcon(Reference.MOD_PREFIX + HarvesterUtils.getNameFromMeta(i) + "Side");
			blankIcons[i] = iIconRegister.registerIcon(Reference.MOD_PREFIX + HarvesterUtils.getNameFromMeta(i) + "Blank");
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		if (side > 1) {
			return sideIcons[meta];
		} else {
			return topIcons[meta];
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int facing, float facingX, float facingY, float facingZ) {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		TileEntity tileEntity = super.createNewTileEntity(world, meta);
		if (tileEntity == null) {
			if (meta == 0) {
				return new TileHarvesterSapling();
			}
		}
		return tileEntity;
	}
}
