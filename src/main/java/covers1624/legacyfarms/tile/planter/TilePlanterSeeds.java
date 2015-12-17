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

public class TilePlanterSeeds extends TilePlanter {

	public TilePlanterSeeds() {
		super(CropProviders.cerealCrops);

		validSoil = new ItemStack(Blocks.dirt);
		validGround = new ItemStack(Blocks.farmland);
		validGroundMorph = new ItemStack(Blocks.farmland, 1, 7);
		validWaste = new ItemStack(Blocks.dirt);
		validDisposal = new ItemStack(Blocks.sand);

		site = Blueprints.defaultFarm;
		siteOffset = new BlockPosition(-7, 0, -7);
		soil = Blueprints.farmSoil;
		soilOffset = new BlockPosition(-7, 0, -7);
		plantation = Blueprints.wheatPlantation;
		plantationOffset = new BlockPosition(-7, 1, -7);
	}

	@Override
	public boolean isSpecialBlock(Block block, int meta) {
		return false;
	}

	@Override
	public void openGui(EntityPlayer player) {
		player.openGui(LegacyFarms.instance, GuiId.FarmGUI.ordinal(), player.worldObj, xCoord, yCoord, zCoord);
	}
}
