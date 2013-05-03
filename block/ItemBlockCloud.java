package skydimension.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemBlockCloud extends ItemBlock {

	public ItemBlockCloud(int par1) {
		super(par1);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return (new StringBuilder()).append(super.getUnlocalizedName()).append(".")
				.append(dyeColorNames[itemstack.getItemDamage()]).toString();

	}

	@Override
	public Icon getIconFromDamage(int i) {
		return Blocks.cloud.getBlockTextureFromSideAndMetadata(2, i);
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

	public static final String dyeColorNames[] = { "white", "blue", "yellow", };

}
