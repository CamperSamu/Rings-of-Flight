package com.campersamu.flyrings.mixins;

import com.campersamu.flyrings.registry.ItemRegistry;
import net.minecraft.enchantment.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(UnbreakingEnchantment.class)
public class UnbreakingMixin extends Enchantment {
    protected UnbreakingMixin(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    /**
     * Allows the Ring of Flight to be enchanted with unbreaking
     *
     * @author Camper_Samu
     */
    @Inject(at = @At("HEAD"), method = "isAcceptableItem")
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(stack.getItem().equals(ItemRegistry.FLY_RING));
    }




}
