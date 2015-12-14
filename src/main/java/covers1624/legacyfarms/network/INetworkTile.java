package covers1624.legacyfarms.network;

import covers1624.lib.util.BlockPosition;
import net.minecraft.nbt.NBTTagCompound;

public interface INetworkTile {

	void readNetData(NBTTagCompound tagCompound);

	void writeNetData(NBTTagCompound tagCompound);

	BlockPosition getTilePos();
}
