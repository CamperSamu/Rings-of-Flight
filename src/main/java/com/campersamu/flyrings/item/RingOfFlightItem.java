package com.campersamu.flyrings.item;


import io.github.ladysnake.pal.Pal;
import io.github.ladysnake.pal.VanillaAbilities;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

import static com.campersamu.flyrings.ModInit.MOD_ID;

public class RingOfFlightItem extends Item {

    public RingOfFlightItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.flyrings.ring_of_flight.tooltip"));
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    public static void subtractXp(PlayerEntity player, int unbreakingLevel) {

        if (!player.getEntityWorld().isClient) {
            if (!player.abilities.creativeMode && player.abilities.flying) {
                if (new Random().nextInt(100) > 20 * unbreakingLevel) {
                    player.addExperience(-1);
                }
                if (player.experienceLevel <= 0 && player.experienceProgress <= 0) {
                    Pal.revokeAbility(player, VanillaAbilities.ALLOW_FLYING, Pal.getAbilitySource(MOD_ID, "ring_of_flight"));
                    Pal.revokeAbility(player, VanillaAbilities.FLYING, Pal.getAbilitySource(MOD_ID, "ring_of_flight"));
                } else {
                    Pal.grantAbility(player, VanillaAbilities.ALLOW_FLYING, Pal.getAbilitySource(MOD_ID, "ring_of_flight"));
                }
            }
        }
    }
}

