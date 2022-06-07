
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.modernplanets.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.modernplanets.world.inventory.GuiRocketMenu;
import net.mcreator.modernplanets.world.inventory.Cheese2Menu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModernPlanetsModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<GuiRocketMenu> GUI_ROCKET = register("gui_rocket", (id, inv, extraData) -> new GuiRocketMenu(id, inv, extraData));
	public static final MenuType<Cheese2Menu> CHEESE_2 = register("cheese_2", (id, inv, extraData) -> new Cheese2Menu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
