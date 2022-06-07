
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.modernplanets.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.modernplanets.client.gui.GuiRocketScreen;
import net.mcreator.modernplanets.client.gui.Cheese2Screen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModernPlanetsModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ModernPlanetsModMenus.GUI_ROCKET, GuiRocketScreen::new);
			MenuScreens.register(ModernPlanetsModMenus.CHEESE_2, Cheese2Screen::new);
		});
	}
}
