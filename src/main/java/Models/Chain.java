package Models;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/


import java.util.*;

// line 38 "model.ump"
// line 162 "model.ump"
// line 187 "model.ump"
public class Chain {

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Chain Associations
    private List<Branch> branches;
    private CorpMenu corpMenu;
    private int minimumNumber;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Chain(CorpMenu aCorpMenu, int minimumNumber) {
        branches = new ArrayList<Branch>();
        this.minimumNumber = minimumNumber;
        if (aCorpMenu == null || aCorpMenu.getChain() != null) {
            throw new RuntimeException("Unable to create Chain due to aCorpMenu. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
        }
        corpMenu = aCorpMenu;
    }

    //------------------------
    // INTERFACE
    //------------------------
    /* Code from template association_GetMany */
    public Branch getBranch(int index) {
        Branch aBranch = branches.get(index);
        return aBranch;
    }

    public List<Branch> getBranches() {
        List<Branch> branches = Collections.unmodifiableList(this.branches);
        return branches;
    }

    public int numberOfBranches() {
        int number = branches.size();
        return number;
    }

    public boolean hasBranches() {
        boolean has = branches.size() > 0;
        return has;
    }

    public int indexOfBranch(Branch aBranch) {
        int index = branches.indexOf(aBranch);
        return index;
    }

    /* Code from template association_GetOne */
    public CorpMenu getCorpMenu() {
        return corpMenu;
    }

    /* Code from template association_MinimumNumberOfMethod */
    public int minimumNumberOfBranches() {
        return this.minimumNumber;
    }

    /* Code from template association_AddManyToOne */
    public Branch addBranch(String aAddress, BranchMenu aBranchMenu, Stock aStock) {
        var newBranch = new Branch(aAddress, aBranchMenu, this, aStock);
        this.branches.add(newBranch);
        return newBranch;
    }

    public boolean addBranch(Branch aBranch) {
        boolean wasAdded = false;
        if (branches.contains(aBranch)) {
            return false;
        }
        Chain existingChain = aBranch.getChain();
        boolean isNewChain = existingChain != null && !this.equals(existingChain);
        if (isNewChain) {
            aBranch.setChain(this);
        } else {
            branches.add(aBranch);
        }
        wasAdded = true;
        return wasAdded;
    }

    public boolean removeBranch(Branch aBranch) {
        boolean wasRemoved = false;
        //Unable to remove aBranch, as it must always have a chain
        if (!this.equals(aBranch.getChain())) {
            branches.remove(aBranch);
            wasRemoved = true;
        }
        return wasRemoved;
    }

    /* Code from template association_AddIndexControlFunctions */
    public boolean addBranchAt(Branch aBranch, int index) {
        boolean wasAdded = false;
        if (addBranch(aBranch)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfBranches()) {
                index = numberOfBranches() - 1;
            }
            branches.remove(aBranch);
            branches.add(index, aBranch);
            wasAdded = true;
        }
        return wasAdded;
    }

    public boolean addOrMoveBranchAt(Branch aBranch, int index) {
        boolean wasAdded = false;
        if (branches.contains(aBranch)) {
            if (index < 0) {
                index = 0;
            }
            if (index > numberOfBranches()) {
                index = numberOfBranches() - 1;
            }
            branches.remove(aBranch);
            branches.add(index, aBranch);
            wasAdded = true;
        } else {
            wasAdded = addBranchAt(aBranch, index);
        }
        return wasAdded;
    }

    public void delete() {
        for (int i = branches.size(); i > 0; i--) {
            Branch aBranch = branches.get(i - 1);
            aBranch.delete();
        }
        CorpMenu existingCorpMenu = corpMenu;
        corpMenu = null;
        if (existingCorpMenu != null) {
            existingCorpMenu.delete();
        }
    }

    // line 42 "model.ump"
    public List<Employee> getManagers() {
        return new ArrayList<Employee>();
    }

    // line 44 "model.ump"
    public int numBranch() {
        return 0;
    }

    // line 46 "model.ump"
    public void addBranch(String Branch) {

    }

    // line 48 "model.ump"
    public boolean removeBranch(String Branch) {
        return true;
    }

}