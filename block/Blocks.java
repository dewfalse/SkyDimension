package skydimension.block;

import skydimension.Config;
import skydimension.SkyDimension;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockOreStorage;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.BlockWood;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

public class Blocks {

	public static final String BLOCK_WELKINITE = "blockWelkinite";
	public static final String ORE_WELKINITE = "oreWelkinite";
	public static final String BLOCK_SKYLITE = "blockSkylite";
	public static final String ORE_SKYLITE = "oreSkylite";
	public static final String BLOCK_LEVITITE = "blockLevitite";
	public static final String ORE_LEVITITE = "oreLevitite";
	public static Block aeroCloud;
	public static Block cloud;
	public static Block acidMoving;
	public static Block acidStationary;
	public static Block skyWood;
	public static Block skeLeaf;
	public static Block skyDirt;
	public static Block skyGrass;
	public static Block skyStone;
	public static Block skyPortal;
	public static Block skyWater;
	public static Block skySapling;
	public static Block leviStone;
	public static Block edgeFlower;

	public static Block oreLevitite;
	public static Block blockLevitite;
	public static Block oreSkylite;
	public static Block blockSkylite;
	public static Block oreWelkinite;
	public static Block blockWelkinite;
	public static Block ambrosiaStationary;
	public static Block ambrosiaFlowing;
	public static Block manaStationary;
	public static Block manaFlowing;

	public static Block teleportSkyStone;
	public static Block teleportEmpyreanStone;

	public static void init() {
		int blockID = Config.blockID;
		skyGrass = new BlockSkyGrass(blockID++).setHardness(0.6F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("skydimension:skyGrass").setCreativeTab(SkyDimension.tab);
		skyDirt = new BlockSkyDirt(blockID++).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("skydimension:skyDirt").setCreativeTab(SkyDimension.tab);
		skyWater = new BlockSkyWater(blockID++).setHardness(100.0F).setLightOpacity(3).setUnlocalizedName("skydimension:skyWater");
		aeroCloud = new BlockAeroCloud(blockID++).setHardness(0.2F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("skydimension:aeroCloud").setCreativeTab(SkyDimension.tab);
		cloud = new BlockCloud(blockID++).setHardness(0.2F).setStepSound(Block.soundClothFootstep).setUnlocalizedName("skydimension:skyCloud").setCreativeTab(SkyDimension.tab);
		skySapling = new BlockSkySapling(blockID++).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("skydimension:skySapling").setCreativeTab(SkyDimension.tab);
		skyWood = new BlockSkyWood(blockID++).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("skydimension:skyWood").setCreativeTab(SkyDimension.tab);
		edgeFlower = (BlockFlower)(new BlockEdgeFlower(blockID++)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("skydimension:edgeFlower").setCreativeTab(SkyDimension.tab);

		GameRegistry.registerBlock(skyGrass, "SkyGrass");
		LanguageRegistry.addName(skyGrass, "Sky Grass");
		GameRegistry.registerBlock(skyDirt, "SkyDirt");
		LanguageRegistry.addName(skyDirt, "Sky Dirt");
		GameRegistry.registerBlock(skySapling, "SkySapling");
		LanguageRegistry.addName(skySapling, "Sky Sapling");
		GameRegistry.registerBlock(skyWood, "SkyWood");
		LanguageRegistry.addName(skyWood, "Sky Wood");
		GameRegistry.registerBlock(aeroCloud, ItemBlockAeroCloud.class);
		LanguageRegistry.addName(new ItemStack(aeroCloud.blockID, 1, 0), "Sky Aero Cloud");
		LanguageRegistry.addName(new ItemStack(aeroCloud.blockID, 1, 1), "Sky Aero Cloud");
		LanguageRegistry.addName(new ItemStack(aeroCloud.blockID, 1, 2), "Sky Aero Cloud");
		GameRegistry.registerBlock(cloud, ItemBlockCloud.class);
		LanguageRegistry.addName(new ItemStack(cloud.blockID, 1, 0), "Sky Cloud");
		LanguageRegistry.addName(new ItemStack(cloud.blockID, 1, 1), "Sky Cloud");
		LanguageRegistry.addName(new ItemStack(cloud.blockID, 1, 2), "Sky Cloud");
		GameRegistry.registerBlock(edgeFlower, "EdgeFlower");
		LanguageRegistry.addName(edgeFlower, "Edge Flower");

		ambrosiaFlowing = new BlockLiquidFlowing(blockID++, Material.water).setHardness(100.0F).setLightOpacity(3).setUnlocalizedName("skydimension:ambrosia").setCreativeTab(SkyDimension.tab);
		ambrosiaStationary = new BlockLiquidStill(blockID++, Material.water).setHardness(100.0F).setLightOpacity(3).setUnlocalizedName("skydimension:ambrosiaStill").setCreativeTab(SkyDimension.tab);
		manaFlowing = new BlockLiquidFlowing(blockID++, Material.water).setHardness(100.0F).setLightOpacity(3).setUnlocalizedName("skydimension:mana").setCreativeTab(SkyDimension.tab);
		manaStationary = new BlockLiquidStill(blockID++, Material.water).setHardness(100.0F).setLightOpacity(3).setUnlocalizedName("skydimension:manaStill").setCreativeTab(SkyDimension.tab);
		GameRegistry.registerBlock(ambrosiaFlowing, "ambrosiaFlowing");
		LanguageRegistry.addName(ambrosiaFlowing, "ambrosiaFlowing");
		GameRegistry.registerBlock(ambrosiaStationary, "ambrosiaStationary");
		LanguageRegistry.addName(ambrosiaStationary, "ambrosiaStationary");
		GameRegistry.registerBlock(manaFlowing, "manaFlowing");
		LanguageRegistry.addName(manaFlowing, "manaFlowing");
		GameRegistry.registerBlock(manaStationary, "manaStationary");
		LanguageRegistry.addName(manaStationary, "manaStationary");

		oreLevitite = (new BlockSkyOre(blockID++)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("skydimension:oreLevitite").setCreativeTab(SkyDimension.tab);
		blockLevitite = (new BlockOreStorage(blockID++)).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("skydimension:blockLevitite").setCreativeTab(SkyDimension.tab);
		oreSkylite = (new BlockSkyOre(blockID++)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("skydimension:oreSkylite").setCreativeTab(SkyDimension.tab);
		blockSkylite = (new BlockOreStorage(blockID++)).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("skydimension:blocSkylite").setCreativeTab(SkyDimension.tab);
		oreWelkinite = (new BlockSkyOre(blockID++)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("skydimension:oreWelkinite").setCreativeTab(SkyDimension.tab);
		blockWelkinite = (new BlockOreStorage(blockID++)).setHardness(3.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("skydimension:blockWelkinite").setCreativeTab(SkyDimension.tab);
		GameRegistry.registerBlock(oreLevitite, ORE_LEVITITE);
		LanguageRegistry.addName(oreLevitite, "Levitite Ore");
		OreDictionary.registerOre(ORE_LEVITITE, oreLevitite);
		MinecraftForge.setBlockHarvestLevel(oreLevitite, "pickaxe", 2);
		GameRegistry.registerBlock(blockLevitite, BLOCK_LEVITITE);
		LanguageRegistry.addName(blockLevitite, "Levitite Block");
		OreDictionary.registerOre(BLOCK_LEVITITE, blockLevitite);
		MinecraftForge.setBlockHarvestLevel(blockLevitite, "pickaxe", 2);

		GameRegistry.registerBlock(oreSkylite, ORE_SKYLITE);
		LanguageRegistry.addName(oreSkylite, "Skylite Ore");
		OreDictionary.registerOre(ORE_SKYLITE, oreSkylite);
		MinecraftForge.setBlockHarvestLevel(oreSkylite, "pickaxe", 1);
		GameRegistry.registerBlock(blockSkylite, BLOCK_SKYLITE);
		LanguageRegistry.addName(blockSkylite, "Skylite Block");
		OreDictionary.registerOre(BLOCK_SKYLITE, blockSkylite);
		MinecraftForge.setBlockHarvestLevel(blockSkylite, "pickaxe", 2);

		GameRegistry.registerBlock(oreWelkinite, ORE_WELKINITE);
		LanguageRegistry.addName(oreWelkinite, "Welkinite Ore");
		OreDictionary.registerOre(ORE_WELKINITE, oreWelkinite);
		MinecraftForge.setBlockHarvestLevel(oreWelkinite, "pickaxe", 2);
		GameRegistry.registerBlock(blockWelkinite, BLOCK_WELKINITE);
		LanguageRegistry.addName(blockWelkinite, "Welkinite Block");
		OreDictionary.registerOre(BLOCK_WELKINITE, blockWelkinite);
		MinecraftForge.setBlockHarvestLevel(blockWelkinite, "pickaxe", 2);

		teleportSkyStone = new BlockTeleportSky(blockID++).setHardness(0.5F).setResistance(10F).setUnlocalizedName("skydimension:teleportSky").setCreativeTab(SkyDimension.tab);
		teleportEmpyreanStone = new BlockTeleportEmpyrean(blockID++).setHardness(0.5F).setResistance(10F).setUnlocalizedName("skydimension:teleportEmpyrean").setCreativeTab(SkyDimension.tab);

		GameRegistry.registerBlock(teleportSkyStone, "TeleportSkyStone");
		LanguageRegistry.addName(teleportSkyStone, "Teleporter Stone (Sky)");
		GameRegistry.registerBlock(teleportEmpyreanStone, "TeleportEmpyreanStone");
		LanguageRegistry.addName(teleportEmpyreanStone, "Teleporter Stone (Empyrean)");

		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(skySapling), 1, 1, 100));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(skySapling), 1, 1, 100));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(skySapling), 1, 1, 100));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(skySapling), 1, 1, 100));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(skySapling), 1, 1, 100));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(skySapling), 1, 1, 100));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(skySapling), 1, 1, 100));
	}

}
