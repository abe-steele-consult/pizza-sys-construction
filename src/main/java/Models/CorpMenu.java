package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CorpMenu {

	private List<Recipe> recipes;

	public List<Recipe> getRecipes() {
		return this.recipes;
	}

	public boolean addRecipe() {
		System.out.println("Add Recipe to corp");
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter recipe name");
		String name = reader.next();
		System.out.println("Enter recipe price");
		float price = reader.nextFloat();
		System.out.println("Enter recipe ingredients");
		List<Ingredient> ingredients = captureRecipeIngredients();

		Recipe recipe = new Recipe(name, price,  ingredients);
		try {
			if (this.recipes.contains(recipe)) {
				throw new Exception("Recipe exists.");
			}
			this.recipes.add(recipe);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	/**
	 *
	 * @param name
	 */
	public Recipe getRecipe(String name) {
		return this.recipes.stream().filter(r -> r.getName() == name).findAny().orElse(null);
	}

	public boolean removeRecipe() throws Exception {
		System.out.println("Remove recipe");
		System.out.println("Enter recipe name");
		Scanner reader = new Scanner(System.in);
		String recipeName = reader.next();
		Recipe recipeToRemove = this.recipes.stream().filter(r -> r.getName() == recipeName).findFirst().orElse(null);
		if(recipeToRemove == null) {
			throw new Exception("Recipe exists already.");
		}
		try {
			this.recipes.remove(recipeToRemove);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private List<Ingredient> captureRecipeIngredients() {
		int addIngredientOption = 1;
		List<Ingredient> ingredients = new ArrayList<>();
		Scanner reader = new Scanner(System.in);
		while (addIngredientOption == 1) {
			System.out.println("Enter ingredient");
			System.out.println("Enter name");
			String name = reader.next();
			System.out.println("Enter quantity needed for recipe");
			int count = reader.nextInt();
			Ingredient ingredient = new Ingredient(name, 0.0);
			for (int i = 0; i < count; i++) {
				ingredients.add(ingredient);
			}

			System.out.println("Do you wish to add a new ingredient? (1) Yes | (2) No");
			addIngredientOption = reader.nextInt();
		}
		reader.close();
		return ingredients;
	}

}