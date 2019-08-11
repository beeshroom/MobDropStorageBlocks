package com.beeshroom.SecondMod.init;

import java.util.ArrayList;
import java.util.List;

import com.beeshroom.SecondMod.Main;
import com.beeshroom.SecondMod.blocks.blazepowderblock;
import com.beeshroom.SecondMod.blocks.blazerodbundle;
import com.beeshroom.SecondMod.blocks.block_ink_sac;
import com.beeshroom.SecondMod.blocks.blockcowprint;
import com.beeshroom.SecondMod.blocks.blockcreeperprint;

import com.beeshroom.SecondMod.blocks.blockfeather;
import com.beeshroom.SecondMod.blocks.blockleather;
import com.beeshroom.SecondMod.blocks.blockmooshroomprint;
import com.beeshroom.SecondMod.blocks.blockmooshroomprintbrown;
import com.beeshroom.SecondMod.blocks.bonesblock;
import com.beeshroom.SecondMod.blocks.carpetbrownmooshroomprint;
import com.beeshroom.SecondMod.blocks.carpetcowprint;
import com.beeshroom.SecondMod.blocks.carpetcreeperprint;
import com.beeshroom.SecondMod.blocks.carpetmooshroomprint;
import com.beeshroom.SecondMod.blocks.eggcrate;
//import com.beeshroom.SecondMod.blocks.carpetcreeperprint;
import com.beeshroom.SecondMod.blocks.gunpowderblock;
import com.beeshroom.SecondMod.blocks.leathermat;
import com.beeshroom.SecondMod.blocks.rottenfleshblock;
import com.beeshroom.SecondMod.blocks.spidereyeblock;
import com.beeshroom.SecondMod.blocks.stickbundle;
import com.beeshroom.SecondMod.blocks.stickmat;
import com.beeshroom.SecondMod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

public class ModBlocks 
{

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ROTTENFLESHBLOCK = new rottenfleshblock("rottenfleshblock", Material.CLOTH);
	public static final Block BONESBLOCK = new bonesblock("bonesblock", Material.GOURD);
	public static final Block SPIDEREYEBLOCK = new spidereyeblock("spidereyeblock", Material.CLOTH);
	public static final Block GUNPOWDERBLOCK = new gunpowderblock("gunpowderblock", Material.SAND);
	public static final Block BLAZERODBUNDLE= new blazerodbundle("blazerodbundle", Material.WOOD);
	public static final Block BLAZEPOWDERBLOCK = new blazepowderblock("blazepowderblock", Material.CLAY);
	public static final Block INKSACBLOCK = new block_ink_sac("block_ink_sac", Material.CLOTH);
	public static final Block BLOCKLEATHER = new blockleather("blockleather", Material.CLOTH);
	public static final Block BLOCKFEATHER = new blockfeather("blockfeather", Material.CLOTH);;
	public static final Block STICKBUNDLE= new stickbundle("stickbundle", Material.WOOD);
	public static final Block BLOCKCREEPERPRINT = new blockcreeperprint("blockcreeperprint", Material.CLOTH);
	public static final Block BLOCKCOWPRINT = new blockcowprint("blockcowprint", Material.CLOTH);
	public static final Block BLOCKMOOSHROOMPRINT = new blockmooshroomprint("blockmooshroomprint", Material.CLOTH);
	public static final Block BLOCKMOOSHROOMPRINTBROWN = new blockmooshroomprintbrown("blockmooshroomprintbrown", Material.CLOTH);
	public static final Block EGGCRATE = new eggcrate("eggcrate", Material.CARPET);

	
	public static final Block CARPETCREEPERPRINT = new carpetcreeperprint("carpetcreeperprint", Material.CARPET);
	public static final Block CARPETCOWPRINT = new carpetcowprint("carpetcowprint", Material.CARPET);
	public static final Block CARPETMOOSHROOMPRINT = new carpetmooshroomprint("carpetmooshroomprint", Material.CARPET);
	public static final Block CARPETBROWNMOOSHROOMPRINT = new carpetbrownmooshroomprint("carpetbrownmooshroomprint", Material.CARPET);
	public static final Block LEATHERMAT = new leathermat("leathermat", Material.CARPET);
	public static final Block STICKMAT = new stickmat("stickmat", Material.CARPET);

	
	
	
}
	
	