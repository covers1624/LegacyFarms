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

public class TilePlanterHerbaceous extends TilePlanter {

	public TilePlanterHerbaceous() {
		super(CropProviders.herbaceousCrops);
		validSoil = new ItemStack(Blocks.dirt);
		validGround = new ItemStack(Blocks.farmland);
		validGroundMorph = new ItemStack(Blocks.farmland, 1, 7);
		validWaste = new ItemStack(Blocks.dirt);
		validDisposal = new ItemStack(Blocks.sand);

		site = Blueprints.pumpkinArea;
		siteOffset = new BlockPosition(-6, -1, -6);
		soil = Blueprints.pumpkinSoil;
		soilOffset = new BlockPosition(-6, -1, -6);
		plantation = Blueprints.pumpkinFarm;
		plantationOffset = new BlockPosition(-6, 0, -6);
	}

	@Override
	public boolean isSpecialBlock(Block block, int meta) {
		return false;
	}

	@Override
	public void openGui(EntityPlayer player) {
		player.openGui(LegacyFarms.instance, GuiId.PumpkinFarmGUI.ordinal(), player.worldObj, xCoord, yCoord, zCoord);
	}
}
