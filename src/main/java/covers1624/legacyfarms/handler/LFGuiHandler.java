package covers1624.legacyfarms.handler;

import covers1624.legacyfarms.container.*;
import covers1624.legacyfarms.gui.planter.*;
import covers1624.legacyfarms.tile.planter.TilePlanter;
import covers1624.legacyfarms.utils.GuiId;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class LFGuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (id > GuiId.values().length) {
			return null;
		}
		switch (GuiId.values()[id]) {
		case ArboretumGUI:
			return new ContainerArboretum(player.inventory, getTilePlanter(world, x, y, z));
		case FarmGUI:
			return new ContainerFarm(player.inventory, getTilePlanter(world, x, y, z));
		case MushroomFarmGUI:
			return new ContainerMushroomFarm(player.inventory, getTilePlanter(world, x, y, z));
		case NetherFarmGUI:
			return new ContainerNetherFarm(player.inventory, getTilePlanter(world, x, y, z));
		case PeatBogGUI:
			return new ContainerPeatBog(player.inventory, getTilePlanter(world, x, y, z));
		case PumpkinFarmGUI:
			return new ContainerPumpkinFarm(player.inventory, getTilePlanter(world, x, y, z));
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		if (id > GuiId.values().length) {
			return null;
		}
		switch (GuiId.values()[id]) {
		case ArboretumGUI:
			return new GuiArboretum(player.inventory, getTilePlanter(world, x, y, z));
		case FarmGUI:
			return new GuiFarm(player.inventory, getTilePlanter(world, x, y, z));
		case MushroomFarmGUI:
			return new GuiMushroomFarm(player.inventory, getTilePlanter(world, x, y, z));
		case NetherFarmGUI:
			return new GuiNetherFarm(player.inventory, getTilePlanter(world, x, y, z));
		case PeatBogGUI:
			return new GuiPeatBog(player.inventory, getTilePlanter(world, x, y, z));
		case PumpkinFarmGUI:
			return new GuiPumpkinFarm(player.inventory, getTilePlanter(world, x, y, z));
		default:
			return null;
		}
	}

	public TilePlanter getTilePlanter(World world, int x, int y, int z) {
		return (TilePlanter) world.getTileEntity(x, y, z);
	}

}
