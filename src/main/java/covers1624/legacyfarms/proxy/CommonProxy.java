package covers1624.legacyfarms.proxy;

import covers1624.legacyfarms.render.RenderPlanter;

public class CommonProxy implements ILFProxy {

	@Override
	public void registerRenderers() {
		// NOOP
	}

	@Override public RenderPlanter getPlanterRenderer(int meta) {
		return null;
	}

}
