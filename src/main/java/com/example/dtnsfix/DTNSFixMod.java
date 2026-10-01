package com.example.dtnsfix;

import com.ferreusveritas.dynamictrees.api.registry.RegistryEvent;
import com.ferreusveritas.dynamictrees.growthlogic.GrowthLogicKit;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xueluoanping.dtnatures_spirit.systems.growthlogic.RedwoodLogic;

@Mod(DTNSFixMod.MOD_ID)
@Mod.EventBusSubscriber(modid = DTNSFixMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DTNSFixMod {

    public static final String MOD_ID = "dtnatures_spirit_fix";
    private static final Logger LOGGER = LogManager.getLogger();

    public DTNSFixMod() {
        LOGGER.info("[DTNS Fix] Loaded");
    }

    @SubscribeEvent
    public static void onGrowthLogicKitsRegistry(final RegistryEvent<GrowthLogicKit> event) {
        try {
            ResourceLocation redwoodId = new ResourceLocation("dtnatures_spirit", "redwood");
            event.getRegistry().register(new RedwoodLogic(redwoodId));
            LOGGER.info("[DTNS Fix] Registered growth logic kit: " + redwoodId);
        } catch (Exception e) {
            LOGGER.warn("[DTNS Fix] Skipped registration: " + e.getMessage());
        }
    }
}
