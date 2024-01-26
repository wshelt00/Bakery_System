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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author William Shelton
 */
public class BakeryItemsDAO implements UADataAccessObject<BakeryItems> {
    
    private List<BakeryItems> bake = new ArrayList<>();

    @Override
    public void insert(BakeryItems item) {
        
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
            
            String sql2 = "SELECT BAKERY_ITEM_ID FROM BAKERY_ITEMS WHERE BAKERY_ITEM_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO BAKERY_ITEMS (BAKERY_ITEM_ID,BAKERY_ITEM_NAME,BAKERY_ITEM_DESCRIPTION,BAKERY_ITEM_PRICE) VALUES (DEFAULT,?,?,?)";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, item.getBakeryItemName());
            pstmt.setString(2, item.getBakeryItemDesciption());
            pstmt.setDouble(3, item.getBakeryItemPrice());
            
                        
            pstmt.execute();
                        
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
            
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void delete(BakeryItems item) {
        
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
            
            String sql2 = "SELECT BAKERY_ITEM_ID FROM BAKERY_ITEMS WHERE BAKERY_ITEM_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "DELETE FROM BAKERY_ITEMS WHERE BAKERY_ITEM_ID = ?";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, item.getBakeryItemId());
            
            pstmt.execute();
            
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
                        
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        } 
        
    }

    @Override
    public List<BakeryItems> getItem() {
        
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
            
            String sql2 = "SELECT * FROM BAKERY_ITEMS";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
           
          if(rs != null) {
            while(rs.next()) {
                
                BakeryItems a = new BakeryItems(rs.getInt("BAKERY_ITEM_ID"), rs.getString("BAKERY_ITEM_NAME"), rs.getString("BAKERY_ITEM_DESCRIPTION"), rs.getDouble("BAKERY_ITEM_PRICE"));
                
                bake.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return bake;
        
    }
    
        
  /*  public List<BakeryItems> getAll(BakeryItems item) {
        
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
            
            String sql2 = "SELECT BAKERY_ITEM_NAME, BAKERY_ITEM_PRICE FROM BAKERY_ITEMS WHERE BAKERY_ITEM_NAME = ?";
            pstmt = con.prepareStatement(sql2);
            
             pstmt.setString(1, item.getBakeryItemName());
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
           
          if(rs != null) {
            while(rs.next()) {
                
                BakeryItems a = new BakeryItems(rs.getString("BAKERY_ITEM_NAME"), rs.getDouble("BAKERY_ITEM_PRICE"));
                
                bake.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return bake;
        
    } */
    
}
