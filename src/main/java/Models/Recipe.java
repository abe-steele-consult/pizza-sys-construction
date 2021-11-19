package Models;

import java.util.Date;
import java.util.List;

public class Recipe {

	private String name;
	private List<Ingredient> ingredients;
	private int price;
	private int deleted;

	/**
	 *
	 * @param name
	 * @param price
	 * @param deleted
	 * @param ingredients
	 */
	public Recipe(String name, float price, Date deleted, List<Ingredient> ingredients) {
		// TODO - implement Recipe.Recipe
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return this.name;
	}

	public List<Ingredient> getIngredients() {
		// TODO - implement Recipe.getIngredients
		throw new UnsupportedOperationException();
	}

	public float getPrice() {
		// TODO - implement Recipe.getPrice
		throw new UnsupportedOperationException();
	}

	public boolean setDeleted() {
		// TODO - implement Recipe.setDeleted
		throw new UnsupportedOperationException();
	}

}