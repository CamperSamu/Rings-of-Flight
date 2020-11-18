package com.campersamu.flyrings.registry;

import com.campersamu.flyrings.item.RingOfFlightItem;

import io.github.ladysnake.pal.Pal;
import io.github.ladysnake.pal.VanillaAbilities;
import nerdhub.cardinal.components.api.event.ItemComponentCallbackV2;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosComponent;
import top.theillusivec4.curios.api.SlotTypeInfo;
import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.type.component.ICurio;


import static com.campersamu.flyrings.ModInit.MOD_ID;

public class CuriosRegistry {
    public static void init() {
        CuriosApi.enqueueSlotType(SlotTypeInfo.BuildScheme.REGISTER, SlotTypePreset.RING.getInfoBuilder().build());
        ItemComponentCallbackV2.event(ItemRegistry.FLY_RING).register(
                ((item, itemStack, componentContainer) -> componentContainer
                        .put(CuriosComponent.ITEM, new ICurio() {
                            @Override
                            public void onEquip(String identifier, int index, LivingEntity livingEntity) {
                                if (livingEntity instanceof PlayerEntity)
                                    Pal.grantAbility(((PlayerEntity) livingEntity), VanillaAbilities.ALLOW_FLYING, Pal.getAbilitySource(MOD_ID, "ring_of_flight"));

                            }

                            @Override
                            public void onUnequip(String identifier, int index, LivingEntity livingEntity) {
                                if (livingEntity instanceof PlayerEntity) {
                                    Pal.revokeAbility(((PlayerEntity) livingEntity), VanillaAbilities.ALLOW_FLYING, Pal.getAbilitySource(MOD_ID, "ring_of_flight"));
                                    Pal.revokeAbility(((PlayerEntity) livingEntity), VanillaAbilities.FLYING, Pal.getAbilitySource(MOD_ID, "ring_of_flight"));
                                }
                            }

                            @Override
                            public void curioTick(String identifier, int index, LivingEntity livingEntity) {
                                if (livingEntity instanceof PlayerEntity) {
                                    PlayerEntity player = ((PlayerEntity) livingEntity);

                                    RingOfFlightItem.subtractXp(player, EnchantmentHelper.getLevel(Enchantments.UNBREAKING, itemStack));


                                }
                            }

                            @Override
                            public boolean canRightClickEquip() {
                                return true;
                            }
                        })));

        ItemComponentCallbackV2.event(ItemRegistry.ADVANCED_FLY_RING).register(
                ((item, itemStack, componentContainer) -> componentContainer
                        .put(CuriosComponent.ITEM, new ICurio() {
                            @Override
                            public void onEquip(String identifier, int index, LivingEntity livingEntity) {
                                if (livingEntity instanceof PlayerEntity)
                                    Pal.grantAbility(((PlayerEntity) livingEntity), VanillaAbilities.ALLOW_FLYING, Pal.getAbilitySource(MOD_ID, "ring_of_flight"));

                            }

                            @Override
                            public void onUnequip(String identifier, int index, LivingEntity livingEntity) {
                                if (livingEntity instanceof PlayerEntity) {
                                    Pal.revokeAbility(((PlayerEntity) livingEntity), VanillaAbilities.ALLOW_FLYING, Pal.getAbilitySource(MOD_ID, "ring_of_flight"));
                                    Pal.revokeAbility(((PlayerEntity) livingEntity), VanillaAbilities.FLYING, Pal.getAbilitySource(MOD_ID, "ring_of_flight"));
                                }
                            }

                            @Override
                            public boolean canRightClickEquip() {
                                return true;
                            }
                        })));
    }
}
