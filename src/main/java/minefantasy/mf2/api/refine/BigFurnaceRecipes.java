package minefantasy.mf2.api.refine;

import java.util.HashMap;

import minefantasy.mf2.api.helpers.CustomToolHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class BigFurnaceRecipes 
{
	public static HashMap<String, BigFurnaceRecipes>recipeList = new HashMap<String, BigFurnaceRecipes>();
	
	public static BigFurnaceRecipes addRecipe(Block input, ItemStack output, int tier)
	{
		return addRecipe(new ItemStack(input, 1, OreDictionary.WILDCARD_VALUE), output, tier);
	}
	public static BigFurnaceRecipes addRecipe(Item input, ItemStack output, int tier)
	{
		return addRecipe(new ItemStack(input, 1, OreDictionary.WILDCARD_VALUE), output, tier);
	}
	public static BigFurnaceRecipes addRecipe(ItemStack input, ItemStack output, int tier)
	{
		BigFurnaceRecipes recipe = new BigFurnaceRecipes(input, output, tier);
		recipeList.put(CustomToolHelper.getReferenceName(input), recipe);
		return recipe;
	}
	public static BigFurnaceRecipes getResult(ItemStack input)
	{
		if(input == null)return null;
		
		BigFurnaceRecipes specific = recipeList.get(CustomToolHelper.getReferenceName(input));
		if(specific != null)return specific;
		
		return recipeList.get(CustomToolHelper.getReferenceName(input, "any"));
	}
	
	public final ItemStack result;
	public final int tier;
	public BigFurnaceRecipes(ItemStack input, ItemStack output, int tier)
	{
		this.result = output;
		this.tier = tier;
	}
}
