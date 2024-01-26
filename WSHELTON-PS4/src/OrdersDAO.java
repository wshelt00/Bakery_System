/************************************************************
* name William Shelton
* user uafs415
* date 5 November 2021
* assign Problem Set 5
************************************************************/


import com.ibm.db2.jcc.am.Connection;
import com.ibm.db2.jcc.am.ResultSet;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
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
public class OrdersDAO implements UADataAccessObject<Orders>{ 
    
    private List<Orders> order = new ArrayList<Orders>();
    private List<Orders> id6 = new ArrayList<Orders>();

    @Override
    public void insert(Orders item) {
        
       String user = "uafs415";
       String pass = "UApass815";
       String url = "jdbc:db2://data.cs.uafs.edu:55000/CS2043";
       
       PreparedStatement pstmt, pstmt2;
       
       Customers a = new Customers();
       
       LocalDate date = LocalDate.now(); 
       LocalTime time = LocalTime.now(); 
       
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
       DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
       
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
            return; //terminate method if driver not found
        }
        
        try {
            
            Connection con = (Connection) DriverManager.getConnection(url, user, pass);
            
            String sql2 = "SELECT ORDER_ID FROM ORDERS WHERE ORDER_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO ORDERS (ORDER_ID,ORDER_DATE,ORDER_TIME,CUSTOMERS_CUST_ID) VALUES (DEFAULT,?,?,800);";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, date.format(formatter));
            pstmt.setString(2, time.format(format));
                                   
            pstmt.execute();
                        
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
            
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void insertWzgy(Orders item, Customers name) {
        
       String user = "uafs415";
       String pass = "UApass815";
       String url = "jdbc:db2://data.cs.uafs.edu:55000/CS2043";
       
       PreparedStatement pstmt, pstmt2;
       
       Customers a = new Customers();
       
       LocalDate date = LocalDate.now(); 
       LocalTime time = LocalTime.now(); 
       
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
       DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
       
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
            return; //terminate method if driver not found
        }
        
        try {
            
            Connection con = (Connection) DriverManager.getConnection(url, user, pass);
            
            String sql2 = "SELECT ORDER_ID FROM ORDERS WHERE ORDER_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO ORDERS (ORDER_ID,ORDER_DATE,ORDER_TIME,CUSTOMERS_CUST_ID) VALUES (DEFAULT,?,?,(SELECT CUST_ID FROM CUSTOMERS WHERE CUST_FIRST_NAME = ?));";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, date.format(formatter));
            pstmt.setString(2, time.format(format));
            pstmt.setString(3, name.getFName());
                                   
            pstmt.execute();
                        
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
            
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void delete(Orders item) {
        
    }

    @Override
    public List<Orders> getItem() {
        
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
            
            String sql2 = "SELECT * FROM ORDERS";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
           
          if(rs != null) {
            while(rs.next()) {
                
                Orders a = new Orders(rs.getInt("ORDER_ID"), rs.getString("ORDER_DATE"), rs.getString("ORDER_TIME"), rs.getInt("CUSTOMERS_CUST_ID"));
                
                order.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return order;
        
    }
    
    public List<Orders> getOID() {
        
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
            
            String sql2 = "SELECT ORDER_ID, CUSTOMERS_CUST_ID FROM ORDERS WHERE CUSTOMERS_CUST_ID = 600";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
           
          if(rs != null) {
            while(rs.next()) {
                
                Orders a = new Orders(rs.getInt("ORDER_ID"), rs.getInt("CUSTOMERS_CUST_ID"));
                
                id6.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return id6;
        
    }
    
    public List<Orders> getOrderID() {
        
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
            
            String sql2 = "SELECT ORDER_ID, CUSTOMERS_CUST_ID FROM ORDERS WHERE CUSTOMERS_CUST_ID = 800";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
           
          if(rs != null) {
            while(rs.next()) {
                
                Orders a = new Orders(rs.getInt("ORDER_ID"), rs.getInt("CUSTOMERS_CUST_ID"));
                
                id6.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return id6;
        
    }
        
 }
