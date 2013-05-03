package skydimension.event;

import skydimension.Config;
import skydimension.world.TeleporterOverworld;
import skydimension.world.TeleporterSky;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class LivingHurtEventHook {

	@ForgeSubscribe
	public void onLivingHurt(LivingHurtEvent event) {
		if(event.source.getDamageType() != DamageSource.outOfWorld.getDamageType()) return;
		if(event.entity instanceof EntityPlayerMP) {
			EntityPlayerMP thePlayer = (EntityPlayerMP) event.entity;
			if(thePlayer.dimension == Config.skyDimensionID || thePlayer.dimension == Config.empyreanDimensionID) {
				event.setCanceled(true);
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterOverworld(thePlayer.mcServer.worldServerForDimension(0), true) );
			}

		}
	}

}
