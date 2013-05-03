package skydimension.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemBlockAeroCloud extends ItemBlock {

	public ItemBlockAeroCloud(int par1) {
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
		return Blocks.aeroCloud.getBlockTextureFromSideAndMetadata(2, i);
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

	public static final String dyeColorNames[] = { "white", "blue", "yellow", };

}
