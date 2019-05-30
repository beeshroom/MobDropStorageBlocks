package com.beeshroom.SecondMod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class rottenfleshblock extends BlockBase
{

	public rottenfleshblock (String name, Material material) 
	{
		super(name, material);

		setSoundType(SoundType.SLIME);
		setHardness(1.5f);
		setResistance(12.5f);
		setHarvestLevel("sword", 0);
		//setLightOpacity(1);
		//setBlockUnbreakable();
		//setLightLevel(0.0f);
		
	
		
		
	}

}
