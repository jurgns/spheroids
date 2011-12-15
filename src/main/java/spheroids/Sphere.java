package spheroids;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.util.Vector;


public class Sphere {
	private final World world;
	private final Vector center;
	private final int radius;

	Sphere(World world, Vector center, int radius) {
		this.world = world;
		this.center = center;
		this.radius = radius;
	}
	
	private static final double lengthSq(double x, double y, double z) {
        return (x * x) + (y * y) + (z * z);
    }
	
	private void setBlock(Vector position, Material material) {
        world.getBlockAt(position.toLocation(world)).setType(material);
	}
	
	// borrowed and adapted from WorldEdit (https://github.com/sk89q/worldedit)
	void draw() {
		final boolean filled = false;
        double radiusX = radius + 0.5;
        double radiusY = radius + 0.5;
        double radiusZ = radius + 0.5;

        final double invRadiusX = 1 / radiusX;
        final double invRadiusY = 1 / radiusY;
        final double invRadiusZ = 1 / radiusZ;

        final int ceilRadiusX = (int) Math.ceil(radiusX);
        final int ceilRadiusY = (int) Math.ceil(radiusY);
        final int ceilRadiusZ = (int) Math.ceil(radiusZ);

        double nextXn = 0;
        forX: for (int x = 0; x <= ceilRadiusX; ++x) {
            final double xn = nextXn;
            nextXn = (x + 1) * invRadiusX;
            double nextYn = 0;
            forY: for (int y = 0; y <= ceilRadiusY; ++y) {
                final double yn = nextYn;
                nextYn = (y + 1) * invRadiusY;
                double nextZn = 0;
                forZ: for (int z = 0; z <= ceilRadiusZ; ++z) {
                    final double zn = nextZn;
                    nextZn = (z + 1) * invRadiusZ;

                    double distanceSq = lengthSq(xn, yn, zn);
                    if (distanceSq > 1) {
                        if (z == 0) {
                            if (y == 0) {
                                break forX;
                            }
                            break forY;
                        }
                        break forZ;
                    }

                    if (!filled) {
                        if (lengthSq(nextXn, yn, zn) <= 1 && lengthSq(xn, nextYn, zn) <= 1 && lengthSq(xn, yn, nextZn) <= 1) {
                            continue;
                        }
                    }

                    Material block = Material.DIRT;
                    setBlock(center.clone().add(new Vector(x, y, z)), block);
                    setBlock(center.clone().add(new Vector(-x, y, z)), block);
                    setBlock(center.clone().add(new Vector(x, -y, z)), block);
                    setBlock(center.clone().add(new Vector(x, y, -z)), block);
                    setBlock(center.clone().add(new Vector(-x, -y, z)), block);
                    setBlock(center.clone().add(new Vector(x, -y, -z)), block);
                    setBlock(center.clone().add(new Vector(-x, y, -z)), block);
                    setBlock(center.clone().add(new Vector(-x, -y, -z)), block);
                }
            }
        }
	}
}
