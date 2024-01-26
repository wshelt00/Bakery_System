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
public class InventoryDAO extends Inventory implements UADataAccessObject<Inventory> {
    
    private List<Inventory> inv = new ArrayList<>();
    private List<Inventory> col = new ArrayList<>();

    @Override
    public void insert(Inventory item) {
        
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
            
            String sql2 = "SELECT INV_ID FROM INVENTORY WHERE INV_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO INVENTORY (INV_ID,INV_NAME,INV_DESCRIPTION,INV_QTY_ONHAND,INV_REORDERED_AMT,INV_REORDERED_PRICE) VALUES (DEFAULT,?,?,?,?,?)";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1,item.getInventoryName());
            pstmt.setString(2,item.getInventoryDescription());
            pstmt.setInt(3,item.getQuantityOnHand());
            pstmt.setInt(4,item.getReorderedAmount());
            pstmt.setDouble(5,item.getReorderedPrice());
                        
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
                        
            pstmt.execute();
                        
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void delete(Inventory item) {
        
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
            
            String sql2 = "SELECT INV_ID FROM INVENTORY WHERE INV_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "DELETE FROM INVENTORY WHERE INV_ID = ?";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, item.getInventoryId());
            
            pstmt.execute();
            
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
                        
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public List<Inventory> getItem() {
        
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
            
            String sql2 = "SELECT * FROM INVENTORY";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
           
          if(rs != null) {
            while(rs.next()) {
                
                Inventory a = new Inventory(rs.getInt("INV_ID"), rs.getString("INV_NAME"), rs.getString("INV_DESCRIPTION"), rs.getInt("INV_QTY_ONHAND"), rs.getInt("INV_REORDERED_AMT"), rs.getDouble("INV_REORDERED_PRICE"));
                
                inv.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return inv;
        
    }
    
    public void updatePita(Recipe quan) {
        
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
            
            String sql2 = "SELECT INV_ID FROM INVENTORY WHERE INV_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "UPDATE INVENTORY SET INV_QTY_ONHAND = INV_QTY_ONHAND - (? * 3) WHERE INV_ID = 5100 OR INV_ID = 5200 OR INV_ID = 5300"; 
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, quan.getQtyNeeded()); 
                                    
            pstmt.execute(); 
            
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
                
            con.close();
                        
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }  
    
    public void updateSour(Recipe quan) {
        
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
            
            String sql2 = "SELECT INV_ID FROM INVENTORY WHERE INV_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "UPDATE INVENTORY SET INV_QTY_ONHAND = INV_QTY_ONHAND - (? * 3) WHERE INV_ID = 5000 OR INV_ID = 5100 OR INV_ID = 5200"; 
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, quan.getQtyNeeded()); 
                                    
            pstmt.execute(); 
            
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
                
            con.close();
                        
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void updateCherry(Recipe quan) {
        
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
            
            String sql2 = "SELECT INV_ID FROM INVENTORY WHERE INV_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "UPDATE INVENTORY SET INV_QTY_ONHAND = INV_QTY_ONHAND - (? * 3) WHERE INV_ID = 4900 OR INV_ID = 5100 OR INV_ID = 6100"; 
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, quan.getQtyNeeded()); 
                                    
            pstmt.execute(); 
            
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
                
            con.close();
                        
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    
    public List<Inventory> getQOHPita() {
        
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
            
            String sql2 = "SELECT INV_QTY_ONHAND FROM INVENTORY WHERE INV_ID = 5100 OR INV_ID = 5200 OR INV_ID = 5300";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
                       
          if(rs != null) {
            while(rs.next()) {
                
                Inventory a = new Inventory(rs.getInt("INV_QTY_ONHAND"));
                
                col.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return col;
    
    }
    
    public List<Inventory> getQOHSour() {
        
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
            
            String sql2 = "SELECT INV_QTY_ONHAND FROM INVENTORY WHERE INV_ID = 5000 OR INV_ID = 5100 OR INV_ID = 5200";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
                       
          if(rs != null) {
            while(rs.next()) {
                
                Inventory a = new Inventory(rs.getInt("INV_QTY_ONHAND"));
                
                col.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return col;
    
    }
    
    public List<Inventory> getQOHCherry() {
        
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
            
            String sql2 = "SELECT INV_QTY_ONHAND FROM INVENTORY WHERE INV_ID = 4900 OR INV_ID = 5100 OR INV_ID = 6100";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
                       
          if(rs != null) {
            while(rs.next()) {
                
                Inventory a = new Inventory(rs.getInt("INV_QTY_ONHAND"));
                
                col.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return col;
    
    }

}
