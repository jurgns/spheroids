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
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    Vector position = center.clone().add(new Vector(x, y, z));
                    world.getBlockAt(position.toLocation(world)).setType(Material.DIRT);
                }
            }
        }
	}

}
