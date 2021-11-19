import Models.*;

import java.util.ArrayList;
import java.util.List;

public class PizzaMain {

    public static void main(String[]args) {
        Chain chain = new Chain();
        List<Employee> ep_employees = new ArrayList<>();
        ep_employees.add(new Employee("Geoff",34000, "Driver","Employee"));
        ep_employees.add(new Employee("John",45000, "Serve","Employee"));
        ep_employees.add(new Employee("Geoff",70000, "Manager","Manager"));
        chain.createNewBranch();
        for (Branch b: chain.getBranches()) {
            System.out.println("Id " + b.getBranchId());
            System.out.println("State " + b.getState());
            System.out.println("City " + b.getCity());
        }
    }
}
