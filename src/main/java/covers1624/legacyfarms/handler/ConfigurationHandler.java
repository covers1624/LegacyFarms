package covers1624.legacyfarms.handler;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {

	public static Configuration configuration;

	// Throttles and Performance.
	public static int planterThrottle;
	public static int harvesterThrottle;

	// Power.
	public static int planterMaxRF;
	public static boolean planterUseRF;

	public static boolean harvesterUseRF;
	public static int harvesterMaxRF;

	// Functionality.
	public static boolean planterSideSensitive;
	public static boolean harvesterSideSensitive;
	public static boolean planterDropBlocks;

	//Intermods.
	public static boolean agricraftSupport;
	public static boolean ic2Support;

	public static void init(File file) {
		if (configuration == null) {
			configuration = new Configuration(file);
		}
		loadConfiguration();
	}

	public static void loadConfiguration() {

		// Throttles and Performance.
		planterThrottle = configuration.getInt("Planter Throttle", "Performance", 10, 1, 1000, "Higher numbers increase working speeds of planters but also increase cpu load.");
		harvesterThrottle = configuration.getInt("Harvester Throttle", "Performance", 200, 1, 1000, "Higher numbers increase working speeds of harvesters but also increase cpu load.");

		// Power.
		planterUseRF = configuration.getBoolean("Planter Use RF", "Power", true, "Set this to false and all planters will not use RF.");
		planterMaxRF = configuration.getInt("Planter Max RF", "Power", 1024, 100, 10000, "The ammount of RF that Planters are able to store.");

		harvesterUseRF = configuration.getBoolean("Harvester Use RF", "Power", true, "Set this to false and all Harvesters will not use RF.");
		harvesterMaxRF = configuration.getInt("Harvester Max RF", "Power", 1024, 100, 10000, "The amount of RF that Harvesters are able to store.");

		// Functionality.
		planterSideSensitive = configuration.getBoolean("Planter Side Sensitive", "Customization", true, "Set to false if planters should output all harvested products regardless of side a pipe is attached to");
		harvesterSideSensitive = configuration.getBoolean("Harvester Side Sensitive", "Customization", true, "Set to false if harvesters should output all harvested products regardless of side a pipe is attached to");
		planterDropBlocks = configuration.getBoolean("Planter Drop Blocks", "Customization", true, "Set this to false and Planters will not drop blocks when clearing an area.");

		agricraftSupport = configuration.getBoolean("Agricraft Support", "Intermods", true, "Set this to false to disable agricraft support.");
		ic2Support = configuration.getBoolean("IC2 Support", "Intermods", true, "Set this to false to disable IC2 Crop Support.");

		configuration.save();
	}
}
