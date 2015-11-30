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
import covers1624.legacyfarms.crop.providers.entity.CropNetherwart;
import covers1624.lib.util.BlockPosition;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;

public class CropProviderNetherwart implements ICropProvider {

	@Override
	public boolean isGermling(ItemStack germling) {
		return germling.isItemEqual(new ItemStack(Items.nether_wart));
	}

	@Override
	public boolean isCrop(World world, BlockPosition blockPos) {
		Block block = blockPos.getBlock(world);
		return block == Blocks.nether_wart;
	}

	@Override
	public void addWindfall(ArrayList<ItemStack> windfall) {

	}

	@Override
	public boolean doPlant(ItemStack germling, World world, BlockPosition blockPos) {
		Block block = blockPos.getBlock(world);

		// Target block needs to be empty
		if (block != Blocks.air) {
			return false;
		}

		// Can only plant on soulsand
		blockPos.step(ForgeDirection.DOWN);
		Block below = blockPos.getBlock(world);
		blockPos.step(ForgeDirection.UP);
		if (below != Blocks.soul_sand) {
			return false;
		}
		blockPos.setBlock(world, Blocks.nether_wart);
		return true;
	}

	@Override
	public ICropEntity getCrop(World world, BlockPosition blockPos) {
		return new CropNetherwart(world, blockPos);
	}
}
