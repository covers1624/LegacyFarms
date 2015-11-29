package covers1624.legacyfarms.block;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.lib.block.MultiTileBlock;
import net.minecraft.block.material.Material;

public abstract class BlockBase extends MultiTileBlock {

	protected BlockBase(Material material) {
		super(material);
		setCreativeTab(LegacyFarms.creativeTab);
	}
}
