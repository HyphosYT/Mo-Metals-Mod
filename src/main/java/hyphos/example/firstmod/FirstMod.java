package hyphos.example.firstmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
	
	public static final Block TITANIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0F, 5.0F).sounds(BlockSoundGroup.METAL));
	
	public static final Item TITANIUM = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	public static final Block TITANIUM_ORE = new TitaniumOre(FabricBlockSettings.of(Material.STONE).strength(3, 3).sounds(BlockSoundGroup.STONE));

	public static final Logger LOGGER = LoggerFactory.getLogger("firstmod");

	@Override
	public void onInitialize() {
	
	Registry.register(Registry.BLOCK, new Identifier("firstmod", "titanium_block"), TITANIUM_BLOCK);
	Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_block"), new BlockItem(TITANIUM_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium"), TITANIUM);
	Registry.register(Registry.BLOCK, new Identifier("firstmod", "titanium_ore"), TITANIUM_ORE);
	Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_ore"), new BlockItem(TITANIUM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		LOGGER.info("Hello Fabric world!");
	}
}
