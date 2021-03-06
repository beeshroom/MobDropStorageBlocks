package com.beeshroom.SecondMod.blocks;

import java.util.List;

import com.beeshroom.SecondMod.Main;
import com.beeshroom.SecondMod.client.renderer.entity.EntityCarpet;
//import com.beeshroom.SecondMod.client.renderer.entity.EntityCarpet;
import com.beeshroom.SecondMod.client.renderer.entity.EntityCreeperPrint;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCarpet;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class carpetcreeperprint extends BlockBase
{
	
	protected static final AxisAlignedBB CARPET_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);

    public carpetcreeperprint (String name, Material material) 
	{
		super(name, material);
        //super(Material.CARPET);
		setSoundType(SoundType.PLANT);
		setHardness(0.1f);
		setResistance(0.5f);
		setHarvestLevel("shears", 0);
        //this.setTickRandomly(true);
        this.setCreativeTab(Main.mobdropstab);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return CARPET_AABB;
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    /**
     * Checks if this block can be placed exactly at the given position.
     */
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return super.canPlaceBlockAt(worldIn, pos) && this.canBlockStay(worldIn, pos);
    }

    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */
   
    
    // I CUT THIS OUT BC THE TNT NEEDS REDSTONE STUFF SO UH. HOPE IT WORKS???
    
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

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        if (side == EnumFacing.UP)
        {
            return true;
        }
        else
        {
            return blockAccess.getBlockState(pos.offset(side)).getBlock() == this ? true : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
        }
    }

  /**
     * Get the geometry of the queried face at the given position and state. This is used to decide whether things like
     * buttons are allowed to be placed on the face, or how glass panes connect to the face, among other things.
     * <p>
     * Common values are {@code SOLID}, which is the default, and {@code UNDEFINED}, which represents something that
     * does not fit the other descriptions and will generally cause other things not to connect to the face.
     * 
     * @return an approximation of the form of the given face
     */
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return face == EnumFacing.DOWN ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
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
    
    
    
    
    
    
    //EXPLOSIVE STUFF
    //
    //
    //
    

    
    
    /**
     * Called when the block is right clicked by a player.
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = playerIn.getHeldItem(hand);

        if (!itemstack.isEmpty() && itemstack.getItem() == Items.FLINT_AND_STEEL) {
        	if (!worldIn.isRemote) {
                EntityCarpet entitycarpet = new EntityCarpet(worldIn, (double)((float)pos.getX() + 0.5F), (double)pos.getY(), (double)((float)pos.getZ() + 0.5F), playerIn);
                worldIn.spawnEntity(entitycarpet);
                worldIn.playSound(null, entitycarpet.posX, entitycarpet.posY, entitycarpet.posZ, SoundEvents.ENTITY_CREEPER_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
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