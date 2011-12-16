package spheroids;

import org.bukkit.util.Vector;

public interface Voxel {
	public byte getBlock(int x, int y, int z);
	public void setBlock(int x, int y, int z, byte type);
	public byte getBlock(Vector p);
	public void setBlock(Vector p, byte type);
	public int getXSize();
	public int getYSize();
	public int getZSize();
	public void applyAtPosition(Voxel v, Vector p);
}
