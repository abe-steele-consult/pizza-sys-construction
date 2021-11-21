package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Branch {

	private int branchId;
	private String state;
	private String city;
	private double revenue;
	private List<Employee> employeeList;
	private Stock stockroom;
	private List<Order> pastOrders= new ArrayList<Order>();
	private BranchMenu menu=new BranchMenu();


	public int getBranchId() {
		return this.branchId;
	}

	public double getRevenue() {
		return this.revenue;
	}

	public List<Employee> getEmployeeList() {
		return this.employeeList;
	}

	/**
	 *
	 * @param branches
	 * @param state
	 * @param city
	 * @param employeeList
	 */
	public Branch(List<Branch> branches, String state, String city, double revenue, List<Employee> employeeList) {
		this.branchId = branches != null? 1: branches.size() + 1;
		this.state = state;
		this.city = city;
		this.revenue = revenue != 0.0 ? revenue : 0.0;
		this.employeeList = employeeList;
		this.stockroom= Stock.EmptyStock();
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public void addEmployee() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Add Employee to branch " + this.branchId);
		System.out.println("Enter name");
		String name = reader.next();

		System.out.println("Enter salary");
		float salary = reader.nextFloat();

		System.out.println("Enter type");
		String type = reader.next();

		System.out.println("Enter role");
		String role = reader.next();


		Employee employee = new Employee(name, salary, type, role);
		this.employeeList.add(employee);
	}

	public void displayOperations(CorpMenu corpMenu) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Welcome to branch management for branch: " + this.branchId);
		System.out.println("Please select the option you desire to perform on this branch.");
		System.out.println("(1) Get state");
		System.out.println("(2) Get city");
		System.out.println("(3) Add employee");
		System.out.println("(4) Get employee list.");
		System.out.println("(5) manage stockroom");
		System.out.println("(6) make an order");
		System.out.println("(7) manage Branch menu");
		int option = reader.nextInt();

		switch (option) {
			case 1 -> System.out.println(this.getState());
			case 2 -> System.out.println(this.getCity());
			case 3 -> this.addEmployee();
			case 4 -> this.getEmployeeList().stream().forEach(e -> {
				System.out.println("Employee: " + e.getName());
				System.out.println("Role: " + e.getRole());
				System.out.println("Type: " + e.getType());
			});
			case 5 -> stockroom.displayOperations();
			case 6 ->{
				pastOrders.add(Order.emptyOrder().runSM(stockroom));
			}
			case 7 ->{
				menu.displayOperations(corpMenu);
			}
			default -> System.out.println("Not an option");
		}

	}

	public Stock getStockroom() {
		return stockroom;
	}

	public void setStockroom(Stock stockroom) {
		this.stockroom = stockroom;
	}
}