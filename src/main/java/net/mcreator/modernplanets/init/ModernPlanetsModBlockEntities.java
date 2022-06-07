
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.modernplanets.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.modernplanets.block.entity.RocketTopBlockEntity;
import net.mcreator.modernplanets.block.entity.RocketBlockEntity;
import net.mcreator.modernplanets.block.entity.CheesePasteurizerBlockEntity;
import net.mcreator.modernplanets.ModernPlanetsMod;

public class ModernPlanetsModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,
			ModernPlanetsMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> ROCKET = register("rocket", ModernPlanetsModBlocks.ROCKET, RocketBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CHEESE_PASTEURIZER = register("cheese_pasteurizer",
			ModernPlanetsModBlocks.CHEESE_PASTEURIZER, CheesePasteurizerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ROCKET_TOP = register("rocket_top", ModernPlanetsModBlocks.ROCKET_TOP,
			RocketTopBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
