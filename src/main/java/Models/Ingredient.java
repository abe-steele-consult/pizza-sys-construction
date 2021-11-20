package Models;

public class Ingredient {

	private String name;
	private int count;
	private float price;

	/**
	 * 
	 * @param name Name of ingredient
	 */
	public void getIngredientCount(String name, Stock stock) {
		// TODO - implement Ingredient.getIngredientCount
		for (int i = 0; i < stock.getAvailableIngredients().size(); i++){
			if (stock.getAvailableIngredients().get(i).name.equals(name)){
				System.out.println(name + " count is: " + stock.getAvailableIngredients().get(i).count);
				//return stock.getAvailableIngredients().get(i).count;
			}
		}
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name Name of ingredient
	 * @param count Count of available ingredients of this type
	 * @param price Price of this ingredient
	 */
	public Ingredient(String name, int count, float price) {
		this.name = name;
		this.count = count;
		this.price = price;
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return name;
	}
	public int getCount() {
		return count;
	}
	public float getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}