
package net.mcreator.modernplanets.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.modernplanets.world.inventory.GuiRocketMenu;
import net.mcreator.modernplanets.procedures.ToSpaceProcedureProcedure;
import net.mcreator.modernplanets.procedures.RocketMarsLaunchProcedure;
import net.mcreator.modernplanets.procedures.MoonTpProcedure;
import net.mcreator.modernplanets.procedures.GoToUranusProcedure;
import net.mcreator.modernplanets.procedures.GoToEarthProcedure;
import net.mcreator.modernplanets.procedures.FuelProcedure;
import net.mcreator.modernplanets.ModernPlanetsMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GuiRocketButtonMessage {
	private final int buttonID, x, y, z;

	public GuiRocketButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public GuiRocketButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(GuiRocketButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(GuiRocketButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = GuiRocketMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			RocketMarsLaunchProcedure.execute(entity);
		}
		if (buttonID == 1) {

			FuelProcedure.execute(entity, guistate);
		}
		if (buttonID == 2) {

			MoonTpProcedure.execute(entity);
		}
		if (buttonID == 3) {

			GoToEarthProcedure.execute(entity);
		}
		if (buttonID == 4) {

			ToSpaceProcedureProcedure.execute(entity);
		}
		if (buttonID == 5) {

			GoToUranusProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ModernPlanetsMod.addNetworkMessage(GuiRocketButtonMessage.class, GuiRocketButtonMessage::buffer, GuiRocketButtonMessage::new,
				GuiRocketButtonMessage::handler);
	}
}
