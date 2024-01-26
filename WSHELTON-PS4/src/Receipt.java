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
public class Receipt {

    /**
     * @return the orID
     */
    public int getOrID() {
        return orID;
    }

    /**
     * @param orID the orID to set
     */
    public void setOrID(int orID) {
        this.orID = orID;
    }
    
    private int orID;
    private String fname;
    private int quantity;
    private String itemName;
    private double itemPrice;
    
    public Receipt() {
        
    }
    
    public Receipt(int id, String item, double price) {
        
        this.orID  = id;
        this.itemName = item;
        this.itemPrice = price;
        
    }
    
    public Receipt(int id,String name,String item,int quant,double price) {
        
        this.orID = id;
        this.fname = name;
        this.quantity = quant;
        this.itemName = item;
        this.itemPrice = price;
        
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemPrice
     */
    public double getItemPrice() {
        return itemPrice;
    }

    /**
     * @param itemPrice the itemPrice to set
     */
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    
    
    
}
