package Models;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 51 "model.ump"
// line 135 "model.ump"
// line 192 "model.ump"
public class CorpMenu {

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //CorpMenu Associations
    private Chain chain;
    private final List<Recipe> recipes;
    private final List<BranchMenu> branchMenus;
    private int minimumNumberOfRecipes;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public CorpMenu(Chain aChain, int minimumNumberOfRecipes) {
        if (aChain == null || aChain.getCorpMenu() != null) {
            throw new RuntimeException("Unable to create CorpMenu due to aChain. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        this.minimumNumberOfRecipes = minimumNumberOfRecipes;
        chain = aChain;
        recipes = new ArrayList<Recipe>();
        branchMenus = new ArrayList<BranchMenu>();
    }

    //------------------------
    // INTERFACE
    //------------------------
    /* Code from template association_GetOne */
    public Chain getChain() {
        return chain;
    }

    /* Code from template association_GetMany */
    public Recipe getRecipe(int index) {
        Recipe aRecipe = recipes.get(index);
        return aRecipe;
    }

    public List<Recipe> getRecipes() {
        List<Recipe> newRecipes = Collections.unmodifiableList(recipes);
        return newRecipes;
    }

    public int numberOfRecipes() {
        int number = recipes.size();
        return number;
    }

    public boolean hasRecipes() {
        boolean has = recipes.size() > 0;
        return has;
    }

    public int indexOfRecipe(Recipe aRecipe) {
        int index = recipes.indexOf(aRecipe);
        return index;
    }

    /* Code from template association_GetMany */
    public BranchMenu getBranchMenus(int index) {
        BranchMenu aBranchMenus = branchMenus.get(index);
        return aBranchMenus;
    }

    public List<BranchMenu> getBranchMenus() {
        List<BranchMenu> newBranchMenus = Collections.unmodifiableList(branchMenus);
        return newBranchMenus;
    }

    public int numberOfBranchMenus() {
        int number = branchMenus.size();
        return number;
    }

    public boolean hasBranchMenus() {
        boolean has = branchMenus.size() > 0;
        return has;
    }

    public int indexOfBranchMenus(BranchMenu aBranchMenus) {
        int index = branchMenus.indexOf(aBranchMenus);
        return index;
    }

    /* Code from template association_MinimumNumberOfMethod */
    public int getMinimumNumberOfRecipes() {
        return this.minimumNumberOfRecipes;
    }

    /* Code from template association_AddManyToOne */
    public Recipe addRecipe(String aName, float aPrice) {
        return new Recipe(aName, aPrice, this);
    }

    public boolean addRecipe(Recipe aRecipe) {
        boolean wasAdded = false;
        if (recipes.contains(aRecipe)) {
            return false;
        }
        CorpMenu existingCorpMenu = aRecipe.getCorpMenu();
        boolean isNewCorpMenu = existingCorpMenu != null && !this.equals(existingCorpMenu);
        if (isNewCorpMenu) {
            aRecipe.setCorpMenu(this);
        } else {
            recipes.add(aRecipe);
        }
        wasAdded = true;
        return wasAdded;
    }

    public boolean removeRecipe(Recipe aRecipe) {
        boolean wasRemoved = false;
        //Unable to remove aRecipe, as it must always have a corpMenu
        if (!this.equals(aRecipe.getCorpMenu())) {
            recipes.remove(aRecipe);
            wasRemoved = true;
        }
        return wasRemoved;
    }

    /* Code from template association_AddIndexControlFunctions */
    public boolean addRecipeAt(Recipe aRecipe, int index) {
        boolean wasAdded = false;
        if (addRecipe(aRecipe)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfRecipes()) {
                index = numberOfRecipes() - 1;
            }
            recipes.remove(aRecipe);
            recipes.add(index, aRecipe);
            wasAdded = true;
        }
        return wasAdded;
    }

    public boolean addOrMoveRecipeAt(Recipe aRecipe, int index) {
        boolean wasAdded = false;
        if (recipes.contains(aRecipe)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfRecipes()) {
                index = numberOfRecipes() - 1;
            }
            recipes.remove(aRecipe);
            recipes.add(index, aRecipe);
            wasAdded = true;
        } else {
            wasAdded = addRecipeAt(aRecipe, index);
        }
        return wasAdded;
    }

    /* Code from template association_MinimumNumberOfMethod */
    public static int minimumNumberOfBranchMenus() {
        return 0;
    }

    /* Code from template association_AddManyToOne */
    public BranchMenu addBranchMenus(Branch aBranch) {
        return new BranchMenu(this, aBranch);
    }

    public boolean addBranchMenus(BranchMenu aBranchMenus) {
        boolean wasAdded = false;
        if (branchMenus.contains(aBranchMenus)) {
            return false;
        }
        CorpMenu existingCorpMenu = aBranchMenus.getCorpMenu();
        boolean isNewCorpMenu = existingCorpMenu != null && !this.equals(existingCorpMenu);
        if (isNewCorpMenu) {
            aBranchMenus.setCorpMenu(this);
        } else {
            branchMenus.add(aBranchMenus);
        }
        wasAdded = true;
        return wasAdded;
    }

    public boolean removeBranchMenus(BranchMenu aBranchMenus) {
        boolean wasRemoved = false;
        //Unable to remove aBranchMenus, as it must always have a corpMenu
        if (!this.equals(aBranchMenus.getCorpMenu())) {
            branchMenus.remove(aBranchMenus);
            wasRemoved = true;
        }
        return wasRemoved;
    }

    /* Code from template association_AddIndexControlFunctions */
    public boolean addBranchMenusAt(BranchMenu aBranchMenus, int index) {
        boolean wasAdded = false;
        if (addBranchMenus(aBranchMenus)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfBranchMenus()) {
                index = numberOfBranchMenus() - 1;
            }
            branchMenus.remove(aBranchMenus);
            branchMenus.add(index, aBranchMenus);
            wasAdded = true;
        }
        return wasAdded;
    }

    public boolean addOrMoveBranchMenusAt(BranchMenu aBranchMenus, int index) {
        boolean wasAdded = false;
        if (branchMenus.contains(aBranchMenus)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfBranchMenus()) {
                index = numberOfBranchMenus() - 1;
            }
            branchMenus.remove(aBranchMenus);
            branchMenus.add(index, aBranchMenus);
            wasAdded = true;
        } else {
            wasAdded = addBranchMenusAt(aBranchMenus, index);
        }
        return wasAdded;
    }

    public void delete() {
        Chain existingChain = chain;
        chain = null;
        if (existingChain != null) {
            existingChain.delete();
        }
        for (int i = recipes.size(); i > 0; i--) {
            Recipe aRecipe = recipes.get(i - 1);
            aRecipe.delete();
        }
        for (int i = branchMenus.size(); i > 0; i--) {
            BranchMenu aBranchMenus = branchMenus.get(i - 1);
            aBranchMenus.delete();
        }
    }

    // line 55 "model.ump"
    public boolean add(Recipe first) {
        try {
            this.recipes.add(first);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // line 58 "model.ump"
    public boolean remove(Recipe recipeToDelete) {
        try {
            this.recipes.remove(recipeToDelete);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}