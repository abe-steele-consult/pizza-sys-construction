package Models;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 38 "model.ump"
// line 162 "model.ump"
// line 187 "model.ump"
public class Chain
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Chain Associations
  private final List<Branch> branchs;
  private CorpMenu corpMenu;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Chain(CorpMenu aCorpMenu)
  {
    branchs = new ArrayList<Branch>();
    if (aCorpMenu == null || aCorpMenu.getChain() != null)
    {
      throw new RuntimeException("Unable to create Chain due to aCorpMenu. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    corpMenu = aCorpMenu;
  }

  public Chain()
  {
    branchs = new ArrayList<Branch>();
    corpMenu = new CorpMenu(this);
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Branch getBranch(int index)
  {
    Branch aBranch = branchs.get(index);
    return aBranch;
  }

  public List<Branch> getBranchs()
  {
    List<Branch> branches = Collections.unmodifiableList(branchs);
    return branches;
  }

  public int numberOfBranchs()
  {
    int number = branchs.size();
    return number;
  }

  public boolean hasBranchs()
  {
    boolean has = branchs.size() > 0;
    return has;
  }

  public int indexOfBranch(Branch aBranch)
  {
    int index = branchs.indexOf(aBranch);
    return index;
  }
  /* Code from template association_GetOne */
  public CorpMenu getCorpMenu()
  {
    return corpMenu;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfBranchs()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Branch addBranch(String aAddress, BranchMenu aBranchMenu, Stock aStock)
  {
    return new Branch(aAddress, aBranchMenu, this, aStock);
  }

  public boolean addBranch(Branch aBranch)
  {
    boolean wasAdded = false;
    if (branchs.contains(aBranch)) { return false; }
    Chain existingChain = aBranch.getChain();
    boolean isNewChain = existingChain != null && !this.equals(existingChain);
    if (isNewChain)
    {
      aBranch.setChain(this);
    }
    else
    {
      branchs.add(aBranch);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeBranch(Branch aBranch)
  {
    boolean wasRemoved = false;
    //Unable to remove aBranch, as it must always have a chain
    if (!this.equals(aBranch.getChain()))
    {
      branchs.remove(aBranch);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addBranchAt(Branch aBranch, int index)
  {  
    boolean wasAdded = false;
    if(addBranch(aBranch))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBranchs()) { index = numberOfBranchs() - 1; }
      branchs.remove(aBranch);
      branchs.add(index, aBranch);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveBranchAt(Branch aBranch, int index)
  {
    boolean wasAdded = false;
    if(branchs.contains(aBranch))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfBranchs()) { index = numberOfBranchs() - 1; }
      branchs.remove(aBranch);
      branchs.add(index, aBranch);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addBranchAt(aBranch, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=branchs.size(); i > 0; i--)
    {
      Branch aBranch = branchs.get(i - 1);
      aBranch.delete();
    }
    CorpMenu existingCorpMenu = corpMenu;
    corpMenu = null;
    if (existingCorpMenu != null)
    {
      existingCorpMenu.delete();
    }
  }

  // line 42 "model.ump"
  public List<Employee> getManagers(){
    return new ArrayList<Employee>();
  }

  // line 44 "model.ump"
  public int numBranch(){
    return 0;
  }

  // line 46 "model.ump"
   public void addBranch(String Branch){
    
  }

  // line 48 "model.ump"
   public boolean reamoveBranch(String Branch){
    return true;
  }

}