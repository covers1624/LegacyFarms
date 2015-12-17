package covers1624.legacyfarms.intermods.IC2;

import covers1624.legacyfarms.crop.CropProviders;
import covers1624.legacyfarms.handler.ConfigurationHandler;
import covers1624.legacyfarms.intermods.IC2.providers.CropProviderIC2;

public class IC2Module {

	public static void init() {
		if (ConfigurationHandler.ic2Support) {
			CropProviders.cropSticksCrops.add(new CropProviderIC2());
		}
	}

}
