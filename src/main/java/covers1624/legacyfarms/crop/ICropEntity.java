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
package covers1624.legacyfarms.crop;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public interface ICropEntity {

	/**
	 * @return True if the crop is ready for harvest
	 */
	boolean isHarvestable();

	/**
	 * @return Integer array of three designating the coordinates to check for a crop after this one. Useful to chop down whole trees. Return null to skip this
	 * function.
	 */
	int[] getNextPosition();

	/**
	 * @return Itemstacks gathered from the harvest. Also responsible for removing the harvested crop from the world.
	 */
	ArrayList<ItemStack> doHarvest();

}
