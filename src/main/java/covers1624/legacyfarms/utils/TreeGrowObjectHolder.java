package covers1624.legacyfarms.utils;

public class TreeGrowObjectHolder {

	private BlockPosition pos;
	private int dimId;
	private int timeout;
	private int aliveTicks;

	public TreeGrowObjectHolder(BlockPosition saplingPos, int dimId, int timeout) {
		pos = saplingPos.copy();
		this.dimId = dimId;
		this.timeout = timeout;
	}

	public boolean shouldChangeBlock() {
		return timeout > aliveTicks;
	}

	public void tick() {
		aliveTicks++;
	}

	public int getDimId() {
		return dimId;
	}

	public BlockPosition getBlockPosition() {
		return pos;
	}

}
