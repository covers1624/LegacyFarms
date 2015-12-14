package covers1624.legacyfarms.tile;

import com.mojang.authlib.GameProfile;
import covers1624.legacyfarms.network.INetworkTile;
import covers1624.lib.util.BlockPosition;
import forestry.api.core.IErrorLogic;
import forestry.api.core.IErrorLogicSource;
import forestry.core.access.IOwnable;
import forestry.core.errors.ErrorLogic;
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

	private boolean needsNetoworkUpdate = false;

	private ForgeDirection facing = ForgeDirection.WEST;

	public ForgeDirection getFacing() {
		return facing;
	}

	public void setFacing(ForgeDirection facing) {
		this.facing = facing;
	}

	public BlockPosition getCoords() {
		return new BlockPosition(xCoord, yCoord, zCoord);
	}

	//public void updateEntity() {
	//	if (this.worldObj.isRemote) {
	//		updateServerSide();
	//	} else {
	//		updateClientSide();
	//	}
//
	//	if (this.needsNetoworkUpdate){
	//		needsNetoworkUpdate = false;
	//		sendNetworkUpdate();
	//	}
	//}

	//protected void updateClientSide() {
//
	//}

	//protected void updateServerSide() {
//
	//}

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

	//@Override
	//public void readFromNBT(NBTTagCompound tagCompound) {
	//	super.readFromNBT(tagCompound);
	//	readNetData(tagCompound);
	//}

	//@Override
	//public void writeToNBT(NBTTagCompound tagCompound) {
	//	super.writeToNBT(tagCompound);
	//	writeNetData(tagCompound);
	//}

	@Override
	public void readNetData(NBTTagCompound tagCompound) {
		facing = ForgeDirection.VALID_DIRECTIONS[tagCompound.getInteger("Facing")];
	}

	@Override
	public void writeNetData(NBTTagCompound tagCompound) {
		tagCompound.setInteger("Facing", facing.ordinal());
	}

	@Override
	public BlockPosition getTilePos() {
		return new BlockPosition(this);
	}

	//protected void sendNetworkUpdate(){
//
	//}

	@Override
	public boolean isOwned() {
		return false;
	}

	@Override
	public GameProfile getOwner() {
		return null;
	}

	@Override
	public void setOwner(GameProfile owner) {
	}

	@Override
	public boolean isOwner(EntityPlayer player) {
		return false;
	}

	@Override
	public IErrorLogic getErrorLogic() {
		return errorLogic;
	}
}
