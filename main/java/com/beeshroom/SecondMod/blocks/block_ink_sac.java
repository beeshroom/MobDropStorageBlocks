package com.beeshroom.SecondMod.blocks;

import java.awt.List;
import java.util.Random;

import com.beeshroom.SecondMod.init.ModBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class block_ink_sac extends BlockBase
{

	public block_ink_sac (String name, Material material) 
	{
		super(name, material);
		this.slipperiness = 0.85F;
		setSoundType(SoundType.SLIME);
		setHardness(1.0f);
		setResistance(4.5f);
		setHarvestLevel("shovel", 0);
		//setLightOpacity(1);
		//setBlockUnbreakable();
		//setLightLevel(0.0f);
		
	
		
		
	}
	
	
	
	/* public void onBlockClicked(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn) {
		  if (playerIn instanceof EntityLivingBase)
	        {
			 // worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, pos.getX(), pos.getY(), pos.getZ(), 0.0D, 0.0D, 0.0D); 
			  ((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 80, 0));
	            worldIn.playSound((EntityPlayer)null, pos, SoundEvents.ENTITY_SQUID_HURT, SoundCategory.BLOCKS, 0.1F, 1.3F);
	            this.spawnParticles(worldIn, pos);  
	          //  this.activate(worldIn, pos);
	           
	            
	        }	
			
		} */
	 
	 public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
	    {
	        this.activate(worldIn, pos);
	        super.onBlockClicked(worldIn, pos, playerIn);
	        ((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 80, 0));
	         worldIn.playSound((EntityPlayer)null, pos, SoundEvents.ENTITY_SQUID_HURT, SoundCategory.BLOCKS, 0.1F, 1.3F);
	    }
	
	    private void activate(World worldIn, BlockPos pos)
	    {
	        this.spawnParticles(worldIn, pos);
	    }

	 
	/* public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	    {
		 
		// ((EntityLivingBase) playerIn).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 80, 0));
         //worldIn.playSound((EntityPlayer)null, pos, SoundEvents.ENTITY_SQUID_HURT, SoundCategory.BLOCKS, 0.1F, 1.3F);
         
	        this.activate(worldIn, pos);
	        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	    } */

	  public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	    {
	        if (entityIn instanceof EntityLivingBase)
	        {
	   //     worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, pos.getX(), pos.getY(), pos.getZ(), 0.0D, 0.0D, 0.0D);
	        	//	worldIn.playSound((EntityPlayer)null, pos, SoundEvents.ENTITY_SQUID_HURT, SoundCategory.BLOCKS, 0.3F, 1.0F);
	        	((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 50, 0));
	        //	  this.spawnParticles(worldIn, pos);
	        	   this.activate(worldIn, pos);
	               super.onEntityWalk(worldIn, pos, entityIn);
	            
	        }
	        
		
	    }
	  
	  
	  
	  
	  
	/*    private void activate(World worldIn, BlockPos pos)
	    {
	        this.spawnParticles(worldIn, pos);
	    }*/
	    
	    
	    private void spawnParticles(World worldIn, BlockPos pos)
	    {
	        Random random = worldIn.rand;
	        double d0 = 0.0625D;

	        for (int i = 0; i < 6; ++i)
	        {
	            double d1 = ((float)pos.getX() + random.nextFloat());
	            double d2 = ((float)pos.getY() + random.nextFloat());
	            double d3 = ((float)pos.getZ() + random.nextFloat());

	            if (i == 0 && !worldIn.getBlockState(pos.up()).isOpaqueCube())
	            {
	                d2 = pos.getY() + 0.0625D + 1.0D;
	            }

	            if (i == 1 && !worldIn.getBlockState(pos.down()).isOpaqueCube())
	            {
	                d2 = pos.getY() - 0.0625D;
	            }

	            if (i == 2 && !worldIn.getBlockState(pos.south()).isOpaqueCube())
	            {
	                d3 = pos.getZ() + 0.0625D + 1.0D;
	            }

	            if (i == 3 && !worldIn.getBlockState(pos.north()).isOpaqueCube())
	            {
	                d3 = pos.getZ() - 0.0625D;
	            }

	            if (i == 4 && !worldIn.getBlockState(pos.east()).isOpaqueCube())
	            {
	                d1 = pos.getX() + 0.0625D + 1.0D;
	            }

	            if (i == 5 && !worldIn.getBlockState(pos.west()).isOpaqueCube())
	            {
	                d1 = pos.getX() - 0.0625D;
	            }

	            if (d1 < pos.getX() || d1 > (pos.getX() + 1) || d2 < 0.0D || d2 > (pos.getY() + 1) || d3 < pos.getZ() || d3 > (pos.getZ() + 1))
	            {
	                worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d1, d2, d3, 0.0D, 0.0D, 0.0D);
	            }
	        }
	    }
}

	  
	 
