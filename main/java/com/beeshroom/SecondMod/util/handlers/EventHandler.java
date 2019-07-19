package com.beeshroom.SecondMod.util.handlers;


	import com.beeshroom.SecondMod.events.LootTableEvent;

import net.minecraftforge.common.MinecraftForge;

	public class EventHandler 
	{
		public static void registerEvents()
		{
	//		EventExample exampleEvent = new EventExample();
			LootTableEvent lootEvent = new LootTableEvent();
	//		OverrideRecipes recipeEvent = new OverrideRecipes();
			
		//	MinecraftForge.EVENT_BUS.register(recipeEvent);
			MinecraftForge.EVENT_BUS.register(lootEvent);
		//	MinecraftForge.EVENT_BUS.register(exampleEvent);
		}
	}
