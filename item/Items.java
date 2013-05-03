package skydimension.item;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemBucketMilk;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.liquids.LiquidContainerData;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.oredict.OreDictionary;
import skydimension.Config;
import skydimension.SkyDimension;
import skydimension.block.Blocks;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Items {

	public static final String GEM_WELKINIA = "gemWelkinia";
	public static final String GEM_SKYLITE = "gemSkylite";
	public static final String GEM_LEVITIA = "gemLevitia";
	public static final String NUGGET_GOLD = "nuggetGold";
	public static final String DUST_SAND = "dustSand";
	public static final String DUST_GOLD = "dustGold";
	public static final String NUGGET_IRON = "nuggetIron";
	public static final String DUST_IRON = "dustIron";
	public static Item cloudCore;
	public static Item plantSeed;
	public static Item skySapling;
	public static Item tearDrop;
	public static Item redFruit;
	public static Item ambrosia;
	public static Item bucketWoodEmpty;
	public static Item bucketWoodWater;
	public static Item bucketWoodAmbrosia;
	public static Item bucketWoodMana;
	public static Item bucketWoodMilk;


	public static void init() {
		int itemID = Config.itemID;
		cloudCore = new ItemCloudCore(itemID++).setUnlocalizedName("skydimension:cloudCore").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(cloudCore, "en_US", "Cloud Core");
		LanguageRegistry.instance().addNameForObject(cloudCore, "ja_JP", "雲の核");

		// 植物
		plantSeed = new Item(itemID++).setUnlocalizedName("skydimension:plantSeed").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(plantSeed, "en_US", "Plant Seed");

		// 護符
		tearDrop = new ItemTearDrop(itemID++).setUnlocalizedName("skydimension:tearDrop").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(tearDrop, "en_US", "Tear Drop of Levitia");

		// アンブロシア
		redFruit = new ItemFood(itemID++, 4, 0.3F, false).setUnlocalizedName("skydimension:redFruit").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(redFruit, "en_US", "Red Fruit");
		ambrosia = new ItemMagicDrink(itemID++, 8, 0.6F, false).setAlwaysEdible().setPotionEffect(Potion.regeneration.id, 40, 0, 1.0F).setUnlocalizedName("skydimension:ambrosia").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(ambrosia, "en_US", "Ambrosia");


		// ブラッドフルーツ
		bloodFruit = new Item(itemID++).setUnlocalizedName("skydimension:bloodFruit").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(bloodFruit, "en_US", "Blood Fruit");
		bloodyPotion = new ItemMagicDrink(itemID++, 8, 0.6F, false).setAlwaysEdible().setPotionEffect(Potion.resistance.id, 40, 0, 1.0F).setUnlocalizedName("skydimension:bloodyPotion").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(bloodyPotion, "en_US", "Bloody Potion");

		// 宝石
		itemSky = new ItemSky(itemID++).setUnlocalizedName("skydimension:gemLevitia").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 0), "en_US", "Levitia");
		OreDictionary.registerOre(GEM_LEVITIA, new ItemStack(itemSky, 1, 0));
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 1), "en_US", "Skylite");
		OreDictionary.registerOre(GEM_SKYLITE, new ItemStack(itemSky, 1, 1));
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 2), "en_US", "Welkinia");
		OreDictionary.registerOre(GEM_WELKINIA, new ItemStack(itemSky, 1, 2));
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 3), "en_US", "Blessed Levitia");
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 4), "en_US", "Blessed Skylite");
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 5), "en_US", "Blessed Welkinia");

		// 金属
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 6), "en_US", "Iron Dust");
		OreDictionary.registerOre(DUST_IRON, new ItemStack(itemSky, 1, 6));
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 7), "en_US", "Nugget Dust");
		OreDictionary.registerOre(NUGGET_IRON, new ItemStack(itemSky, 1, 7));
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 8), "en_US", "Gold Dust");
		OreDictionary.registerOre(DUST_GOLD, new ItemStack(itemSky, 1, 8));

		// 砂粒
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 9), "en_US", "Sand Dust");
		OreDictionary.registerOre(DUST_SAND, new ItemStack(itemSky, 1, 9));

		// 素材
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 10), "en_US", "Edge Leaf");

		// 魔化素材
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 11), "en_US", "Enchanted Iron Ingot");
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 12), "en_US", "Enchanted Gold Ingot");
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 13), "en_US", "Blessed Iron Ingot");
		LanguageRegistry.instance().addNameForObject(new ItemStack(itemSky, 1, 14), "en_US", "Blessed Gold Ingot");

		// ツール
		edgeLeafShears = new Item(itemID++).setUnlocalizedName("skydimension:edgeLeafShears").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(edgeLeafShears, "en_US", "EdgeLeaf Shears");
		edgeLeafAxe = new Item(itemID++).setUnlocalizedName("skydimension:edgeLeafAxe").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(edgeLeafAxe, "en_US", "EdgeLeaf Axe");

		pickaxeLevitia = new Item(itemID++).setUnlocalizedName("skydimension:levitiaPickaxe").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(pickaxeLevitia, "en_US", "Levitia Pickaxe");
		shovelLevitia = new Item(itemID++).setUnlocalizedName("skydimension:levitiaShovel").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(shovelLevitia, "en_US", "Levitia Shovel");
		axeLevitia = new Item(itemID++).setUnlocalizedName("skydimension:levitiaAxe").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(axeLevitia, "en_US", "Levitia Axe");
		hoeLevitia = new Item(itemID++).setUnlocalizedName("skydimension:levitiaHoe").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(hoeLevitia, "en_US", "Levitia Hoe");

		pickaxeSkylite = new Item(itemID++).setUnlocalizedName("skydimension:skylitePickax").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(pickaxeSkylite, "en_US", "Skylite Pickaxe");
		shovelSkylite = new Item(itemID++).setUnlocalizedName("skydimension:skyliteShovel").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(shovelSkylite, "en_US", "Skylite Shovel");
		axeSkylite = new Item(itemID++).setUnlocalizedName("skydimension:skyliteAxe").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(axeSkylite, "en_US", "Skylite Axe");
		hoeSkylite = new Item(itemID++).setUnlocalizedName("skydimension:skyliteHoe").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(hoeSkylite, "en_US", "Skylite Hoe");

		pickaxeWelkinia = new Item(itemID++).setUnlocalizedName("skydimension:pickaxeWelkinia").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(pickaxeWelkinia, "en_US", "Welkinia Pickaxe");
		shovelWelkinia = new Item(itemID++).setUnlocalizedName("skydimension:shovelWelkinia").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(shovelWelkinia, "en_US", "Welkinia Shovel");
		axeWelkinia = new Item(itemID++).setUnlocalizedName("skydimension:axeWelkinia").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(axeWelkinia, "en_US", "Welkinia Axe");
		hoeWelkinia = new Item(itemID++).setUnlocalizedName("skydimension:hoeWelkinia").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(hoeWelkinia, "en_US", "Welkinia Hoe");

		// バケツ
		bucketWoodEmpty = new ItemBucket(itemID++, 0).setUnlocalizedName("skydimension:bucketWoodEmpty").setMaxStackSize(16).setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(bucketWoodEmpty, "en_US", "Bucket Wood");
		bucketWoodWater = new ItemBucket(itemID++, Block.waterMoving.blockID).setUnlocalizedName("skydimension:bucketWoodWater").setContainerItem(bucketWoodEmpty).setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(bucketWoodWater, "en_US", "Bucket Wood Water");
		bucketWoodMilk = new ItemBucketMilk(itemID++).setUnlocalizedName("skydimension:bucketWoodMilk").setContainerItem(bucketWoodEmpty).setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(bucketWoodMilk, "en_US", "Bucket Wood Milk");

		bucketAmbrosia = new ItemBucket(itemID++, Blocks.ambrosiaFlowing.blockID).setUnlocalizedName("skydimension:bucketAmbrosia").setContainerItem(Item.bucketEmpty).setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(bucketAmbrosia, "en_US", "Bucket Ambrosia");
		bucketMana = new ItemBucket(itemID++, Blocks.manaFlowing.blockID).setUnlocalizedName("skydimension:bucketMana").setContainerItem(Item.bucketEmpty).setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(bucketMana, "en_US", "Bucket Mana");
		bucketWoodAmbrosia = new ItemBucket(itemID++, Blocks.ambrosiaFlowing.blockID).setUnlocalizedName("skydimension:bucketWoodAmbrosia").setContainerItem(bucketWoodEmpty).setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(bucketWoodAmbrosia, "en_US", "Bucket Wood Ambrosia");
		bucketWoodMana = new ItemBucket(itemID++, Blocks.manaFlowing.blockID).setUnlocalizedName("skydimension:bucketWoodMana").setContainerItem(bucketWoodEmpty).setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(bucketWoodMana, "en_US", "Bucket Wood Mana");
		LiquidContainerRegistry.registerLiquid(new LiquidContainerData(new LiquidStack(Block.waterStill, LiquidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketWoodWater), new ItemStack(bucketWoodEmpty)));
		LiquidContainerRegistry.registerLiquid(new LiquidContainerData(new LiquidStack(Blocks.ambrosiaStationary, LiquidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketWoodAmbrosia), new ItemStack(bucketWoodEmpty)));
		LiquidContainerRegistry.registerLiquid(new LiquidContainerData(new LiquidStack(Blocks.manaStationary, LiquidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketWoodMana), new ItemStack(bucketWoodEmpty)));
		LiquidContainerRegistry.registerLiquid(new LiquidContainerData(new LiquidStack(Blocks.ambrosiaStationary, LiquidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketAmbrosia), new ItemStack(Item.bucketEmpty)));
		LiquidContainerRegistry.registerLiquid(new LiquidContainerData(new LiquidStack(Blocks.manaStationary, LiquidContainerRegistry.BUCKET_VOLUME), new ItemStack(bucketMana), new ItemStack(Item.bucketEmpty)));

		// 剣
		edgeLeafSword = new Item(itemID++).setUnlocalizedName("skydimension:edgeLeafSword").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(edgeLeafSword, "en_US", "EdgeLeaf Sword");

		// アーマー
		helmetEdgeLeaf = new Item(itemID++).setUnlocalizedName("skydimension:helmetEdgeLeaf").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(helmetEdgeLeaf, "en_US", "EdgeLeaf Helmet");
		plateEdgeLeaf = new Item(itemID++).setUnlocalizedName("skydimension:plateEdgeLeaf").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(plateEdgeLeaf, "en_US", "EdgeLeaf Plate");
		legsEdgeLeaf = new Item(itemID++).setUnlocalizedName("skydimension:legsEdgeLeaf").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(legsEdgeLeaf, "en_US", "EdgeLeaf Legs");
		bootsEdgeLeaf = new Item(itemID++).setUnlocalizedName("skydimension:bootsEdgeLeaf").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(bootsEdgeLeaf, "en_US", "EdgeLeaf Boots");

		// 杖
		wandOfLevitia = new Item(itemID++).setUnlocalizedName("skydimension:wandOfLevitia").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(wandOfLevitia, "en_US", "Wand Of Levitia");
		wandOfFlame = new Item(itemID++).setUnlocalizedName("skydimension:wandOfFlame").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(wandOfFlame, "en_US", "Wand Of Flame");
		wandOfThunder = new Item(itemID++).setUnlocalizedName("skydimension:wandOfThunder").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(wandOfThunder, "en_US", "Wand Of Thunder");
		wandOfExplosion = new Item(itemID++).setUnlocalizedName("skydimension:wandOfExplosion").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(wandOfExplosion, "en_US", "Wand Of Explosion");
		wandOfPower = new Item(itemID++).setUnlocalizedName("skydimension:wandOfPower").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(wandOfPower, "en_US", "Wand Of Power");

		// 護符
		amuletOfGreed = new Item(itemID++).setUnlocalizedName("skydimension:amuletOfGreed").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(amuletOfGreed, "en_US", "Amulet Of Greed");
		amuletOfLevitia = new Item(itemID++).setUnlocalizedName("skydimension:amuletOfLevitia").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(amuletOfLevitia, "en_US", "AmuletOfLevitia");
		amuletOfSkylite = new Item(itemID++).setUnlocalizedName("skydimension:amuletOfSkylite").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(amuletOfSkylite, "en_US", "Amulet Of Skylite");
		amuletOfWelkinia = new Item(itemID++).setUnlocalizedName("skydimension:amuletOfWelkinia").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(amuletOfWelkinia, "en_US", "Amulet Of Welkinia");
		amuletOfSacrifice = new Item(itemID++).setUnlocalizedName("skydimension:amuletOfSacrifice").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(amuletOfSacrifice, "en_US", "Amulet Of Sacrifice");
		amuletOfSunlight = new Item(itemID++).setUnlocalizedName("skydimension:amuletOfSunlight").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(amuletOfSunlight, "en_US", "Amulet Of Sunlight");

		// 武器
		soulStealer = new Item(itemID++).setUnlocalizedName("skydimension:soulStealer").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(soulStealer, "en_US", "Soul Stealer");
		deathSickle = new Item(itemID++).setUnlocalizedName("skydimension:deathSickle").setCreativeTab(SkyDimension.tab);
		LanguageRegistry.instance().addNameForObject(deathSickle, "en_US", "Death Sickle");

		OreDictionary.registerOre(NUGGET_GOLD, Item.goldNugget);

		EnumToolMaterial materialLevitia = EnumHelper.addToolMaterial("LEVITIA", 2, 200, 6.0F, 2, 10);
		EnumToolMaterial materialSkylite = EnumHelper.addToolMaterial("SKYLITE", 2, 500, 6.0F, 2, 5);
		EnumToolMaterial materialWelkinia = EnumHelper.addToolMaterial("WELKINIA", 2, 300, 6.0F, 2, 22);
		EnumToolMaterial materialEdgeLeaf = EnumHelper.addToolMaterial("EDGELEAF", 1, 59, 4.0F, 2, 5);
		// 液体魔力
		// 素材３
		// 中間素材３
		// アーマーセット４×３種類＝１２
		// ダメージ反射
		// 剣３
		// ダメージ逆流、貫通、天界特効、ネザー特効
		// 杖５
		// 浮力、引力、斥力、火炎、雷、爆発、魔力弾
		// 護符５
		// ダメージ回復、身代わり、空腹回復、視線で固化、落下ダメージ無効
		// 封印解除アイテム４
		// テイム用の餌３
		// 肉や羽などドロップアイテム４
		// 弓と専用の矢
		// ハサミ
		// 魚
	}
	public static Item bucketAmbrosia;
	public static Item bloodFruit;
	public static Item bloodyPotion;
	public static Item bucketMana;

	public static Item itemSky;

	public static Item edgeLeafShears;
	public static Item edgeLeafAxe;
	public static Item edgeLeafSword;
	public static Item helmetEdgeLeaf;
	public static Item plateEdgeLeaf;
	public static Item legsEdgeLeaf;
	public static Item bootsEdgeLeaf;

	public static Item wandOfLevitia;
	public static Item wandOfFlame;
	public static Item wandOfThunder;
	public static Item wandOfExplosion;
	public static Item wandOfPower;

	public static Item amuletOfGreed;
	public static Item amuletOfLevitia;
	public static Item amuletOfSkylite;
	public static Item amuletOfWelkinia;
	public static Item amuletOfSacrifice;
	public static Item amuletOfSunlight;

	public static Item soulStealer;
	public static Item deathSickle;



	public static Item arrowOfGravitite;

	public static Item helmetEnchantedIron;
	public static Item plateEnchantedIron;
	public static Item legsEnchantedIron;
	public static Item bootsEnchantedIron;
	public static Item helmetEnchantedGold;
	public static Item plateEnchantedGold;
	public static Item legsEnchantedGold;
	public static Item bootsEnchantedGold;
	public static Item helmetBlessedIron;
	public static Item plateBlessedIron;
	public static Item legsBlessedIron;
	public static Item bootsBlessedIron;
	public static Item helmetBlessedGold;
	public static Item plateBlessedGold;
	public static Item legsBlessedGold;
	public static Item bootsBlessedGold;
	public static Item pickaxeLevitia;
	public static Item shovelLevitia;
	public static Item axeLevitia;
	public static Item hoeLevitia;
	public static Item pickaxeSkylite;
	public static Item shovelSkylite;
	public static Item axeSkylite;
	public static Item hoeSkylite;
	public static Item pickaxeWelkinia;
	public static Item shovelWelkinia;
	public static Item axeWelkinia;
	public static Item hoeWelkinia;

	// swords

	// armor

	// meat

	// bow

	// arrow

	// fish

	// charm

	// staff

	// flower

	//
}
