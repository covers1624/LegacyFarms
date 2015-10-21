package covers1624.legacyfarms.handler;

import covers1624.legacyfarms.LegacyFarms;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class CropHandler {

	public static ArrayList<ItemStack> registeredLeaves = new ArrayList<ItemStack>();
	public static ArrayList<ItemStack> registeredLogs = new ArrayList<ItemStack>();
	public static ArrayList<ItemStack> blueprintWhitelistedBlocks = new ArrayList<ItemStack>();
	public static ArrayList<ItemStack> blueprintBlacklistedBlocks = new ArrayList<ItemStack>();

	public static void init() {
		ArrayList<ItemStack> leaves = OreDictionary.getOres("treeLeaves");
		for (ItemStack stack : leaves) {
			registerLeaves(stack);
		}
		ArrayList<ItemStack> logs = OreDictionary.getOres("logWood");
		for (ItemStack stack : logs) {
			registerLog(stack);
		}
		blueprintWhitelistedBlocks.add(new ItemStack(Blocks.redstone_torch));
	}

	//REGISTER
	public static void registerLeaves(ItemStack itemStack) {
		if (registeredLeaves.contains(itemStack)) {
			LegacyFarms.logger.warn("Leaves allready registered, will not register stack. Name: %s", itemStack.getDisplayName());
			return;
		}
		LegacyFarms.logger.info("Adding leaves: " + itemStack.getDisplayName());
		registeredLeaves.add(itemStack);
	}

	public static void registerLog(ItemStack itemStack) {
		if (registeredLogs.contains(itemStack)) {
			LegacyFarms.logger.warn("Logs allready registered, will not register stack. Name: %s", itemStack.getDisplayName());
			return;
		}
		LegacyFarms.logger.info("Adding log: " + itemStack.getDisplayName());
		registeredLogs.add(itemStack);
	}

	//GET
	public static boolean containsLogOrLeaf(ItemStack stack) {
		for (ItemStack itemStack : registeredLeaves) {
			if (itemStack.getItem() == stack.getItem()) {
				if (itemStack.getItemDamage() == OreDictionary.WILDCARD_VALUE) {
					return true;
				}
				if (itemStack.getItemDamage() == stack.getItemDamage()) {
					return true;
				}
			}
		}
		for (ItemStack itemStack : registeredLogs) {
			if (itemStack.getItem() == stack.getItem()) {
				if (itemStack.getItemDamage() == OreDictionary.WILDCARD_VALUE) {
					return true;
				}
				if (itemStack.getItemDamage() == stack.getItemDamage()) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean containsLog(ItemStack stack) {
		for (ItemStack itemStack : registeredLogs) {
			if (itemStack.getItem() == stack.getItem()) {
				if (itemStack.getItemDamage() == OreDictionary.WILDCARD_VALUE) {
					return true;
				}
				if (itemStack.getItemDamage() == stack.getItemDamage()) {
					return true;
				}
			}
		}
		return false;
	}
}
