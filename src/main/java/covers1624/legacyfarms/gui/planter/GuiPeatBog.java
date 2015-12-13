package covers1624.legacyfarms.gui.planter;

import covers1624.legacyfarms.container.ContainerPeatBog;
import covers1624.legacyfarms.reference.Reference;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.legacyfarms.utils.PlanterUtils;
import forestry.core.gui.GuiForestry;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by covers1624 on 12/5/2015.
 */
public class GuiPeatBog extends GuiForestry<ContainerPeatBog, TilePlanter> {

	public GuiPeatBog(InventoryPlayer player, TilePlanter planter) {
		super(new ResourceLocation(Reference.GUI_FOLDER + PlanterUtils.getNameFromMeta(6) + ".png"), new ContainerPeatBog(player, planter), planter);
	}
}
