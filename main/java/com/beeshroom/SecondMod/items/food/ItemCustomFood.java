package com.beeshroom.SecondMod.items.food;

import com.beeshroom.SecondMod.Main;
import com.beeshroom.SecondMod.init.ModItems;
import com.beeshroom.SecondMod.util.IHasModel;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemCustomFood extends ItemFood implements IHasModel 
{
	public ItemCustomFood(String name, int amount, boolean iswolffood)
	{
		super(amount, iswolffood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.mobdropstab);
		
		ModItems.ITEMS.add(this);
		
	}
	@Override 
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
