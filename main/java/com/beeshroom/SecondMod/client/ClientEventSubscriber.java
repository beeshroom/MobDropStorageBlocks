package com.beeshroom.SecondMod.client;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;

import javax.annotation.Nonnull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.beeshroom.SecondMod.client.renderer.entity.EntityCarpet;
import com.beeshroom.SecondMod.client.renderer.entity.EntityCreeperPrint;
import com.beeshroom.SecondMod.client.renderer.entity.EntityGunpowder;
import com.beeshroom.SecondMod.client.renderer.entity.RenderCarpet;
import com.beeshroom.SecondMod.client.renderer.entity.RenderCreeperPrint;
import com.beeshroom.SecondMod.client.renderer.entity.RenderGunpowder;
import com.beeshroom.SecondMod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Subscribe to events that should be handled on the PHYSICAL CLIENT in this class
 *
 * base code @author Cadiboo, Used with permission
 */
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = CLIENT)
public final class ClientEventSubscriber {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * This method will be called by Forge when it is time for the mod to register its models.
	 * This method will always be called after the block and item registry methods.
	 */
	@SubscribeEvent
	public static void onRegisterModelsEvent(@Nonnull final ModelRegistryEvent event) {

		registerTileEntitySpecialRenderers();
		LOGGER.debug("Registered tile entity special renderers");

		registerEntityRenderers();
		LOGGER.debug("Registered entity renderers");

		ForgeRegistries.ITEMS.getValuesCollection().stream()
		.filter(item -> item.getRegistryName().getResourceDomain().equals(Reference.MOD_ID))
		.forEach(item -> {
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "normal"));
		});

		LOGGER.debug("Registered models");

	}

	/**
	 * Helper method to register all TESRs in
	 */
	private static void registerTileEntitySpecialRenderers() {

//		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityExampleTileEntity.class, new RenderExampleTileEntity());

	}

	/**
	 * Helper method to register all Entity Renderers in
	 */
	private static void registerEntityRenderers() {

		RenderingRegistry.registerEntityRenderingHandler(EntityCreeperPrint.class, RenderCreeperPrint::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityCarpet.class, RenderCarpet::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityGunpowder.class, RenderGunpowder::new);

	}
	
	public static void registerSlab(IForgeRegistry<Block> registry, Block halfSlab, Block doubleSlab, ItemSlab itemSlab)
    {
        registry.registerAll(halfSlab, doubleSlab);
        itemSlab.setRegistryName(halfSlab.getRegistryName());
        ForgeRegistries.ITEMS.register(itemSlab);
        ModelLoader.setCustomModelResourceLocation(itemSlab, 0, new ModelResourceLocation(itemSlab.getRegistryName(), "inventory"));
    }

	
	
//new also removed @override ??
	
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}	
	
	
	public void registerVariantRenderer(Item item, int meta, String filename, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, filename), id));
	}
	
	
	
}