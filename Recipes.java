package skydimension;

import skydimension.item.EnumSkyItem;
import skydimension.item.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipesTools;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void init() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.itemSky, 1, EnumSkyItem.nuggetIron.ordinal()), new Object[] {
			"DDD",
			"DDD",
			"DDD",
			Character.valueOf('D'), Items.DUST_IRON
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.ingotIron), new Object[] {
			"NNN",
			"NNN",
			"NNN",
			Character.valueOf('N'), Items.NUGGET_IRON
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.goldNugget), new Object[] {
			"DDD",
			"DDD",
			"DDD",
			Character.valueOf('D'), Items.DUST_GOLD
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Block.sand), new Object[] {
			"DDD",
			"DDD",
			"DDD",
			Character.valueOf('D'), Items.DUST_SAND
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.ambrosia), new Object[] {
			"RRR",
			"RGR",
			"RRR",
			Character.valueOf('R'), Items.redFruit,
			Character.valueOf('G'), Item.glassBottle,
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.bloodyPotion), new Object[] {
			"BBB",
			"BGB",
			"BBB",
			Character.valueOf('B'), Items.bloodFruit,
			Character.valueOf('G'), Item.glassBottle,
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.ambrosia), new Object[] {
			"AAA",
			"ABA",
			"AAA",
			Character.valueOf('A'), Items.ambrosia,
			Character.valueOf('B'), Item.bucketEmpty,
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.bloodyPotion), new Object[] {
			"bbb",
			"bBb",
			"bbb",
			Character.valueOf('b'), Items.bloodyPotion,
			Character.valueOf('B'), Item.bucketEmpty,
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.ambrosia), new Object[] {
			"AAA",
			"ABA",
			"AAA",
			Character.valueOf('A'), Items.ambrosia,
			Character.valueOf('B'), Items.bucketWoodEmpty,
		}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.bloodyPotion), new Object[] {
			"bbb",
			"bBb",
			"bbb",
			Character.valueOf('b'), Items.bloodyPotion,
			Character.valueOf('B'), Items.bucketWoodEmpty,
		}));
		GameRegistry.addRecipe(new ItemStack(Item.cake, 1), new Object[] {
			"AAA",
			"BEB",
			"CCC",
			'A', Items.bucketWoodMilk,
			'B', Item.sugar,
			'C', Item.wheat,
			'E', Item.egg,
			});

		String[][] recipePatterns = new String[][] {{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
		Object[][] recipeItems  = new Object[][] {
				{Items.GEM_LEVITIA, Items.GEM_SKYLITE, Items.GEM_WELKINIA},
				{Items.pickaxeLevitia, Items.pickaxeSkylite, Items.pickaxeWelkinia},
				{Items.shovelLevitia, Items.shovelSkylite, Items.shovelWelkinia},
				{Items.axeLevitia, Items.axeSkylite, Items.axeWelkinia},
				{Items.hoeLevitia, Items.hoeSkylite, Items.hoeWelkinia}};

        for (int i = 0; i < recipeItems[0].length; ++i)
        {
            Object object = recipeItems[0][i];

            for (int j = 0; j < recipeItems.length - 1; ++j)
            {
                Item item = (Item)recipeItems[j + 1][i];
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(item), new Object[] {
                	recipePatterns[j], '#', Item.stick, 'X', object}));
            }
        }

        GameRegistry.addRecipe(new ItemStack(Item.shears), new Object[] {" #", "# ", '#', new ItemStack(Items.itemSky, 1, EnumSkyItem.edgeLeaf.ordinal())});

	}
}
