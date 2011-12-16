package spheroids;

import org.bukkit.util.Vector;

public class Cube extends BaseVoxel {
	private int size;

	Cube(int size) {
		this.size = size;
		init();
	}
	
	@Override
	public int getXSize() {
		return size;
	}
	
	@Override
	public int getYSize() {
		return size;
	}
	
	@Override
	public int getZSize() {
		return size;
	}
	
	void init() {
		super.init();
		Spheroids.getLogger().info("CUBE -> X: " + getXSize() + "; Y: " + getYSize() + "; Z: " + getZSize() + "; W: " + size);
		Spheroids.getLogger().info("body size: " + getBody().length); 
        for (int a = 0; a < size; a++) {
        	for (int b = 0; b < size; b++) {
        		Vector[] positions = {
        				new Vector(a, b, 0),
        				new Vector(a, b, size-1),
        				new Vector(a, 0, b),
        				new Vector(a, size-1, b),
        				new Vector(0, a, b),
        				new Vector(size-1, a, b)
        				};
        		for (Vector v : positions) {
                    setBlock(v, Blocks.Stone);
        		}
        	}
        }
	}
}
