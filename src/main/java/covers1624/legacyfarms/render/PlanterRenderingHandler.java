package covers1624.legacyfarms.render;

import covers1624.legacyfarms.block.BlockPlanter;
import covers1624.legacyfarms.proxy.ClientProxy;
import covers1624.legacyfarms.reference.Reference;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class PlanterRenderingHandler implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		if (block.getRenderType() == ClientProxy.planterRenderID) {
			RenderPlanter renderPlanter = new RenderPlanter(Reference.MODEL_FOLDER + BlockPlanter.getUnlocFromMeta(metadata));
			renderPlanter.inventoryRender(-0.5, -0.5, -0.5, 0, 0);
		}

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return ClientProxy.planterRenderID;
	}

}
