package Models;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class BranchMenu {

	private List<Recipe> menuItems;

	/**
	 * 
	 * @param corpMenu
	 */
	public Recipe addRecipe(CorpMenu corpMenu) {
		System.out.println("Add new recipe in branch menu");
		Recipe corpRecipeToAdd = this.getRecipeFromCorpMenu(corpMenu);

		if(menuItems.contains(corpRecipeToAdd)) {
			System.out.println("Recipe exists already");
			return corpRecipeToAdd;
		}

		menuItems.add(corpRecipeToAdd);
		System.out.println("Recipe added");
		return corpRecipeToAdd;
	}

	public boolean removeRecipe(CorpMenu corpMenu) {
		System.out.println("Remove recipe from branch menu");
		Recipe corpRecipeToRemove = this.getRecipeFromCorpMenu(corpMenu);
		if(menuItems.contains(corpRecipeToRemove)) {
			System.out.println("Recipe does not exist in this branch");
			return false;
		}

		menuItems.add(corpRecipeToRemove);
		System.out.println("Recipe removed");
		return true;
	}

	/**
	 * 
	 * @param recipe
	 */
	public Recipe getRecipe(Recipe recipe) {
		return this.menuItems.stream().filter(r -> r == recipe).findAny().orElse(null);
	}


	private Recipe getRecipeFromCorpMenu(CorpMenu corpMenu) {
		System.out.println("Choose recipe from corp menu");
		Scanner reader = new Scanner(System.in);
		HashMap<AtomicInteger, Recipe> recipeOptions = new HashMap<>();
		AtomicInteger optionIdx = new AtomicInteger(1);

		corpMenu.getRecipes().stream().forEach(r -> {
			System.out.println(optionIdx + " - " + r.getName());
			recipeOptions.put(optionIdx, r);
			optionIdx.addAndGet(1);
		});

		int option = reader.nextInt();

		Recipe corpRecipeToAdd = recipeOptions.get(option);
		reader.close();
		return corpRecipeToAdd;
	}

	public void displayOperations(CorpMenu corpMenu) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to branch menu for branch");
		System.out.println("Please select the option you desire to perform on this branch menu.");
		System.out.println("(1) Get menu items");
		System.out.println("(2) Add recipe");
		System.out.println("(3) Remove recipe");
		int option = reader.nextInt();

		switch (option) {
			case 1:
				this.menuItems.stream().forEach(i -> {
					System.out.println(i.getName());
				});
				break;
			case 2:
				this.addRecipe(corpMenu);
				break;
			case 3:
				this.removeRecipe(corpMenu);
				break;
			default:
				System.out.println("Not an option");
				break;
		}

		reader.close();
	}
}