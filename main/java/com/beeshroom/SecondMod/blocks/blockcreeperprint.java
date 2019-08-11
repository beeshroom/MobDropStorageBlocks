package com.beeshroom.SecondMod.blocks;

import java.util.List;

import com.beeshroom.SecondMod.Main;
import com.beeshroom.SecondMod.client.renderer.entity.EntityCarpet;
import com.beeshroom.SecondMod.client.renderer.entity.EntityCreeperPrint;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class blockcreeperprint extends BlockBase
{
	//copying the tnt code v
	//public static final PropertyBool EXPLODE = PropertyBool.create("explode");
	
	public blockcreeperprint (String name, Material material) 
	{
		super(name, material);

		setSoundType(SoundType.PLANT);
		setHardness(1.0f);
		setResistance(9.9f);
		setHarvestLevel("shears", 0);
		//setLightOpacity(1);
		//setBlockUnbreakable();
		//setLightLevel(0.0f);
		
		
	}
	
	// (can it burn?) 
	@Override
	public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
		return super.canEntityDestroy(state, world, pos, entity);
	}
	
	@Override

    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)

    {

        return 9;

    }


    @Override

    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)

    {

        return 5;

    } 
    
    
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add("explodes with flint and steel");
    }

	  
	
	/**
     * Called when the block is right clicked by a player.
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = playerIn.getHeldItem(hand);

        if (!itemstack.isEmpty() && itemstack.getItem() == Items.FLINT_AND_STEEL) {
        	if (!worldIn.isRemote) {
                EntityCreeperPrint entitycreeperprint = new EntityCreeperPrint(worldIn, (double)((float)pos.getX() + 0.5F), (double)pos.getY(), (double)((float)pos.getZ() + 0.5F), playerIn);
                worldIn.spawnEntity(entitycreeperprint);
                worldIn.playSound(null, entitycreeperprint.posX, entitycreeperprint.posY, entitycreeperprint.posZ, SoundEvents.ENTITY_CREEPER_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
             worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
            itemstack.damageItem(1, playerIn);
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
         worldIn.playSound((EntityPlayer)null, pos, SoundEvents.ENTITY_CREEPER_HURT, SoundCategory.BLOCKS, 0.1F, 1.3F);

    }

}
