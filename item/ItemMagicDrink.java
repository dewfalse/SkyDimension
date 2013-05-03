package skydimension.item;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemMagicDrink extends ItemFood {

	public ItemMagicDrink(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.drink;
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		super.onEaten(par1ItemStack, par2World, par3EntityPlayer);

		if (!par3EntityPlayer.capabilities.isCreativeMode) {
			if (par1ItemStack.stackSize <= 0) {
				return new ItemStack(Item.glassBottle);
			}

			par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.glassBottle));
		}

		return par1ItemStack;
	}

}
