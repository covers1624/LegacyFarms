package covers1624.legacyfarms.init;

import covers1624.legacyfarms.blueprint.StructureBlueprint;
import covers1624.lib.util.BlockPosition;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

import java.util.HashMap;

public class Blueprints {

	private static HashMap<String, Integer> nameIndex = new HashMap<String, Integer>();
	private static HashMap<Integer, StructureBlueprint> structureIndex = new HashMap<Integer, StructureBlueprint>();
	private static int currIndex = 1;

	public static final StructureBlueprint defaultArboretum = new StructureBlueprint("defaultArboretum", new BlockPosition(15, 10, 15));
	public static final StructureBlueprint defaultFarm = new StructureBlueprint("defaultFarm", new BlockPosition(15, 6, 15));
	public static final StructureBlueprint defaultSoil = new StructureBlueprint("saplingSoil", new BlockPosition(13, 1, 13));
	public static final StructureBlueprint defaultPlantation = new StructureBlueprint("saplingPlantation", new BlockPosition(13, 1, 13));

	public static final StructureBlueprint bogEarth = new StructureBlueprint("bogEarth", new BlockPosition(15, 1, 15));

	public static final StructureBlueprint pumpkinArea = new StructureBlueprint("pumpkinArea", new BlockPosition(13, 7, 13));
	public static final StructureBlueprint pumpkinSoil = new StructureBlueprint("pumpkinSoil", new BlockPosition(13, 1, 13));
	public static final StructureBlueprint pumpkinFarm = new StructureBlueprint("pumpkinFarm", new BlockPosition(13, 1, 13));

	public static final StructureBlueprint defaultShroom = new StructureBlueprint("mushroomFarm", new BlockPosition(17, 10, 17));
	public static final StructureBlueprint shroomSoil = new StructureBlueprint("mushroomSoil", new BlockPosition(13, 1, 13));
	public static final StructureBlueprint shroomPlantation = new StructureBlueprint("mushroomPlantation", new BlockPosition(13, 1, 13));

	public static final StructureBlueprint netherwartSoil = new StructureBlueprint("netherwartSoil", new BlockPosition(15, 1, 15));
	public static final StructureBlueprint netherwartPlantation = new StructureBlueprint("netherwartPlantation", new BlockPosition(15, 1, 15));

	public static final StructureBlueprint farmSoil = new StructureBlueprint("wheatSoil", new BlockPosition(15, 1, 15));
	public static final StructureBlueprint wheatPlantation = new StructureBlueprint("wheatPlantation", new BlockPosition(15, 1, 15));

	public static void init() {
		createData();
		registerData();
	}

	private static void registerData() {
		registerStructureBlueprint(defaultArboretum);
		registerStructureBlueprint(defaultFarm);
		registerStructureBlueprint(defaultSoil);
		registerStructureBlueprint(defaultPlantation);
		registerStructureBlueprint(bogEarth);
		registerStructureBlueprint(pumpkinArea);
		registerStructureBlueprint(pumpkinSoil);
		registerStructureBlueprint(pumpkinFarm);
		registerStructureBlueprint(defaultShroom);
		registerStructureBlueprint(shroomSoil);
		registerStructureBlueprint(shroomPlantation);
		registerStructureBlueprint(netherwartSoil);
		registerStructureBlueprint(netherwartPlantation);
		registerStructureBlueprint(farmSoil);
		registerStructureBlueprint(wheatPlantation);
	}

	public static void registerStructureBlueprint(StructureBlueprint structureBlueprint) {
		nameIndex.put(structureBlueprint.id, currIndex);
		structureIndex.put(currIndex, structureBlueprint);
		currIndex++;
	}

	public static StructureBlueprint getBlueprintByName(String name) {
		int id = nameIndex.get(name);
		if (id > 0 && id >= currIndex) {
			return structureIndex.get(id);
		}
		return null;
	}

	public static StructureBlueprint getBlueprintByID(int id) {
		if (id > 0 && id >= currIndex) {
			return structureIndex.get(id);
		}
		return null;
	}

	private static void createData() {
		Block i;
		Block j;
		Block n = null;
		Block a = Blocks.air;

		// Arboretum
		i = ModBlocks.forestrySoil;
		Block[][] soil = new Block[][] { // Format :D
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 2
				new Block[] { i, i, n, n, n, n, n, n, n, n, n, i, i }, // 3
				new Block[] { i, i, n, n, n, n, n, n, n, n, n, i, i }, // 4
				new Block[] { i, i, n, n, n, n, n, n, n, n, n, i, i }, // 5
				new Block[] { i, i, n, n, n, n, n, n, n, n, n, i, i }, // 6
				new Block[] { i, i, n, n, n, n, n, n, n, n, n, i, i }, // 7
				new Block[] { i, i, n, n, n, n, n, n, n, n, n, i, i }, // 8
				new Block[] { i, i, n, n, n, n, n, n, n, n, n, i, i }, // 9
				new Block[] { i, i, n, n, n, n, n, n, n, n, n, i, i }, // 10
				new Block[] { i, i, n, n, n, n, n, n, n, n, n, i, i }, // 11
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 12
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		defaultSoil.setPlane(0, soil);

		i = Blocks.sapling;
		Block[][] plantation = new Block[][] { // Format :D
				new Block[] { i, a, i, a, i, a, i, a, i, a, i, a, i }, // 1
				new Block[] { a, i, a, i, a, i, a, i, a, i, a, i, a }, // 2
				new Block[] { i, a, n, n, n, n, n, n, n, n, n, a, i }, // 3
				new Block[] { a, i, n, n, n, n, n, n, n, n, n, i, a }, // 4
				new Block[] { i, a, n, n, n, n, n, n, n, n, n, a, i }, // 5
				new Block[] { a, i, n, n, n, n, n, n, n, n, n, i, a }, // 6
				new Block[] { i, a, n, n, n, n, n, n, n, n, n, a, i }, // 7
				new Block[] { a, i, n, n, n, n, n, n, n, n, n, i, a }, // 8
				new Block[] { i, a, n, n, n, n, n, n, n, n, n, a, i }, // 9
				new Block[] { a, i, n, n, n, n, n, n, n, n, n, i, a }, // 10
				new Block[] { i, a, n, n, n, n, n, n, n, n, n, a, i }, // 11
				new Block[] { a, i, a, i, a, i, a, i, a, i, a, i, a }, // 12
				new Block[] { i, a, i, a, i, a, i, a, i, a, i, a, i } // 13
		};
		defaultPlantation.setPlane(0, plantation);

		Block[][] arboretum0 = new Block[][] { // Format
				new Block[] { n, n, n, n, n, n, n, n, n, n, n, n, n, n, n }, // 1
				new Block[] { n, a, a, a, a, a, a, a, a, a, a, a, a, a, n }, // 2
				new Block[] { n, a, a, a, a, a, a, a, a, a, a, a, a, a, n }, // 3
				new Block[] { n, a, a, a, a, a, a, a, a, a, a, a, a, a, n }, // 4
				new Block[] { n, a, a, a, n, n, n, n, n, n, n, a, a, a, n }, // 5
				new Block[] { n, a, a, a, n, n, n, n, n, n, n, a, a, a, n }, // 6
				new Block[] { n, a, a, a, n, n, n, n, n, n, n, a, a, a, n }, // 7
				new Block[] { n, a, a, a, n, n, n, n, n, n, n, a, a, a, n }, // 8
				new Block[] { n, a, a, a, n, n, n, n, n, n, n, a, a, a, n }, // 9
				new Block[] { n, a, a, a, n, n, n, n, n, n, n, a, a, a, n }, // 10
				new Block[] { n, a, a, a, n, n, n, n, n, n, n, a, a, a, n }, // 11
				new Block[] { n, a, a, a, a, a, a, a, a, a, a, a, a, a, n }, // 12
				new Block[] { n, a, a, a, a, a, a, a, a, a, a, a, a, a, n }, // 13
				new Block[] { n, a, a, a, a, a, a, a, a, a, a, a, a, a, n }, // 14
				new Block[] { n, n, n, n, n, n, n, n, n, n, n, n, n, n, n } // 15
		};
		defaultArboretum.setPlane(0, arboretum0);
		Block[][] arboretum1 = new Block[][] { // Format
				new Block[] { n, n, n, n, n, n, n, n, n, n, n, n, n, n, n }, // 1
				new Block[] { n, a, a, a, a, a, a, a, a, a, a, a, a, a, n }, // 2
				new Block[] { n, a, a, a, a, a, a, a, a, a, a, a, a, a, n }, // 3
				new Block[] { n, a, a, a, a, a, a, a, a, a, a, a, a, a, n }, // 4
				new Block[] { n, a, a, a, n, n, n, n, n, n, n, a, a, a, n }, // 5
				new Block[] { n, a, a, a, n, n, n, n, n, n, n, a, a, a, n }, // 6
				new Block[] { n, a, a, a, n, n, n, n, n, n, n, a, a, a, n }, // 7
				new Block[] { n, a, a, a, n, n, n, n, n, n, n, a, a, a, n }, // 8
				new Block[] { n, a, a, a, n, n, n, n, n, n, n, a, a, a, n }, // 9
				new Block[] { n, a, a, a, n, n, n, n, n, n, n, a, a, a, n }, // 10
				new Block[] { n, a, a, a, n, n, n, n, n, n, n, a, a, a, n }, // 11
				new Block[] { n, a, a, a, a, a, a, a, a, a, a, a, a, a, n }, // 12
				new Block[] { n, a, a, a, a, a, a, a, a, a, a, a, a, a, n }, // 13
				new Block[] { n, a, a, a, a, a, a, a, a, a, a, a, a, a, n }, // 14
				new Block[] { n, n, n, n, n, n, n, n, n, n, n, n, n, n, n } // 15
		};
		defaultArboretum.setPlane(1, arboretum1);
		defaultArboretum.setPlane(2, arboretum1);
		defaultArboretum.setPlane(3, arboretum1);
		defaultArboretum.setPlane(4, arboretum1);
		defaultArboretum.setPlane(5, arboretum1);
		defaultArboretum.setPlane(6, arboretum1);
		defaultArboretum.setPlane(7, arboretum1);
		defaultArboretum.setPlane(8, arboretum1);
		defaultArboretum.setPlane(9, arboretum1);

		Block[][] farm0 = new Block[][] { // Format
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 1
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 2
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 3
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 4
				new Block[] { a, a, a, a, n, n, n, n, n, n, n, a, a, a, a }, // 5
				new Block[] { a, a, a, a, n, n, n, n, n, n, n, a, a, a, a }, // 6
				new Block[] { a, a, a, a, n, n, n, n, n, n, n, a, a, a, a }, // 7
				new Block[] { a, a, a, a, n, n, n, n, n, n, n, a, a, a, a }, // 8
				new Block[] { a, a, a, a, n, n, n, n, n, n, n, a, a, a, a }, // 9
				new Block[] { a, a, a, a, n, n, n, n, n, n, n, a, a, a, a }, // 10
				new Block[] { a, a, a, a, n, n, n, n, n, n, n, a, a, a, a }, // 11
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 12
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 13
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 14
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 15
		};
		defaultFarm.setPlane(0, farm0);
		defaultFarm.setPlane(1, farm0);
		defaultFarm.setPlane(2, farm0);
		defaultFarm.setPlane(3, farm0);
		defaultFarm.setPlane(4, farm0);
		defaultFarm.setPlane(5, farm0);

		i = ModBlocks.forestrySoil;
		j = Blocks.water;
		Block[][] bogSoil = new Block[][] { // Format :D
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new Block[] { i, j, i, i, j, i, i, j, i, i, j, i, i, j, i }, // 1
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 2
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 3
				new Block[] { i, j, i, a, a, a, a, a, a, a, a, a, i, j, i }, // 4
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 5
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 6
				new Block[] { i, j, i, a, a, a, a, a, a, a, a, a, i, j, i }, // 7
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 8
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 9
				new Block[] { i, j, i, a, a, a, a, a, a, a, a, a, i, j, i }, // 10
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 11
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 12
				new Block[] { i, j, i, i, j, i, i, j, i, i, j, i, i, j, i }, // 13
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		bogEarth.setPlane(0, bogSoil);

		i = Blocks.dirt;
		Block[][] area = new Block[][] {  // Format :D
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 2
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 3
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 4
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 5
				new Block[] { n, n, n, n, n, n, n, n, n, n, n, n, n }, // 6
				new Block[] { n, n, n, n, n, n, n, n, n, n, n, n, n }, // 7
				new Block[] { n, n, n, n, n, n, n, n, n, n, n, n, n }, // 8
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 9
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 10
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 11
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 12
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		Block[][] areaY = new Block[][] {  // Format :D
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 2
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 2
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 2
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 4
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 2
				new Block[] { n, n, n, n, n, n, n, n, n, n, n, n, n }, // 6
				new Block[] { n, n, n, n, n, n, n, n, n, n, n, n, n }, // 7
				new Block[] { n, n, n, n, n, n, n, n, n, n, n, n, n }, // 8
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 2
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 10
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 2
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 12
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 2
		};
		pumpkinArea.setPlane(0, area);
		pumpkinArea.setPlane(1, areaY);
		pumpkinArea.setPlane(2, areaY);
		pumpkinArea.setPlane(3, areaY);
		pumpkinArea.setPlane(4, areaY);
		pumpkinArea.setPlane(5, areaY);
		pumpkinArea.setPlane(6, areaY);

		i = Blocks.farmland;
		j = Blocks.water;
		Block[][] soilPumpkin = new Block[][] {  // Format :D
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 2
				new Block[] { i, i, i, i, j, i, i, i, i, j, i, i, i }, // 3
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 4
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 5
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 6
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 7
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 8
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 9
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 10
				new Block[] { i, i, i, j, i, i, i, i, j, i, i, i, i }, // 11
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 12
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		pumpkinSoil.setPlane(0, soilPumpkin);

		i = Blocks.sapling;
		Block[][] plantationPumpkin = new Block[][] {  // Format :D
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 2
				new Block[] { a, i, i, a, a, a, i, i, a, a, a, i, a }, // 3
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 4
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 5
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 6
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 7
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 8
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 5
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 10
				new Block[] { a, i, a, a, a, i, i, a, a, a, i, i, a }, // 11
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a }, // 12
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		pumpkinFarm.setPlane(0, plantationPumpkin);

		Block[][] farmShroom = new Block[][] {  // Format :D
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 1
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 2
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 3
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 4
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 5
				new Block[] { a, a, a, a, a, n, n, n, n, n, n, n, a, a, a, a, a }, // 6
				new Block[] { a, a, a, a, a, n, n, n, n, n, n, n, a, a, a, a, a }, // 7
				new Block[] { a, a, a, a, a, n, n, n, n, n, n, n, a, a, a, a, a }, // 8
				new Block[] { a, a, a, a, a, n, n, n, n, n, n, n, a, a, a, a, a }, // 9
				new Block[] { a, a, a, a, a, n, n, n, n, n, n, n, a, a, a, a, a }, // 10
				new Block[] { a, a, a, a, a, n, n, n, n, n, n, n, a, a, a, a, a }, // 11
				new Block[] { a, a, a, a, a, n, n, n, n, n, n, n, a, a, a, a, a }, // 12
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 13
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 14
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 15
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 16
				new Block[] { a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a }, // 17
		};
		defaultShroom.setPlane(0, farmShroom);
		defaultShroom.setPlane(1, farmShroom);
		defaultShroom.setPlane(2, farmShroom);
		defaultShroom.setPlane(3, farmShroom);
		defaultShroom.setPlane(4, farmShroom);
		defaultShroom.setPlane(5, farmShroom);
		defaultShroom.setPlane(6, farmShroom);
		defaultShroom.setPlane(7, farmShroom);
		defaultShroom.setPlane(8, farmShroom);
		defaultShroom.setPlane(9, farmShroom);

		i = Blocks.mycelium;
		Block[][] soilShroom = new Block[][] { new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 2
				new Block[] { i, i, a, a, a, a, a, a, a, a, a, i, i }, // 3
				new Block[] { i, i, a, a, a, a, a, a, a, a, a, i, i }, // 4
				new Block[] { i, i, a, a, a, a, a, a, a, a, a, i, i }, // 5
				new Block[] { i, i, a, a, a, a, a, a, a, a, a, i, i }, // 6
				new Block[] { i, i, a, a, a, a, a, a, a, a, a, i, i }, // 7
				new Block[] { i, i, a, a, a, a, a, a, a, a, a, i, i }, // 8
				new Block[] { i, i, a, a, a, a, a, a, a, a, a, i, i }, // 9
				new Block[] { i, i, a, a, a, a, a, a, a, a, a, i, i }, // 10
				new Block[] { i, i, a, a, a, a, a, a, a, a, a, i, i }, // 11
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 12
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		shroomSoil.setPlane(0, soilShroom);

		i = Blocks.sapling;
		Block[][] plantationShroom = new Block[][] { new Block[] { i, a, i, a, i, a, i, a, i, a, i, a, i }, // 1
				new Block[] { a, i, a, i, a, i, a, i, a, i, a, i, a }, // 2
				new Block[] { i, a, a, a, a, a, a, a, a, a, a, a, i }, // 3
				new Block[] { a, i, a, a, a, a, a, a, a, a, a, i, a }, // 4
				new Block[] { i, a, a, a, a, a, a, a, a, a, a, a, i }, // 5
				new Block[] { a, i, a, a, a, a, a, a, a, a, a, i, a }, // 6
				new Block[] { i, a, a, a, a, a, a, a, a, a, a, a, i }, // 7
				new Block[] { a, i, a, a, a, a, a, a, a, a, a, i, a }, // 8
				new Block[] { i, a, a, a, a, a, a, a, a, a, a, a, i }, // 9
				new Block[] { a, i, a, a, a, a, a, a, a, a, a, i, a }, // 10
				new Block[] { i, a, a, a, a, a, a, a, a, a, a, a, i }, // 11
				new Block[] { a, i, a, i, a, i, a, i, a, i, a, i, a }, // 12
				new Block[] { i, a, i, a, i, a, i, a, i, a, i, a, i } // 13
		};
		shroomPlantation.setPlane(0, plantationShroom);

		i = Blocks.soul_sand;
		Block[][] soulSoil = new Block[][] { new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new Block[] { i, a, i, i, a, i, i, a, i, i, a, i, i, a, i }, // 2
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 3
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 4
				new Block[] { i, a, i, a, a, a, a, a, a, a, a, a, i, a, i }, // 5
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 6
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 7
				new Block[] { i, a, i, a, a, a, a, a, a, a, a, a, i, a, i }, // 8
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 9
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 10
				new Block[] { i, a, i, a, a, a, a, a, a, a, a, a, i, a, i }, // 11
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 12
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
				new Block[] { i, a, i, i, a, i, i, a, i, i, a, i, i, a, i }, // 14
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 15
		};
		netherwartSoil.setPlane(0, soulSoil);

		i = Blocks.sapling;
		Block[][] wheatPlants = new Block[][] { new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new Block[] { i, a, i, i, a, i, i, a, i, i, a, i, i, a, i }, // 2
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 3
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 4
				new Block[] { i, a, i, a, a, a, a, a, a, a, a, a, i, a, i }, // 5
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 6
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 7
				new Block[] { i, a, i, a, a, a, a, a, a, a, a, a, i, a, i }, // 8
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 9
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 10
				new Block[] { i, a, i, a, a, a, a, a, a, a, a, a, i, a, i }, // 11
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 12
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
				new Block[] { i, a, i, i, a, i, i, a, i, i, a, i, i, a, i }, // 14
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 15
		};
		netherwartPlantation.setPlane(0, wheatPlants);

		i = Blocks.farmland;
		j = Blocks.water;
		Block[][] farmedSoil = new Block[][] { new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new Block[] { i, j, i, i, j, i, i, j, i, i, j, i, i, j, i }, // 2
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 3
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 4
				new Block[] { i, j, i, a, a, a, a, a, a, a, a, a, i, j, i }, // 5
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 6
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 7
				new Block[] { i, j, i, a, a, a, a, a, a, a, a, a, i, j, i }, // 8
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 9
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 10
				new Block[] { i, j, i, a, a, a, a, a, a, a, a, a, i, j, i }, // 11
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 12
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
				new Block[] { i, j, i, i, j, i, i, j, i, i, j, i, i, j, i }, // 14
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 15
		};
		farmSoil.setPlane(0, farmedSoil);

		i = Blocks.sapling;
		Block[][] wheatPlants1 = new Block[][] { new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new Block[] { i, j, i, i, j, i, i, j, i, i, j, i, i, j, i }, // 1
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 2
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 3
				new Block[] { i, j, i, a, a, a, a, a, a, a, a, a, i, j, i }, // 4
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 5
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 6
				new Block[] { i, j, i, a, a, a, a, a, a, a, a, a, i, j, i }, // 7
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 8
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 9
				new Block[] { i, j, i, a, a, a, a, a, a, a, a, a, i, j, i }, // 10
				new Block[] { i, i, i, a, a, a, a, a, a, a, a, a, i, i, i }, // 11
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 12
				new Block[] { i, j, i, i, j, i, i, j, i, i, j, i, i, j, i }, // 13
				new Block[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		wheatPlantation.setPlane(0, wheatPlants1);
	}
}
