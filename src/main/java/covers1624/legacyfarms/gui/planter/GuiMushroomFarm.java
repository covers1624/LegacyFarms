package covers1624.legacyfarms.gui.planter;

import covers1624.legacyfarms.container.ContainerArboretum;
import covers1624.legacyfarms.container.ContainerMushroomFarm;
import covers1624.legacyfarms.reference.Reference;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.legacyfarms.utils.PlanterUtils;
import forestry.core.gui.GuiForestry;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiMushroomFarm extends GuiForestry<ContainerMushroomFarm, TilePlanter> {

	public GuiMushroomFarm(InventoryPlayer inventoryPlayer, TilePlanter arboretum) {
		super(new ResourceLocation(Reference.GUI_FOLDER + PlanterUtils.getNameFromMeta(5) + ".png"), new ContainerMushroomFarm(inventoryPlayer, arboretum), arboretum);
	}
}
