package Models;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 91 "model.ump"
// line 149 "model.ump"
public class Ingredient
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ingredient Attributes
  private String name;
  private float price;

  //Ingredient Associations
  private List<Recipe> recipes;
  private List<Stock> stocks;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ingredient(String aName, float aPrice)
  {
    name = aName;
    price = aPrice;
    recipes = new ArrayList<Recipe>();
    stocks = new ArrayList<Stock>();
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

  public boolean setPrice(float aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public float getPrice()
  {
    return price;
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
  public Stock getStock(int index)
  {
    Stock aStock = stocks.get(index);
    return aStock;
  }

  public List<Stock> getStocks()
  {
    List<Stock> newStocks = Collections.unmodifiableList(stocks);
    return newStocks;
  }

  public int numberOfStocks()
  {
    int number = stocks.size();
    return number;
  }

  public boolean hasStocks()
  {
    boolean has = stocks.size() > 0;
    return has;
  }

  public int indexOfStock(Stock aStock)
  {
    int index = stocks.indexOf(aStock);
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
    if (aRecipe.indexOfIngredient(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aRecipe.addIngredient(this);
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
    if (aRecipe.indexOfIngredient(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aRecipe.removeIngredient(this);
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
        aNewRecipe.addIngredient(this);
      }
    }

    for (Recipe anOldRecipe : oldRecipes)
    {
      anOldRecipe.removeIngredient(this);
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
  public static int minimumNumberOfStocks()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addStock(Stock aStock)
  {
    boolean wasAdded = false;
    if (stocks.contains(aStock)) { return false; }
    stocks.add(aStock);
    if (aStock.indexOfIngredient(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aStock.addIngredient(this);
      if (!wasAdded)
      {
        stocks.remove(aStock);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeStock(Stock aStock)
  {
    boolean wasRemoved = false;
    if (!stocks.contains(aStock))
    {
      return wasRemoved;
    }

    int oldIndex = stocks.indexOf(aStock);
    stocks.remove(oldIndex);
    if (aStock.indexOfIngredient(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aStock.removeIngredient(this);
      if (!wasRemoved)
      {
        stocks.add(oldIndex,aStock);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStockAt(Stock aStock, int index)
  {  
    boolean wasAdded = false;
    if(addStock(aStock))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStocks()) { index = numberOfStocks() - 1; }
      stocks.remove(aStock);
      stocks.add(index, aStock);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStockAt(Stock aStock, int index)
  {
    boolean wasAdded = false;
    if(stocks.contains(aStock))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStocks()) { index = numberOfStocks() - 1; }
      stocks.remove(aStock);
      stocks.add(index, aStock);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStockAt(aStock, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Recipe> copyOfRecipes = new ArrayList<Recipe>(recipes);
    recipes.clear();
    for(Recipe aRecipe : copyOfRecipes)
    {
      if (aRecipe.numberOfIngredients() <= Recipe.minimumNumberOfIngredients())
      {
        aRecipe.delete();
      }
      else
      {
        aRecipe.removeIngredient(this);
      }
    }
    ArrayList<Stock> copyOfStocks = new ArrayList<Stock>(stocks);
    stocks.clear();
    for(Stock aStock : copyOfStocks)
    {
      aStock.removeIngredient(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "price" + ":" + getPrice()+ "]";
  }
}