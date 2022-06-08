
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.modernplanets.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.modernplanets.block.UranusRingRockBlock;
import net.mcreator.modernplanets.block.Tier1LaunchPadBlock;
import net.mcreator.modernplanets.block.SolarWoodWoodBlock;
import net.mcreator.modernplanets.block.SolarWoodStairsBlock;
import net.mcreator.modernplanets.block.SolarWoodSlabBlock;
import net.mcreator.modernplanets.block.SolarWoodPressurePlateBlock;
import net.mcreator.modernplanets.block.SolarWoodPlanksBlock;
import net.mcreator.modernplanets.block.SolarWoodLogBlock;
import net.mcreator.modernplanets.block.SolarWoodLeavesBlock;
import net.mcreator.modernplanets.block.SolarWoodFenceGateBlock;
import net.mcreator.modernplanets.block.SolarWoodFenceBlock;
import net.mcreator.modernplanets.block.SolarWoodButtonBlock;
import net.mcreator.modernplanets.block.RocketTopBlock;
import net.mcreator.modernplanets.block.RocketBlock;
import net.mcreator.modernplanets.block.MarsStoneBlock;
import net.mcreator.modernplanets.block.MarsPortalBlock;
import net.mcreator.modernplanets.block.LaunchTowerBlock;
import net.mcreator.modernplanets.block.CheesePasteurizerBlock;
import net.mcreator.modernplanets.block.CheeseOreBlock;
import net.mcreator.modernplanets.ModernPlanetsMod;

public class ModernPlanetsModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ModernPlanetsMod.MODID);
	public static final RegistryObject<Block> MARS_STONE = REGISTRY.register("mars_stone", () -> new MarsStoneBlock());
	public static final RegistryObject<Block> MARS_PORTAL = REGISTRY.register("mars_portal", () -> new MarsPortalBlock());
	public static final RegistryObject<Block> ROCKET = REGISTRY.register("rocket", () -> new RocketBlock());
	public static final RegistryObject<Block> CHEESE_ORE = REGISTRY.register("cheese_ore", () -> new CheeseOreBlock());
	public static final RegistryObject<Block> CHEESE_PASTEURIZER = REGISTRY.register("cheese_pasteurizer", () -> new CheesePasteurizerBlock());
	public static final RegistryObject<Block> LAUNCH_TOWER = REGISTRY.register("launch_tower", () -> new LaunchTowerBlock());
	public static final RegistryObject<Block> ROCKET_TOP = REGISTRY.register("rocket_top", () -> new RocketTopBlock());
	public static final RegistryObject<Block> URANUS_RING_ROCK = REGISTRY.register("uranus_ring_rock", () -> new UranusRingRockBlock());
	public static final RegistryObject<Block> SOLAR_WOOD_WOOD = REGISTRY.register("solar_wood_wood", () -> new SolarWoodWoodBlock());
	public static final RegistryObject<Block> SOLAR_WOOD_LOG = REGISTRY.register("solar_wood_log", () -> new SolarWoodLogBlock());
	public static final RegistryObject<Block> SOLAR_WOOD_PLANKS = REGISTRY.register("solar_wood_planks", () -> new SolarWoodPlanksBlock());
	public static final RegistryObject<Block> SOLAR_WOOD_LEAVES = REGISTRY.register("solar_wood_leaves", () -> new SolarWoodLeavesBlock());
	public static final RegistryObject<Block> SOLAR_WOOD_STAIRS = REGISTRY.register("solar_wood_stairs", () -> new SolarWoodStairsBlock());
	public static final RegistryObject<Block> SOLAR_WOOD_SLAB = REGISTRY.register("solar_wood_slab", () -> new SolarWoodSlabBlock());
	public static final RegistryObject<Block> SOLAR_WOOD_FENCE = REGISTRY.register("solar_wood_fence", () -> new SolarWoodFenceBlock());
	public static final RegistryObject<Block> SOLAR_WOOD_FENCE_GATE = REGISTRY.register("solar_wood_fence_gate", () -> new SolarWoodFenceGateBlock());
	public static final RegistryObject<Block> SOLAR_WOOD_PRESSURE_PLATE = REGISTRY.register("solar_wood_pressure_plate",
			() -> new SolarWoodPressurePlateBlock());
	public static final RegistryObject<Block> SOLAR_WOOD_BUTTON = REGISTRY.register("solar_wood_button", () -> new SolarWoodButtonBlock());
	public static final RegistryObject<Block> TIER_1_LAUNCH_PAD = REGISTRY.register("tier_1_launch_pad", () -> new Tier1LaunchPadBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			RocketBlock.registerRenderLayer();
			LaunchTowerBlock.registerRenderLayer();
			Tier1LaunchPadBlock.registerRenderLayer();
		}
	}
}
