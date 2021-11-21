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

	public boolean removeRecipe() {
		System.out.println("Remove recipe");
		System.out.println("Enter recipe name");
		Scanner reader = new Scanner(System.in);
		String recipeName = reader.next();
		Recipe recipeToRemove = this.recipes.stream().filter(r -> r.getName() == recipeName).findFirst().orElse(null);
		if(recipeToRemove == null) {
			System.out.println("Recipe exists already.");
			return false;
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
		return ingredients;
	}

	public void displayOperations() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to corp menu for your chain");
		System.out.println("Please select an option.");
		System.out.println("(1) Get menu items");
		System.out.println("(2) Add recipe");
		System.out.println("(3) Remove recipe");
		int option = reader.nextInt();

		switch (option) {
			case 1 -> this.recipes.stream().forEach(i -> {
				System.out.println(i.getName());
			});
			case 2 -> this.addRecipe();
			case 3 -> this.removeRecipe();
			default -> System.out.println("Not an option");
		}
	}
}