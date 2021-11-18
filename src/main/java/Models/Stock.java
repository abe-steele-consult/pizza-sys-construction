package Models;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;
import Models.Ingredient;

// line 79 "model.ump"
// line 167 "model.ump"
public class Stock
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Stock Associations
  private Branch branch;
  private final List<Ingredient> ingredients;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Stock(Branch aBranch)
  {
    if (aBranch == null || aBranch.getStock() != null)
    {
      throw new RuntimeException("Unable to create Stock due to aBranch. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    branch = aBranch;
    ingredients = new ArrayList<Ingredient>();
  }

  public Stock(String aAddressForBranch, BranchMenu aBranchMenuForBranch, Chain aChainForBranch)
  {
    branch = new Branch(aAddressForBranch, aBranchMenuForBranch, aChainForBranch, this);
    ingredients = new ArrayList<Ingredient>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Branch getBranch()
  {
    return branch;
  }
  /* Code from template association_GetMany */
  public Ingredient getIngredient(int index)
  {
    Ingredient aIngredient = ingredients.get(index);
    return aIngredient;
  }

  public List<Ingredient> getIngredients()
  {
    List<Ingredient> newIngredients = Collections.unmodifiableList(ingredients);
    return newIngredients;
  }

  public int numberOfIngredients()
  {
    int number = ingredients.size();
    return number;
  }

  public boolean hasIngredients()
  {
    boolean has = ingredients.size() > 0;
    return has;
  }

  public int indexOfIngredient(Ingredient aIngredient)
  {
    int index = ingredients.indexOf(aIngredient);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfIngredients()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addIngredient(Ingredient aIngredient)
  {
    boolean wasAdded = false;
    if (ingredients.contains(aIngredient)) { return false; }
    ingredients.add(aIngredient);
    if (aIngredient.indexOfStock(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aIngredient.addStock(this);
      if (!wasAdded)
      {
        ingredients.remove(aIngredient);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeIngredient(Ingredient aIngredient)
  {
    boolean wasRemoved = false;
    if (!ingredients.contains(aIngredient))
    {
      return wasRemoved;
    }

    int oldIndex = ingredients.indexOf(aIngredient);
    ingredients.remove(oldIndex);
    if (aIngredient.indexOfStock(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aIngredient.removeStock(this);
      if (!wasRemoved)
      {
        ingredients.add(oldIndex,aIngredient);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addIngredientAt(Ingredient aIngredient, int index)
  {  
    boolean wasAdded = false;
    if(addIngredient(aIngredient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIngredients()) { index = numberOfIngredients() - 1; }
      ingredients.remove(aIngredient);
      ingredients.add(index, aIngredient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIngredientAt(Ingredient aIngredient, int index)
  {
    boolean wasAdded = false;
    if(ingredients.contains(aIngredient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIngredients()) { index = numberOfIngredients() - 1; }
      ingredients.remove(aIngredient);
      ingredients.add(index, aIngredient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIngredientAt(aIngredient, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Branch existingBranch = branch;
    branch = null;
    if (existingBranch != null)
    {
      existingBranch.delete();
    }
    ArrayList<Ingredient> copyOfIngredients = new ArrayList<Ingredient>(ingredients);
    ingredients.clear();
    for(Ingredient aIngredient : copyOfIngredients)
    {
      aIngredient.removeStock(this);
    }
  }

  // line 83 "model.ump"
   public void add(Ingredient first, int quanity){
    
  }

  // line 86 "model.ump"
  public boolean remove(Ingredient arg0, int quanity){
    return true;
  }

  // line 88 "model.ump"
  public boolean has(List<Ingredient> request){
    return true;
  }
}