package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chain {

	private List<Employee> managerList;
	private double totalRevenue;
	private List<Branch> branches;

	public Chain() {
		this.branches = new ArrayList();
	}

	public double getTotalRevenue() { return totalRevenue; }

	/**
	 *
	 * @param totalRevenue
	 */
	public void setTotalRevenue(double totalRevenue) { this.totalRevenue = totalRevenue; }

	public List<Employee> getManagerList() {
		return this.managerList;
	}

	/**
	 *
	 * @param managerList
	 */
	public void setManagerList(List<Employee> managerList) {
		this.managerList = managerList;
	}

	public boolean createNewBranch() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Create New Branch");
		System.out.println("Enter State");
		String state = reader.next();
		System.out.println("Enter city");
		String city = reader.next();
		Branch branch = new Branch(this.branches, state, city, 0.0, new ArrayList<>());
		this.branches.add(branch);
		return true;
	}

	/**
	 *
	 * @param branchId
	 */
	public boolean deleteBranch(int branchId) {
		Branch removeObject = this.branches.stream().filter(b -> b.getBranchId() == branchId).findAny().orElse(null);
		this.branches.remove(removeObject);
		return true;
	}

	public List<Branch> getBranches() {
		return this.branches;
	}

	/**
	 *
	 * @param branches
	 */
	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

}