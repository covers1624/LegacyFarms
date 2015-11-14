package covers1624.legacyfarms.event;

import net.minecraft.world.World;
import net.minecraftforge.event.world.WorldEvent;

import java.util.Random;

/**
 * Created by covers1624 on 11/5/2015.
 * Carbon copy of SaplingGrowEvent, used because lazy..
 */
public class PhantomSaplingGrowEvent extends WorldEvent {

	public final int x;
	public final int y;
	public final int z;
	public final Random rand;

	public PhantomSaplingGrowEvent(World world, Random rand, int x, int y, int z) {
		super(world);
		this.rand = rand;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
