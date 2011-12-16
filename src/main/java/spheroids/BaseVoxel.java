package spheroids;

import org.bukkit.util.Vector;

public abstract class BaseVoxel implements Voxel {

	private byte[] body;
	
	BaseVoxel() {
		//Spheroids.getLogger().info("X: " + getXSize() + "; Y: " + getYSize() + "; Z: " + getZSize());
		init();
	}
	
	void init() {
		body = new byte[getXSize() * getYSize() * getZSize()];
	}
	
	public byte[] getBody() {
		return body;
	}
	
	@Override
	public byte getBlock(int x, int y, int z) {
		return body[(x * getXSize() + z) * getYSize() + y];
	}
	
	@Override
	public void setBlock(int x, int y, int z, byte type) {
		body[(x * getXSize() + z) * getYSize() + y] = type;
	}
	
	@Override
	public byte getBlock(Vector p) {
		return getBlock(p.getBlockX(), p.getBlockY(), p.getBlockZ());
	}
	
	@Override
	public void setBlock(Vector p, byte type) {
		setBlock(p.getBlockX(), p.getBlockY(), p.getBlockZ(), type);
	}

	@Override
	public int getXSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getZSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void applyAtPosition(Voxel v, Vector p) {
		Vector thisOffset = p.clone();
		Vector thatOffset = new Vector(0, 0, 0);
		if (p.getBlockX() < 0) {
			thisOffset.setX(0);
			thatOffset.setX(-p.getBlockX());
		}
		if (p.getBlockY() < 0) {
			thisOffset.setY(0);
			thatOffset.setY(-p.getBlockY());
		}
		if (p.getBlockZ() < 0) {
			thisOffset.setZ(0);
			thatOffset.setZ(-p.getBlockZ());
		}
		Vector stop = thatOffset.clone().add(new Vector(v.getXSize(), v.getYSize(), v.getZSize()));
		if (thisOffset.getBlockX() + stop.getBlockX() > getXSize()) {
			//Spheroids.getLogger().info("Capping X");
			stop.setX(getXSize() - thisOffset.getBlockX());
		}
		if (thisOffset.getBlockX() + stop.getBlockY() > getYSize()) {
			//Spheroids.getLogger().info("Capping Y");
			stop.setY(getYSize() - thisOffset.getBlockY());
		}
		if (thisOffset.getBlockX() + stop.getBlockZ() > getZSize()) {
			//Spheroids.getLogger().info("Capping Z");
			stop.setZ(getZSize() - thisOffset.getBlockZ());
		}
		//Spheroids.getLogger().info("STOP: " + stop);
		for (int x = thatOffset.getBlockX(); x < stop.getBlockX(); x++) {
			for (int y = thatOffset.getBlockY(); y < stop.getBlockY(); y++) {
				for (int z = thatOffset.getBlockZ(); z < stop.getBlockZ(); z++) {
					//if (x >= v.getXSize() || y >= v.getYSize() || z >= v.getZSize()) Spheroids.getLogger().info("FAIL");
					Vector position = new Vector(x, y, z);
					setBlock(thisOffset.clone().add(position), v.getBlock(position));
				}
			}
		}
	}
}
