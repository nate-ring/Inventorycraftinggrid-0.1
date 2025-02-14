package com.natering.inventorycraftinggrid;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class Events{

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onGuiOpen(GuiOpenEvent event){
        Gui gui = event.getGui();
        if(gui != null && gui.getClass() == GuiInventory.class){
            event.setGui(new GuiInventoryCraftingGrid(Minecraft.getMinecraft().player));
        }
    }

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event){

        if(event.getEntity() instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer) event.getEntity();

            System.out.println("IEE join world");
            /*
             * PlayerPowerups power = PlayerPowerups.get(player); if(power != null) {
             * power.onJoinWorld(); }
             */
            if(player.inventory instanceof InventoryPlayerCrafting == false){
                player.inventory = new InventoryPlayerCrafting(player);
                player.inventoryContainer = new ContainerPlayerCrafting((InventoryPlayerCrafting) player.inventory, !player.world.isRemote, player);
                player.openContainer = player.inventoryContainer;
            }

        }
    }


    @SubscribeEvent
    public void onPlayerLoad(UpdatedAttachCapabilitiesEvent.Entity event){

//load
				/*
				 if (this.player.inventory instanceof InventoryPlayerCrafting == false)
				 {
				   this.player.inventory = new InventoryPlayerCrafting(this.player);
				   this.player.inventoryContainer = new ContainerPlayerCrafting((InventoryPlayerCrafting)this.player.inventory, !this.player.worldObj.isRemote, this.player);
				   this.player.openContainer = this.player.inventoryContainer;
				   ((InventoryPlayerCrafting)this.player.inventory).readFromNBT(compound.getTagList("Inventory", 10));
				 }
*/


    }

}

