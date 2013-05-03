package skydimension.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraftforge.liquids.ILiquid;

public class BlockLiquidStill extends BlockStationary implements ILiquid {
	@SideOnly(Side.CLIENT)
	private Icon[] theIcon;
	public static int renderID;

	public BlockLiquidStill(int i, Material material) {
		super(i, material);

		setHardness(100F);
		setLightOpacity(3);
	}

	@Override
	public int getRenderType() {
		return renderID;
	}

	@Override
	public int stillLiquidId() {
		if(this.blockID == Blocks.ambrosiaFlowing.blockID || this.blockID == Blocks.ambrosiaStationary.blockID) {
			return Blocks.ambrosiaStationary.blockID;
		}
		return Blocks.manaStationary.blockID;
	}

	@Override
	public boolean isMetaSensitive() {
		return false;
	}

	@Override
	public int stillLiquidMeta() {
		return 0;
	}

	@Override
	public boolean isBlockReplaceable(World world, int i, int j, int k) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		if(this.blockID == Blocks.ambrosiaFlowing.blockID || this.blockID == Blocks.ambrosiaStationary.blockID) {
			this.theIcon = new Icon[] {
					iconRegister.registerIcon("skydimension:ambrosia"),
					iconRegister.registerIcon("skydimension:ambrosia_flow") };
		}
		else {
			this.theIcon = new Icon[] {
					iconRegister.registerIcon("skydimension:mana"),
					iconRegister.registerIcon("skydimension:mana_flow") };
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2) {
		return par1 != 0 && par1 != 1 ? this.theIcon[1] : this.theIcon[0];
	}

}
