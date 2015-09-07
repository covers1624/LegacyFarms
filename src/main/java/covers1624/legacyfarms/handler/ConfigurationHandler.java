package covers1624.legacyfarms.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

	public static Configuration configuration;

	public static int planterThrottle;
	public static int harvesterThrottle;

	public static int planterMaxRF;

	public static boolean planterSideSensitive;

	public static void init(File file) {
		if (configuration == null) {
			configuration = new Configuration(file);
		}
		loadConfiguration();
	}

	public static void loadConfiguration() {
		planterThrottle = configuration.getInt("Planter Throttle", "Performance", 10, 1, 1000, "Higher numbers increase working speeds of planters but also increase cpu load.");
		harvesterThrottle = configuration.getInt("Harvester Throttle", "Performance", 200, 1, 1000, "Higher numbers increase working speeds of harvesters but also increase cpu load.");
		planterSideSensitive = configuration.getBoolean("Planter Side Sensitive", "Customization", true, "Set to false if farms should output all harvested products regardless of side a pipe is attached to");

		planterMaxRF = configuration.getInt("Planter Max RF", "Power", 1024, 100, 10000, "The ammount of RF that Planters are able to store.");

		configuration.save();
	}

}
