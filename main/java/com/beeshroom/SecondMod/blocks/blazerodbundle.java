package com.beeshroom.SecondMod.blocks;

import java.util.Random;

import com.beeshroom.SecondMod.Main;
import com.beeshroom.SecondMod.init.ModBlocks;
import com.beeshroom.SecondMod.init.ModItems;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


//The facing code here is 100% credited to SmellyModder, creator of The Lost Sea mod. Without him I wouldn't have had
//any idea how to accomplish something like this. Through a mutual collaboration in which I provide some texture assets 
//to The Lost Sea, I've been granted permission to use this code.


public class blazerodbundle extends BlockRotatedPillar {

	public blazerodbundle(String name, Material material) {
	
		super(material);

		setSoundType(SoundType.STONE);
		setHardness(1.5f);
		setResistance(16.5f);
		setHarvestLevel("pickaxe", 0);
		//setLightOpacity(1);
		//setBlockUnbreakable();
		setLightLevel(3.0f);
		
		
		setRegistryName(name);
		setUnlocalizedName(name);
		
		setCreativeTab(Main.mobdropstab);
		
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		 this.setDefaultState(this.getDefaultState().withProperty(AXIS, EnumFacing.Axis.Y));
	}

	/*
	 @SideOnly(Side.CLIENT)
	    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	    {
	        super.randomDisplayTick(stateIn, worldIn, pos, rand);

	        if (rand.nextInt(10) == 0)
	        {
	            worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)((float)pos.getX() + rand.nextFloat()), (double)((float)pos.getY() + 1.1F), (double)((float)pos.getZ() + rand.nextFloat()), 0.0D, 0.0D, 0.0D);
	        }
	    }*/
	
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

	
	

/*
	public void onEntityWalk(World worldIn, IBlockState stateIn, BlockPos pos, Entity entityIn, Random rand)
    {
        if (entityIn instanceof EntityLivingBase)
        	 { Random rand1 = new Random(); 
        	super.randomDisplayTick(stateIn, worldIn, pos, rand);

            if (rand1.nextInt(10) == 0)
            {
                worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)((float)pos.getX() + rand1.nextFloat()), (double)((float)pos.getY() + 1.1F), (double)((float)pos.getZ() + rand1.nextFloat()), 0.0D, 0.0D, 0.0D);
            }
        }
    }*/
	

/*	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}*/
}