/*******************************************************************************
 * Copyright (c) 2011-2014 SirSengir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * <p/>
 * Various Contributors including, but not limited to:
 * SirSengir (original work), CovertJaguar, Player, Binnie, MysteriousAges
 ******************************************************************************/
package covers1624.legacyfarms.blueprint;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.legacyfarms.utils.Vect;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;

public class StructureConstruction {
	private StructureBlueprint blueprint;

	private Vect position;
	private Vect shift;
	private Vect current = new Vect(0, 0, 0);

	public boolean isFinished = false;

	public StructureConstruction() {
	}

	/**
	 * @param bp Blueprint to use
	 * @param p Starting block
	 * @param s Shift on xCoordinate from starting block
	 */
	public StructureConstruction(StructureBlueprint bp, Vect p, Vect s) {
		this.blueprint = bp;

		position = p;
		shift = s;
	}

	public Block getCurrentBlock() {
		return blueprint.getBlock(current);
	}

	/**
	 * Y-Coordinate to place current planned block on. Independent of direction originating machine block is facing.
	 */
	public int getCurrentY() {
		return position.y + current.y + shift.y;
	}

	public int getCurrentX() {
		return position.x + current.x + shift.x;
		/* switch(facing) { case WEST: return xPosition+xCurrent+xShift; case SOUTH: return xPosition-xCurrent-xShift; default: case EAST: return xPosition+xCurrent+zShift; } */
	}

	public int getCurrentZ() {
		return position.z + current.z + shift.z;
		/* switch(facing) { case WEST: return zPosition-zCurrent-zShift; case SOUTH: return zPosition-zCurrent-zShift; default: case EAST: return zPosition+zCurrent+zShift; } */
	}

	/**
	 * @return Current block to build/check as vector position.
	 */
	public Vect getCurrentPos() {
		return new Vect(this.getCurrentX(), this.getCurrentY(), this.getCurrentZ());
	}

	public void advanceStep() {
		// Increment z first until end reached
		if (current.z < blueprint.getZLength() - 1) {
			current.z++;
		} else {
			current.z = 0;

			if (current.x < blueprint.getXLength() - 1) {
				current.x++;
			} else {
				current.x = 0;

				if (current.y < blueprint.getYLength() - 1) {
					current.y++;
				} else {
					isFinished = true;
				}
			}
		}
	}

	public void reset() {
		current = new Vect(0, 0, 0);
		isFinished = false;
	}

	public void readFromNBT(NBTTagCompound nbttagcompound) {
		isFinished = nbttagcompound.getBoolean("IsFinished");

		String ident;
		if (nbttagcompound.hasKey("BlueprintIdent")) {
			ident = nbttagcompound.getString("BlueprintIdent");
		} else {
			// Legacy for version < 1.0.7.15
			int id = nbttagcompound.getInteger("BlueprintId");
			switch (id) {
			case 0:
				ident = "defaultArboretum";
				break;
			case 1:
				ident = "saplingSoil";
				break;
			case 2:
				ident = "saplingPlantation";
				break;
			case 3:
				ident = "wheatSoil";
				break;
			case 4:
				ident = "wheatPlantation";
				break;
			default:
				ident = "defaultArboretum";
			}
		}
		if (StructureBlueprint.index.containsKey(ident)) {
			blueprint = StructureBlueprint.index.get(ident);
		} else {
			LegacyFarms.logger.error("Tried to load non-existing structure blueprint identified by " + ident);
		}

		position = new Vect(nbttagcompound.getInteger("XPosition"), nbttagcompound.getInteger("YPosition"), nbttagcompound.getInteger("ZPosition"));
		shift = new Vect(nbttagcompound.getInteger("XShift"), nbttagcompound.getInteger("YShift"), nbttagcompound.getInteger("ZShift"));
		current = new Vect(nbttagcompound.getInteger("XCurrent"), nbttagcompound.getInteger("YCurrent"), nbttagcompound.getInteger("ZCurrent"));
	}

	public void writeToNBT(NBTTagCompound nbttagcompound) {
		nbttagcompound.setBoolean("IsFinished", isFinished);
		nbttagcompound.setString("BlueprintIdent", blueprint.id);
		nbttagcompound.setInteger("XPosition", position.x);
		nbttagcompound.setInteger("YPosition", position.y);
		nbttagcompound.setInteger("ZPosition", position.z);
		nbttagcompound.setInteger("XShift", shift.x);
		nbttagcompound.setInteger("YShift", shift.y);
		nbttagcompound.setInteger("ZShift", shift.z);
		nbttagcompound.setInteger("XCurrent", current.x);
		nbttagcompound.setInteger("YCurrent", current.y);
		nbttagcompound.setInteger("ZCurrent", current.z);
	}

}
