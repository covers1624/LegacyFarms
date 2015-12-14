package covers1624.legacyfarms.tile.planter;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.crop.providers.CropProviderPeat;
import covers1624.legacyfarms.init.Blueprints;
import covers1624.legacyfarms.init.ForestryProxy;
import covers1624.legacyfarms.utils.GuiId;
import covers1624.lib.util.BlockPosition;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * Created by covers1624 on 12/1/2015.
 */
public class TilePlanterBog extends TilePlanter{


	public TilePlanterBog(){
		super(new CropProviderPeat());
		validSoil = new ItemStack(ForestryProxy.soil, 1, 1);
		validGround = new ItemStack(ForestryProxy.soil, 1, 1);
		validWaste = new ItemStack(Blocks.dirt);
		validDisposal = new ItemStack(Blocks.dirt);

		site = Blueprints.defaultFarm;
		siteOffset = new BlockPosition(-7, 0, -7);
		soil = Blueprints.bogEarth;
		soilOffset = new BlockPosition(-7, 0, -7);

		requiresGermling = false;
	}

	@Override
	public boolean isSpecialBlock(Block block, int meta) {
		return false;
	}

	@Override
	public void openGui(EntityPlayer player) {
		player.openGui(LegacyFarms.instance, GuiId.PeatBogGUI.ordinal(), player.worldObj, xCoord, yCoord, zCoord);
	}
}
