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
public class Inventory {
    
    private int inventoryId;
    private String inventoryName;
    private String inventoryDescription;
    private int quantityOnHand;
    private int reorderedAmount;
    private double reorderedPrice;
    
    public Inventory() {
       
    }
    
    public Inventory(int qoh) {
        this.quantityOnHand = qoh;
    }
    
    public Inventory(int id, String name, String desc, int qoh, int reamt, double price) {
        
        this.inventoryId = id;
        this.inventoryName = name;
        this.inventoryDescription = desc;
        this.quantityOnHand = qoh;
        this.reorderedAmount = reamt;
        this.reorderedPrice = price;
        
    }

    /**
     * @return the inventoryId
     */
    public int getInventoryId() {
        return inventoryId;
    }

    /**
     * @param inventoryId the inventoryId to set
     */
    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    /**
     * @return the inventoryName
     */
    public String getInventoryName() {
        return inventoryName;
    }

    /**
     * @param inventoryName the inventoryName to set
     */
    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    /**
     * @return the inventoryDescription
     */
    public String getInventoryDescription() {
        return inventoryDescription;
    }

    /**
     * @param inventoryDescription the inventoryDescription to set
     */
    public void setInventoryDescription(String inventoryDescription) {
        this.inventoryDescription = inventoryDescription;
    }

    /**
     * @return the quantityOnHand
     */
    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    /**
     * @param quantityOnHand the quantityOnHand to set
     */
    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    /**
     * @return the reorderedAmount
     */
    public int getReorderedAmount() {
        return reorderedAmount;
    }

    /**
     * @param reorderedAmount the reorderedAmount to set
     */
    public void setReorderedAmount(int reorderedAmount) {
        this.reorderedAmount = reorderedAmount;
    }

    /**
     * @return the reorderedPrice
     */
    public double getReorderedPrice() {
        return reorderedPrice;
    }

    /**
     * @param reorderedPrice the reorderedPrice to set
     */
    public void setReorderedPrice(double reorderedPrice) {
        this.reorderedPrice = reorderedPrice;
    }
    
}
