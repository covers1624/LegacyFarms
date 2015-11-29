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

import covers1624.lib.util.BlockPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

public interface ICropProvider {

	ArrayList<ItemStack> validPlants = new ArrayList<ItemStack>();

	/**
	 * @param germling .
	 * @return True if the passed ItemStack is a valid germling for use in planting.
	 */
	boolean isGermling(ItemStack germling);

	/**
	 * @param world    World.
	 * @param blockPos Position.
	 * @return True if the block at the passed location is a valid crop (mature or immature). Includes saplings!
	 */
	boolean isCrop(World world, BlockPosition blockPos);

	/**
	 * Called once to configure possible windfall created by harvested crops managed by this provider.
	 *
	 * @return Array of item stacks representing possible windfall.
	 */
	ItemStack[] getWindfall();

	/**
	 * Plant a crop in the world with the germling given. Planter will have called isGermling beforehand.
	 *
	 * @param germling ItemStack representing the germling available. Stack is decreased by the planter, not by the provider.
	 * @param world    World.
	 * @param blockPos Pos.
	 * @return True if planting is successful, false otherwise.
	 */
	boolean doPlant(ItemStack germling, World world, BlockPosition blockPos);

	/**
	 * Returns the crop at the given location. Planter will have called isCrop beforehand.
	 *
	 * @param world    World.
	 * @param blockPos Pos.
	 */
	ICropEntity getCrop(World world, BlockPosition blockPos);

}
