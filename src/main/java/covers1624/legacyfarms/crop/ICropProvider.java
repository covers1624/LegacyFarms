/*******************************************************************************
 * Copyright (c) 2011-2014 SirSengir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * 
 * Various Contributors including, but not limited to:
 * SirSengir (original work), CovertJaguar, Player, Binnie, MysteriousAges
 ******************************************************************************/
package covers1624.legacyfarms.crop;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ICropProvider {

	/**
	 * @param germling
	 * @return True if the passed itemstack is a valid germling for use in planting.
	 */
	public boolean isGermling(ItemStack germling);

	/**
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @return True if the block at the passed location is a valid crop (mature or immature). Includes saplings!
	 */
	public boolean isCrop(World world, int x, int y, int z);

	/**
	 * Called once to configure possible windfall created by harvested crops managed by this provider.
	 * 
	 * @return Array of item stacks representing possible windfall.
	 */
	public ItemStack[] getWindfall();

	/**
	 * Plant a crop in the world with the germling given. Planter will have called isGermling beforehand.
	 * 
	 * @param germling
	 *            ItemStack representing the germling available. Stack is decreased by the planter, not by the provider.
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @return True if planting is successfull, false otherwise.
	 */
	public boolean doPlant(ItemStack germling, World world, int x, int y, int z);

	/**
	 * Returns the crop at the given location. Planter will have called isCrop beforehand.
	 * 
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @return
	 */
	public ICropEntity getCrop(World world, int x, int y, int z);

}