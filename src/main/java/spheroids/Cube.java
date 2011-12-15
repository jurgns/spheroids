package spheroids;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class Cube {
	private final World world;
	private final Vector center;
	private final int radius;

	Cube(World world, Vector center, int radius) {
		this.world = world;
		this.center = center;
		this.radius = radius;
	}
	
	void draw() {
        for (int a = -radius; a <= radius; a++) {
        	for (int b = -radius; b <= radius; b++) {
        		Vector[] positions = {
        				new Vector(a, b, -radius),
        				new Vector(a, b, radius),
        				new Vector(a, -radius, b),
        				new Vector(a, radius, b),
        				new Vector(-radius, a, b),
        				new Vector(radius, a, b)
        				};
        		for (Vector v : positions) {
                    world.getBlockAt(v.add(center).toLocation(world)).setType(Material.DIRT);
        		}
        	}
        }
	}
}
