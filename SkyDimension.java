package skydimension;

import java.util.logging.Logger;

import skydimension.block.Blocks;
import skydimension.event.FillBucketEventHook;
import skydimension.event.LivingHurtEventHook;
import skydimension.event.PlayerInteractEventHook;
import skydimension.item.Items;
import skydimension.world.Worlds;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = SkyDimension.modID, name = SkyDimension.modID, version = "1.0")
@NetworkMod
public class SkyDimension {
	public static final String modID = "SkyDimension";
	@SidedProxy(clientSide = "skydimension.ClientProxy", serverSide = "skydimension.CommonProxy")
	public static CommonProxy proxy;

	@Instance(SkyDimension.modID)
	public static SkyDimension instance;

	public static Logger logger = Logger.getLogger("Minecraft");

	public static Config config = new Config();

	public static CreativeTabs tab = new CreativeTabsSky();

	@Mod.Init
	public void load(FMLInitializationEvent event) {
		Blocks.init();
		Items.init();
		Recipes.init();
		Entities.init();
		proxy.init();
		Worlds.init();
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		MinecraftForge.EVENT_BUS.register(new PlayerInteractEventHook());
		MinecraftForge.EVENT_BUS.register(new FillBucketEventHook());
		MinecraftForge.EVENT_BUS.register(new LivingHurtEventHook());
	}

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		config.load(event.getSuggestedConfigurationFile());
	}
}