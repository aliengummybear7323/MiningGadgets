package com.direwolf20.mininggadgets.client.renderer;

import com.direwolf20.mininggadgets.common.MiningGadgets;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.rendertype.LayeringTransform;
import net.minecraft.client.renderer.rendertype.RenderSetup;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.Identifier;

public final class MyRenderType {
    private static final Identifier LASER_BEAM =
            Identifier.fromNamespaceAndPath(MiningGadgets.MOD_ID, "textures/misc/laser.png");
    private static final Identifier LASER_BEAM_2 =
            Identifier.fromNamespaceAndPath(MiningGadgets.MOD_ID, "textures/misc/laser2.png");
    private static final Identifier LASER_BEAM_GLOW =
            Identifier.fromNamespaceAndPath(MiningGadgets.MOD_ID, "textures/misc/laser_glow.png");

    private MyRenderType() {
    }

    // Closest match to your old textured translucent beam
    public static final RenderType LASER_MAIN_BEAM =
            RenderTypes.endCrystalBeam(LASER_BEAM_2);

    // Closest match to your old additive/glow pass
    public static final RenderType LASER_MAIN_ADDITIVE =
            RenderTypes.entityTranslucentEmissive(LASER_BEAM_GLOW);

    // Closest match to your old core beam with no cull / bright translucent texture
    public static final RenderType LASER_MAIN_CORE =
            RenderTypes.beaconBeam(LASER_BEAM, true);

    // Closest match to your old colored quad overlay
    public static final RenderType BLOCK_OVERLAY =
            RenderTypes.debugQuads();

    // Closest match to your old block-sheet render type
//    public static final RenderType RENDER_BLOCK =
//            RenderTypes.translucentMovingBlock();

    public static final RenderType RENDER_BLOCK = RenderType.create("MiningLaserRenderBlock",
            RenderSetup.builder(RenderPipelines.TRANSLUCENT_BLOCK)
                    .withTexture("Sampler0", TextureAtlas.LOCATION_BLOCKS)
                    .useLightmap()
                    .useOverlay()
                    .setLayeringTransform(LayeringTransform.VIEW_OFFSET_Z_LAYERING)
                    .createRenderSetup());


    //TODO
//    public static final RenderType LASER_MAIN_BEAM = RenderType.create(
//            "MiningLaserMainBeam",
//            DefaultVertexFormat.POSITION_COLOR_TEX_LIGHTMAP,
//            VertexFormat.Mode.QUADS,
//            256,
//            false,
//            false,
//            RenderType.CompositeState.builder()
//                    .setTextureState(new RenderType.TextureStateShard(LASER_BEAM_2, false, false))
//                    .setShaderState(RenderType.POSITION_COLOR_TEX_LIGHTMAP_SHADER)
//                    .setLayeringState(RenderType.VIEW_OFFSET_Z_LAYERING)
//                    .setTransparencyState(RenderType.TRANSLUCENT_TRANSPARENCY)
//                    .setDepthTestState(RenderType.LEQUAL_DEPTH_TEST)
//                    .setCullState(RenderType.CULL)
//                    .setLightmapState(RenderType.NO_LIGHTMAP)
//                    .setWriteMaskState(RenderType.COLOR_DEPTH_WRITE)
//                    .createCompositeState(false)
//    );
//
//    public static final RenderType LASER_MAIN_ADDITIVE = RenderType.create(
//            "MiningLaserAdditiveBeam",
//            DefaultVertexFormat.POSITION_COLOR_TEX_LIGHTMAP,
//            VertexFormat.Mode.QUADS,
//            256,
//            false,
//            false,
//            RenderType.CompositeState.builder()
//                    .setTextureState(new RenderType.TextureStateShard(LASER_BEAM_GLOW, false, false))
//                    .setShaderState(RenderType.POSITION_COLOR_TEX_LIGHTMAP_SHADER)
//                    .setLayeringState(RenderType.VIEW_OFFSET_Z_LAYERING)
//                    .setTransparencyState(RenderType.TRANSLUCENT_TRANSPARENCY)
//                    .setDepthTestState(RenderType.LEQUAL_DEPTH_TEST)
//                    .setCullState(RenderType.NO_CULL)
//                    .setLightmapState(RenderType.NO_LIGHTMAP)
//                    .setWriteMaskState(RenderType.COLOR_WRITE)
//                    .createCompositeState(false)
//    );
//
//    public static final RenderType LASER_MAIN_CORE = RenderType.create(
//            "MiningLaserCoreBeam",
//            DefaultVertexFormat.POSITION_COLOR_TEX_LIGHTMAP,
//            VertexFormat.Mode.QUADS,
//            256,
//            false,
//            false,
//            RenderType.CompositeState.builder()
//                    .setTextureState(new RenderType.TextureStateShard(LASER_BEAM, false, false))
//                    .setShaderState(RenderType.POSITION_COLOR_TEX_LIGHTMAP_SHADER)
//                    .setLayeringState(RenderType.VIEW_OFFSET_Z_LAYERING)
//                    .setTransparencyState(RenderType.TRANSLUCENT_TRANSPARENCY)
//                    .setDepthTestState(RenderType.NO_DEPTH_TEST)
//                    .setCullState(RenderType.NO_CULL)
//                    .setLightmapState(RenderType.NO_LIGHTMAP)
//                    .setWriteMaskState(RenderType.COLOR_WRITE)
//                    .createCompositeState(false)
//    );
//
//    public static final RenderType BLOCK_OVERLAY = RenderType.create(
//            "MiningLaserBlockOverlay",
//            DefaultVertexFormat.POSITION_COLOR,
//            VertexFormat.Mode.QUADS,
//            256,
//            false,
//            false,
//            RenderType.CompositeState.builder()
//                    .setShaderState(RenderType.POSITION_COLOR_SHADER)
//                    .setLayeringState(RenderType.VIEW_OFFSET_Z_LAYERING)
//                    .setTransparencyState(RenderType.TRANSLUCENT_TRANSPARENCY)
//                    .setTextureState(RenderType.NO_TEXTURE)
//                    .setDepthTestState(RenderType.LEQUAL_DEPTH_TEST)
//                    .setCullState(RenderType.CULL)
//                    .setLightmapState(RenderType.NO_LIGHTMAP)
//                    .setWriteMaskState(RenderType.COLOR_DEPTH_WRITE)
//                    .createCompositeState(false)
//    );
//
//    public static final RenderType RENDER_BLOCK = RenderType.create(
//            "MiningLaserRenderBlock",
//            DefaultVertexFormat.BLOCK,
//            VertexFormat.Mode.QUADS,
//            256,
//            false,
//            false,
//            RenderType.CompositeState.builder()
//                    .setShaderState(RenderType.RENDERTYPE_SOLID_SHADER)
//                    .setLightmapState(RenderType.LIGHTMAP)
//                    .setTextureState(RenderType.BLOCK_SHEET_MIPPED)
//                    .setLayeringState(RenderType.VIEW_OFFSET_Z_LAYERING)
//                    .setTransparencyState(RenderType.TRANSLUCENT_TRANSPARENCY)
//                    .setDepthTestState(RenderType.LEQUAL_DEPTH_TEST)
//                    .setCullState(RenderType.CULL)
//                    .setWriteMaskState(RenderType.COLOR_WRITE)
//                    .createCompositeState(false)
//    );
}