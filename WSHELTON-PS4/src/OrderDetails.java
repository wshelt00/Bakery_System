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
public class OrderDetails {
    
    private int detailsId;
    private int orderId;
    private int bakeryItemId;
    private int quantity;
    
    public OrderDetails() {
        
    }
    
    public OrderDetails(int id, int oid, int bid, int quant) {
        
        this.detailsId = id;
        this.orderId = oid;
        this.bakeryItemId = bid;
        this.quantity = quant;
        
    }

    /**
     * @return the detailsId
     */
    public int getDetailsId() {
        return detailsId;
    }

    /**
     * @param detailsId the detailsId to set
     */
    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the bakeryItemId
     */
    public int getBakeryItemId() {
        return bakeryItemId;
    }

    /**
     * @param bakeryItemId the bakeryItemId to set
     */
    public void setBakeryItemId(int bakeryItemId) {
        this.bakeryItemId = bakeryItemId;
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
    
    
}
