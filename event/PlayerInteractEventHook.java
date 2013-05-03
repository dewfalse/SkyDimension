package skydimension.event;

import skydimension.Config;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class PlayerInteractEventHook {

	@ForgeSubscribe
	public void onPlayerInteract(PlayerInteractEvent event) {
		if(event.action != Action.RIGHT_CLICK_BLOCK) return;
		if(event.entityPlayer.dimension != Config.skyDimensionID && event.entityPlayer.dimension != Config.empyreanDimensionID) return;
		ItemStack itemStack = event.entityPlayer.getCurrentEquippedItem();
		if(itemStack == null) return;
		if(itemStack.itemID == Block.torchWood.blockID) {
			event.setResult(Result.DENY);
			event.setCanceled(true);
		}
		if(itemStack.itemID == Item.flintAndSteel.itemID) {
			event.setResult(Result.DENY);
			event.setCanceled(true);
		}
	}

}
