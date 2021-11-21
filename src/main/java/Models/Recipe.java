package Models;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Recipe {

	private String name;
	private List<Ingredient> ingredients;
	private double price;

	/**
	 *
	 * @param name the name of this good
	 * @param price the sales price of this good
	 * @param ingredients the things needed to make this recipe
	 */
	public Recipe(String name, double price, List<Ingredient> ingredients) {
		this.name=name;
		this.price=price;
		this.ingredients=ingredients;
	}

	public String getName() {
		return this.name;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public double getPrice() {
		return price;
	}


	public void displayOperations() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to recipe operations");
		System.out.println("Please select the option you desire to perform on this recipe.");
		System.out.println("(1) Get name");
		System.out.println("(2) Get ingredients");
		System.out.println("(3) Get price");
		int option = reader.nextInt();

		switch (option) {
			case 1 -> System.out.println(this.getName());
			case 2 -> this.ingredients.stream().forEach(e -> {
				System.out.println("Ingredient: " + e.getName());
				System.out.println("Avg. Price: " + e.getPrice());
			});
			case 3 -> System.out.println(this.getPrice());
			default -> System.out.println("Not an option");
		}

		reader.close();
	}
}