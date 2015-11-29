package covers1624.legacyfarms.tile.planter;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.crop.CropProviders;
import covers1624.legacyfarms.init.Blueprints;
import covers1624.legacyfarms.utils.GuiId;
import covers1624.lib.util.BlockPosition;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class TilePlanterNetherwarts extends TilePlanter {

	public TilePlanterNetherwarts() {
		super(CropProviders.infernalCrops);

		validSoil = new ItemStack(Blocks.soul_sand);
		validGround = new ItemStack(Blocks.soul_sand);
		validWaste = new ItemStack(Blocks.dirt);
		validDisposal = new ItemStack(Blocks.sand);

		site = Blueprints.defaultFarm;
		siteOffset = new BlockPosition(-7, 0, -7);
		soil = Blueprints.netherwartSoil;
		soilOffset = new BlockPosition(-7, 0, -7);
		plantation = Blueprints.netherwartPlantation;
		plantationOffset = new BlockPosition(-7, 1, -7);
	}

	@Override
	public void openGui(EntityPlayer player) {
		player.openGui(LegacyFarms.instance, GuiId.NetherFarmGUI.ordinal(), player.worldObj, xCoord, yCoord, zCoord);
	}

	@Override
	public boolean isSpecialBlock(Block block, int meta) {
		// TODO Auto-generated method stub
		return false;
	}

}
