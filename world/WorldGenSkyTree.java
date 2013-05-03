package skydimension.world;

import java.util.Random;

import skydimension.block.Blocks;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeDirection;

public class WorldGenSkyTree extends WorldGenerator {

	public WorldGenSkyTree() {
		super(true);
	}

	static ForgeDirection[] dirs = {ForgeDirection.UP, ForgeDirection.EAST, ForgeDirection.SOUTH, ForgeDirection.WEST, ForgeDirection.NORTH};
	@Override
	public boolean generate(World world, Random random, int i, int j, int k) {
		for(int n = 0; n < 3; ++n) {
			int x = i;
			int y = j;
			int z = k;
			while(y < 256) {
				setBlockAndMetadata(world, x, y, z, Blocks.skyWood.blockID, 0);
				ForgeDirection dir = dirs[random.nextInt(dirs.length)];
				x += dir.offsetX;
				y += dir.offsetY;
				z += dir.offsetZ;
			}
		}
		return false;
	}

}
