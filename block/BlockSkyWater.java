package skydimension.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockSkyWater extends BlockStationary {

	protected BlockSkyWater(int par1) {
		super(par1, Material.water);
		disableStats();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
		for(ForgeDirection dir : new ForgeDirection[]{ForgeDirection.WEST, ForgeDirection.NORTH, ForgeDirection.EAST, ForgeDirection.SOUTH}) {
			int blockID = par1World.getBlockId(par2+dir.offsetX, par3+dir.offsetY, par4+dir.offsetZ);
			if(blockID != Blocks.skyGrass.blockID && blockID != Blocks.skyDirt.blockID) {
				return false;
			}
		}
		int blockID = par1World.getBlockId(par2, par3-1, par4);
		if(blockID == Blocks.skyGrass.blockID || blockID == Blocks.skyDirt.blockID) {
			return true;
		}
		return false;
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, int par5) {
		if(canBlockStay(par1World, par2, par3, par4) == false) {
			int metadata = par1World.getBlockMetadata(par2, par3, par4);
			par1World.setBlock(par2, par3, par4, Block.waterMoving.blockID, 0, 3);
		}
	}

	@Override
	public void randomDisplayTick(World par1World, int par2, int par3,
			int par4, Random par5Random) {
		if(par5Random.nextInt(20) != 0) {
			return;
		}
		int metadata = par1World.getBlockMetadata(par2, par3, par4);
		metadata--;
		if(metadata >= 8 || metadata <= 0) {
			par1World.setBlock(par2, par3, par4, Block.waterStill.blockID, 0, 3);
		}
		else {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, metadata, 2);
		}
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		// TODO 自動生成されたメソッド・スタブ
		super.registerIcons(par1IconRegister);
	}

}
