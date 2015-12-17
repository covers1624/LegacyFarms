package covers1624.legacyfarms.intermods.agricraft;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.crop.CropProviders;
import covers1624.legacyfarms.handler.ConfigurationHandler;
import covers1624.legacyfarms.init.ModBlocks;
import covers1624.legacyfarms.intermods.agricraft.providers.CropProviderAgriCraft;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AgricraftModule {

	public static Block blockCrop;
	public static Item itemCrops;

	static {
		try {
			blockCrop = (Block) Class.forName("com.InfinityRaider.AgriCraft.init.Blocks").getField("blockCrop").get(null);
			itemCrops = (Item) Class.forName("com.InfinityRaider.AgriCraft.init.Items").getField("crops").get(null);
		} catch (Exception e) {
			LegacyFarms.logger.error("Unable to reflect AgriCraft Blocks class..");
			e.printStackTrace();
		}
	}

	public static void init() {
		if (ConfigurationHandler.agricraftSupport) {
			LegacyFarms.logger.info("Agricraft support initialized..");
			CropProviders.cropSticksCrops.add(new CropProviderAgriCraft());
		} else {
			LegacyFarms.logger.trace("AgriCraft support disabled.");
		}
	}

	public static void initRecipes() {
		if (itemCrops != null) {
			GameRegistry.addRecipe(new ItemStack(ModBlocks.blockHarvester, 1, 9), "SGS", "GAG", "SGS", 'G', Blocks.glass, 'A', new ItemStack(ModBlocks.blockHarvester, 1, 0), 'S', itemCrops);
		}
	}
}
