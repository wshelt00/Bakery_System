/************************************************************
* name William Shelton
* user uafs415
* date 5 November 2021
* assign Problem Set 5
************************************************************/

import com.ibm.db2.jcc.am.Connection;
import com.ibm.db2.jcc.am.ResultSet;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.text.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William Shelton
 */
public class ReceiptDAO {
    
    private List<Receipt> amt = new ArrayList<>();
    private List<Receipt> prev = new ArrayList<>();
    private List<AmountDue> price = new ArrayList<>();
    
    public void insert(Orders item) {
        
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
            
            String sql2 = "SELECT ORDER_ID FROM AMOUNTDUE WHERE ORDER_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO RECEIPT(BAKERY_ITEM_NAME,QUANTITY,TOTAL_PRICE)	SELECT o.ORDER_ID, c.CUST_FIRST_NAME, b.BAKERY_ITEM_NAME, od.QUANTITY, (od.QUANTITY * b.BAKERY_ITEM_PRICE) AS TOTAL_PRICE FROM ORDERS o JOIN CUSTOMERS c ON c.CUST_ID = o.CUSTOMERS_CUST_ID JOIN ORDER_DETAILS od ON o.ORDER_ID = od.ORDER_ID JOIN BAKERY_ITEMS b ON od.BAKERY_ITEM_ID = b.BAKERY_ITEM_ID WHERE c.CUST_FIRST_NAME = ?";
            pstmt = con.prepareStatement(sql);
            
             pstmt.setInt(1,item.getOrderId());
                                   
            pstmt.execute();
                        
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
            
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void insertRec(Customers cust,BakeryItems bake, Receipt quantity) {
        
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
            
            String sql2 = "SELECT ORDER_ID FROM AMOUNTDUE WHERE ORDER_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO RECEIPT(ORDER_ID,BAKERY_ITEM_NAME,TOTAL_PRICE) VALUES ((SELECT o.ORDER_ID FROM ORDERS o JOIN CUSTOMERS c ON c.CUST_ID = o.CUSTOMERS_CUST_ID WHERE CUST_FIRST_NAME = ?),?,(SELECT (q.QUANTITY * b.BAKERY_ITEM_PRICE)AS TOTAL_PRICE FROM ORDER_DETAILS q JOIN BAKERY_ITEMS b ON q.BAKERY_ITEM_ID = b.BAKERY_ITEM_ID WHERE QUANTITY = ?))";
            pstmt = con.prepareStatement(sql);
            
             pstmt.setString(1,cust.getFName());
             pstmt.setString(2,bake.getBakeryItemName());
             pstmt.setInt(3,quantity.getQuantity());
                                   
            pstmt.execute();
                        
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
            
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public List<Receipt> getAll() {
        
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
            
            String sql = "SELECT * FROM RECEIPT WHERE TOTAL_PRICE > 0"; 
            pstmt = con.prepareStatement(sql);
                        
            ResultSet rs = (ResultSet) pstmt.executeQuery();
           
          if(rs != null) {
            while(rs.next()) {
                
                Receipt a = new Receipt(rs.getInt("ORDER_ID"), rs.getString("BAKERY_ITEM_NAME"), rs.getDouble("TOTAL_PRICE"));
                
                amt.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return amt;
        
    }    
    
    public List<Receipt> getPrevious() {
        
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
            
            String sql = "SELECT * FROM RECEIPT WHERE TOTAL_PRICE = 0"; 
            pstmt = con.prepareStatement(sql);
                        
            ResultSet rs = (ResultSet) pstmt.executeQuery();
           
          if(rs != null) {
            while(rs.next()) {
                
                Receipt a = new Receipt(rs.getInt("ORDER_ID"), rs.getString("BAKERY_ITEM_NAME"), rs.getDouble("TOTAL_PRICE"));
                
                prev.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return prev;
        
    }
    
    public List<AmountDue> Message(Orders item) {
        
       String user = "uafs415";
       String pass = "UApass815";
       String url = "jdbc:db2://data.cs.uafs.edu:55000/CS2043";
       
       PreparedStatement pstmt, pstmt2;
       
       try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        try {
            
            Connection con = (Connection) DriverManager.getConnection(url, user, pass);
            
            String sql = "SELECT TOTAL_PRICE, CASE WHEN TOTAL_PRICE = 0 THEN 'Payment has been made' END FROM AMOUNTDUE WHERE ORDER_ID = ?";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1,item.getOrderId());
                        
            ResultSet rs = (ResultSet) pstmt.executeQuery();
            
            while(rs.next()) {
                
                AmountDue a = new AmountDue(rs.getDouble("TOTAL_PRICE"));
                
                price.add(a);
                
            }
            
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
       return price; 
        
    }
    
    public List<AmountDue> getPrice(BakeryItems bake) {
        
       String user = "uafs415";
       String pass = "UApass815";
       String url = "jdbc:db2://data.cs.uafs.edu:55000/CS2043";
       
       PreparedStatement pstmt, pstmt2;
       
       try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        try {
            
            Connection con = (Connection) DriverManager.getConnection(url, user, pass);
            
            String sql = "SELECT TOTAL_PRICE FROM RECEIPT WHERE BAKERY_ITEM_NAME = ?";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1,bake.getBakeryItemName());
                        
            ResultSet rs = (ResultSet) pstmt.executeQuery();
            
            while(rs.next()) {
                
                AmountDue a = new AmountDue(rs.getDouble("TOTAL_PRICE"));
                
                price.add(a);
                
            }
            
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
       return price; 
        
    }
    
}
