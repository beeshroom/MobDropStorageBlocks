package com.beeshroom.SecondMod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class bonesblock extends BlockBase
{

	public bonesblock (String name, Material material) 
	{
		super(name, material);

		setSoundType(SoundType.STONE);
		setHardness(2.7f);
		setResistance(15.0f);
		setHarvestLevel("pickaxe", 0);
		//setLightOpacity(1);
		//setBlockUnbreakable();
		//setLightLevel(0.0f);
		
	
		
		
	}

}
