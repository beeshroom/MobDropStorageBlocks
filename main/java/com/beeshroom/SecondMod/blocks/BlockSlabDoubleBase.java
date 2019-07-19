package com.beeshroom.SecondMod.blocks;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSlabDoubleBase extends BlockSlabBase
{
	public BlockSlabDoubleBase(String name, Material materialIn, CreativeTabs tab, BlockSlab half) 
	{
		super(name, materialIn, half);
		setCreativeTab(tab);
	}

	@Override
	public boolean isDouble() 
	{	
		return true;
	}
}