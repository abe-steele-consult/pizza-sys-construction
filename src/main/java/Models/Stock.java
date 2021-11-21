package Models;

import java.util.*;

public class Stock {

	private HashMap<Ingredient,Integer> availableIngredients;
	private int lowStockThreshold;

	public Stock(){

	}
	public List<Ingredient> getAvailableIngredients() {
		return new ArrayList<Ingredient>(availableIngredients.keySet());
	}

	/**
	 * 
	 * @param count the number of this ingredient
	 * @param newIngredient what ingredient is to be added to this stock
	 */
	public void addAvailableIngredients(int count, Ingredient newIngredient) {
		if(availableIngredients.containsKey(newIngredient)) {
			int old = availableIngredients.get(newIngredient);
			availableIngredients.put(newIngredient, old + count);
		}else availableIngredients.put(newIngredient,count);
	}

	public int getLowStockThreshold() {
		return this.lowStockThreshold;
	}

	/**
	 * 
	 * @param lowStockThreshold the point at which we say ingredients are "low"
	 */
	public void setLowStockThreshold(int lowStockThreshold) {
		this.lowStockThreshold = lowStockThreshold;
	}
	public ArrayList<Ingredient> getlowStock(){
		ArrayList<Ingredient> lowstock=new ArrayList<>();
		List<Ingredient> list1
				= new ArrayList<>(availableIngredients.keySet());
		List<Integer> list2
				= new ArrayList<>(availableIngredients.values());
		int i=0;
		for (Integer k:list2){
			if(k<=lowStockThreshold){
				lowstock.add(list1.get(i));
			}
			i++;
		}
		return lowstock;
	}
	public boolean inStock(List<Ingredient> required){
		HashMap<Ingredient,Integer> curr=new HashMap<>();
		for (Ingredient i:required){
			if(curr.containsKey(i)){
				curr.put(i,curr.get(i)+1);
			}else {
				curr.put(i,1);
			}
		}
		Set<Ingredient> unquie=curr.keySet();
		for (Ingredient i:unquie){
			if (availableIngredients.get(i) < curr.get(i)) { return false;}
		}
		return true;
	}
	public void remove(List<Ingredient> required){
		if(inStock(required)){
			HashMap<Ingredient,Integer> curr=new HashMap<>();
			for (Ingredient i:required){
				if(curr.containsKey(i)){
					curr.put(i,curr.get(i)+1);
				}else {
					curr.put(i,1);
				}
			}
			Set<Ingredient> unquie=curr.keySet();
			for (Ingredient i:unquie) {
				availableIngredients.put(i, availableIngredients.get(i) - curr.get(i));
			}
		}
	}
	public static Stock EmptyStock(){
		System.out.println("empty stock is created");
		return new Stock();
	}
	public void displayOperations(){
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to stock menu for branch");
		System.out.println("Please select the option you desire to perform on this branch menu.");
		System.out.println("(1) Get stock");
		System.out.println("(2) Add ingredient");
		System.out.println("(3) Remove ingredient");
		int option = reader.nextInt();
		String name;
		List<Ingredient> ingredients;

		switch (option) {
			case 1 -> {
				ingredients = new ArrayList<Ingredient>(availableIngredients.keySet());
				for (Ingredient i : ingredients) {
					System.out.println("there are " + availableIngredients.get(i) + "of type" + i.getName() + "in this stock");
				}
			}
			case 2 -> {
				System.out.println("what is the name of the ingredient");
				name = reader.next();
				System.out.println("how many are you adding?");
				int count = reader.nextInt();
				System.out.println("how many are they worth?");
				Double price = reader.nextDouble();
				addAvailableIngredients(count, new Ingredient(name, price));
			}
			case 3 -> {
				System.out.println("what is the name of the ingredient");
				name = reader.next();
				System.out.println("how many are you removeing");
				option = reader.nextInt();
				ingredients = new ArrayList<Ingredient>(availableIngredients.keySet());
				for (Ingredient i : ingredients) {
					if (i.getName().equals(name)) {
						int curr = availableIngredients.get(i) - 1;
						if (curr < 0) {
							System.out.println("we dont have that many,we have removed all that exist");
						} else {
							availableIngredients.put(i, curr);
						}
					}
				}
			}
			default -> System.out.println("Not an option");
		}
	}
}