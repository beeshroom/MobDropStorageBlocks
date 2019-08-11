package com.beeshroom.SecondMod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class blockfeather extends BlockBase
{

	public blockfeather (String name, Material material) 
	{
		super(name, material);

		setSoundType(SoundType.CLOTH);
		setHardness(0.4f);
		setResistance(0.5f);
		setHarvestLevel("shears", 0);
		setLightOpacity(3);
		//setBlockUnbreakable();
		//setLightLevel(0.0f);
		}
	
	   public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance)
	    {
	        entityIn.fall(fallDistance, 0.2F);
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
	   
}
