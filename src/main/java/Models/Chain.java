package Models;

import java.util.ArrayList;
import java.util.List;

public class Chain {

	private List<Employee> managerList;
	private double totalRevenue;
	private List<Branch> branches;

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

	/**
	 *
	 * @param branch
	 */
	public boolean createNewBranch(Branch branch) {
		if(this.branches == null) {
			this.branches = new ArrayList<>();
			this.branches.add(branch);
			return true;
		}
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