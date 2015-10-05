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

	// Functionality.
	public static boolean planterSideSensitive;
	public static boolean planterDropBlocks;

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

		// Functionality.
		planterSideSensitive = configuration.getBoolean("Planter Side Sensitive", "Customization", true, "Set to false if farms should output all harvested products regardless of side a pipe is attached to");
		planterDropBlocks = configuration.getBoolean("Planter Drop Blocks", "Customization", true, "Set this to false and Planters will not drop blocks when clearing an area.");

		configuration.save();
	}
}
