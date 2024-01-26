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
public class Payment {
    
    private int id;
    private String method;
    private double paymentAMT;
    private int orderID;
    
    public Payment() {
        
    }
    
    public Payment(double pay) {
        this.paymentAMT = pay;
    }
    
    public Payment(int id, String method, double amt, int oid) {
        
        this.id = id;
        this.method = method;
        this.paymentAMT = amt;
        this.orderID = oid;
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * @return the paymentAMT
     */
    public double getPaymentAMT() {
        return paymentAMT;
    }

    /**
     * @param paymentAMT the paymentAMT to set
     */
    public void setPaymentAMT(double paymentAMT) {
        this.paymentAMT = paymentAMT;
    }

    /**
     * @return the orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * @param orderID the orderID to set
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    
    
}
