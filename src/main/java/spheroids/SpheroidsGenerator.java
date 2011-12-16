package spheroids;

import java.util.Random;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.Vector;

public class SpheroidsGenerator extends ChunkGenerator {
	
	private Spheroids plugin;

	public SpheroidsGenerator(Spheroids spheroids) {
		plugin = spheroids;
	}

	@Override
	public byte[] generate(World world, Random random, int chunkX, int chunkZ) {
		PrimitiveChunk result = new PrimitiveChunk();

		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				for (int y = 0; y < 128; y++) {
					if (y == 0 || y == 1) {
						result.setBlock(x, y, z, Blocks.Bedrock);
					} else if (y > 1 && y <= 4) {
						result.setBlock(x, y, z, Blocks.Water);						
					} else {
						result.setBlock(x, y, z, Blocks.Air);
					}
				}
			}
		}
		
		if (random.nextInt(100) <= 5) {
			Cube c = new Cube(random.nextInt(40) + 10);
			Vector p = new Vector(7, random.nextInt(40) + 40, 7);
			result.applyAtPosition(c, p);
		}
		
		return result.getBody();
	}
	
	//@Override
	//public List<BlockPopulator> getDefaultPopulators(World world) {
	//	return Arrays.asList((BlockPopulator) new SpheroidPopulator());
	//}
}
