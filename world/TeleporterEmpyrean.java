package skydimension.world;

import skydimension.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

public class TeleporterEmpyrean extends Teleporter {

    private final WorldServer worldServerInstance;
	public TeleporterEmpyrean(WorldServer par1WorldServer) {
		super(par1WorldServer);
		worldServerInstance = par1WorldServer;
	}

	@Override
	public void placeInPortal(Entity par1Entity, double par2, double par4, double par6, float par8) {
		placePortalAndPlayer(par1Entity, par2, par4, par6, par8);
	}

	void placePortalAndPlayer(Entity par1Entity, double par2, double par4, double par6, float par8) {
	}

	@Override
	public boolean placeInExistingPortal(Entity par1Entity, double par2, double par4, double par6, float par8) {
		placePortalAndPlayer(par1Entity, par2, par4, par6, par8);
		return true;
	}

}
