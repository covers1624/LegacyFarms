package covers1624.legacyfarms.init;

import covers1624.legacyfarms.blueprint.StructureBlueprint;
import covers1624.legacyfarms.utils.Vect;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class Blueprints {

	public static final StructureBlueprint defaultArboretum = new StructureBlueprint("defaultArboretum", new Vect(15, 10, 15));
	public static final StructureBlueprint defaultFarm = new StructureBlueprint("defaultFarm", new Vect(15, 6, 15));
	public static final StructureBlueprint defaultSoil = new StructureBlueprint("saplingSoil", new Vect(13, 1, 13));
	public static final StructureBlueprint defaultPlantation = new StructureBlueprint("saplingPlantation", new Vect(13, 1, 13));

	public static final StructureBlueprint bogEarth = new StructureBlueprint("bogEarth", new Vect(15, 1, 15));

	public static final StructureBlueprint pumpkinArea = new StructureBlueprint("pumpkinArea", new Vect(13, 7, 13));
	public static final StructureBlueprint pumpkinSoil = new StructureBlueprint("pumpkinSoil", new Vect(13, 1, 13));
	public static final StructureBlueprint pumpkinFarm = new StructureBlueprint("pumpkinFarm", new Vect(13, 1, 13));

	public static final StructureBlueprint defaultShroom = new StructureBlueprint("mushroomFarm", new Vect(17, 10, 17));
	public static final StructureBlueprint shroomSoil = new StructureBlueprint("mushroomSoil", new Vect(13, 1, 13));
	public static final StructureBlueprint shroomPlantation = new StructureBlueprint("mushroomPlantation", new Vect(13, 1, 13));

	public static final StructureBlueprint netherwartSoil = new StructureBlueprint("netherwartSoil", new Vect(15, 1, 15));
	public static final StructureBlueprint netherwartPlantation = new StructureBlueprint("netherwartPlantation", new Vect(15, 1, 15));

	public static final StructureBlueprint farmSoil = new StructureBlueprint("wheatSoil", new Vect(15, 1, 15));
	public static final StructureBlueprint wheatPlantation = new StructureBlueprint("wheatPlantation", new Vect(15, 1, 15));

	public static void init() {
		int i;
		int j;
		// Arboretum
		i = getId(ModBlocks.forestrySoil);
		int[][] soil = new int[][] { // Format :D
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 2
				new int[] { i, i, -1, -1, -1, -1, -1, -1, -1, -1, -1, i, i }, // 3
				new int[] { i, i, -1, -1, -1, -1, -1, -1, -1, -1, -1, i, i }, // 4
				new int[] { i, i, -1, -1, -1, -1, -1, -1, -1, -1, -1, i, i }, // 5
				new int[] { i, i, -1, -1, -1, -1, -1, -1, -1, -1, -1, i, i }, // 6
				new int[] { i, i, -1, -1, -1, -1, -1, -1, -1, -1, -1, i, i }, // 7
				new int[] { i, i, -1, -1, -1, -1, -1, -1, -1, -1, -1, i, i }, // 8
				new int[] { i, i, -1, -1, -1, -1, -1, -1, -1, -1, -1, i, i }, // 9
				new int[] { i, i, -1, -1, -1, -1, -1, -1, -1, -1, -1, i, i }, // 10
				new int[] { i, i, -1, -1, -1, -1, -1, -1, -1, -1, -1, i, i }, // 11
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 12
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		defaultSoil.setPlane(0, soil);
		i = getId(Blocks.sapling);
		int[][] plantation = new int[][] { // Format :D
				new int[] { i, 0, i, 0, i, 0, i, 0, i, 0, i, 0, i }, // 1
				new int[] { 0, i, 0, i, 0, i, 0, i, 0, i, 0, i, 0 }, // 2
				new int[] { i, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, i }, // 3
				new int[] { 0, i, -1, -1, -1, -1, -1, -1, -1, -1, -1, i, 0 }, // 4
				new int[] { i, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, i }, // 5
				new int[] { 0, i, -1, -1, -1, -1, -1, -1, -1, -1, -1, i, 0 }, // 6
				new int[] { i, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, i }, // 7
				new int[] { 0, i, -1, -1, -1, -1, -1, -1, -1, -1, -1, i, 0 }, // 8
				new int[] { i, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, i }, // 9
				new int[] { 0, i, -1, -1, -1, -1, -1, -1, -1, -1, -1, i, 0 }, // 10
				new int[] { i, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, i }, // 11
				new int[] { 0, i, 0, i, 0, i, 0, i, 0, i, 0, i, 0 }, // 12
				new int[] { i, 0, i, 0, i, 0, i, 0, i, 0, i, 0, i } // 13
		};
		defaultPlantation.setPlane(0, plantation);

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
		defaultArboretum.setPlane(0, arboretum0);
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
		defaultArboretum.setPlane(1, arboretum1);
		defaultArboretum.setPlane(2, arboretum1);
		defaultArboretum.setPlane(3, arboretum1);
		defaultArboretum.setPlane(4, arboretum1);
		defaultArboretum.setPlane(5, arboretum1);
		defaultArboretum.setPlane(6, arboretum1);
		defaultArboretum.setPlane(7, arboretum1);
		defaultArboretum.setPlane(8, arboretum1);
		defaultArboretum.setPlane(9, arboretum1);

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
		defaultFarm.setPlane(0, farm0);
		defaultFarm.setPlane(1, farm0);
		defaultFarm.setPlane(2, farm0);
		defaultFarm.setPlane(3, farm0);
		defaultFarm.setPlane(4, farm0);
		defaultFarm.setPlane(5, farm0);

		i = getId(ModBlocks.forestrySoil);
		j = getId(Blocks.water);
		int[][] bogSoil = new int[][] { // Format :D
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new int[] { i, j, i, i, j, i, i, j, i, i, j, i, i, j, i }, // 1
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 2
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 3
				new int[] { i, j, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, j, i }, // 4
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 5
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 6
				new int[] { i, j, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, j, i }, // 7
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 8
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 9
				new int[] { i, j, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, j, i }, // 10
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 11
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 12
				new int[] { i, j, i, i, j, i, i, j, i, i, j, i, i, j, i }, // 13
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		bogEarth.setPlane(0, bogSoil);

		i = getId(Blocks.dirt);
		int[][] area = new int[][] { new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 2
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 3
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 4
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 5
				new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, // 6
				new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, // 7
				new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, // 8
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 9
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 10
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 11
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 12
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		int[][] areaY = new int[][] { new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 2
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 2
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 2
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 4
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 2
				new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, // 6
				new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, // 7
				new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, // 8
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 2
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 10
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 2
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 12
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 2
		};
		pumpkinArea.setPlane(0, area);
		pumpkinArea.setPlane(1, areaY);
		pumpkinArea.setPlane(2, areaY);
		pumpkinArea.setPlane(3, areaY);
		pumpkinArea.setPlane(4, areaY);
		pumpkinArea.setPlane(5, areaY);
		pumpkinArea.setPlane(6, areaY);

		i = getId(Blocks.farmland);
		j = getId(Blocks.water);
		int[][] soilPumpkin = new int[][] { new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 2
				new int[] { i, i, i, i, j, i, i, i, i, j, i, i, i }, // 3
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 4
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 5
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 6
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 7
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 8
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 9
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 10
				new int[] { i, i, i, j, i, i, i, i, j, i, i, i, i }, // 11
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 12
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		pumpkinSoil.setPlane(0, soilPumpkin);

		i = getId(Blocks.sapling);
		int[][] plantationPumpkin = new int[][] { new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 2
				new int[] { 0, i, i, 0, 0, 0, i, i, 0, 0, 0, i, 0 }, // 3
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 4
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 5
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 6
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 7
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 8
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 5
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 10
				new int[] { 0, i, 0, 0, 0, i, i, 0, 0, 0, i, i, 0 }, // 11
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 12
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		pumpkinFarm.setPlane(0, plantationPumpkin);

		int[][] farmShroom = new int[][] { new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 1
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 2
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 3
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 4
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 5
				new int[] { 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0 }, // 6
				new int[] { 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0 }, // 7
				new int[] { 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0 }, // 8
				new int[] { 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0 }, // 9
				new int[] { 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0 }, // 10
				new int[] { 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0 }, // 11
				new int[] { 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, 0, 0, 0, 0, 0 }, // 12
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 13
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 14
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 15
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 16
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 17
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

		i = getId(Blocks.mycelium);
		int[][] soilShroom = new int[][] { new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 2
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 3
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 4
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 5
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 6
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 7
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 8
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 9
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 10
				new int[] { i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i }, // 11
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 12
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		shroomSoil.setPlane(0, soilShroom);

		i = getId(Blocks.sapling);
		int[][] plantationShroom = new int[][] { new int[] { i, 0, i, 0, i, 0, i, 0, i, 0, i, 0, i }, // 1
				new int[] { 0, i, 0, i, 0, i, 0, i, 0, i, 0, i, 0 }, // 2
				new int[] { i, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i }, // 3
				new int[] { 0, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0 }, // 4
				new int[] { i, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i }, // 5
				new int[] { 0, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0 }, // 6
				new int[] { i, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i }, // 7
				new int[] { 0, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0 }, // 8
				new int[] { i, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i }, // 9
				new int[] { 0, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0 }, // 10
				new int[] { i, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, i }, // 11
				new int[] { 0, i, 0, i, 0, i, 0, i, 0, i, 0, i, 0 }, // 12
				new int[] { i, 0, i, 0, i, 0, i, 0, i, 0, i, 0, i } // 13
		};
		shroomPlantation.setPlane(0, plantationShroom);

		i = getId(Blocks.soul_sand);
		int[][] soulSoil = new int[][] { new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new int[] { i, 0, i, i, 0, i, i, 0, i, i, 0, i, i, 0, i }, // 2
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 3
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 4
				new int[] { i, 0, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0, i }, // 5
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 6
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 7
				new int[] { i, 0, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0, i }, // 8
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 9
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 10
				new int[] { i, 0, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0, i }, // 11
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 12
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
				new int[] { i, 0, i, i, 0, i, i, 0, i, i, 0, i, i, 0, i }, // 14
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 15
		};
		netherwartSoil.setPlane(0, soulSoil);

		i = getId(Blocks.sapling);
		int[][] wheatPlants = new int[][] { new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new int[] { i, 0, i, i, 0, i, i, 0, i, i, 0, i, i, 0, i }, // 2
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 3
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 4
				new int[] { i, 0, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0, i }, // 5
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 6
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 7
				new int[] { i, 0, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0, i }, // 8
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 9
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 10
				new int[] { i, 0, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, 0, i }, // 11
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 12
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
				new int[] { i, 0, i, i, 0, i, i, 0, i, i, 0, i, i, 0, i }, // 14
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 15
		};
		netherwartPlantation.setPlane(0, wheatPlants);

		i = getId(Blocks.farmland);
		j = getId(Blocks.water);
		int[][] farmedSoil = new int[][] { new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new int[] { i, j, i, i, j, i, i, j, i, i, j, i, i, j, i }, // 2
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 3
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 4
				new int[] { i, j, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, j, i }, // 5
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 6
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 7
				new int[] { i, j, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, j, i }, // 8
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 9
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 10
				new int[] { i, j, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, j, i }, // 11
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 12
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
				new int[] { i, j, i, i, j, i, i, j, i, i, j, i, i, j, i }, // 14
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 15
		};
		farmSoil.setPlane(0, farmedSoil);

		i = getId(Blocks.sapling);
		int[][] wheatPlants1 = new int[][] { new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 1
				new int[] { i, j, i, i, j, i, i, j, i, i, j, i, i, j, i }, // 1
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 2
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 3
				new int[] { i, j, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, j, i }, // 4
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 5
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 6
				new int[] { i, j, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, j, i }, // 7
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 8
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 9
				new int[] { i, j, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, j, i }, // 10
				new int[] { i, i, i, 0, 0, 0, 0, 0, 0, 0, 0, 0, i, i, i }, // 11
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 12
				new int[] { i, j, i, i, j, i, i, j, i, i, j, i, i, j, i }, // 13
				new int[] { i, i, i, i, i, i, i, i, i, i, i, i, i, i, i }, // 13
		};
		wheatPlantation.setPlane(0, wheatPlants1);

	}

	private static int getId(Block block) {
		return Block.getIdFromBlock(block);
	}

}
