package hyphos.example.firstmod.mixin;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import hyphos.example.firstmod.class_files.Titanium_Registry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin (ArmorItem.class)
public abstract class ArmorItemMixin {
    @Shadow @Final private static UUID[] MODIFIERS;
    @Shadow @Final @Mutable
    private Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    @Final protected float speed_boost;

    @Inject(method = "<init>", at = @At(value = "RETURN"))
    private void constructor(ArmorMaterial material, EquipmentSlot slot, Item.Settings settings, CallbackInfo ci) {
        UUID uUID = MODIFIERS[slot.getEntitySlotId()];

        if (material == Titanium_Registry.TITANIUM_ARMOR_MATERIAL) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();

            this.attributeModifiers.forEach(builder::put);

            builder.put(
                    EntityAttributes.GENERIC_MOVEMENT_SPEED,
                    new EntityAttributeModifier(uUID,
                            "Armor speed boost",
                            this.speed_boost,
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );

            this.attributeModifiers = builder.build();
        }
    }

}

