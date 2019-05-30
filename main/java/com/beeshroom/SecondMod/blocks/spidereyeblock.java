package com.beeshroom.SecondMod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class spidereyeblock extends BlockBase
{

	public spidereyeblock (String name, Material material) 
	{
		super(name, material);

		setSoundType(SoundType.SLIME);
		setHardness(1.0f);
		setResistance(10.5f);
		setHarvestLevel("shovel", 0);
		//setLightOpacity(1);
		//setBlockUnbreakable();
		//setLightLevel(0.0f);
		
	
		
		
	}

}
