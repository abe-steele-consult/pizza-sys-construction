package Models;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 14 "model.ump"
// line 118 "model.ump"
// line 177 "model.ump"
public class Branch
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Branch Attributes
  private String address;

  //Branch Associations
  private BranchMenu branchMenu;
  private Chain chain;
  private final List<Employee> employees;
  private Stock stock;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Branch(String aAddress, BranchMenu aBranchMenu, Chain aChain, Stock aStock)
  {
    address = aAddress;
    if (aBranchMenu == null || aBranchMenu.getBranch() != null)
    {
      throw new RuntimeException("Unable to create Branch due to aBranchMenu. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    branchMenu = aBranchMenu;
    boolean didAddChain = setChain(aChain);
    if (!didAddChain)
    {
      throw new RuntimeException("Unable to create branch due to chain. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    employees = new ArrayList<Employee>();
    if (aStock == null || aStock.getBranch() != null)
    {
      throw new RuntimeException("Unable to create Branch due to aStock. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    stock = aStock;
  }

  public Branch(String aAddress, CorpMenu aCorpMenuForBranchMenu, Chain aChain)
  {
    address = aAddress;
    branchMenu = new BranchMenu(aCorpMenuForBranchMenu, this);
    boolean didAddChain = setChain(aChain);
    if (!didAddChain)
    {
      throw new RuntimeException("Unable to create branch due to chain. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    employees = new ArrayList<Employee>();
    stock = new Stock(this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public String getAddress()
  {
    return address;
  }
  /* Code from template association_GetOne */
  public BranchMenu getBranchMenu()
  {
    return branchMenu;
  }
  /* Code from template association_GetOne */
  public Chain getChain()
  {
    return chain;
  }
  /* Code from template association_GetMany */
  public Employee getEmployee(int index)
  {
    Employee aEmployee = employees.get(index);
    return aEmployee;
  }

  public List<Employee> getEmployees()
  {
    List<Employee> newEmployees = Collections.unmodifiableList(employees);
    return newEmployees;
  }

  public int numberOfEmployees()
  {
    int number = employees.size();
    return number;
  }

  public boolean hasEmployees()
  {
    boolean has = employees.size() > 0;
    return has;
  }

  public int indexOfEmployee(Employee aEmployee)
  {
    int index = employees.indexOf(aEmployee);
    return index;
  }
  /* Code from template association_GetOne */
  public Stock getStock()
  {
    return stock;
  }
  /* Code from template association_SetOneToMany */
  public boolean setChain(Chain aChain)
  {
    boolean wasSet = false;
    if (aChain == null)
    {
      return wasSet;
    }

    Chain existingChain = chain;
    chain = aChain;
    if (existingChain != null && !existingChain.equals(aChain))
    {
      existingChain.removeBranch(this);
    }
    chain.addBranch(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfEmployees()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Employee addEmployee(String aName, int aId, int aSalary, float aTimeWorked, Order... allOrders)
        //(String aName, int aId, int aSalary, float aTimeWorked, enum aType, enum aRole, Order... allOrders)
  {
    return new Employee(aName, aId, aSalary, aTimeWorked, this, allOrders);
  }

  public boolean addEmployee(Employee aEmployee)
  {
    boolean wasAdded = false;
    if (employees.contains(aEmployee)) { return false; }
    Branch existingBranch = aEmployee.getBranch();
    boolean isNewBranch = existingBranch != null && !this.equals(existingBranch);
    if (isNewBranch)
    {
      aEmployee.setBranch(this);
    }
    else
    {
      employees.add(aEmployee);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeEmployee(Employee aEmployee)
  {
    boolean wasRemoved = false;
    //Unable to remove aEmployee, as it must always have a branch
    if (!this.equals(aEmployee.getBranch()))
    {
      employees.remove(aEmployee);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addEmployeeAt(Employee aEmployee, int index)
  {  
    boolean wasAdded = false;
    if(addEmployee(aEmployee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEmployees()) { index = numberOfEmployees() - 1; }
      employees.remove(aEmployee);
      employees.add(index, aEmployee);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEmployeeAt(Employee aEmployee, int index)
  {
    boolean wasAdded = false;
    if(employees.contains(aEmployee))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEmployees()) { index = numberOfEmployees() - 1; }
      employees.remove(aEmployee);
      employees.add(index, aEmployee);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEmployeeAt(aEmployee, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    BranchMenu existingBranchMenu = branchMenu;
    branchMenu = null;
    if (existingBranchMenu != null)
    {
      existingBranchMenu.delete();
    }
    Chain placeholderChain = chain;
    this.chain = null;
    if(placeholderChain != null)
    {
      placeholderChain.removeBranch(this);
    }
    for(int i=employees.size(); i > 0; i--)
    {
      Employee aEmployee = employees.get(i - 1);
      aEmployee.delete();
    }
    Stock existingStock = stock;
    stock = null;
    if (existingStock != null)
    {
      existingStock.delete();
    }
  }

  // line 17 "model.ump"
   public void add(String employee){
    
  }

  // line 19 "model.ump"
  public boolean remove(String employee){
    return true;
  }


  public String toString()
  {
    return super.toString() + "["+
            "address" + ":" + getAddress()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "branchMenu = "+(getBranchMenu()!=null?Integer.toHexString(System.identityHashCode(getBranchMenu())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "chain = "+(getChain()!=null?Integer.toHexString(System.identityHashCode(getChain())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "stock = "+(getStock()!=null?Integer.toHexString(System.identityHashCode(getStock())):"null");
  }
}