package covers1624.legacyfarms.proxy;

import covers1624.legacyfarms.client.render.RenderMill;
import covers1624.legacyfarms.client.render.RenderPlanter;
import covers1624.legacyfarms.client.render.RenderingHandler;
import covers1624.legacyfarms.client.render.TileRenderHandler;
import covers1624.legacyfarms.init.ModBlocks;
import covers1624.legacyfarms.reference.Reference;
import covers1624.legacyfarms.tile.TileBase;
import covers1624.legacyfarms.utils.PlanterUtils;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	public static int lfRenderId = RenderingRegistry.getNextAvailableRenderId();
	private static RenderingHandler renderingHandler = new RenderingHandler();

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerBlockHandler(lfRenderId, renderingHandler);
		ClientRegistry.bindTileEntitySpecialRenderer(TileBase.class, new TileRenderHandler());
		RenderingHandler.registerBlockRender(ModBlocks.blockPlanter, 0, new RenderPlanter(Reference.MODEL_FOLDER + PlanterUtils.getNameFromMeta(0)));
		RenderingHandler.registerBlockRender(ModBlocks.blockPlanter, 1, new RenderPlanter(Reference.MODEL_FOLDER + PlanterUtils.getNameFromMeta(1)));
		RenderingHandler.registerBlockRender(ModBlocks.blockPlanter, 3, new RenderPlanter(Reference.MODEL_FOLDER + PlanterUtils.getNameFromMeta(3)));
		RenderingHandler.registerBlockRender(ModBlocks.blockPlanter, 4, new RenderPlanter(Reference.MODEL_FOLDER + PlanterUtils.getNameFromMeta(4)));
		RenderingHandler.registerBlockRender(ModBlocks.blockPlanter, 5, new RenderPlanter(Reference.MODEL_FOLDER + PlanterUtils.getNameFromMeta(5)));
		RenderingHandler.registerBlockRender(ModBlocks.blockPlanter, 6, new RenderPlanter(Reference.MODEL_FOLDER + PlanterUtils.getNameFromMeta(6)));

		RenderingHandler.registerBlockRender(ModBlocks.blockMill, 0, new RenderMill(Reference.MODEL_FOLDER + "forester_"));
	}
}
