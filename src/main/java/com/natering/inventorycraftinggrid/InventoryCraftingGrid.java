package com.natering.inventorycraftinggrid;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = InventoryCraftingGrid.MODID, name = InventoryCraftingGrid.NAME, version = InventoryCraftingGrid.VERSION)
public class InventoryCraftingGrid {
    public static final String MODID = "inventorycraftinggrid";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "@VERSIONS@";

    private static Logger logger;
    public InventoryCraftingGrid() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onGuiOpened(GuiOpenEvent event) {
        System.out.println("Gui opened");
        Gui gui = event.getGui();
        if (gui instanceof GuiInventory) {

        }
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
