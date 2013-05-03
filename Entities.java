package skydimension;

import cpw.mods.fml.common.registry.EntityRegistry;

public class Entities {

	public static void init() {
		EntityRegistry.registerModEntity(EntityCloud.class, "Bullet", 1, SkyDimension.instance, 250, 1, true);
	}

}
