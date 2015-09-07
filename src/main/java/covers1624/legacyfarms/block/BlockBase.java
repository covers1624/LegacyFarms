package covers1624.legacyfarms.block;

import covers1624.legacyfarms.LegacyFarms;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

public abstract class BlockBase extends BlockContainer {

	protected BlockBase(Material material) {
		super(material);
		setCreativeTab(LegacyFarms.creativeTab);
	}

}
