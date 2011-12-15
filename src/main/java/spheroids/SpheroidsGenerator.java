package spheroids;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

public class SpheroidsGenerator extends ChunkGenerator {
	
	private Spheroids plugin;

	public SpheroidsGenerator(Spheroids spheroids) {
		plugin = spheroids;
	}

	@Override
	public byte[] generate(World world, Random seed, int chunkX, int chunkZ) {
		byte[] result = new byte[32768];

		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				for (int y = 0; y < 128; y++) {
					if (y == 0 || y == 1) {
						result[(x * 16 + z) * 128 + y] = Blocks.Bedrock;
					} else if (y > 1 && y <= 4) {
						result[(x * 16 + z) * 128 + y] = Blocks.Water;						
					} else {
						result[(x * 16 + z) * 128 + y] = Blocks.Air;
					}
				}
			}
		}
		return result;
	}
	
	@Override
	public List<BlockPopulator> getDefaultPopulators(World world) {
		return Arrays.asList((BlockPopulator) new SpheroidPopulator());
	}
}
