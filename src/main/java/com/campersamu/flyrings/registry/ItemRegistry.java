package com.campersamu.flyrings.registry;

import com.campersamu.flyrings.item.AdvancedRingOfFlightItem;
import com.campersamu.flyrings.item.RingOfFlightItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static com.campersamu.flyrings.ModInit.MOD_ID;

public class ItemRegistry {

    public static final Item FLY_RING = new RingOfFlightItem(new Item.Settings().group(ItemGroup.TOOLS).rarity(Rarity.RARE).maxCount(1));
    public static final Item ADVANCED_FLY_RING = new AdvancedRingOfFlightItem(new Item.Settings().group(ItemGroup.TOOLS).rarity(Rarity.EPIC).maxCount(1));

    public static void init() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "ring_of_flight"), FLY_RING);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "advanced_ring_of_flight"), ADVANCED_FLY_RING);
    }


}
