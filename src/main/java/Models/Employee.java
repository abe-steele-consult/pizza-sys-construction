package Models;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.util.*;

// line 64 "model.ump"
// line 143 "model.ump"
public class Employee
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Employee Attributes
  private String name;
  private int id;
  private int salary;
  private Long timeWorked;
  private LocalTime timeIn;
  private LocalTime timeOut;
//  private enum type;
//  private enum role;

  //Employee Associations
  private final List<Order> orders;
  private Branch branch;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Employee(String aName, int aId, int aSalary, Branch aBranch, Order... allOrders)
  //(String aName, int aId, int aSalary, float aTimeWorked, enum aType, enum aRole, Branch aBranch, Order... allOrders)
  {
    name = aName;
    if (aId <= 99999 && aId > 0){
      id = aId;
    }else{
      System.out.println("Id is of the incorrect format");
    }
    if (aSalary >= 15100){
      salary = aSalary;
    }else{
      System.out.println("Salary is too low");
    }
//    type = aType;
//    role = aRole;
    orders = new ArrayList<Order>();
    boolean didAddOrders = setOrders(allOrders);
    if (!didAddOrders)
    {
      throw new RuntimeException("Unable to create Employee, must have at least 1 orders. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddBranch = setBranch(aBranch);
    if (!didAddBranch)
    {
      throw new RuntimeException("Unable to create employee due to branch. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  public void clockIn(){
    LocalTime inTime = LocalTime.now();
    this.setTimeIn(inTime);
  }

  public void clockOut(){
    LocalTime outTime = LocalTime.now();
    LocalTime inTime = this.getTimeIn();

    Long timeWorked = inTime.until(outTime, MINUTES);
    this.setTimeWorked(timeWorked);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setSalary(int aSalary)
  {
    boolean wasSet = false;
    salary = aSalary;
    wasSet = true;
    return wasSet;
  }

  public boolean setTimeWorked(Long aTimeWorked)
  {
    boolean wasSet = false;
    timeWorked = aTimeWorked;
    wasSet = true;
    return wasSet;
  }

  public boolean setTimeIn(LocalTime aTimeIn)
  {
    boolean wasSet = false;
    timeIn = aTimeIn;
    wasSet = true;
    return wasSet;
  }

  public boolean setTimeOut(LocalTime aTimeOut)
  {
    boolean wasSet = false;
    timeOut = aTimeOut;
    wasSet = true;
    return wasSet;
  }

  public boolean setType()//(enum aType)
  {
    boolean wasSet = false;
//    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setRole()//(enum aRole)
  {
    boolean wasSet = false;
//    role = aRole;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public int getId()
  {
    return id;
  }

  public int getSalary()
  {
    return salary;
  }

  public Long getTimeWorked()
  {
    return timeWorked;
  }

  public LocalTime getTimeIn(){return timeIn;}

  public LocalTime getTimeOut(){return timeOut;}

  //  public enum getType()
//  {
//    return enum;
//  }
//
//  public enum getRole()
//  {
//    return role;
//  }
  /* Code from template association_GetMany */
  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }
  /* Code from template association_GetOne */
  public Branch getBranch()
  {
    return branch;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfOrdersValid()
  {
    boolean isValid = numberOfOrders() >= minimumNumberOfOrders();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfOrders()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    orders.add(aOrder);
    if (aOrder.indexOfEmployee(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aOrder.addEmployee(this);
      if (!wasAdded)
      {
        orders.remove(aOrder);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    if (!orders.contains(aOrder))
    {
      return wasRemoved;
    }

    if (numberOfOrders() <= minimumNumberOfOrders())
    {
      return wasRemoved;
    }

    int oldIndex = orders.indexOf(aOrder);
    orders.remove(oldIndex);
    if (aOrder.indexOfEmployee(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aOrder.removeEmployee(this);
      if (!wasRemoved)
      {
        orders.add(oldIndex,aOrder);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setOrders(Order... newOrders)
  {
    boolean wasSet = false;
    ArrayList<Order> verifiedOrders = new ArrayList<Order>();
    for (Order aOrder : newOrders)
    {
      if (verifiedOrders.contains(aOrder))
      {
        continue;
      }
      verifiedOrders.add(aOrder);
    }

    if (verifiedOrders.size() != newOrders.length || verifiedOrders.size() < minimumNumberOfOrders())
    {
      return wasSet;
    }

    ArrayList<Order> oldOrders = new ArrayList<Order>(orders);
    orders.clear();
    for (Order aNewOrder : verifiedOrders)
    {
      orders.add(aNewOrder);
      if (oldOrders.contains(aNewOrder))
      {
        oldOrders.remove(aNewOrder);
      }
      else
      {
        aNewOrder.addEmployee(this);
      }
    }

    for (Order anOldOrder : oldOrders)
    {
      anOldOrder.removeEmployee(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    else
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setBranch(Branch aBranch)
  {
    boolean wasSet = false;
    if (aBranch == null)
    {
      return wasSet;
    }

    Branch existingBranch = branch;
    branch = aBranch;
    if (existingBranch != null && !existingBranch.equals(aBranch))
    {
      existingBranch.removeEmployee(this);
    }
    branch.addEmployee(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Order> copyOfOrders = new ArrayList<Order>(orders);
    orders.clear();
    for(Order aOrder : copyOfOrders)
    {
      aOrder.removeEmployee(this);
    }
    Branch placeholderBranch = branch;
    this.branch = null;
    if(placeholderBranch != null)
    {
      placeholderBranch.removeEmployee(this);
    }
  }

  // line 67 "model.ump"
  public void clockIn(float time){

  }

  // line 69 "model.ump"
  public void clockOut(float time){

  }


//  public String toString()
//  {
//    return super.toString() + "["+
//            "name" + ":" + getName()+ "," +
//            "id" + ":" + getId()+ "," +
//            "salary" + ":" + getSalary()+ "," +
//            "timeWorked" + ":" + getTimeWorked()+ "]" + System.getProperties().getProperty("line.separator") +
//            "  " + "type" + "=" + (getType() != null ? !getType().equals(this)  ? getType().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
//            "  " + "role" + "=" + (getRole() != null ? !getRole().equals(this)  ? getRole().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
//            "  " + "branch = "+(getBranch()!=null?Integer.toHexString(System.identityHashCode(getBranch())):"null");
//  }
}