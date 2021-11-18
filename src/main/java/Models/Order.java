package Models;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 112 "model.ump"
// line 172 "model.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private boolean served;
  private int id;
//  private enum type;
  private String order;

  //Order Associations
  private final List<Recipe> recipes;
  private final List<Employee> employees;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(boolean aServed, int aId, String aOrder, Recipe... allRecipes)//(boolean aServed, int aId, enum aType, String aOrder, Recipe... allRecipes)
  {
    served = aServed;
    id = aId;
//    type = aType;
    order = aOrder;
    recipes = new ArrayList<Recipe>();
    boolean didAddRecipes = setRecipes(allRecipes);
    if (!didAddRecipes)
    {
      throw new RuntimeException("Unable to create Order, must have at least 1 recipes. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    employees = new ArrayList<Employee>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setServed(boolean aServed)
  {
    boolean wasSet = false;
    served = aServed;
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

  public boolean setType()//(enum aType)
  {
    boolean wasSet = false;
//    type = aType;
    wasSet = true;
    return wasSet;
  }

  public boolean setOrder(String aOrder)
  {
    boolean wasSet = false;
    order = aOrder;
    wasSet = true;
    return wasSet;
  }

  public boolean getServed()
  {
    return served;
  }

  public int getId()
  {
    return id;
  }

//  public enum getType()
//  {
//    return type;
//  }

  public String getOrder()
  {
    return order;
  }
  /* Code from template association_GetMany */
  public Recipe getRecipe(int index)
  {
    Recipe aRecipe = recipes.get(index);
    return aRecipe;
  }

  public List<Recipe> getRecipes()
  {
    List<Recipe> newRecipes = Collections.unmodifiableList(recipes);
    return newRecipes;
  }

  public int numberOfRecipes()
  {
    int number = recipes.size();
    return number;
  }

  public boolean hasRecipes()
  {
    boolean has = recipes.size() > 0;
    return has;
  }

  public int indexOfRecipe(Recipe aRecipe)
  {
    int index = recipes.indexOf(aRecipe);
    return index;
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
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfRecipesValid()
  {
    boolean isValid = numberOfRecipes() >= minimumNumberOfRecipes();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfRecipes()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addRecipe(Recipe aRecipe)
  {
    boolean wasAdded = false;
    if (recipes.contains(aRecipe)) { return false; }
    recipes.add(aRecipe);
    if (aRecipe.indexOfOrder(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRecipe.addOrder(this);
      if (!wasAdded)
      {
        recipes.remove(aRecipe);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeRecipe(Recipe aRecipe)
  {
    boolean wasRemoved = false;
    if (!recipes.contains(aRecipe))
    {
      return wasRemoved;
    }

    if (numberOfRecipes() <= minimumNumberOfRecipes())
    {
      return wasRemoved;
    }

    int oldIndex = recipes.indexOf(aRecipe);
    recipes.remove(oldIndex);
    if (aRecipe.indexOfOrder(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRecipe.removeOrder(this);
      if (!wasRemoved)
      {
        recipes.add(oldIndex,aRecipe);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setRecipes(Recipe... newRecipes)
  {
    boolean wasSet = false;
    ArrayList<Recipe> verifiedRecipes = new ArrayList<Recipe>();
    for (Recipe aRecipe : newRecipes)
    {
      if (verifiedRecipes.contains(aRecipe))
      {
        continue;
      }
      verifiedRecipes.add(aRecipe);
    }

    if (verifiedRecipes.size() != newRecipes.length || verifiedRecipes.size() < minimumNumberOfRecipes())
    {
      return wasSet;
    }

    ArrayList<Recipe> oldRecipes = new ArrayList<Recipe>(recipes);
    recipes.clear();
    for (Recipe aNewRecipe : verifiedRecipes)
    {
      recipes.add(aNewRecipe);
      if (oldRecipes.contains(aNewRecipe))
      {
        oldRecipes.remove(aNewRecipe);
      }
      else
      {
        aNewRecipe.addOrder(this);
      }
    }

    for (Recipe anOldRecipe : oldRecipes)
    {
      anOldRecipe.removeOrder(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addRecipeAt(Recipe aRecipe, int index)
  {  
    boolean wasAdded = false;
    if(addRecipe(aRecipe))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRecipes()) { index = numberOfRecipes() - 1; }
      recipes.remove(aRecipe);
      recipes.add(index, aRecipe);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveRecipeAt(Recipe aRecipe, int index)
  {
    boolean wasAdded = false;
    if(recipes.contains(aRecipe))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfRecipes()) { index = numberOfRecipes() - 1; }
      recipes.remove(aRecipe);
      recipes.add(index, aRecipe);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addRecipeAt(aRecipe, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfEmployees()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addEmployee(Employee aEmployee)
  {
    boolean wasAdded = false;
    if (employees.contains(aEmployee)) { return false; }
    employees.add(aEmployee);
    if (aEmployee.indexOfOrder(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aEmployee.addOrder(this);
      if (!wasAdded)
      {
        employees.remove(aEmployee);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeEmployee(Employee aEmployee)
  {
    boolean wasRemoved = false;
    if (!employees.contains(aEmployee))
    {
      return wasRemoved;
    }

    int oldIndex = employees.indexOf(aEmployee);
    employees.remove(oldIndex);
    if (aEmployee.indexOfOrder(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aEmployee.removeOrder(this);
      if (!wasRemoved)
      {
        employees.add(oldIndex,aEmployee);
      }
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
    ArrayList<Recipe> copyOfRecipes = new ArrayList<Recipe>(recipes);
    recipes.clear();
    for(Recipe aRecipe : copyOfRecipes)
    {
      aRecipe.removeOrder(this);
    }
    ArrayList<Employee> copyOfEmployees = new ArrayList<Employee>(employees);
    employees.clear();
    for(Employee aEmployee : copyOfEmployees)
    {
      if (aEmployee.numberOfOrders() <= Employee.minimumNumberOfOrders())
      {
        aEmployee.delete();
      }
      else
      {
        aEmployee.removeOrder(this);
      }
    }
  }

  // line 5 "model.ump"
  public List requires(){
    return new ArrayList();
  }


//  public String toString()
//  {
//    return super.toString() + "["+
//            "served" + ":" + getServed()+ "," +
//            "id" + ":" + getId()+ "," +
//            "order" + ":" + getOrder()+ "]" + System.getProperties().getProperty("line.separator") +
//            "  " + "type" + "=" + (getType() != null ? !getType().equals(this)  ? getType().toString().replaceAll("  ","    ") : "this" : "null");
//  }
}