package com.beeshroom.SecondMod.blocks;

import java.util.List;
import java.util.Random;

import com.beeshroom.SecondMod.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class eggcrate extends BlockBase
{
	
	
	public static final AxisAlignedBB EGGCRATE = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.37D, 0.9375D);
//0.03125D, 0.0D, 0.03125D, 0.96875D, 1.66666D, 0.96875D
	public eggcrate (String name, Material material) 
	{
		super(name, material);

		setSoundType(SoundType.PLANT);
		setHardness(0.5f);
		setResistance(3.0f);
		//setHarvestLevel("axe", 0);
		//setLightOpacity(1);
		//setBlockUnbreakable();
		//setLightLevel(0.0f);
	}
	
	@Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) 
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add("egg storage block");
    }
	
	/*@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) 
	{
		return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) 
	{
		if(!this.canBlockStay(worldIn, pos))
		{
			worldIn.setBlockToAir(pos);
			InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModBlocks.EGGCRATE));
		}
	}*/
	
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return super.canPlaceBlockAt(worldIn, pos) && this.canBlockStay(worldIn, pos);
    }
	
	  public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	    {
	        this.checkForDrop(worldIn, pos, state);
	    }

	    private boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
	    {
	        if (!this.canBlockStay(worldIn, pos))
	        {
	            this.dropBlockAsItem(worldIn, pos, state, 0);
	            worldIn.setBlockToAir(pos);
	            return false;
	        }
	        else
	        {
	            return true;
	        }
	    }
	    
	    private boolean canBlockStay(World worldIn, BlockPos pos)
	    {
	        return !worldIn.isAirBlock(pos.down());
	    }
	    
	
	
	
	
	@Override
	public BlockRenderLayer getBlockLayer() 
	{
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}

	   public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return Items.EGG;
	    }

	    /**
	     * Returns the quantity of items to drop on block destruction.
	     */
	    public int quantityDropped(Random random)
	    {
	        return 9;
	    }
	    
		@Override
		public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)  
		{
			   return EGGCRATE;
	           
	        }

		
		@Override
		public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
			return super.canEntityDestroy(state, world, pos, entity);
		}


	/*	@Override
		public void registerModels() {
			Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		}*/
		
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
		
		
	    public EnumPushReaction getMobilityFlag(IBlockState state)
	    {
	        return EnumPushReaction.DESTROY;
	    }			
}

