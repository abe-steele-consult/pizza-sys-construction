package Models;

import java.util.List;

public class Branch {

	private int branchId;
	private String state;
	private String city;
	private float revenue;
	private List<Employee> employeeList;

	public int getBranchId() {
		return this.branchId;
	}

	public float getRevenue() {
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
	 * @param String
	 * @param emloyeeList
	 */
	public Branch(List<Branch> branches, String state, int city, int String, List<Employee> emloyeeList) {
		// TODO - implement Branch.Branch
		throw new UnsupportedOperationException();
	}

}