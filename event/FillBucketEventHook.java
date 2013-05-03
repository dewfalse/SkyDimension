package skydimension.event;

import skydimension.Config;
import net.minecraft.item.Item;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class FillBucketEventHook {

	@ForgeSubscribe
	public void onFillBucket(FillBucketEvent event) {
		if(event.entityPlayer.dimension != Config.skyDimensionID && event.entityPlayer.dimension != Config.empyreanDimensionID) return;
		if(event.current.itemID == Item.bucketLava.itemID) {
			event.setResult(Result.DENY);
			event.setCanceled(true);
		}

	}

}
