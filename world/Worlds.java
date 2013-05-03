package skydimension.world;

import skydimension.Config;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class Worlds {

	public static void init() {
		WorldChunkManagerSky.init();
		DimensionManager.registerProviderType(Config.skyProviderTypeID, WorldProviderSky.class, false);
		DimensionManager.registerDimension(Config.skyDimensionID, Config.skyProviderTypeID);
		WorldChunkManagerEmpyrean.init();
		DimensionManager.registerProviderType(Config.empyreanProviderTypeID, WorldProviderEmpyrean.class, false);
		DimensionManager.registerDimension(Config.empyreanDimensionID, Config.empyreanProviderTypeID);
	}

}
