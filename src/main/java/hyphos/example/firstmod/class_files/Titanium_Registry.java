package hyphos.example.firstmod.class_files;

import hyphos.example.firstmod.FirstMod;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Titanium_Registry {
    public static final ArmorMaterial TITANIUM_ARMOR_MATERIAL = new TitaniumArmorMaterial();
    public static final TitaniumArmorMaterial TITANIUM_MATERIAL = new TitaniumArmorMaterial();
    public static final Item TITANIUM_MATERIAL_HELMET = new ArmorItem(TITANIUM_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(FirstMod.MO_METALS_MOD));
    public static final Item TITANIUM_MATERIAL_CHESTPLATE = new ArmorItem(TITANIUM_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(FirstMod.MO_METALS_MOD));
    public static final Item TITANIUM_MATERIAL_LEGGINGS = new ArmorItem(TITANIUM_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(FirstMod.MO_METALS_MOD));
    public static final Item TITANIUM_MATERIAL_BOOTS = new ArmorItem(TITANIUM_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(FirstMod.MO_METALS_MOD));

    public static final ToolItem TITANIUM_SWORD = new SwordItem(TitaniumToolMaterial.INSTANCE, 5, -1.5F, new Item.Settings().group(FirstMod.MO_METALS_MOD));
    public static final ToolItem TITANIUM_SHOVEL = new ShovelItem(TitaniumToolMaterial.INSTANCE, 3F, -2F, new Item.Settings().group(FirstMod.MO_METALS_MOD));
    public static final ToolItem TITANIUM_PICKAXE = new TitaniumPickaxeItem(TitaniumToolMaterial.INSTANCE, 3, -1.8F, new Item.Settings().group(FirstMod.MO_METALS_MOD));
    public static final ToolItem TITANIUM_AXE = new TitaniumAxeItem(TitaniumToolMaterial.INSTANCE, 7, -2F, new Item.Settings().group(FirstMod.MO_METALS_MOD));
    public static final ToolItem TITANIUM_HOE = new TitaniumHoeItem(TitaniumToolMaterial.INSTANCE, 0, -1F, new Item.Settings().group(FirstMod.MO_METALS_MOD));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_sword"), TITANIUM_SWORD);
        Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_shovel"), TITANIUM_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_pickaxe"), TITANIUM_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_axe"), TITANIUM_AXE);
        Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_hoe"), TITANIUM_HOE);
        Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_material_helmet"), TITANIUM_MATERIAL_HELMET);
        Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_material_chestplate"), TITANIUM_MATERIAL_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_material_leggings"), TITANIUM_MATERIAL_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("firstmod", "titanium_material_boots"), TITANIUM_MATERIAL_BOOTS);
    }
}
