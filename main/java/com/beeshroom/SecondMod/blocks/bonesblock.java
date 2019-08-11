package com.beeshroom.SecondMod.blocks;

import com.beeshroom.SecondMod.client.renderer.entity.EntityCarpet;
import com.beeshroom.SecondMod.init.ModItems;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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



public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
{
    ItemStack itemstack = playerIn.getHeldItem(hand);

    //if (!itemstack.isEmpty() && itemstack.getItem() == Items.BONE)

    if (!itemstack.isEmpty() && (itemstack.getItem() == Items.BONE || itemstack.getItem() == ModItems.SKELETON_ARM))

{
    	if (!worldIn.isRemote) {
    		  worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_SKELETON_STEP, SoundCategory.BLOCKS, 0.8F, 1.0F);    
    	}
        return true;
    } 
    else 
    {
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }
    
}



public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
{
    super.onBlockClicked(worldIn, pos, playerIn);
     worldIn.playSound((EntityPlayer)null, pos, SoundEvents.ENTITY_SKELETON_AMBIENT, SoundCategory.BLOCKS, 1.0F, 1.0F);

}

/*

public boolean onBlockClicked(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
{
    ItemStack itemstack = playerIn.getHeldItem(hand);

    //if (!itemstack.isEmpty() && itemstack.getItem() == Items.BONE)

    if (!itemstack.isEmpty() && (itemstack.getItem() == Items.BONE || itemstack.getItem() == ModItems.SKELETON_ARM))

{
    	if (!worldIn.isRemote) {
    		  worldIn.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_SKELETON_AMBIENT, SoundCategory.BLOCKS, 1.0F, 1.0F);    
    	}
        return true;
    } 
    else 
    {
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }
}  */
    
}
