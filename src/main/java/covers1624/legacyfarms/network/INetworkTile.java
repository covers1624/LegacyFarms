package covers1624.legacyfarms.network;

import net.minecraft.nbt.NBTTagCompound;

public interface INetworkTile {

	public void readNetData(NBTTagCompound tagCompound);

	public void writeNetData(NBTTagCompound tagCompound);

}
