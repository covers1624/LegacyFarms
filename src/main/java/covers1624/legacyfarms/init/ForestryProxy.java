package covers1624.legacyfarms.init;

import covers1624.legacyfarms.LegacyFarms;
import cpw.mods.fml.common.registry.GameRegistry;
import forestry.apiculture.items.ItemPollenCluster;
import forestry.arboriculture.blocks.BlockSapling;
import forestry.core.blocks.BlockSoil;
import forestry.core.circuits.ItemCircuitBoard;
import forestry.core.items.*;
import forestry.core.utils.StringUtil;
import forestry.farming.blocks.BlockMushroom;
import forestry.plugins.*;
import net.minecraft.block.Block;

import java.util.EnumSet;

/**
 * Created by covers1624 on 12/15/2015.
 */
public class ForestryProxy {

	public static ItemForestry peat = PluginCore.items.peat;
	public static ItemForestry sturdyCasing = PluginCore.items.sturdyCasing;
	public static ItemElectronTube tubes = PluginCore.items.tubes;
	public static ItemCircuitBoard circuitBards = PluginCore.items.circuitboards;

	public static ItemLiquidContainer waxCapsuleEmpty = PluginFluids.items.waxCapsuleEmpty;
	public static ItemLiquidContainer emptyCan = PluginFluids.items.canEmpty;
	public static ItemForestryBonemeal fertilizerCompound = PluginCore.items.fertilizerCompound;

	public static ItemPollenCluster pollenCluster = PluginApiculture.items.pollenCluster;
	public static ItemOverlay honeyDrop = PluginApiculture.items.honeyDrop;

	public static BlockMushroom mushroom;
	public static BlockSoil soil = PluginCore.blocks.soil;
	public static BlockSapling blockSapling = PluginArboriculture.blocks.saplingGE;

	public static boolean moduleFarmingEnabled = PluginManager.Module.FARMING.isEnabled();
	public static boolean moduleApicultureEnabled = PluginManager.Module.APICULTURE.isEnabled();
	public static boolean moduleArboricultureEnabled = PluginManager.Module.ARBORICULTURE.isEnabled();


	// Sanity check.
	public static void init() {
		if (moduleFarmingEnabled) {
			mushroom = PluginFarming.blocks.mushroom;
		} else {
			LegacyFarms.logger.info("Unable to find Farming module of Forestry.. Injecting Fake Mushroom Block..");
			BlockMushroom mush = new BlockMushroom();
			mush.setBlockName("for.mushroom");
			GameRegistry.registerBlock(mush, ItemBlockTyped.class, StringUtil.cleanBlockName(mush));
			mushroom = mush;
		}
	}
 }
