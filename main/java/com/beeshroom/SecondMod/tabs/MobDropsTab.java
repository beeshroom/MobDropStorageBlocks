package com.beeshroom.SecondMod.tabs;

import com.beeshroom.SecondMod.init.ModBlocks;
import com.beeshroom.SecondMod.init.ModItems;
import com.beeshroom.SecondMod.items.ItemBase;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MobDropsTab extends CreativeTabs
{
	public MobDropsTab(String label) {super("mobdropstab");}
	public ItemStack getTabIconItem() { return new ItemStack(ModBlocks.ROTTENFLESHBLOCK);}

	}

	
