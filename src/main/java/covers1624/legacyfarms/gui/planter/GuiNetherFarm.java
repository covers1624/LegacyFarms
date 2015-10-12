package covers1624.legacyfarms.gui.planter;

import covers1624.legacyfarms.block.BlockPlanter;
import covers1624.legacyfarms.container.ContainerNetherFarm;
import covers1624.legacyfarms.reference.Reference;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.legacyfarms.utils.PlanterUtils;
import forestry.core.gui.GuiForestry;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiNetherFarm extends GuiForestry<ContainerNetherFarm, TilePlanter> {

	public GuiNetherFarm(InventoryPlayer inventoryPlayer, TilePlanter arboretum) {
		super(new ResourceLocation(Reference.GUI_FOLDER + PlanterUtils.getNameFromMeta(6) + ".png"), new ContainerNetherFarm(inventoryPlayer, arboretum), arboretum);
	}

}
