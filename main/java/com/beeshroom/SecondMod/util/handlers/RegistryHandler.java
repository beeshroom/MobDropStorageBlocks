package com.beeshroom.SecondMod.util.handlers;


import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.beeshroom.SecondMod.client.renderer.entity.EntityCarpet;
import com.beeshroom.SecondMod.client.renderer.entity.EntityCreeperPrint;
import com.beeshroom.SecondMod.client.renderer.entity.EntityGunpowder;
import com.beeshroom.SecondMod.init.ModBlocks;
import com.beeshroom.SecondMod.init.ModItems;
import com.beeshroom.SecondMod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public final class RegistryHandler {

	private static final Logger LOGGER = LogManager.getLogger(Reference.MOD_ID + " Event Subscriber");

	private static int entityId = 0; 

/*@EventBusSubscriber
public class RegistryHandler
{   
*/
	
@SubscribeEvent

public static void onItemRegister(RegistryEvent.Register<Item> event)
{
	event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
}

@SubscribeEvent

public static void onBlockRegister(RegistryEvent.Register<Block> event)
{
	event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
}

@SubscribeEvent
public static void onRegisterEntitiesEvent(@Nonnull final RegistryEvent.Register<EntityEntry> event) {

    final ResourceLocation EntityCreeperPrint = new ResourceLocation(Reference.MOD_ID, "entitycreeperprint");
    final ResourceLocation EntityCarpet = new ResourceLocation(Reference.MOD_ID, "entitycarpet");
    final ResourceLocation EntityGunpowder = new ResourceLocation(Reference.MOD_ID, "entitygunpowder");
   // final ResourceLocation EntityBrownMooshroom = new ResourceLocation(Reference.MOD_ID, "entitybrownmooshroom");

    event.getRegistry().registerAll(
        EntityEntryBuilder.create()
            .entity(EntityCreeperPrint.class)
            .id(EntityCreeperPrint, entityId++)
            .name(EntityCreeperPrint.getResourcePath())
            .tracker(32, 10, false)
            .build(),
         
                    EntityEntryBuilder.create()
                        .entity(EntityCarpet.class)
                        .id(EntityCarpet, entityId++)
                        .name(EntityCarpet.getResourcePath())
                        .tracker(32, 10, false)
                        .build(),
                        
                        EntityEntryBuilder.create()
                        .entity(EntityGunpowder.class)
                        .id(EntityGunpowder, entityId++)
                        .name(EntityGunpowder.getResourcePath())
                        .tracker(32, 10, false)
                        .build()
                   /* EntityEntryBuilder.create()
                        .entity(EntityBrownMooshroom.class)
                        .egg(9527612, 14732970)
                        .id(EntityBrownMooshroom, entityId++)
                        .name(EntityBrownMooshroom.getResourcePath())
                        .tracker(64, 2, true)
                        .build() */
    ); 

    LOGGER.debug("Registered entities");

}

/*
@SubscribeEvent

public static void onModelRegister(ModelRegistryEvent event)
{
	for(Item item : ModItems.ITEMS)
	{
		if(item instanceof IHasModel)
		{
			((IHasModel)item).registerModels();
		}
	}
	for(Block block : ModBlocks.BLOCKS)
	{
		if(block instanceof IHasModel)
		{
			((IHasModel)block).registerModels();
		}
	}
	
} */

/*public static void registerSlab(IForgeRegistry<Block> registry, Block halfSlab, Block doubleSlab, ItemSlab itemSlab)
{
	registry.register(setupBlock(new BlockEggsSlab.Half(), "eggs_slab"));
	registry.register(setupBlock(new BlockEggSlab.Double(), "eggs_double_slab"));
	
	final ItemSlab itemSlab = new ItemSlab(EGGS_SLAB_HALF, EGGS_SLAB_HALF, EGGS_SLAB_DOUBLE);
	final ResourceLocation name = EGGS_SLAB_HALF.getRegistryName();
	itemSlab.setRegistryName(name);
	registry.register(itemSlab);
	*/
  //  registry.registerAll(halfSlab, doubleSlab);
  //  itemSlab.setRegistryName(halfSlab.getRegistryName());
   // ForgeRegistries.ITEMS.register(itemSlab);
  //  ModelLoader.setCustomModelResourceLocation(itemSlab, 0, new ModelResourceLocation(itemSlab.getRegistryName(), "inventory"));
//}



public static void preInitRegistries()
{
	EventHandler.registerEvents();

}

@SubscribeEvent
public static void furnaceFuelBurnTime(FurnaceFuelBurnTimeEvent event)
{
	if(event.getItemStack().getItem() == Item.getItemFromBlock(ModBlocks.BLAZERODBUNDLE))
	{
		event.setBurnTime(24000);
	}
	
	if(event.getItemStack().getItem() == Item.getItemFromBlock(ModBlocks.STICKBUNDLE))
	{
		event.setBurnTime(1000);
	}
	
}

}
