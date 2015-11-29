package covers1624.legacyfarms.blueprint;

import covers1624.lib.util.BlockPosition;
import net.minecraft.block.Block;

public class StructureBlueprint {
	public String id;
	// Y / X / Z
	private Block[][][] pattern;

	public StructureBlueprint(String id, BlockPosition area) {
		this.id = id;
		this.pattern = new Block[area.y][area.x][area.z];
	}

	public void setPlane(int y, Block[][] plane) {
		pattern[y] = plane;
	}

	public Block getBlock(BlockPosition pos) {
		if (pos.y >= this.pattern.length) {
			return null;
		}
		if (pos.x >= this.pattern[pos.y].length) {
			return null;
		}
		if (pos.z >= this.pattern[pos.y][pos.x].length) {
			return null;
		}
		return this.pattern[pos.y][pos.x][pos.z];
	}

	public int getYLength() {
		return pattern.length;
	}

	public int getXLength() {
		return pattern[0].length;
	}

	public int getZLength() {
		return pattern[0][0].length;
	}
}
