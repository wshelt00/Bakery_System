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
public class BakeryItems {
    
    private int bakeryItemId;
    private String bakeryItemName;
    private String bakeryItemDesciption;
    private double bakeryItemPrice;


    public BakeryItems() {
        
    }
    
    public BakeryItems(String itemName) {
        this.bakeryItemName = itemName;
    }
    
    public BakeryItems(String name, double price) {
        
        this.bakeryItemName = name;
        this.bakeryItemPrice = price;
        
    }
    
    public BakeryItems(int id, String name, String desc, double price) {
        
        this.bakeryItemId = id;
        this.bakeryItemName = name;
        this.bakeryItemDesciption = desc;
        this.bakeryItemPrice = price;
        
    }
    
    public int getBakeryItemId() {
        return bakeryItemId;
    }


    public void setBakeryItemId(int bakeryItemId) {
        this.bakeryItemId = bakeryItemId;
    }


    public String getBakeryItemName() {
        return bakeryItemName;
    }


    public void setBakeryItemName(String bakeryItemName) {
        this.bakeryItemName = bakeryItemName;
    }


    public String getBakeryItemDesciption() {
        return bakeryItemDesciption;
    }


    public void setBakeryItemDesciption(String bakeryItemDesciption) {
        this.bakeryItemDesciption = bakeryItemDesciption;
    }


    public double getBakeryItemPrice() {
        return bakeryItemPrice;
    }


    public void setBakeryItemPrice(double bakeryItemPrice) {
        this.bakeryItemPrice = bakeryItemPrice;
    }
    
    
}
