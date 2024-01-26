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
public class OrderDetailsDAO implements UADataAccessObject<OrderDetails>{
    
    private List<OrderDetails> details = new ArrayList<OrderDetails>();

    @Override
    public void insert(OrderDetails item) {
                        
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
            
            String sql2 = "SELECT CUST_ID FROM ORDER_DETAILS WHERE ORDER_DETAILS_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO ORDER_DETAILS (ORDER_DETAILS_ID,ORDER_ID,BAKERY_ITEM_ID,QUANTITY) VALUES (DEFAULT,(SELECT ORDER_ID FROM ORDERS WHERE CUSTOMERS_CUST_ID = 600 OR CUSTOMERS_CUST_ID = 800 OR CUSTOMERS_CUST_ID = 4200),600,?);";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, item.getOrderId());
            pstmt.setInt(2, item.getQuantity());
            
                 
            pstmt.execute();
            
            
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void insertCherry(OrderDetails item, BakeryItems bake, Customers cust) {
        
       Inventory i = new Inventory();
                        
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
            
            String sql2 = "SELECT CUST_ID FROM ORDER_DETAILS WHERE ORDER_DETAILS_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO ORDER_DETAILS (ORDER_DETAILS_ID,ORDER_ID,BAKERY_ITEM_ID,QUANTITY) VALUES (DEFAULT,(SELECT o.ORDER_ID FROM ORDERS o JOIN CUSTOMERS c ON c.CUST_ID = o.CUSTOMERS_CUST_ID WHERE CUST_FIRST_NAME = ?),(SELECT BAKERY_ITEM_ID FROM BAKERY_ITEMS WHERE BAKERY_ITEM_NAME = ?),?);";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, cust.getFName());
            pstmt.setString(2, bake.getBakeryItemName());
            pstmt.setInt(3, item.getQuantity());
            
                 
            pstmt.execute();
            
            
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void delete(OrderDetails item) {
        
    }

    @Override
    public List<OrderDetails> getItem() {
        
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
            
            String sql2 = "SELECT * FROM ORDER_DETAILS";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
           
          if(rs != null) {
            while(rs.next()) {
                
                OrderDetails a = new OrderDetails(rs.getInt("ORDER_DETAILS_ID"), rs.getInt("ORDER_ID"), rs.getInt("BAKERY_ITEM_ID"), rs.getInt("QUANTITY"));
                
                details.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return details;
        
    }
    
}
