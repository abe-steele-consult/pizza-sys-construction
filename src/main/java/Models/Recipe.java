package Models;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

	public void displayOperations() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to recipe operations");
		System.out.println("Please select the option you desire to perform on this recipe.");
		System.out.println("(1) Get name");
		System.out.println("(2) Get ingredients");
		System.out.println("(3) Get price");
		System.out.println("(4) Delete");
		int option = reader.nextInt();

		switch (option) {
			case 1:
				System.out.println(this.getName());
				break;
			case 2:
				this.ingredients.stream().forEach(e -> {
					System.out.println("Ingredient: " + e.getName());
					System.out.println("Needed: " + e.getCount());
					System.out.println("Avg. Price: " + e.getPrice());
				});
				break;
			case 3:
				System.out.println(this.getPrice());
				break;
			case 4:
				if (this.setDeleted() == true) {
					System.out.println("Recipe Deleted");
				} else {
					System.out.println("Not deleted");
				}
				break;
			default:
				System.out.println("Not an option");
				break;
		}

		reader.close();
	}
}