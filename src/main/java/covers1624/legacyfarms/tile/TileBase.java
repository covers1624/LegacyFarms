package covers1624.legacyfarms.tile;

import com.mojang.authlib.GameProfile;
import covers1624.legacyfarms.network.INetworkTile;
import covers1624.legacyfarms.utils.Vect;
import forestry.api.core.IErrorLogic;
import forestry.api.core.IErrorLogicSource;
import forestry.core.delegates.ErrorLogic;
import forestry.core.interfaces.IOwnable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileBase extends TileEntity implements IOwnable, IErrorLogicSource, INetworkTile {

	public ErrorLogic errorLogic = new ErrorLogic();

	protected boolean isInited = false;

	private ForgeDirection facing = ForgeDirection.WEST;

	public ForgeDirection getFacing() {
		return facing;
	}

	public void setFacing(ForgeDirection facing) {
		this.facing = facing;
	}

	public Vect getCoords() {
		return new Vect(xCoord, yCoord, zCoord);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTagCompound = new NBTTagCompound();
		// writeNetData(nbtTagCompound);
		nbtTagCompound.setInteger("Facing", facing.ordinal());
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, nbtTagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		// readNetData(pkt.func_148857_g());
		facing = ForgeDirection.VALID_DIRECTIONS[pkt.func_148857_g().getInteger("Facing")];
		this.worldObj.func_147479_m(xCoord, yCoord, zCoord);
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);
		// readNetData(tagCompound);
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);
		// writeNetData(tagCompound);
	}

	@Override
	public boolean isOwned() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GameProfile getOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOwner(GameProfile owner) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isOwner(EntityPlayer player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IErrorLogic getErrorLogic() {
		return errorLogic;
	}

	@Override
	public void readNetData(NBTTagCompound tagCompound) {

	}

	@Override
	public void writeNetData(NBTTagCompound tagCompound) {
		// TODO Auto-generated method stub

	}
}
