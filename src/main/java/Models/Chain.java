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
	 * @param totalRevenue Annual Revenue of chain
	 */
	public void setTotalRevenue(double totalRevenue) { this.totalRevenue = totalRevenue; }

	public List<Employee> getManagerList() {
		return this.managerList;
	}

	/**
	 *
	 * @param managerList List of Manager Employees
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

	public void viewBranches(){
		System.out.println("Branches:");
		for(int i = 0; i < branches.size(); i++){
			System.out.println(branches.get(i).getState() + ", " + branches.get(i).getCity());
		}
	}

	public void viewManagers(){
		System.out.println("Managers:");
		for(int i = 0; i < managerList.size(); i++){
			System.out.println(managerList.get(i).getName());
		}
	}

	public void displayOperations(){
		Scanner input = new Scanner(System.in);
		System.out.println("Chain Management...");
		System.out.println("Select from the following options");
		System.out.println("(1) Create a new branch");
		System.out.println("(2) View branches");
		System.out.println("(3) View Managers");
		int option = input.nextInt();

		switch (option) {
			case 1:
				this.createNewBranch();
				break;
			case 2:
				this.viewBranches();
				break;
			case 3:
				this.viewManagers();
				break;
		}
	}

	/**
	 *
	 * @param branchId id of branch to be deleted
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
	 * @param branches list of branches
	 */
	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

}