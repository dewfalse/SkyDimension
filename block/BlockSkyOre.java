package skydimension.block;

import java.util.Random;

import skydimension.item.Items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockSkyOre extends Block {

	public BlockSkyOre(int par1) {
		super(par1, Material.rock);
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		if(this.blockID == Blocks.oreLevitite.blockID) {
			return Items.itemSky.itemID;
		}
		if(this.blockID == Blocks.oreSkylite.blockID) {
			return Items.itemSky.itemID;
		}
		if(this.blockID == Blocks.oreWelkinite.blockID) {
			return Items.itemSky.itemID;
		}
		return this.blockID;
	}

	@Override
	public int damageDropped(int par1) {
		if(this.blockID == Blocks.oreLevitite.blockID) {
			return 0;
		}
		if(this.blockID == Blocks.oreSkylite.blockID) {
			return 1;
		}
		if(this.blockID == Blocks.oreWelkinite.blockID) {
			return 2;
		}
		return super.damageDropped(par1);
	}

	@Override
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
		super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

		if (this.idDropped(par5, par1World.rand, par7) != this.blockID) {
			int j1 = 0;
			j1 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
			this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
		}
	}

	@Override
	public int quantityDroppedWithBonus(int par1, Random par2Random) {
		// fortune
		if(par1 > 0 && this.blockID != this.idDropped(0, par2Random, par1)) {
			int j = par2Random.nextInt(par1 + 2) - 1;
			if (j < 0) {
				j = 0;
			}

			return this.quantityDropped(par2Random) * (j + 1);
		} else {
			return this.quantityDropped(par2Random);
		}
	}

}
