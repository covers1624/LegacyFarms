package covers1624.legacyfarms.proxy;

import covers1624.legacyfarms.client.render.RenderPlanter;
import covers1624.legacyfarms.client.render.RenderingHandler;
import covers1624.legacyfarms.client.render.TileRenderHandler;
import covers1624.legacyfarms.init.ModBlocks;
import covers1624.legacyfarms.reference.Reference;
import covers1624.legacyfarms.tile.TileBase;
import covers1624.legacyfarms.utils.PlanterUtils;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

import java.util.HashMap;

public class ClientProxy implements ILFProxy {

	public static int lfRenderId = RenderingRegistry.getNextAvailableRenderId();
	public static HashMap<Integer, RenderPlanter> planterRenderers = new HashMap<Integer, RenderPlanter>();
	private static RenderingHandler renderingHandler = new RenderingHandler();

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerBlockHandler(lfRenderId, renderingHandler);
		ClientRegistry.bindTileEntitySpecialRenderer(TileBase.class, new TileRenderHandler());
		RenderingHandler.registerBlockRender(ModBlocks.blockPlanter, 0, new RenderPlanter(Reference.MODEL_FOLDER + PlanterUtils.getNameFromMeta(0)));
		RenderingHandler.registerBlockRender(ModBlocks.blockPlanter, 3, new RenderPlanter(Reference.MODEL_FOLDER + PlanterUtils.getNameFromMeta(3)));
		RenderingHandler.registerBlockRender(ModBlocks.blockPlanter, 4, new RenderPlanter(Reference.MODEL_FOLDER + PlanterUtils.getNameFromMeta(4)));
		RenderingHandler.registerBlockRender(ModBlocks.blockPlanter, 6, new RenderPlanter(Reference.MODEL_FOLDER + PlanterUtils.getNameFromMeta(6)));

	}

	public RenderPlanter getPlanterRenderer(int meta) {
		RenderPlanter renderPlanter;
		if (!planterRenderers.containsKey(meta)) {
			renderPlanter = new RenderPlanter(Reference.MODEL_FOLDER + PlanterUtils.getNameFromMeta(meta));
			planterRenderers.put(meta, renderPlanter);
		} else {
			renderPlanter = planterRenderers.get(meta);
		}
		return renderPlanter;
	}

}
