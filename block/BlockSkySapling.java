package skydimension.block;

import java.util.Random;

import skydimension.Config;
import skydimension.world.WorldGenSkyTree;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSkySapling extends BlockFlower {
	private static final String[] saplingNames = new String[] { "sapling",
			"sapling_spruce", "sapling_birch", "sapling_jungle" };
	@SideOnly(Side.CLIENT)
	private Icon[] icons;

	protected BlockSkySapling(int par1) {
		super(par1);
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		if (!par1World.isRemote) {
			super.updateTick(par1World, par2, par3, par4, par5Random);

			if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0) {
				int l = par1World.getBlockMetadata(par2, par3, par4);

				if ((l & 8) == 0) {
					par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
				} else {
					this.growTree(par1World, par2, par3, par4, par5Random);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		par2 &= 3;
		return this.icons[par2];
	}

	@Override
	public int damageDropped(int par1) {
		return par1;
	}

	public void growTree(World par1World, int par2, int par3, int par4, Random par5Random) {
		if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4))
			return;

		(new WorldGenSkyTree()).generate(par1World, par5Random, par2, par3, par4);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		this.icons = new Icon[saplingNames.length];

		for (int i = 0; i < this.icons.length; ++i) {
			this.icons[i] = par1IconRegister.registerIcon(saplingNames[i]);
		}
	}

}
