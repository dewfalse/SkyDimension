package skydimension.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import skydimension.Config;
import skydimension.world.TeleporterEmpyrean;
import skydimension.world.TeleporterSky;

public class BlockTeleportEmpyrean extends Block {

	public BlockTeleportEmpyrean(int par1) {
		super(par1, Material.rock);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4,
			EntityPlayer par5EntityPlayer) {
		if (par5EntityPlayer.isRiding() == false
				&& par5EntityPlayer instanceof EntityPlayerMP) {

			EntityPlayerMP thePlayer = (EntityPlayerMP) par5EntityPlayer;
			thePlayer.timeUntilPortal = 10;

			if (par1World.provider.dimensionId != Config.empyreanDimensionID) {
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, Config.empyreanDimensionID, new TeleporterEmpyrean(thePlayer.mcServer.worldServerForDimension(Config.empyreanDimensionID)));
			}
			else {
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0);
			}
		}
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		if (par5EntityPlayer.isRiding() == false
				&& par5EntityPlayer instanceof EntityPlayerMP) {

			EntityPlayerMP thePlayer = (EntityPlayerMP) par5EntityPlayer;
			thePlayer.timeUntilPortal = 10;

			if (par1World.provider.dimensionId != Config.empyreanDimensionID) {
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, Config.empyreanDimensionID, new TeleporterEmpyrean(thePlayer.mcServer.worldServerForDimension(Config.empyreanDimensionID)));
			}
			else {
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0);
			}
		}
		return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
	}

}
