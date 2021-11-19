package Models;

import java.util.List;

public class CorpMenu {

	private List<Recipe> recipes;

	public List<Recipe> getRecipes() {
		return this.recipes;
	}

	/**
	 *
	 * @param recipe
	 */
	public boolean addRecipe(Recipe recipe) {
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

	/**
	 *
	 * @param recipeName
	 */
	public boolean removeRecipe(String recipeName) throws Exception {
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

}