package skydimension.block;

import java.util.Random;

import net.minecraft.block.BlockGrass;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockSkyGrass extends BlockGrass {

	protected BlockSkyGrass(int par1) {
		super(par1);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4,
			Random par5Random) {
		// TODO 自動生成されたメソッド・スタブ
		super.updateTick(par1World, par2, par3, par4, par5Random);

		if (!par1World.isRemote) {
			if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4
					&& par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2) {
				par1World.setBlock(par2, par3, par4, Blocks.skyDirt.blockID);
			} else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9) {
				for (int l = 0; l < 4; ++l) {
					int i1 = par2 + par5Random.nextInt(3) - 1;
					int j1 = par3 + par5Random.nextInt(5) - 3;
					int k1 = par4 + par5Random.nextInt(3) - 1;
					int l1 = par1World.getBlockId(i1, j1 + 1, k1);

					if (par1World.getBlockId(i1, j1, k1) == Blocks.skyDirt.blockID
							&& par1World.getBlockLightValue(i1, j1 + 1, k1) >= 4
							&& par1World.getBlockLightOpacity(i1, j1 + 1, k1) <= 2) {
						par1World.setBlock(i1, j1, k1, Blocks.skyGrass.blockID);
					}
				}
			}

			for(ForgeDirection dir : new ForgeDirection[]{ForgeDirection.WEST, ForgeDirection.NORTH, ForgeDirection.EAST, ForgeDirection.SOUTH}) {
				if(par1World.getBlockId(par2+dir.offsetX, par3+dir.offsetY, par4+dir.offsetZ) == 0) {
					if(Blocks.skyWater.canBlockStay(par1World, par2+dir.offsetX, par3+dir.offsetY, par4+dir.offsetZ)) {
						par1World.setBlock(par2+dir.offsetX, par3+dir.offsetY, par4+dir.offsetZ, Blocks.skyWater.blockID, 7, 3);
					}
				}
			}
		}
	}

}
