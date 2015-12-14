package covers1624.legacyfarms.tile.mill;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.crop.Overgrowth;
import covers1624.legacyfarms.crop.OvergrowthStrict;
import covers1624.legacyfarms.init.ForestryProxy;
import covers1624.legacyfarms.init.ModItems;
import covers1624.legacyfarms.utils.GuiId;
import covers1624.lib.util.BlockPosition;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockSapling;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by covers1624 on 12/15/2015.
 */
public class TileMillForester extends TileMillGrower {

	public TileMillForester() {
		super(new ItemStack(ModItems.itemCatalyst));
		putOvergrowth(new Overgrowth(new ItemStack(Blocks.sapling), new ItemStack(Blocks.log)));

		putOvergrowth(new OvergrowthStrict(new ItemStack(Blocks.wheat, 1, 0), new ItemStack(Blocks.wheat, 1, 7))); // Wheat
		putOvergrowth(new OvergrowthStrict(new ItemStack(Blocks.wheat, 1, 1), new ItemStack(Blocks.wheat, 1, 7))); // Wheat
		putOvergrowth(new OvergrowthStrict(new ItemStack(Blocks.wheat, 1, 2), new ItemStack(Blocks.wheat, 1, 7))); // Wheat
		putOvergrowth(new OvergrowthStrict(new ItemStack(Blocks.wheat, 1, 3), new ItemStack(Blocks.wheat, 1, 7))); // Wheat
		putOvergrowth(new OvergrowthStrict(new ItemStack(Blocks.wheat, 1, 4), new ItemStack(Blocks.wheat, 1, 7))); // Wheat
		putOvergrowth(new OvergrowthStrict(new ItemStack(Blocks.wheat, 1, 5), new ItemStack(Blocks.wheat, 1, 7))); // Wheat
		putOvergrowth(new OvergrowthStrict(new ItemStack(Blocks.wheat, 1, 6), new ItemStack(Blocks.wheat, 1, 7))); // Wheat
	}

	public void openGui(EntityPlayer player) {
		player.openGui(LegacyFarms.instance, GuiId.ForesterGUI.ordinal(), player.worldObj, xCoord, yCoord, zCoord);
	}

	@Override
	public void growCrop(ItemStack crop, BlockPosition blockPos) {
		if (crop.isItemEqual(new ItemStack(Blocks.sapling))){
			((BlockSapling)Blocks.sapling).func_149853_b(worldObj, worldObj.rand, blockPos.x, blockPos.y, blockPos.z);
		}
		if (ForestryProxy.moduleArboricultureEnabled){
			if (crop.isItemEqual(new ItemStack(ForestryProxy.blockSapling))){
				ForestryProxy.blockSapling.func_149853_b(worldObj, worldObj.rand, blockPos.x, blockPos.y, blockPos.z);
			}
		}
		if (crop.getItem() == Item.getItemFromBlock(Blocks.wheat)){
			((BlockCrops)Blocks.wheat).func_149853_b(worldObj, worldObj.rand, blockPos.x, blockPos.y, blockPos.z);
		}
		if (crop.isItemEqual(new ItemStack(Blocks.nether_wart))){
			blockPos.setBlock(worldObj, blockPos.getBlock(worldObj), 3);
		}
	}

	//TODO our own stuff.
	@Override
	public Object getGui(EntityPlayer entityPlayer, int i) {
		return null;
	}

	@Override
	public Object getContainer(EntityPlayer entityPlayer, int i) {
		return null;
	}
}
