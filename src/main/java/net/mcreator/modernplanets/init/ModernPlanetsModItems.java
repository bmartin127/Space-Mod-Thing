
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.modernplanets.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.modernplanets.item.MarsItem;
import net.mcreator.modernplanets.item.IronConeItem;
import net.mcreator.modernplanets.item.FuelCanisterItem;
import net.mcreator.modernplanets.item.CheeseItem;
import net.mcreator.modernplanets.item.BoosterItem;
import net.mcreator.modernplanets.ModernPlanetsMod;

public class ModernPlanetsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ModernPlanetsMod.MODID);
	public static final RegistryObject<Item> MARS_STONE = block(ModernPlanetsModBlocks.MARS_STONE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> MARS = REGISTRY.register("mars", () -> new MarsItem());
	public static final RegistryObject<Item> ROCKET = block(ModernPlanetsModBlocks.ROCKET, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> FUEL_CANISTER = REGISTRY.register("fuel_canister", () -> new FuelCanisterItem());
	public static final RegistryObject<Item> CHEESE_ORE = block(ModernPlanetsModBlocks.CHEESE_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> CHEESE_PASTEURIZER = block(ModernPlanetsModBlocks.CHEESE_PASTEURIZER,
			CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> IRON_CONE = REGISTRY.register("iron_cone", () -> new IronConeItem());
	public static final RegistryObject<Item> BOOSTER = REGISTRY.register("booster", () -> new BoosterItem());
	public static final RegistryObject<Item> CHEESE = REGISTRY.register("cheese", () -> new CheeseItem());
	public static final RegistryObject<Item> LAUNCH_TOWER = block(ModernPlanetsModBlocks.LAUNCH_TOWER, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> ROCKET_TOP = block(ModernPlanetsModBlocks.ROCKET_TOP, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> URANUS_RING_ROCK = block(ModernPlanetsModBlocks.URANUS_RING_ROCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> SOLAR_WOOD_WOOD = block(ModernPlanetsModBlocks.SOLAR_WOOD_WOOD, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> SOLAR_WOOD_LOG = block(ModernPlanetsModBlocks.SOLAR_WOOD_LOG, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> SOLAR_WOOD_PLANKS = block(ModernPlanetsModBlocks.SOLAR_WOOD_PLANKS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> SOLAR_WOOD_LEAVES = block(ModernPlanetsModBlocks.SOLAR_WOOD_LEAVES, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> SOLAR_WOOD_STAIRS = block(ModernPlanetsModBlocks.SOLAR_WOOD_STAIRS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> SOLAR_WOOD_SLAB = block(ModernPlanetsModBlocks.SOLAR_WOOD_SLAB, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> SOLAR_WOOD_FENCE = block(ModernPlanetsModBlocks.SOLAR_WOOD_FENCE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> SOLAR_WOOD_FENCE_GATE = block(ModernPlanetsModBlocks.SOLAR_WOOD_FENCE_GATE,
			CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Item> SOLAR_WOOD_PRESSURE_PLATE = block(ModernPlanetsModBlocks.SOLAR_WOOD_PRESSURE_PLATE,
			CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Item> SOLAR_WOOD_BUTTON = block(ModernPlanetsModBlocks.SOLAR_WOOD_BUTTON, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> TIER_1_LAUNCH_PAD = block(ModernPlanetsModBlocks.TIER_1_LAUNCH_PAD, CreativeModeTab.TAB_BUILDING_BLOCKS);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
