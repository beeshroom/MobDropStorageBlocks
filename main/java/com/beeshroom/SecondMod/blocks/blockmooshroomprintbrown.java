package com.beeshroom.SecondMod.blocks;

import java.util.List;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class blockmooshroomprintbrown extends BlockBase
{

	public blockmooshroomprintbrown (String name, Material material) 
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
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add("#CoryYes");
    }

}
