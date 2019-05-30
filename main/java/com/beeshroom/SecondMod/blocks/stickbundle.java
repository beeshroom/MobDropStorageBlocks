package com.beeshroom.SecondMod.blocks;

import com.beeshroom.SecondMod.Main;
import com.beeshroom.SecondMod.init.ModBlocks;
import com.beeshroom.SecondMod.init.ModItems;
import com.beeshroom.SecondMod.util.IHasModel;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

//The facing code here is 100% credited to SmellyModder, creator of The Lost Sea mod. Without him I wouldn't have had
//any idea how to accomplish something like this. Through a mutual collaboration in which I provide some texture assets 
//to The Lost Sea, I've been granted permission to use this code.


public class stickbundle extends BlockRotatedPillar implements IHasModel{

	public stickbundle(String name, Material material) {
	
		super(material);
		setSoundType(SoundType.WOOD);
		setHardness(0.1f);
		setResistance(6.9f);
		setHarvestLevel("axe", 0);
		//setLightOpacity(1);
		//setBlockUnbreakable();
		//setLightLevel(0.0f);
		
		setRegistryName(name);
		setUnlocalizedName(name);
		
		//setCreativeTab(Main.oatmealtab);
		
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		 this.setDefaultState(this.getDefaultState().withProperty(AXIS, EnumFacing.Axis.Y));
	}

	
	@Override
	public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
		return super.canEntityDestroy(state, world, pos, entity);
	}


	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
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
}