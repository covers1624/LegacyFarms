package covers1624.legacyfarms.gui.planter;

import covers1624.legacyfarms.container.ContainerFarm;
import covers1624.legacyfarms.reference.Reference;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.legacyfarms.utils.PlanterUtils;
import forestry.core.gui.GuiForestry;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by covers1624 on 12/14/2015.
 */
public class GuiFarm extends GuiForestry<ContainerFarm, TilePlanter> {
	public GuiFarm(InventoryPlayer inventoryPlayer, TilePlanter arboretum) {
		super(new ResourceLocation(Reference.GUI_FOLDER + PlanterUtils.getNameFromMeta(1) + ".png"), new ContainerFarm(inventoryPlayer, arboretum), arboretum);
	}
}
