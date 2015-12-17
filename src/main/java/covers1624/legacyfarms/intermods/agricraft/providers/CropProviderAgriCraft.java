package covers1624.legacyfarms.intermods.agricraft.providers;

import covers1624.legacyfarms.crop.ICropEntity;
import covers1624.legacyfarms.crop.ICropProvider;
import covers1624.legacyfarms.intermods.agricraft.AgricraftModule;
import covers1624.legacyfarms.intermods.agricraft.providers.entity.CropEntityAgriCraft;
import covers1624.lib.util.BlockPosition;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

public class CropProviderAgriCraft implements ICropProvider {
	@Override
	public boolean isGermling(ItemStack germling) {
		return false;
	}

	@Override
	public boolean isCrop(World world, BlockPosition blockPos) {
		return blockPos.getBlock(world) == AgricraftModule.blockCrop;
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
