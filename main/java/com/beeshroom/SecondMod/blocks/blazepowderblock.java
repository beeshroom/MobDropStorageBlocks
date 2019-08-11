package com.beeshroom.SecondMod.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
	
	 
	 /*
	  public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	    {
		  
		  if (entityIn instanceof EntityLivingBase)
	       
	        {
	            worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)((float)pos.getX() + ), (double)((float)pos.getY() + 1.1F), (double)((float)pos.getZ()), 0.0D, 0.0D, 0.0D);
	        }
	    } */
	
	
	    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	    {
	    	 super.onEntityWalk(worldIn, pos, entityIn);
	    	  this.spawnParticles(worldIn, pos);
	    }
	    
	    
	    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
	    {
	    	super.onBlockClicked(worldIn, pos, playerIn);
	    	 // this.spawnParticles(worldIn, pos);
	    	Random rand = new Random(); 
	    	 
		            worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)((float)pos.getX() + rand.nextFloat()), (double)((float)pos.getY() + 1.1F), (double)((float)pos.getZ() + rand.nextFloat()), 0.0D, 0.0D, 0.0D);
		     
	    }
	    
	    
	    
	    private void spawnParticles(World worldIn, BlockPos pos)
	    {
	        Random random = worldIn.rand;
	        
	        if (random.nextInt(20) == 0)
	        {
	            worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)((float)pos.getX() + random.nextFloat()), (double)((float)pos.getY() + 1.1F), (double)((float)pos.getZ() + random.nextFloat()), 0.0D, 0.0D, 0.0D);
	        }
	    }
	
	
	

	
	
	
	

}
