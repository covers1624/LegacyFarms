package covers1624.legacyfarms.utils;

public class HarvesterUtils {

	public static String getNameFromMeta(int meta) {
		switch (meta) {
		case 0:
			return "logger";
		case 1:
			return "combine";
		case 2:
			return "rubberTreeHarvester";
		case 3:
			return "pumpkinHarvester";
		case 4:
			return "turbary";
		case 5:
			return "cactiHarvester";
		case 6:
			return "mushroomPicker";
		case 7:
			return "sugarCaneHarvester";
		case 8:
			return "infernalHarvester";
		case 9:
			return "cropStickHarvester";
		default:
			return "UNKNOWN";
		}
	}
}
