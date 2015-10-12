package covers1624.legacyfarms.gui.planter;

import covers1624.legacyfarms.block.BlockPlanter;
import covers1624.legacyfarms.container.ContainerArboretum;
import covers1624.legacyfarms.reference.Reference;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.legacyfarms.utils.PlanterUtils;
import forestry.core.gui.GuiForestry;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiArboretum extends GuiForestry<ContainerArboretum, TilePlanter> {

	public GuiArboretum(InventoryPlayer inventoryPlayer, TilePlanter arboretum) {
		super(new ResourceLocation(Reference.GUI_FOLDER + PlanterUtils.getNameFromMeta(0) + ".png"), new ContainerArboretum(inventoryPlayer, arboretum), arboretum);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		super.drawGuiContainerForegroundLayer(p_146979_1_, p_146979_2_);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY) {
		super.drawGuiContainerBackgroundLayer(f, mouseX, mouseY);
	}

}
