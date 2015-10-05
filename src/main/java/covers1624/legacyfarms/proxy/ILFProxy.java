package covers1624.legacyfarms.proxy;

import covers1624.legacyfarms.render.RenderPlanter;

public interface ILFProxy {

	void registerRenderers();

	RenderPlanter getPlanterRenderer(int meta);

}
