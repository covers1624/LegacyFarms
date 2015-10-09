package covers1624.legacyfarms.intermods.waila;

import covers1624.legacyfarms.tile.planter.TilePlanter;
import mcp.mobius.waila.api.IWailaRegistrar;

/**
 * Created by covers1624 on 10/5/2015}.
 */
public class WailaModule {

	public static void callBackRegister(IWailaRegistrar registrar){

		registrar.registerBodyProvider(new PlanterProvider(), TilePlanter.class);
	}

}
