package covers1624.legacyfarms.client.render;

import covers1624.legacyfarms.tile.planter.TilePlanter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class RenderPlanter implements IBlockRenderer {
	private String gfxBase;

	private ModelRenderer base;
	private ModelRenderer ceiling;
	private ModelRenderer terrarium;
	private ModelRenderer showcase;

	public RenderPlanter() {
		ModelBase model = new ModelBase() {
		};
		base = new ModelRenderer(model, 0, 0);
		base.addBox(-8F, 4F, -8F, 16, 4, 16);
		base.rotationPointX = 8;
		base.rotationPointY = 8;
		base.rotationPointZ = 8;

		ceiling = new ModelRenderer(model, 0, 0);
		ceiling.addBox(-8F, -8F, -8F, 16, 4, 16);
		ceiling.rotationPointX = 8;
		ceiling.rotationPointY = 8;
		ceiling.rotationPointZ = 8;

		terrarium = new ModelRenderer(model, 0, 0);
		terrarium.addBox(-6F, -7F, -6F, 12, 12, 12);
		terrarium.rotationPointX = 8;
		terrarium.rotationPointY = 8;
		terrarium.rotationPointZ = 8;

		showcase = new ModelRenderer(model, 0, 0);
		showcase.addBox(-4F, -4F, -4F, 8, 8, 8);
		showcase.rotationPointX = 8;
		showcase.rotationPointY = 8;
		showcase.rotationPointZ = 8;

	}

	public RenderPlanter(String baseTexture) {
		this();
		this.gfxBase = baseTexture;
	}

	@Override
	public void inventoryRender(double x, double y, double z, float f, float f1) {
		render(ForgeDirection.UP, gfxBase, x, y, z);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f) {

		TilePlanter planter = (TilePlanter) tileentity;
		// if (planter.machine != null) {
		render(planter.getFacing(), gfxBase, d, d1, d2);
		// }
	}

	private void render(ForgeDirection orientation, String gfxBase, double x, double y, double z) {

		GL11.glPushMatrix();
		GL11.glDisable(2896 /* GL_LIGHTING */);

		GL11.glTranslatef((float) x, (float) y, (float) z);

		float[] angle = { 0, 0, 0 };
		//float[] translate = { 0, 0, 0 };

		if (orientation == null) {
			orientation = ForgeDirection.WEST;
		}

		switch (orientation) {
		case EAST:
			//translate[1] = 1;
			break;
		case WEST:
			angle[2] = (float) Math.PI;
			//translate[1] = -1;
			break;
		case UP:
			angle[2] = (float) -Math.PI / 2;
			//translate[0] = 1;
			break;
		case DOWN:
			angle[2] = (float) Math.PI / 2;
			//translate[0] = -1;
			break;
		case SOUTH:
			angle[0] = (float) Math.PI / 2;
			//translate[2] = 1;
			break;
		default:
		case NORTH:
			angle[0] = (float) -Math.PI / 2;
			//translate[2] = -1;
			break;
		}

		base.rotateAngleX = angle[0];
		base.rotateAngleY = angle[1];
		base.rotateAngleZ = angle[2];

		ceiling.rotateAngleX = angle[0];
		ceiling.rotateAngleY = angle[1];
		ceiling.rotateAngleZ = angle[2];

		terrarium.rotateAngleX = angle[0];
		terrarium.rotateAngleY = angle[1];
		terrarium.rotateAngleZ = angle[2];

		showcase.rotateAngleX = angle[0];
		showcase.rotateAngleY = angle[1];
		showcase.rotateAngleZ = angle[2];

		float factor = (float) (1.0 / 16.0);

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(gfxBase + "_base.png"));
		base.render(factor);

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(gfxBase + "_ceiling.png"));
		ceiling.render(factor);

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(gfxBase + "_terrarium.png"));
		terrarium.render(factor);

		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(gfxBase + "_showcase.png"));
		showcase.render(factor);

		GL11.glEnable(2896 /* GL_LIGHTING */);
		GL11.glPopMatrix();
	}
}