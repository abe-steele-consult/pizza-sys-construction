package Models;

import java.util.List;

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
		this.branchId = branches.size();
		this.state = state;
		this.city = city;
		this.revenue = revenue != 0.0 ? revenue : 0.0;
		this.employeeList = employeeList;
	}

}