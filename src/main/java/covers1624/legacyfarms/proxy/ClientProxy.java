package covers1624.legacyfarms.proxy;

import covers1624.legacyfarms.block.BlockPlanter;
import covers1624.legacyfarms.reference.Reference;
import covers1624.legacyfarms.render.PlanterRenderingHandler;
import covers1624.legacyfarms.render.RenderPlanter;
import covers1624.legacyfarms.render.TilePlanterRender;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

import java.util.HashMap;

public class ClientProxy implements ILFProxy {

	public static int planterRenderID = RenderingRegistry.getNextAvailableRenderId();
	public static HashMap<Integer, RenderPlanter> planterRenderers = new HashMap<Integer, RenderPlanter>();

	@Override
	public void registerRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TilePlanter.class, new TilePlanterRender());
		RenderingRegistry.registerBlockHandler(planterRenderID, new PlanterRenderingHandler());

	}

	@Override public RenderPlanter getPlanterRenderer(int meta) {
		RenderPlanter renderPlanter;
		if (!planterRenderers.containsKey(meta)){
			renderPlanter = new RenderPlanter(Reference.MODEL_FOLDER + BlockPlanter.getUnlocFromMeta(meta));
			planterRenderers.put(meta, renderPlanter);
		} else {
			renderPlanter = planterRenderers.get(meta);
		}
		return renderPlanter;
	}

}
