package skydimension.world;

import skydimension.Config;
import skydimension.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

public class TeleporterSky extends Teleporter {

    private final WorldServer worldServerInstance;
	public TeleporterSky(WorldServer par1WorldServer) {
		super(par1WorldServer);
		worldServerInstance = par1WorldServer;
	}

	@Override
	public void placeInPortal(Entity par1Entity, double par2, double par4, double par6, float par8) {
		placePortalAndPlayer(par1Entity, par2, par4, par6, par8);
	}

	void placePortalAndPlayer(Entity par1Entity, double par2, double par4, double par6, float par8) {
		int i = (int)par1Entity.posX;
		int k = (int)par1Entity.posZ;

		i = (i / 256) * 256;
		k = (k / 256) * 256;

		if(this.worldServerInstance.getBlockId(i + 1, 60, k + 1) == Block.bedrock.blockID) {
			par1Entity.setLocationAndAngles(i + 1, 64, k + 1, 0, 0);
			return;
		}

		for(int y = 60; y < 62; ++y) {
			for(int x = 0; x < 6; ++x) {
				for(int z = 0; z < 6; ++z) {
					this.worldServerInstance.setBlock(i + x, y, k + z, Blocks.skyDirt.blockID, 0, 2);
				}
			}
		}
		for(int x = 0; x < 6; ++x) {
			for(int z = 0; z < 6; ++z) {
				this.worldServerInstance.setBlock(i + x, 62, k + z, Blocks.skyGrass.blockID, 0, 2);
			}
		}
		for(int y = 0; y < 62; ++y) {
			if(this.worldServerInstance.isAirBlock(i -1, y, k -1)) {
				this.worldServerInstance.setBlock(i -1, y, k -1, Block.wood.blockID, 0, 2);
			}
		}
		this.worldServerInstance.setBlock(i + 1, 60, k + 1, Block.bedrock.blockID, 0, 2);
		par1Entity.setLocationAndAngles(i + 1, 64, k + 1, 0, 0);
	}

	@Override
	public boolean placeInExistingPortal(Entity par1Entity, double par2, double par4, double par6, float par8) {
		placePortalAndPlayer(par1Entity, par2, par4, par6, par8);
		return true;
	}

}
