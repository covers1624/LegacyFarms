package covers1624.legacyfarms;

import covers1624.legacyfarms.gui.LFCreativeTab;
import covers1624.legacyfarms.handler.ConfigurationHandler;
import covers1624.legacyfarms.handler.CropHandler;
import covers1624.legacyfarms.handler.LFEventHandler;
import covers1624.legacyfarms.handler.LFGuiHandler;
import covers1624.legacyfarms.init.Blueprints;
import covers1624.legacyfarms.init.Crops;
import covers1624.legacyfarms.init.ModBlocks;
import covers1624.legacyfarms.proxy.ILFProxy;
import covers1624.legacyfarms.reference.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraftforge.common.MinecraftForge;

@Mod(name = Reference.MOD_NAME, modid = Reference.MOD_ID, version = Reference.MOD_VERSION, dependencies = "after:Forestry")
public class LegacyFarms {

	public static final LFCreativeTab creativeTab = new LFCreativeTab();

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static ILFProxy proxy;

	@Instance(Reference.MOD_NAME)
	public static LegacyFarms instance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		instance = this;
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new LFGuiHandler());

		// Register to all the things
		LFEventHandler eventHandler = new LFEventHandler();
		MinecraftForge.EVENT_BUS.register(eventHandler);
		MinecraftForge.TERRAIN_GEN_BUS.register(eventHandler);
		FMLCommonHandler.instance().bus().register(eventHandler);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		ModBlocks.init();
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		Blueprints.init();
		Crops.init();
		CropHandler.init();
	}

}