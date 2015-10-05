package covers1624.legacyfarms.blueprint;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.utils.Vect;

import java.util.HashMap;

public class StructureBlueprint {
	public String id;
	// Y / X / Z
	private int[][][] pattern;

	public StructureBlueprint(String id, Vect area) {
		this.id = id;
		this.pattern = new int[area.y][area.x][area.z];
	}

	public void setPlane(int y, int[][] plane) {
		pattern[y] = plane;
	}

	public int getBlockId(Vect pos) {
		if (pos.y >= this.pattern.length) {
			return -1;
		}
		if (pos.x >= this.pattern[pos.y].length) {
			return -1;
		}
		if (pos.z >= this.pattern[pos.y][pos.x].length) {
			return -1;
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

	// public static final StructureBlueprint[] index = new
	// StructureBlueprint[255];
	// public static final StructureBlueprint defaultArboretum = new
	// StructureBlueprint(0, new Vect(15, 10, 15));
	public static final HashMap<String, StructureBlueprint> index = new HashMap<String, StructureBlueprint>();

	public static StructureBlueprint getBlueprint(String id) {
		if (index.containsKey(id)) {
			return index.get(id);
		} else {
			LegacyFarms.logger.fatal("Tried to retrieve unknown StructureBlueprint identified by " + id);
			return null;
		}
	}

	// public static final StructureBlueprint defaultArboretum = new StructureBlueprint("defaultArboretum", new Vect(15, 10, 15));
	// public static final StructureBlueprint defaultFarm = new StructureBlueprint("defaultFarm", new Vect(15, 6, 15));

	static {
		int[][] arboretum0 = new int[][] { // Format
				new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, // 1
				new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 }, // 2
				new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 }, // 3
				new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 }, // 4
				new int[] { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 }, // 5
				new int[] { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 }, // 6
				new int[] { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 }, // 7
				new int[] { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 }, // 8
				new int[] { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 }, // 9
				new int[] { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 }, // 10
				new int[] { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 }, // 11
				new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 }, // 12
				new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 }, // 13
				new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 }, // 14
				new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 } // 15
		};
		// defaultArboretum.setPlane(0, arboretum0);
		int[][] arboretum1 = new int[][] { // Format
				new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, // 1
				new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 }, // 2
				new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 }, // 3
				new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 }, // 4
				new int[] { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 }, // 5
				new int[] { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 }, // 6
				new int[] { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 }, // 7
				new int[] { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 }, // 8
				new int[] { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 }, // 9
				new int[] { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 }, // 10
				new int[] { -1, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, -1 }, // 11
				new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 }, // 12
				new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 }, // 13
				new int[] { -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1 }, // 14
				new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 } // 15
		};
		// defaultArboretum.setPlane(1, arboretum1);
		// defaultArboretum.setPlane(2, arboretum1);
		// defaultArboretum.setPlane(3, arboretum1);
		// defaultArboretum.setPlane(4, arboretum1);
		// defaultArboretum.setPlane(5, arboretum1);
		// defaultArboretum.setPlane(6, arboretum1);
		// defaultArboretum.setPlane(7, arboretum1);
		// defaultArboretum.setPlane(8, arboretum1);
		// defaultArboretum.setPlane(9, arboretum1);

		int[][] farm0 = new int[][] { // Format
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 1
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 2
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 3
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 4
				new int[] { 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0 }, // 5
				new int[] { 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0 }, // 6
				new int[] { 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0 }, // 7
				new int[] { 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0 }, // 8
				new int[] { 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0 }, // 9
				new int[] { 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0 }, // 10
				new int[] { 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0 }, // 11
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 12
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 13
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 14
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 15
		};
		// defaultFarm.setPlane(0, farm0);
		// defaultFarm.setPlane(1, farm0);
		// defaultFarm.setPlane(2, farm0);
		// defaultFarm.setPlane(3, farm0);
		// defaultFarm.setPlane(4, farm0);
		// defaultFarm.setPlane(5, farm0);

	}

}
