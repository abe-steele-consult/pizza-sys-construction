import Models.*;

import java.util.*;

public class PizzaMain {
    static Chain chain = new Chain();
    static CorpMenu corpMenu = new CorpMenu();

    public static void main(String[]args) {
        displayMenu();
    }

    private static void displayMenu() {
        while (true) {
            System.out.println("Welcome to the chain management system");
            System.out.println("Choose the option you would like to use");
            System.out.println("(1) Chain options");
            System.out.println("(2) Corp Menu options");
            System.out.println("(3) Branch options");
            System.out.println("(4) Employee options");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch(option) {
                case 1 -> chain.displayOperations();
                case 2 -> corpMenu.displayOperations();
                case 3 -> {
                    if(chain.getBranches() == null) {
                        System.out.println("No branches yet please add a new branch in chain options");
                        break;
                    }
                    getBranchToManage().displayOperations();
                    break;
                }
                case 4 -> {
                    System.out.println("Enter employee name:");
                    String nameEntry = scanner.next();

                    for (int i = 0; i < chain.getBranches().size(); i++){
                        for (int j = 0; j < chain.getBranches().get(i).getEmployeeList().size(); j++){
                            if (chain.getBranches().get(i).getEmployeeList().get(j).getName().equals(nameEntry)){
                                chain.getBranches().get(i).getEmployeeList().get(j).displayOperations();
                            }
                        }
                    }
                    System.out.println("Employee not found");
                }
                default -> System.out.println("Not an option");
            }
        }
    }

    private static Branch getBranchToManage() {
        Map<Integer, Branch> branchDictionary = new HashMap<>();
        int optionIdx = 1;
        System.out.println("Which branch do you wish to manage");
        for (Branch b : chain.getBranches()) {
            System.out.println("(" + optionIdx + ") BranchId: " + b.getBranchId() + " State: " + b.getState() + " City: " + b.getCity());
            branchDictionary.put(optionIdx, b);
            optionIdx += 1;
        }

        Scanner scanner = new Scanner(System.in);

        Integer option = scanner.nextInt();
        Branch branch = branchDictionary.get(option);
        return branch;
    }
}
