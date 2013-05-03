package skydimension.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemSky extends Item {

	Icon[] icons;
	public ItemSky(int par1) {
		super(par1);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	@Override
	public Icon getIconFromDamage(int par1) {
		return icons[par1];
	}

	@Override
	public void updateIcons(IconRegister par1IconRegister) {
		icons = new Icon[15];
		icons[0] = par1IconRegister.registerIcon("skydimension:gemLevitia");
		icons[1] = par1IconRegister.registerIcon("skydimension:gemSkylite");
		icons[2] = par1IconRegister.registerIcon("skydimension:gemWelkinia");
		icons[3] = par1IconRegister.registerIcon("skydimension:gemLevitia");
		icons[4] = par1IconRegister.registerIcon("skydimension:gemSkylite");
		icons[5] = par1IconRegister.registerIcon("skydimension:gemWelkinia");

		icons[6] = par1IconRegister.registerIcon("skydimension:dustIron");
		icons[7] = par1IconRegister.registerIcon("skydimension:nuggetIron");
		icons[8] = par1IconRegister.registerIcon("skydimension:dustGold");
		icons[9] = par1IconRegister.registerIcon("skydimension:dustSand");
		icons[10] = par1IconRegister.registerIcon("skydimension:edgeLeaf");

		icons[11] = par1IconRegister.registerIcon("skydimension:ingotEnchantedIron");
		icons[12] = par1IconRegister.registerIcon("skydimension:ingotEnchantedGold");
		icons[13] = par1IconRegister.registerIcon("skydimension:ingotBlessedIron");
		icons[14] = par1IconRegister.registerIcon("skydimension:ingotBlessedGold");
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		int damage = par1ItemStack.getItemDamage();
		if(damage == EnumSkyItem.gemBlessedLevitia.ordinal()) return true;
		if(damage == EnumSkyItem.gemBlessedSkylite.ordinal()) return true;
		if(damage == EnumSkyItem.gemBlessedWelkinia.ordinal()) return true;
		if(damage == EnumSkyItem.ingotEnchantedIron.ordinal()) return true;
		if(damage == EnumSkyItem.ingotEnchantedGold.ordinal()) return true;
		if(damage == EnumSkyItem.ingotBlessedIron.ordinal()) return true;
		if(damage == EnumSkyItem.ingotBlessedGold.ordinal()) return true;
		// TODO 自動生成されたメソッド・スタブ
		return super.hasEffect(par1ItemStack);
	}

	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for(int i = 0; i < EnumSkyItem.values().length; ++i) {
			par3List.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return (new StringBuilder()).append(super.getUnlocalizedName()).append(".")
				.append(EnumSkyItem.values()[par1ItemStack.getItemDamage()]).toString();
	}

}
