package covers1624.legacyfarms.utils;

/**
 * Created by covers1624 on 10/10/2015}.
 *
 */
public class PlanterUtils {

	public static String getNameFromMeta(int meta) {
		switch (meta) {
		case 0:
			return "arboretum";
		case 1:
			return "farm";
		case 2:
			return "rubberFarm";
		case 3:
			return "pumpkinFarm";
		case 4:
			return "peatBog";
		case 5:
			return "mushroomFarm";
		case 6:
			return "infernalFarm";
		default:
			return "UNKNOWN";
		}
	}
}
