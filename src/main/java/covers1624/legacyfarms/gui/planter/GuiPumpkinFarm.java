package covers1624.legacyfarms.gui.planter;

import covers1624.legacyfarms.container.ContainerPumpkinFarm;
import covers1624.legacyfarms.reference.Reference;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.legacyfarms.utils.PlanterUtils;
import forestry.core.gui.GuiForestry;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by covers1624 on 12/13/2015.
 */
public class GuiPumpkinFarm extends GuiForestry<ContainerPumpkinFarm, TilePlanter> {

	public GuiPumpkinFarm(InventoryPlayer inventoryPlayer, TilePlanter planter) {
		super(new ResourceLocation(Reference.GUI_FOLDER + PlanterUtils.getNameFromMeta(3) + ".png"), new ContainerPumpkinFarm(inventoryPlayer, planter), planter);
	}
}
