package covers1624.legacyfarms.init;

import covers1624.legacyfarms.crop.CropProviders;
import covers1624.legacyfarms.crop.providers.*;

public class Crops {

	public static void init() {
		CropProviders.arborealCrops.add(new CropProviderSapling());
		CropProviders.cerealCrops.add(new CropProviderSeeds());
		CropProviders.cerealCrops.add(new CropProviderPotato());
		CropProviders.cerealCrops.add(new CropProviderCarrots());
		CropProviders.infernalCrops.add(new CropProviderNetherwart());
		CropProviders.herbaceousCrops.add(new CropProviderHerbaceous());
		CropProviders.succulentCrops.add(new CropProviderCacti());
		CropProviders.poaleCrops.add(new CropProviderReeds());
		CropProviders.fungalCrops.add(new CropProviderMushroom());
	}

}
