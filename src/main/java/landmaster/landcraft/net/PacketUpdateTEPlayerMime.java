package landmaster.landcraft.net;

import io.netty.buffer.*;
import landmaster.landcraft.tile.*;
import net.minecraftforge.fml.common.network.simpleimpl.*;

public class PacketUpdateTEPlayerMime implements ITEUpdatePacket {
	private int energy;
	
	public PacketUpdateTEPlayerMime() {};
	public PacketUpdateTEPlayerMime(int energy) {
		this.energy = energy;
	}
	
	public static IMessage onMessage(TEPlayerMime te, PacketUpdateTEPlayerMime message, MessageContext ctx) {
		te.setEnergyStored(null, message.energy);
		return null;
	}
	@Override
	public void fromBytes(ByteBuf buf) {
		energy = buf.readInt();
	}
	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(energy);
	}
}
