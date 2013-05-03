package skydimension.block;

import net.minecraft.block.BlockLog;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import skydimension.Config;
import skydimension.world.TeleporterSky;

public class BlockSkyWood extends BlockLog {

	public BlockSkyWood(int par1) {
		super(par1);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		transferPlayerToSkyDimension(par1World, par2, par3, par4);
	}

	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		transferPlayerToSkyDimension(par1World, par2, par3, par4);
	}

	void transferPlayerToSkyDimension(World par1World, int par2, int par3, int par4) {
		if (par3 > 253) {
			EntityPlayer player = par1World.getClosestPlayer((double) par2 + 0.5D, (double) par3 + 0.5D, (double) par4 + 0.5D, (double) 16);
			if (player == null) {
				return;
			}
			if (player.isRiding() == false && player instanceof EntityPlayerMP) {

				EntityPlayerMP thePlayer = (EntityPlayerMP) player;
				thePlayer.timeUntilPortal = 10;

				if (par1World.provider.dimensionId != Config.skyDimensionID && par1World.provider.dimensionId != Config.empyreanDimensionID) {
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, Config.skyDimensionID, new TeleporterSky(thePlayer.mcServer.worldServerForDimension(Config.skyDimensionID)));
				}
			}
		}
	}

}
