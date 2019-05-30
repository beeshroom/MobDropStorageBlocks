package com.beeshroom.SecondMod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class blockmooshroomprint extends BlockBase
{

	public blockmooshroomprint (String name, Material material) 
	{
		super(name, material);

		setSoundType(SoundType.CLOTH);
		setHardness(1.5f);
		setResistance(13.0f);
		setHarvestLevel("axe", 0);
		//setLightOpacity(1);
		//setBlockUnbreakable();
		//setLightLevel(0.0f);
		
	
		
		
	}

}
