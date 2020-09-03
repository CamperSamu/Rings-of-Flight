package com.campersamu.flyrings;

import com.campersamu.flyrings.registry.CuriosRegistry;
import com.campersamu.flyrings.registry.ItemRegistry;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModInit implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "flyrings";
    public static final String MOD_NAME = "rings-of-flight";


    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing...");
        log(Level.INFO, "\t-ItemRegistry");
        ItemRegistry.init();
        log(Level.INFO, "\t-CuriosRegistry");
        CuriosRegistry.init();
        log(Level.INFO, "Initialized!");
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}