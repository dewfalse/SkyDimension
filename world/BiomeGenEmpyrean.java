package skydimension.world;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenEmpyrean extends BiomeGenBase {

	public BiomeGenEmpyrean(int par1) {
		super(par1);
		this.topBlock = (byte)Block.dirt.blockID;
		this.fillerBlock = (byte)Block.dirt.blockID;
	}

}
