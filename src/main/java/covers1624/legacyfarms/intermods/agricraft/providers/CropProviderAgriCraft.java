package covers1624.legacyfarms.intermods.agricraft.providers;

import com.InfinityRaider.AgriCraft.init.Blocks;
import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.legacyfarms.crop.ICropProvider;
import covers1624.legacyfarms.intermods.agricraft.providers.entity.CropEntityAgriCraft;
import covers1624.lib.util.BlockPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by covers1624 on 12/16/2015.
 */
public class CropProviderAgriCraft implements ICropProvider{
	@Override
	public boolean isGermling(ItemStack germling) {
		return false;
	}

	@Override
	public boolean isCrop(World world, BlockPosition blockPos) {
		return blockPos.getBlock(world) == Blocks.blockCrop;
	}

	@Override
	public void addWindfall(ArrayList<ItemStack> windfall) {

	}

	@Override
	public boolean doPlant(ItemStack germling, World world, BlockPosition blockPos) {
		return false;
	}

	@Override
	public ICropEntity getCrop(World world, BlockPosition blockPos) {
		return new CropEntityAgriCraft(world, blockPos);
	}
}
