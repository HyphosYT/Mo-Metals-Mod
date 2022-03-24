package hyphos.example.firstmod.class_files;

import hyphos.example.firstmod.FirstMod;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TitaniumToolMaterial implements ToolMaterial {

    public static final TitaniumToolMaterial INSTANCE = new TitaniumToolMaterial();

    @Override
    public float getAttackDamage() {
        
        return 0F;
    }

    @Override
    public int getDurability() {
        
        return 1500;
    }

    @Override
    public int getEnchantability() {
        
        return 20;
    }

    @Override
    public int getMiningLevel() {
        
        return 4;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        
        return 7.5F;
    }

    @Override
    public Ingredient getRepairIngredient() {
        
        return Ingredient.ofItems(FirstMod.TITANIUM);
    }
    
}
