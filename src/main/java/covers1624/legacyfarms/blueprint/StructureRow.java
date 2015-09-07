package covers1624.legacyfarms.blueprint;

import covers1624.legacyfarms.exception.StructureConstructionException;
import covers1624.legacyfarms.utils.LogHelper;
import net.minecraft.block.Block;

public class StructureRow {

	private Block[] row;

	public StructureRow(Block[] blocks, int length) {
		row = new Block[length];
		if (blocks.length != length) {
			LogHelper.fatal("A fatal error occored while initalizing a Structure Row, the length of the row provided was different than the expected length. Length porvided: %s, Length expected: %s", String.valueOf(blocks.length), String.valueOf(length));
			throw new StructureConstructionException();
		}
		row = blocks;
	}

}
