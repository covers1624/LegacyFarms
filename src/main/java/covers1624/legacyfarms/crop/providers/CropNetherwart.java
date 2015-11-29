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
import covers1624.lib.util.BlockPosition;
import forestry.core.proxy.Proxies;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

public class CropNetherwart implements ICropEntity {

	private World world;
	private int xCoord;
	private int yCoord;
	private int zCoord;
	private int meta;

	public CropNetherwart(World world, BlockPosition blockPos) {
		this.world = world;
		this.xCoord = blockPos.x;
		this.yCoord = blockPos.y;
		this.zCoord = blockPos.z;
		this.meta = world.getBlockMetadata(blockPos.x, blockPos.y, blockPos.z);
	}

	@Override
	public boolean isHarvestable() {
		return meta >= 3;
	}

	@Override
	public int[] getNextPosition() {
		return null;
	}

	@Override
	public ArrayList<ItemStack> doHarvest() {
		ArrayList<ItemStack> harvest = Blocks.nether_wart.getDrops(world, xCoord, yCoord, zCoord, meta, 0);
		Proxies.common.addBlockDestroyEffects(world, xCoord, yCoord, zCoord, Blocks.nether_wart, 0);
		world.setBlockToAir(xCoord, yCoord, zCoord);
		return harvest;
	}

}
