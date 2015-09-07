package covers1624.legacyfarms.block;

import covers1624.legacyfarms.reference.Reference;
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
			topIcons[i] = iIconRegister.registerIcon(Reference.MOD_PREFIX + getUnlocFromMeta(i) + "Top");
			sideIcons[i] = iIconRegister.registerIcon(Reference.MOD_PREFIX + getUnlocFromMeta(i) + "Side");
			blankIcons[i] = iIconRegister.registerIcon(Reference.MOD_PREFIX + getUnlocFromMeta(i) + "Blank");
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
	public TileEntity createNewTileEntity(World world, int metadata) {
		return null;// new TileHarvester();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int facing, float facingX, float facingY, float facingZ) {
		return false;

	}

	public static String getUnlocFromMeta(int meta) {
		switch (meta) {
		case 0:
			return "logger";
		case 1:
			return "combine";
		case 2:
			return "rubberTreeHarvester";
		case 3:
			return "pumpkinHarvester";
		case 4:
			return "turbary";
		case 5:
			return "cactiHarvester";
		case 6:
			return "mushroomPicker";
		case 7:
			return "sugarCaneHarvester";
		case 8:
			return "infernalHarvester";
		default:
			return "UNKNOWN";
		}
	}

}
