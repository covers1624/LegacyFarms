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
package covers1624.legacyfarms.crop.providers;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.legacyfarms.crop.ICropProvider;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CropProviderNetherwart implements ICropProvider {

	@Override
	public boolean isGermling(ItemStack germling) {
		return germling.isItemEqual(new ItemStack(Items.nether_wart));
	}

	@Override
	public boolean isCrop(World world, int x, int y, int z) {
		Block blockid = world.getBlock(x, y, z);
		return blockid == Blocks.nether_wart;
	}

	@Override
	public ItemStack[] getWindfall() {
		return null;
	}

	@Override
	public boolean doPlant(ItemStack germling, World world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);

		// Target block needs to be empty
		if (block != Blocks.air) {
			return false;
		}

		// Can only plant on soulsand
		Block below = world.getBlock(x, y - 1, z);
		if (below != Blocks.soul_sand) {
			return false;
		}

		world.setBlock(x, y, z, Blocks.nether_wart);
		return true;
	}

	@Override
	public ICropEntity getCrop(World world, int x, int y, int z) {
		return new CropNetherwart(world, x, y, z);
	}
}
