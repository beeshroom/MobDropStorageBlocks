package com.beeshroom.SecondMod.entity.render;


@SideOnly(Side.CLIENT)
public class RenderBrownMooshroom extends Render<EntityCow>
{
    public RenderBrownMooshroom(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 0.5F;
    }

}