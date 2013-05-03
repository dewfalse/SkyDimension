package skydimension.event;

import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import skydimension.Config;
import skydimension.block.Blocks;
import skydimension.item.Items;

public class FillBucketEventHook {

	@ForgeSubscribe
	public void onFillBucket(FillBucketEvent event) {
		if (event.entityPlayer.dimension == Config.skyDimensionID || event.entityPlayer.dimension == Config.empyreanDimensionID) {
			if (event.current.itemID == Item.bucketLava.itemID) {
				event.setResult(Result.DENY);
				event.setCanceled(true);
				return;
			}
		}

		int i = event.target.blockX;
		int j = event.target.blockY;
		int k = event.target.blockZ;

		if (event.current.itemID == Items.bucketWoodEmpty.itemID || event.current.itemID == Item.bucketEmpty.itemID) {
			// 空のバケツなら液体入りのバケツを返却する

			if (event.target.typeOfHit == EnumMovingObjectType.TILE) {

				if (!event.world.canMineBlock(event.entityPlayer, i, j, k)) {
					return;
				}

				if (!event.entityPlayer.canPlayerEdit(i, j, k, event.target.sideHit, event.current)) {
					return;
				}
				int blockID = event.world.getBlockId(i, j, k);

				if (blockID == Blocks.ambrosiaFlowing.blockID || blockID == Blocks.ambrosiaStationary.blockID) {
					if (event.current.itemID == Items.bucketWoodEmpty.itemID) {
						event.result = new ItemStack(Items.bucketWoodAmbrosia);
						event.setResult(Result.ALLOW);
					} else if (event.current.itemID == Item.bucketEmpty.itemID) {
						event.result = new ItemStack(Items.bucketAmbrosia);
						event.setResult(Result.ALLOW);
					} else {
						return;
					}
				} else if (blockID == Blocks.manaFlowing.blockID || blockID == Blocks.manaStationary.blockID) {
					if (event.current.itemID == Items.bucketWoodEmpty.itemID) {
						event.result = new ItemStack(Items.bucketWoodMana);
						event.setResult(Result.ALLOW);
					} else if (event.current.itemID == Item.bucketEmpty.itemID) {
						event.result = new ItemStack(Items.bucketMana);
						event.setResult(Result.ALLOW);
					} else {
						return;
					}
				} else {
					return;
				}
				if (event.world.getBlockMaterial(i, j, k) == Material.water && event.world.getBlockMetadata(i, j, k) == 0) {
					event.world.setBlockToAir(i, j, k);
				}
			} else if (event.target.entityHit instanceof EntityCow) {
				// 牛がターゲットならミルク入りの木製バケツを返す
				if (event.current.itemID == Items.bucketWoodEmpty.itemID) {
					event.result = new ItemStack(Items.bucketWoodMilk);
					event.setResult(Result.ALLOW);
				}
			}
		} else if (event.current.itemID == Items.bucketWoodAmbrosia.itemID || event.current.itemID == Items.bucketWoodMana.itemID) {
			// 液体入りの木製バケツなら内容物を設置して空の木製バケツを返す

			if (event.target.sideHit == 0) {
				--j;
			}

			if (event.target.sideHit == 1) {
				++j;
			}

			if (event.target.sideHit == 2) {
				--k;
			}

			if (event.target.sideHit == 3) {
				++k;
			}

			if (event.target.sideHit == 4) {
				--i;
			}

			if (event.target.sideHit == 5) {
				++i;
			}

			if (!event.entityPlayer.canPlayerEdit(i, j, k, event.target.sideHit, event.current)) {
				return;
			}
			float f = 1.0F;
			double d0 = event.entityPlayer.prevPosX + (event.entityPlayer.posX - event.entityPlayer.prevPosX) * (double) f;
			double d1 = event.entityPlayer.prevPosY + (event.entityPlayer.posY - event.entityPlayer.prevPosY) * (double) f + 1.62D - (double) event.entityPlayer.yOffset;
			double d2 = event.entityPlayer.prevPosZ + (event.entityPlayer.posZ - event.entityPlayer.prevPosZ) * (double) f;

			if (((ItemBucket) event.current.getItem()).tryPlaceContainedLiquid(event.world, d0, d1, d2, i, j, k) && !event.entityPlayer.capabilities.isCreativeMode) {
				event.result = new ItemStack(Items.bucketWoodEmpty);
				event.setResult(Result.ALLOW);
			}
		}

	}

}
