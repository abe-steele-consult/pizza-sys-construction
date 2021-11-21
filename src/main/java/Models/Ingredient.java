package Models;

public class Ingredient {

	private String name;
	private double price;



	/**
	 *
	 * @param name Name of ingredient
	 * @param price Price of this ingredient
	 */
	public Ingredient(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}