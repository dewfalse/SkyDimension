package skydimension.world;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import skydimension.Config;

public class WorldProviderEmpyrean extends WorldProvider {

	@Override
	public String getDimensionName() {
		return "Empyrean";
	}

	@Override
	protected void registerWorldChunkManager() {
		worldChunkMgr = new WorldChunkManagerEmpyrean(worldObj);
		this.dimensionId = Config.empyreanDimensionID;
		setSpawnPoint(0,64,0);
	}

	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderEmpyrean(this.worldObj, this.worldObj.getSeed());
	}

	@Override
	public boolean canCoordinateBeSpawn(int par1, int par2) {
		// TODO 自動生成されたメソッド・スタブ
		return super.canCoordinateBeSpawn(par1, par2);
	}

	@Override
	public void setSpawnPoint(int x, int y, int z) {
		// TODO 自動生成されたメソッド・スタブ
		super.setSpawnPoint(x, y, z);
	}

	@Override
	public boolean isSurfaceWorld() {
		// TODO 自動生成されたメソッド・スタブ
		return super.isSurfaceWorld();
	}

	@Override
	public ChunkCoordinates getSpawnPoint() {
		return new ChunkCoordinates(0, 64, 0);
	}

	@Override
	public ChunkCoordinates getEntrancePortalLocation() {
		return new ChunkCoordinates(0, 64, 0);
	}

	@Override
	public boolean canRespawnHere() {
		// TODO 自動生成されたメソッド・スタブ
		//return super.canRespawnHere();
		return false;
	}

	@Override
	public int getRespawnDimension(EntityPlayerMP player) {
		// TODO 自動生成されたメソッド・スタブ
		return super.getRespawnDimension(player);
	}

}
