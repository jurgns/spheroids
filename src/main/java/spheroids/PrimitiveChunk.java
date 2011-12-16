package spheroids;

public class PrimitiveChunk extends BaseVoxel implements Voxel {
	@Override
	public int getXSize() {
		return 16;
	}
	@Override
	public int getYSize() {
		return 128;
	}
	@Override
	public int getZSize() {
		return 16;
	}


}
