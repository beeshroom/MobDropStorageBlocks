package com.beeshroom.SecondMod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class blockeggs extends BlockBase
{

	public blockeggs (String name, Material material) 
	{
		super(name, material);

		setSoundType(SoundType.WOOD);
		setHardness(1.2f);
		setResistance(2.0f);
		//setHarvestLevel("axe", 0);
		//setLightOpacity(1);
		//setBlockUnbreakable();
		//setLightLevel(0.0f);
		
	
		
		
	}

}
