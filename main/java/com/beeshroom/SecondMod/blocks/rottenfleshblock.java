package com.beeshroom.SecondMod.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class rottenfleshblock extends BlockBase
{
	 protected static final AxisAlignedBB SOUL_SAND_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.975D, 1.0D);
	
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
	
	 @Nullable
	    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	    {
	        return SOUL_SAND_AABB;
	    }

	 public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	    {
	        entityIn.motionX *= 0.7D;
	        entityIn.motionZ *= 0.7D;
	    }
	
}
