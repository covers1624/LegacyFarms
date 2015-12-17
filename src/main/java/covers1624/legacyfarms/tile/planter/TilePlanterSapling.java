package covers1624.legacyfarms.tile.planter;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.crop.CropProviders;
import covers1624.legacyfarms.crop.ICropProvider;
import covers1624.legacyfarms.handler.CropHandler;
import covers1624.legacyfarms.init.Blueprints;
import covers1624.legacyfarms.init.ForestryProxy;
import covers1624.legacyfarms.utils.GuiId;
import covers1624.lib.util.BlockPosition;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class TilePlanterSapling extends TilePlanter {

	public TilePlanterSapling() {
		super(CropProviders.arborealCrops);

		validSoil = new ItemStack(ForestryProxy.mushroom);
		validGround = new ItemStack(ForestryProxy.mushroom);
		validWaste = new ItemStack(Blocks.sand);
		validDisposal = new ItemStack(Blocks.sand);

		site = Blueprints.defaultArboretum;
		siteOffset = new BlockPosition(-7, 0, -7);
		soil = Blueprints.defaultSoil;
		soilOffset = new BlockPosition(-6, 0, -6);
		plantation = Blueprints.defaultPlantation;
		plantationOffset = new BlockPosition(-6, 1, -6);
	}

	@Override
	public void openGui(EntityPlayer player) {
		player.openGui(LegacyFarms.instance, GuiId.ArboretumGUI.ordinal(), player.worldObj, xCoord, yCoord, zCoord);
	}

	@Override
	public boolean isSpecialBlock(Block block, int meta) {
		if (block == ForestryProxy.mushroom) {
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
