package hyphos.example.firstmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hyphos.example.firstmod.class_files.TitaniumAxeItem;
import hyphos.example.firstmod.class_files.TitaniumHoeItem;
import hyphos.example.firstmod.class_files.TitaniumOre;
import hyphos.example.firstmod.class_files.TitaniumPickaxeItem;
import hyphos.example.firstmod.class_files.TitaniumToolMaterial;

public class FirstMod implements ModInitializer {
	
	public static final Block TITANIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0F, 5.0F).sounds(BlockSoundGroup.METAL));
	
	public static final Item TITANIUM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	public static final Block TITANIUM_ORE = new TitaniumOre(FabricBlockSettings.of(Material.STONE).strength(3, 3).sounds(BlockSoundGroup.STONE));

	private static ConfiguredFeature<?, ?> TITANIUM_ORE_OVERWORLD = new ConfiguredFeature
		(Feature.ORE, new OreFeatureConfig(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, TITANIUM_ORE.getDefaultState(), 5)); //vein size

	public static PlacedFeature TITANIUM_ORE_OVERWORLD_FEATURE = new PlacedFeature(
		RegistryEntry.of(TITANIUM_ORE_OVERWORLD),
		Arrays.asList(
			CountPlacementModifier.of(5), //number of veins per chunk
			SquarePlacementModifier.of(), //spreading horizontally
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(20)) //height for generation
		));

	public static ToolItem TITANIUM_SWORD = new SwordItem(TitaniumToolMaterial.INSTANCE, 3, 7F, new Item.Settings().group(ItemGroup.COMBAT));

	public static ToolItem TITANIUM_SHOVEL = new ShovelItem(TitaniumToolMaterial.INSTANCE, 1.5F, 3F, new Item.Settings().group(ItemGroup.COMBAT));

	public static ToolItem TITANIUM_PICKAXE = new TitaniumPickaxeItem(TitaniumToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings().group(ItemGroup.TOOLS));

	public static ToolItem TITANIUM_AXE = new TitaniumAxeItem(TitaniumToolMaterial.INSTANCE, 7, -3.2F, new Item.Settings().group(ItemGroup.TOOLS));

	public static ToolItem TITANIUM_HOE = new TitaniumHoeItem(TitaniumToolMaterial.INSTANCE, 1, 3, new Item.Settings().group(ItemGroup.TOOLS));

	public static final Logger LOGGER = LoggerFactory.getLogger("firstmod");

	@Override
	public void onInitialize() {
	
	Registry.register(Registry.BLOCK, new Identifier("firstmod", "titanium_block"), TITANIUM_BLOCK);
	Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_block"), new BlockItem(TITANIUM_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

	Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium"), TITANIUM);

	Registry.register(Registry.BLOCK, new Identifier("firstmod", "titanium_ore"), TITANIUM_ORE);
	Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_ore"), new BlockItem(TITANIUM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

	Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("firstmod", "titanium_ore_overworld"), TITANIUM_ORE_OVERWORLD);
	Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("firstmod", "titanium_ore_overworld"),
        TITANIUM_ORE_OVERWORLD_FEATURE);
	BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("firstmod", "titanium_ore_overworld")));

	Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_sword"), TITANIUM_SWORD);
	Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_shovel"), TITANIUM_SHOVEL);
	Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_pickaxe"), TITANIUM_PICKAXE);
	Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_axe"), TITANIUM_AXE);
	Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_hoe"), TITANIUM_HOE);
	
		LOGGER.info("Hello Fabric world!");
	}
}
