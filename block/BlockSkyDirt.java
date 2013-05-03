package skydimension.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockSkyDirt extends BlockDirt {

	protected BlockSkyDirt(int par1) {
		super(par1);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.blockIcon = par1IconRegister.registerIcon("dirt");
	}

	@Override
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		// TODO 自動生成されたメソッド・スタブ
		return this.blockIcon;
	}

}
