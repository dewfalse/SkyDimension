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
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return super.canCoordinateBeSpawn(par1, par2);
	}

	@Override
	public void setSpawnPoint(int x, int y, int z) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		super.setSpawnPoint(x, y, z);
	}

	@Override
	public boolean isSurfaceWorld() {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
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
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		//return super.canRespawnHere();
		return false;
	}

	@Override
	public int getRespawnDimension(EntityPlayerMP player) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return super.getRespawnDimension(player);
	}

}
