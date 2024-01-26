/************************************************************
* name William Shelton
* user uafs415
* date 5 November 2021
* assign Problem Set 5
************************************************************/

import com.ibm.db2.jcc.am.Connection;
import com.ibm.db2.jcc.am.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William Shelton
 */
public class PaymentDAO implements UADataAccessObject<Payment>{
    
    private List<Payment> amt = new ArrayList<Payment>();

    @Override
    public void insert(Payment item) {
        
       String user = "uafs415";
       String pass = "UApass815";
       String url = "jdbc:db2://data.cs.uafs.edu:55000/CS2043";
       
       PreparedStatement pstmt, pstmt2;
       
       try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
            return; //terminate method if driver not found
        }
        
        try {
            
            Connection con = (Connection) DriverManager.getConnection(url, user, pass);
            
            String sql2 = "SELECT PAYMENT_ID FROM PAYMENT WHERE PAYMENT_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO PAYMENT (PAYMENT_ID,PAYMENT_METHOD,PAYMENT_AMOUNT,ORDER_ID) VALUES (DEFAULT,?,?,(SELECT o.ORDER_ID FROM ORDERS o JOIN CUSTOMERS c ON c.CUST_ID = o.CUSTOMERS_CUST_ID WHERE CUST_FIRST_NAME = ?))";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, item.getMethod());
            pstmt.setDouble(2, item.getPaymentAMT());
            pstmt.setInt(3, item.getOrderID());
                                   
            pstmt.execute();
                        
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
            
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void insertPay(Payment item, Customers cust) {
        
       String user = "uafs415";
       String pass = "UApass815";
       String url = "jdbc:db2://data.cs.uafs.edu:55000/CS2043";
       
       PreparedStatement pstmt, pstmt2;
       
       try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
            return; //terminate method if driver not found
        }
        
        try {
            
            Connection con = (Connection) DriverManager.getConnection(url, user, pass);
            
            String sql2 = "SELECT PAYMENT_ID FROM PAYMENT WHERE PAYMENT_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO PAYMENT (PAYMENT_ID,PAYMENT_METHOD,PAYMENT_AMOUNT,ORDER_ID) VALUES (DEFAULT,?,?,(SELECT o.ORDER_ID FROM ORDERS o JOIN CUSTOMERS c ON c.CUST_ID = o.CUSTOMERS_CUST_ID WHERE CUST_FIRST_NAME = ?))";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, item.getMethod());
            pstmt.setDouble(2, item.getPaymentAMT());
            pstmt.setString(3, cust.getFName());
                                   
            pstmt.execute();
                        
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
            
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void delete(Payment item) {
        
    }

    @Override
    public List<Payment> getItem() {
        
        String user = "uafs415";
       String pass = "UApass815";
       String url = "jdbc:db2://data.cs.uafs.edu:55000/CS2043";
       
       PreparedStatement pstmt;
       
       try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        try {
       
            Connection con = (Connection) DriverManager.getConnection(url, user, pass);
            
            String sql2 = "SELECT * FROM PAYMENT";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
           
          if(rs != null) {
            while(rs.next()) {
                
                Payment a = new Payment(rs.getInt("PAYMENT_ID"),rs.getString("PAYMENT_METHOD"),rs.getDouble("PAYMENT_AMOUNT"),rs.getInt("ORDER_ID"));
                
                amt.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return amt;
        
    }
    
    public void update(Payment item, BakeryItems bake) {
        
       String user = "uafs415";
       String pass = "UApass815";
       String url = "jdbc:db2://data.cs.uafs.edu:55000/CS2043";
       
       PreparedStatement pstmt, pstmt2;
       
       try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
            return; //terminate method if driver not found
        }
        
        try {
            
            Connection con = (Connection) DriverManager.getConnection(url, user, pass);
            
            String sql2 = "SELECT TOTAL_PRICE FROM AMOUNTDUE";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "UPDATE RECEIPT SET TOTAL_PRICE = TOTAL_PRICE - ? WHERE BAKERY_ITEM_NAME = ?";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setDouble(1, item.getPaymentAMT());
            pstmt.setString(2, bake.getBakeryItemName());
                                    
            pstmt.execute();
            
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
            
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    
    
}
