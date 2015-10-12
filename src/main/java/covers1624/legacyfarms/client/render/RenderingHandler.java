package covers1624.legacyfarms.client.render;

import covers1624.legacyfarms.client.util.RenderListEntry;
import covers1624.legacyfarms.proxy.ClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

import java.util.HashMap;

public class RenderingHandler implements ISimpleBlockRenderingHandler {

	private static HashMap<Block, RenderListEntry> renderMap = new HashMap<Block, RenderListEntry>();

	@Override
	public void renderInventoryBlock(Block block, int meta, int modelId, RenderBlocks renderer) {
		IBlockRenderer render = getIBlockRenderFromBlockAndMeta(block, meta);
		if (render != null) {
			render.inventoryRender(-0.5, -0.5, -0.5, 0, 0);
		}

	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		// Handled by a tile entity special render
		return false;
	}

	public static void registerBlockRender(Block block, int meta, IBlockRenderer render) {
		RenderListEntry entry;
		if (renderMap.containsKey(block)) {
			entry = renderMap.get(block);
		} else {
			entry = new RenderListEntry();
		}
		entry.metaRenderers[meta] = render;
		renderMap.put(block, entry);
	}

	public static IBlockRenderer getIBlockRenderFromBlockAndMeta(Block block, int meta) {
		if (renderMap.containsKey(block)) {
			if (meta != -1) {
				return renderMap.get(block).metaRenderers[meta];
			}
		}
		return null;
}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return ClientProxy.lfRenderId;
	}

}
