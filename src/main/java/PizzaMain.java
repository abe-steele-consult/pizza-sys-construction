import Models.*;

import java.util.ArrayList;
import java.util.List;

public class PizzaMain {

    public static void main(String[]args) {
        Chain chain = new Chain();
        List<Branch> branches = new ArrayList<>();
        List<Employee> ep_employees = new ArrayList<>();
        ep_employees.add(new Employee("Geoff",34000, "Driver","Employee"));
        ep_employees.add(new Employee("John",45000, "Serve","Employee"));
        ep_employees.add(new Employee("Geoff",70000, "Manager","Manager"));
        Branch ep_branch = new Branch(branches, "TX", "El Paso", 0.0, ep_employees);

        chain.createNewBranch(ep_branch);
        for (Branch b: chain.getBranches()) {
            System.out.println(b.getBranchId());
        }
    }
}
