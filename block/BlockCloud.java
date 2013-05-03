package skydimension.block;

import java.awt.Color;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCloud extends BlockBreakable {

	Icon[] icons;

	public BlockCloud(int par1) {
		super(par1, "skydimension:skyCloud", Material.snow, false);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
	}
    public boolean canCollideCheck(int par1, boolean par2)
    {
        return super.canCollideCheck(par1, par2);
    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

	@Override
	public boolean isOpaqueCube() {
        return false;
	}
	@Override
	public int getBlockColor() {
		return Color.RED.getRGB();
	}

	@Override
	public int getRenderColor(int par1) {
		if(par1 == 1) {
			return Color.BLUE.getRGB();
		}
		if(par1 == 2) {
			return Color.YELLOW.getRGB();
		}
		return Color.WHITE.getRGB();
	}
    public int getRenderBlockPass()
    {
        return 1;
    }
    @Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return Blocks.cloud.blockID;
	}
	@Override
	public int damageDropped(int par1) {
		// TODO 自動生成されたメソッド・スタブ
		return super.damageDropped(par1);
	}
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, 1 - par5);
    }

	@Override
	public boolean canHarvestBlock(EntityPlayer player, int meta) {
		return true;
	}
	@Override
	public int colorMultiplier(IBlockAccess par1iBlockAccess, int par2,
			int par3, int par4) {
		int metadata = par1iBlockAccess.getBlockMetadata(par2, par3, par4);
		if(metadata == 1) {
			return Color.BLUE.getRGB();
		}
		else if(metadata == 2) {
			return Color.YELLOW.getRGB();
		}
		return Color.WHITE.getRGB();
	}

}
