package skydimension.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCloudCore extends Item {

	public ItemCloudCore(int par1) {
		super(par1);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		if(par2World.isRemote) return par1ItemStack;

		par1ItemStack.splitStack(1);
		int n = par2World.rand.nextInt(10);
		ItemStack itemStack;
		switch(n) {
		case 0:
			itemStack = new ItemStack(Item.seeds);
			break;
		case 1:
			itemStack = new ItemStack(Items.itemSky, 1, EnumSkyItem.dustGold.ordinal());
			break;
		case 2:
			itemStack = new ItemStack(Items.itemSky, 1, EnumSkyItem.dustIron.ordinal());
			break;
		case 3:
			itemStack = new ItemStack(Item.redstone);
			break;
		case 4:
			itemStack = new ItemStack(Item.lightStoneDust);
			break;
		case 5:
			itemStack = new ItemStack(Items.itemSky, 1, EnumSkyItem.dustSand.ordinal());
			break;
		default:
			itemStack = new ItemStack(Items.plantSeed);
			break;
		}
		if (!par3EntityPlayer.inventory.addItemStackToInventory(itemStack.copy())) {
			par3EntityPlayer.dropPlayerItem(itemStack);
		}
		return par1ItemStack;
	}

}
