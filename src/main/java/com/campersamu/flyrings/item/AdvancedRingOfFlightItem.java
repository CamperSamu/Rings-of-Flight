package com.campersamu.flyrings.item;


import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;

public class AdvancedRingOfFlightItem extends Item {

    public AdvancedRingOfFlightItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.flyrings.advanced_ring_of_flight.tooltip0"));
        tooltip.add(new TranslatableText("item.flyrings.advanced_ring_of_flight.tooltip1"));
    }


}
