package skydimension.world;

import skydimension.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterOverworld extends Teleporter {

    private final WorldServer worldServerInstance;
    boolean fall;
	public TeleporterOverworld(WorldServer par1WorldServer, boolean fall) {
		super(par1WorldServer);
		worldServerInstance = par1WorldServer;
		this.fall = fall;
	}

	@Override
	public void placeInPortal(Entity par1Entity, double par2, double par4, double par6, float par8) {
		placePortalAndPlayer(par1Entity, par2, par4, par6, par8);
	}

	void placePortalAndPlayer(Entity par1Entity, double par2, double par4, double par6, float par8) {
		int i = (int)par1Entity.posX;
		int k = (int)par1Entity.posZ;
		if(fall) {
			par1Entity.setLocationAndAngles(i, 127, k, 0, 0);
		}
	}

	@Override
	public boolean placeInExistingPortal(Entity par1Entity, double par2, double par4, double par6, float par8) {
		placePortalAndPlayer(par1Entity, par2, par4, par6, par8);
		return true;
	}

}
