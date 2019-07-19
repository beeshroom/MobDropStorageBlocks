package com.beeshroom.SecondMod.events;


import java.util.Random;

import com.beeshroom.SecondMod.init.ModItems;

import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class LootTableEvent 
{
	@SubscribeEvent
	public void customLootTableDrop(LivingDropsEvent event)
	{
		Random rand = new Random();
		if(event.getEntityLiving() instanceof EntitySkeleton)
		{
		/*	if(rand.nextInt(1) == 0)
			{
				event.getEntityLiving().entityDropItem(new ItemStack(ModItems.LIGHTNING_STAFF), 0.0f);
			}*/
			
			if(rand.nextInt(20) == 0)
			{
				event.getEntityLiving().entityDropItem(new ItemStack(ModItems.SKELETON_ARM), 0.0f);
			}
		}
		
	/*	if(event.getEntityLiving() instanceof EntitySilverfish)
		{
			if(rand.nextInt(5) == 0)
			{
				event.getEntityLiving().entityDropItem(new ItemStack(BlockInit.SILVER_BLOCK), 0.0f);
			}
		} */
	}
}