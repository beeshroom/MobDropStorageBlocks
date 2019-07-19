package com.beeshroom.SecondMod.blocks;


import com.beeshroom.SecondMod.init.ModBlocks;
import com.beeshroom.SecondMod.init.ModItems;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;

public class BlockSlabHalfBase extends BlockSlabBase 
{
	public BlockSlabHalfBase(String name, Material materialIn, CreativeTabs tab, BlockSlab half, BlockSlab doubleSlab)
	{
		super(name, materialIn, half);
		setCreativeTab(tab);
		ModItems.ITEMS.add(new ItemSlab(this, this, doubleSlab).setRegistryName(name));
	}
	
	@Override
	public boolean isDouble() 
	{
		return false;
	}

	/*@Override
	public void registerModels()
	{
		ModBlocks.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	*/
}