package Models;

import java.util.List;
import java.util.Scanner;

public class Branch {

	private int branchId;
	private String state;
	private String city;
	private double revenue;
	private List<Employee> employeeList;

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
	 * @param employeeList
	 */
	public Branch(List<Branch> branches, String state, String city, double revenue, List<Employee> employeeList) {
		this.branchId = branches != null? 1: branches.size() + 1;
		this.state = state;
		this.city = city;
		this.revenue = revenue != 0.0 ? revenue : 0.0;
		this.employeeList = employeeList;
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

		reader.close();
	}
}