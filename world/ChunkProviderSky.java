package skydimension.world;

import java.util.List;
import java.util.Random;

import skydimension.block.Blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderSky implements IChunkProvider {

	private Random skyRNG;
	private World skyWorld;
	private BiomeGenBase[] biomesForGeneration;
	public ChunkProviderSky(World worldObj, long seed) {
		// TODO 自動生成されたコンストラクター・スタブ
		skyWorld = worldObj;
		skyRNG = new Random(seed);
	}

	@Override
	public boolean chunkExists(int i, int j) {
		return true;
	}

	@Override
	public Chunk provideChunk(int i, int j) {
        this.skyRNG.setSeed((long)i * 341873128712L + (long)j * 132897987541L);
        byte[] abyte = new byte[32768];
        this.biomesForGeneration = this.skyWorld.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, i * 16, j * 16, 16, 16);
        //this.generateTerrain(i, j, abyte, this.biomesForGeneration);
        //this.replaceBlocksForBiome(i, j, abyte, this.biomesForGeneration);
        Chunk chunk = new Chunk(this.skyWorld, abyte, i, j);
        byte[] abyte1 = chunk.getBiomeArray();

        for (int k = 0; k < abyte1.length; ++k)
        {
            abyte1[k] = (byte)this.biomesForGeneration[k].biomeID;
        }

        chunk.generateSkylightMap();
        return chunk;
	}

	@Override
	public Chunk loadChunk(int i, int j) {
		return this.provideChunk(i, j);
	}

	@Override
	public void populate(IChunkProvider ichunkprovider, int i, int j) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
		return true;
	}

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public String makeString() {
		return "RandomLevelSource";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i,
			int j, int k) {
        BiomeGenBase biomegenbase = this.skyWorld.getBiomeGenForCoords(i, k);
        return biomegenbase == null ? null : biomegenbase.getSpawnableList(enumcreaturetype);
	}

	@Override
	public ChunkPosition findClosestStructure(World world, String s, int i,
			int j, int k) {
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int i, int j) {
	}

}
