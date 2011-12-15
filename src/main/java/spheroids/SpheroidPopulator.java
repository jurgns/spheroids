package spheroids;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.util.BlockVector;
import org.bukkit.util.Vector;


public class SpheroidPopulator extends BlockPopulator {
	private static final int SPHERE_CHANCE = 10;
	private static final int SPHERE_FACTOR = 100;

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		if (random.nextInt(SPHERE_FACTOR) <= SPHERE_CHANCE) {
			int centerX = (chunk.getX() << 4) + random.nextInt(16);
            int centerZ = (chunk.getZ() << 4) + random.nextInt(16);
            int centerY = random.nextInt(100) + 20;
            Vector center = new BlockVector(centerX, centerY, centerZ);
            int radius = 10;
            if (random.nextBoolean()) {
    			new Sphere(world, center, radius).draw();
            } else {
            	new Cube(world, center, radius).draw();
            }
		}
	}

}
