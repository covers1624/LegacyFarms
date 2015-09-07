package covers1624.legacyfarms.proxy;

import covers1624.legacyfarms.render.PlanterRenderingHandler;
import covers1624.legacyfarms.render.TilePlanterRender;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy implements ILFProxy {

	public static int planterRenderID = RenderingRegistry.getNextAvailableRenderId();

	@Override
	public void registerRenderers() {
		// RenderingRegistry.registerBlockHandler(planterRenderID, new RenderHandler());
		ClientRegistry.bindTileEntitySpecialRenderer(TilePlanter.class, new TilePlanterRender());
		RenderingRegistry.registerBlockHandler(new PlanterRenderingHandler());

	}

}
