/************************************************************
* name William Shelton
* user uafs415
* date 5 November 2021
* assign Problem Set 5
************************************************************/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William Shelton
 */
public class Recipe {
    
    private int recipeID;
    private int bakeryItemID;
    private int invID;
    private int QtyNeeded;
    
    public Recipe() {
        
    }
    
    public Recipe(int qneed) {
        this.QtyNeeded = qneed;
    }
    
    public Recipe(int id, int bId, int invId, int qtyNeeded) {
        
        this.recipeID = id;
        this.bakeryItemID = bId;
        this.invID = invId;
        this.QtyNeeded = qtyNeeded;
        
    }

    /**
     * @return the recipeID
     */
    public int getRecipeID() {
        return recipeID;
    }

    /**
     * @param recipeID the recipeID to set
     */
    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    /**
     * @return the bakeryItemID
     */
    public int getBakeryItemID() {
        return bakeryItemID;
    }

    /**
     * @param bakeryItemID the bakeryItemID to set
     */
    public void setBakeryItemID(int bakeryItemID) {
        this.bakeryItemID = bakeryItemID;
    }

    /**
     * @return the invID
     */
    public int getInvID() {
        return invID;
    }

    /**
     * @param invID the invID to set
     */
    public void setInvID(int invID) {
        this.invID = invID;
    }

    /**
     * @return the intQtyNeeded
     */
    public int getQtyNeeded() {
        return QtyNeeded;
    }

    /**
     * @param intQtyNeeded the intQtyNeeded to set
     */
    public void setQtyNeeded(int QtyNeeded) {
        this.QtyNeeded = QtyNeeded;
    }
    
}
