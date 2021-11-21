package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static Models.PizzaOrder.State.*;


public class Order {

	private int orderId;
	private float total = 0;
	private int employeeId;
	private String status;
	private LocalDate date;
	private String customerName;
	private String customerPhoneNumber;
	private String type;
	private List<Recipe> order;
	final private PizzaOrder currState= new PizzaOrder();

	/**
	 * 
	 * @param employeeId the id of the employee who made this order
	 * @param customerName the name of the person ordering
	 * @param customerPhoneNumber the phone number to contact the person
	 * @param type order type from delivery,pickup, inhouse
	 * @param order the list of recipes ordered
	 */
	public Order(int employeeId, String customerName, String customerPhoneNumber, String type, List<Recipe> order) {
		this.employeeId=employeeId;
		this.customerName=customerName;
		this.customerPhoneNumber=customerPhoneNumber;
		this.type=type;
		this.order=order;
		this.status="open";
		this.date= LocalDate.now();
		this.orderId=ThreadLocalRandom.current().nextInt();
	}

	/*public static Order emptyOrder(){
		Scanner reader = new Scanner(System.in);
		System.out.println("what is the employeeID");
		int employeeId=reader.nextInt();
		System.out.println("what is the customername");
		String customerName=reader.next();
		System.out.println("what is the customerPhoneNumber");
		String customerPhoneNumber=reader.next();
		System.out.println("what is the order type(delivery,pickup, inhouse)");
		String type=reader.next();
		return new Order(employeeId,customerName,customerPhoneNumber,type,new ArrayList<>());
	} */
	/**
	 * 
	 * @param customerName whos order we wish to cancel
	 */
	public void cancelOrder(String customerName) {
		/* if(this.customerName==customerName){
		*	currState.
		*}
		*/
	}

	public double calculateTotal() {
		double sum=0;
		for(Recipe item:order){
			sum+=item.getPrice();
		}
		return sum;
	}

	public void runSM(Stock supply){
		Scanner reader = new Scanner(System.in);
		System.out.println("order with id:"+orderId+"has been created");
		List<Ingredient> cost =new ArrayList<>();
		for (Recipe res:order){
			cost.addAll(res.getIngredients());
		}
		if(supply.inStock(cost)){
			currState.orderCreated();
		}else {
			currState.outOfStock();
		}
		while(currState.getState() == Idle){
			System.out.println("deque item?(yes/no)");
			String responce=reader.next();
			if (responce.equals("yes")){
				currState.deQueueOrder();
			}
		}
		while (currState.getState()==Preparation){
			System.out.println("is order ready?(yes/no)");
			String responce=reader.next();
			if (responce.equals("yes")){
				if(supply.inStock(cost)){
					currState.orderReady();
					supply.remove(cost);
				}else {
					currState.outOfStock();
				}
			}
		}
		if(currState.getState()==OrderType){
			switch (type) {
				case "delivery" ->{ currState.deliverOrder();
					this.status="closed";}
				case "pickup" ->{ currState.pickupOrder();
				this.status="closed";}
				case "inhouse" ->{ currState.serveOrder();
					this.status="closed";}
			}
		}
	}
	public void addRecipe(Recipe recipe){
		order.add(recipe);

	}


}