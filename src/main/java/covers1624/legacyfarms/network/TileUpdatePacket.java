package covers1624.legacyfarms.network;

import covers1624.legacyfarms.LegacyFarms;
import covers1624.lib.network.AbstractPacket;
import covers1624.lib.util.BlockPosition;
import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by covers1624 on 12/15/2015.
 */
public class TileUpdatePacket extends AbstractPacket{

	private NBTTagCompound tagCompound;

	private BlockPosition blockPosition;

	public TileUpdatePacket(INetworkTile tile){
		tagCompound = new NBTTagCompound();
		tile.writeNetData(tagCompound);
		blockPosition = tile.getTilePos().copy();
	}

	@Override
	public void encodeInto(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
		blockPosition.writeToNBT(tagCompound);
		ByteBufUtils.writeTag(byteBuf, tagCompound);
	}

	@Override
	public void decodeInto(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
		tagCompound = ByteBufUtils.readTag(byteBuf);
		blockPosition = new BlockPosition(tagCompound);
	}

	@Override
	public void handleClientSide(EntityPlayer entityPlayer) {
		TileEntity tileEntity = blockPosition.getTileEntity(entityPlayer.worldObj);
		if (tileEntity instanceof INetworkTile){
			INetworkTile tile = (INetworkTile)tileEntity;
			tile.readNetData(tagCompound);
		} else {
			LegacyFarms.logger.error("Received packet from server for block that is not and instance of INetworkTile.. " + blockPosition.toString());
		}
	}

	@Override
	public void handleServerSide(EntityPlayer entityPlayer) {
		//Nope.
	}
}
