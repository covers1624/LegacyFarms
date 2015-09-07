package covers1624.legacyfarms.tile.planter;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.crop.CropProviders;
import covers1624.legacyfarms.crop.ICropProvider;
import covers1624.legacyfarms.handler.CropHandler;
import covers1624.legacyfarms.init.Blueprints;
import covers1624.legacyfarms.init.ModBlocks;
import covers1624.legacyfarms.utils.GuiId;
import covers1624.legacyfarms.utils.Vect;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class TilePlanterSapling extends TilePlanter {

	public TilePlanterSapling() {
		super(CropProviders.arborealCrops);

		validSoil = new ItemStack(ModBlocks.forestrySoil);
		validGround = new ItemStack(ModBlocks.forestrySoil);
		validWaste = new ItemStack(Blocks.sand);
		validDisposal = new ItemStack(Blocks.sand);

		site = Blueprints.defaultArboretum;
		siteOffset = new Vect(-7, 0, -7);
		soil = Blueprints.defaultSoil;
		soilOffset = new Vect(-6, 0, -6);
		plantation = Blueprints.defaultPlantation;
		plantationOffset = new Vect(-6, 1, -6);
	}

	@Override
	public void openGui(EntityPlayer player) {
		player.openGui(LegacyFarms.instance, GuiId.ArboretumGUI.ordinal(), player.worldObj, xCoord, yCoord, zCoord);
	}

	@Override
	public boolean isSpecialBlock(Block block, int meta) {
		if (block == ModBlocks.forestrySoil || block == Block.getBlockFromItem(validWaste.getItem())) {
			return true;
		}
		if (CropHandler.containsLogOrLeaf(new ItemStack(block, 1, meta))) {
			return true;
		}
		for (ICropProvider provider : cropProviders) {
			if (provider.isGermling(new ItemStack(block, 1, meta))) {
				return true;
			}
		}
		return false;
	}

}
