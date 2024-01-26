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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William Shelton
 */
public class CustomerDAO extends Customers implements UADataAccessObject<Customers> {
    
    private DefaultTableModel model;
    
    private List<Customers> customers = new ArrayList<>();

    @Override  
    public void insert(Customers item) {    
        
       String user = "uafs415";
       String pass = "UApass815";
       String url = "jdbc:db2://data.cs.uafs.edu:55000/CS2043";
       
       PreparedStatement pstmt, pstmt2;
       
       Encrypt a = new Encrypt();
       
       try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
            return; //terminate method if driver not found
        }
        
        try {
            
            Connection con = (Connection) DriverManager.getConnection(url, user, pass);
            
            String sql2 = "SELECT CUST_ID FROM CUSTOMERS WHERE CUST_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO CUSTOMERS (CUST_ID,CUST_FIRST_NAME,CUST_LAST_NAME,CUST_ADDRESS,CUST_CITY,CUST_STATE,CUST_ZIP,CUST_EMAIL,CUST_PHONE,CUST_USERNAME,CUST_PASSWORD) VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, item.getFName());
            pstmt.setString(2, item.getLName());
            pstmt.setString(3, item.getAddress());
            pstmt.setString(4, item.getCity());
            pstmt.setString(5, item.getState());
            pstmt.setString(6, item.getZip());
            pstmt.setString(7, item.getEmail());
            pstmt.setString(8, item.getPhone());
            pstmt.setString(9, item.getUser());
            pstmt.setString(10, item.getPass());
            
                        
            pstmt.execute();
                        
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
            
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void delete(Customers item) {
        
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
            
            String sql2 = "SELECT CUST_ID FROM CUSTOMERS WHERE CUST_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "DELETE FROM CUSTOMERS WHERE CUST_ID = ?";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, item.getCustomerId());
            
            pstmt.execute();
            
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
                        
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        
        
    } 

    @Override
    public List<Customers> getItem() {
        
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
            
            String sql2 = "SELECT * FROM CUSTOMERS";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
           
          if(rs != null) {
            while(rs.next()) {
                
                Customers a = new Customers(rs.getInt("CUST_ID"), rs.getString("CUST_FIRST_NAME"), rs.getString("CUST_LAST_NAME"), rs.getString("CUST_ADDRESS"), rs.getString("CUST_CITY"), rs.getString("CUST_STATE"), rs.getString("CUST_ZIP"), rs.getString("CUST_EMAIL"), rs.getString("CUST_PHONE"), rs.getString("CUST_USERNAME"), rs.getString("CUST_PASSWORD"));
                
                customers.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return customers;
        
    }
    
    public List<Customers> searchCustomer(Customers item) {
        
        String user = "uafs415";
        String pass = "UApass815";
        String url = "jdbc:db2://data.cs.uafs.edu:55000/CS2043";

        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        int results;
        
        //Step 1:  load driver
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Step 2:  connect to DBMS
        try {
            con = (Connection) DriverManager.getConnection(url, user, pass);

            
            //Step 3:  prepare SQL statement 
            String sql = "SELECT * FROM CUSTOMERS WHERE CUST_FIRST_NAME = ?";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, item.getFName());
            
            rs = (ResultSet) pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    
                    Customers a = new Customers(rs.getInt("CUST_ID"), rs.getString("CUST_FIRST_NAME"), rs.getString("CUST_LAST_NAME"), rs.getString("CUST_ADDRESS"), rs.getString("CUST_CITY"), rs.getString("CUST_STATE"), rs.getString("CUST_ZIP"), rs.getString("CUST_EMAIL"), rs.getString("CUST_PHONE"), rs.getString("CUST_USERNAME"),rs.getString("CUST_PASSWORD"));
                
                    customers.add(a);
                    
                }

            }
            
            //Step 5:  disconnect from dbms
            con.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customers;
    }

}
