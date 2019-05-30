package com.beeshroom.SecondMod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class blazepowderblock extends BlockBase
{

	public blazepowderblock (String name, Material material) 
	{
		super(name, material);

		setSoundType(SoundType.GROUND);
		setHardness(0.4f);
		setResistance(10.5f);
		setHarvestLevel("shovel", 0);
		//setLightOpacity(1);
		//setBlockUnbreakable();
		setLightLevel(3.0f);
		
	
		
		
	}

}
