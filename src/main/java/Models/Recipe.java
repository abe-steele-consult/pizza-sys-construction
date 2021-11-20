package Models;

import java.util.Date;
import java.util.List;

public class Recipe {

	private String name;
	private List<Ingredient> ingredients;
	private float price;
	private Date deleted;

	/**
	 *
	 * @param name
	 * @param price
	 * @param deleted
	 * @param ingredients
	 */
	public Recipe(String name, float price, Date deleted, List<Ingredient> ingredients) {
		this.name = name;
		this.price = price;
		this.deleted = null;
		this.ingredients = ingredients;
	}

	public String getName() {
		return this.name;
	}

	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public float getPrice() {
		return this.price;
	}

	public boolean setDeleted() {
		try {
			deleted = new Date();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

}