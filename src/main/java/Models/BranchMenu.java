package Models;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 27 "model.ump"
// line 129 "model.ump"
// line 182 "model.ump"
public class BranchMenu
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //BranchMenu Associations
  private CorpMenu corpMenu;
  private Branch branch;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public BranchMenu(CorpMenu aCorpMenu, Branch aBranch)
  {
    boolean didAddCorpMenu = setCorpMenu(aCorpMenu);
    if (!didAddCorpMenu)
    {
      throw new RuntimeException("Unable to create branchMenus due to corpMenu. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (aBranch == null || aBranch.getBranchMenu() != null)
    {
      throw new RuntimeException("Unable to create BranchMenu due to aBranch. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    branch = aBranch;
  }

  public BranchMenu(CorpMenu aCorpMenu, String aAddressForBranch, Chain aChainForBranch, Stock aStockForBranch)
  {
    boolean didAddCorpMenu = setCorpMenu(aCorpMenu);
    if (!didAddCorpMenu)
    {
      throw new RuntimeException("Unable to create branchMenus due to corpMenu. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    branch = new Branch(aAddressForBranch, this, aChainForBranch, aStockForBranch);
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public CorpMenu getCorpMenu()
  {
    return corpMenu;
  }
  /* Code from template association_GetOne */
  public Branch getBranch()
  {
    return branch;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCorpMenu(CorpMenu aCorpMenu)
  {
    boolean wasSet = false;
    if (aCorpMenu == null)
    {
      return wasSet;
    }

    CorpMenu existingCorpMenu = corpMenu;
    corpMenu = aCorpMenu;
    if (existingCorpMenu != null && !existingCorpMenu.equals(aCorpMenu))
    {
      existingCorpMenu.removeBranchMenus(this);
    }
    corpMenu.addBranchMenus(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    CorpMenu placeholderCorpMenu = corpMenu;
    this.corpMenu = null;
    if(placeholderCorpMenu != null)
    {
      placeholderCorpMenu.removeBranchMenus(this);
    }
    Branch existingBranch = branch;
    branch = null;
    if (existingBranch != null)
    {
      existingBranch.delete();
    }
  }

  // line 31 "model.ump"
   public void add(Recipe first, float price){
    
  }

  // line 34 "model.ump"
  public boolean remove(Recipe arg0){
    return true;
  }

}