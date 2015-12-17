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

public class TilePlanterMushroom extends TilePlanter {

	public TilePlanterMushroom() {
		super(CropProviders.fungalCrops);

		validSoil = new ItemStack(Blocks.mycelium);
		validGround = new ItemStack(Blocks.mycelium);
		validWaste = new ItemStack(Blocks.dirt);
		validDisposal = new ItemStack(Blocks.dirt);

		site = Blueprints.defaultShroom;
		siteOffset = new BlockPosition(-8, 0, -8);
		soil = Blueprints.shroomSoil;
		soilOffset = new BlockPosition(-6, 0, -6);
		plantation = Blueprints.shroomPlantation;
		plantationOffset = new BlockPosition(-6, 1, -6);
	}

	@Override
	public boolean isSpecialBlock(Block block, int meta) {
		return false;
	}

	@Override
	public void openGui(EntityPlayer player) {
		player.openGui(LegacyFarms.instance, GuiId.MushroomFarmGUI.ordinal(), player.worldObj, xCoord, yCoord, zCoord);
	}
}
