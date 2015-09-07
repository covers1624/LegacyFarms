package covers1624.legacyfarms.init;

import covers1624.legacyfarms.crop.CropProviders;
import covers1624.legacyfarms.crop.providers.CropProviderNetherwart;
import covers1624.legacyfarms.crop.providers.CropProviderSapling;

public class Crops {

	public static void init() {
		CropProviders.arborealCrops.add(new CropProviderSapling());
		CropProviders.infernalCrops.add(new CropProviderNetherwart());
	}

}
