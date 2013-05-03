package skydimension;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockDragonEgg;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class RenderCloud extends Render {
	private RenderBlocks renderBlocks = new RenderBlocks();

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
		this.doRenderCloud((EntityCloud) entity, d0, d1, d2, f, f1);
	}

	private void doRenderCloud(EntityCloud entity, double par2, double par4, double par6, float par8, float par9) {
		World world = entity.getWorld();
		Block block = Block.blocksList[entity.blockID];

		if (world.getBlockId(MathHelper.floor_double(entity.posX), MathHelper.floor_double(entity.posY), MathHelper.floor_double(entity.posZ)) != entity.blockID) {
			GL11.glPushMatrix();
			GL11.glTranslatef((float) par2, (float) par4, (float) par6);
			this.loadTexture("/terrain.png");
			GL11.glDisable(GL11.GL_LIGHTING);
			Tessellator tessellator;
			if (block != null) {
				this.renderBlocks.setRenderBoundsFromBlock(block);
				this.renderBlocks.renderBlockSandFalling(block, world, MathHelper.floor_double(entity.posX), MathHelper.floor_double(entity.posY), MathHelper.floor_double(entity.posZ), entity.metadata);
			}

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		}
	}

}
