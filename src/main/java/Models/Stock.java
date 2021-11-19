package Models;

import java.util.List;

public class Stock {

	private List<Ingredient> availableIngredients;
	private int lowStockThreshold;

	public List<Ingredient> getAvailableIngredients() {
		return this.availableIngredients;
	}

	/**
	 * 
	 * @param availableIngredients
	 * @param newIngredient
	 */
	public void setAvailableIngredients(List<Ingredient> availableIngredients, Ingredient newIngredient) {
		// TODO - implement Stock.setAvailableIngredients
		throw new UnsupportedOperationException();
	}

	public int getLowStockThreshold() {
		return this.lowStockThreshold;
	}

	/**
	 * 
	 * @param lowStockThreshold
	 */
	public void setLowStockThreshold(int lowStockThreshold) {
		this.lowStockThreshold = lowStockThreshold;
	}

}