package com.beeshroom.SecondMod.init;

import java.util.ArrayList;
import java.util.List;

import com.beeshroom.SecondMod.items.ItemBase;
import com.beeshroom.SecondMod.items.food.ItemCustomFood;
import com.beeshroom.SecondMod.items.tools.ToolSword;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	public static final ToolMaterial MATERIAL_BONE = EnumHelper.addToolMaterial("material_bone", 1, 75, 4.0F, 1.9F, 15);
	
	
	//items
	//public static final Item OAT = new ItemBase("oat");
	public static final Item COWHIDE = new ItemBase("cowhide");
	public static final Item MOOSHROOMHIDE = new ItemBase("mooshroomhide");
	public static final Item MOOSHROOMHIDEBROWN = new ItemBase("mooshroomhidebrown");
	public static final Item CREEPYMOSS = new ItemBase("creepymoss");
	public static final Item LEATHER_STRIP = new ItemBase("leather_strip");
	
	
	
	//food 
	//public static final Item MILLET = new ItemCustomFood("millet", 2, false);
	
	//Tools
	public static final ItemSword SKELETON_ARM = new ToolSword("skeleton_arm", MATERIAL_BONE);

}