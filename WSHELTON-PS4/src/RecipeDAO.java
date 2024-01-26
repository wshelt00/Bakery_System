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
public class RecipeDAO implements UADataAccessObject<Recipe> {
    
    private List<Recipe> rec = new ArrayList<>();
    private List<Recipe> qneed = new ArrayList<>();

    @Override
    public void insert(Recipe item) {
        
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
            
            String sql2 = "SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO RECIPE (RECIPE_ID,BAKERY_ITEM_ID,INV_ID,INV_QTY_NEEDED) VALUES (DEFAULT,600,5100,?), (DEFAULT,600,5200,?), (DEFAULT,600,5300,?)";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1,item.getQtyNeeded());
            pstmt.setInt(2,item.getQtyNeeded());
            pstmt.setInt(3,item.getQtyNeeded());
                        
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
                        
            pstmt.execute();
                        
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
     public void insertPita(Recipe item, BakeryItems bake) {
        
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
            
            String sql2 = "SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO RECIPE (RECIPE_ID,BAKERY_ITEM_ID,INV_ID,INV_QTY_NEEDED) VALUES (DEFAULT,(SELECT BAKERY_ITEM_ID FROM BAKERY_ITEMS WHERE BAKERY_ITEM_NAME = ?),5100,?), (DEFAULT,(SELECT BAKERY_ITEM_ID FROM BAKERY_ITEMS WHERE BAKERY_ITEM_NAME = ?),5200,?), (DEFAULT,(SELECT BAKERY_ITEM_ID FROM BAKERY_ITEMS WHERE BAKERY_ITEM_NAME = ?),5300,?)";
            pstmt = con.prepareStatement(sql);
            
            
            pstmt.setString(1,bake.getBakeryItemName());
            pstmt.setInt(2,item.getQtyNeeded());
            pstmt.setString(3,bake.getBakeryItemName());
            pstmt.setInt(4,item.getQtyNeeded());
            pstmt.setString(5,bake.getBakeryItemName());
            pstmt.setInt(6,item.getQtyNeeded());
                        
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
                        
            pstmt.execute();
                        
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
     public void insertSour(Recipe item, BakeryItems bake) {
        
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
            
            String sql2 = "SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO RECIPE (RECIPE_ID,BAKERY_ITEM_ID,INV_ID,INV_QTY_NEEDED) VALUES (DEFAULT,(SELECT BAKERY_ITEM_ID FROM BAKERY_ITEMS WHERE BAKERY_ITEM_NAME = ?),5000,?), (DEFAULT,(SELECT BAKERY_ITEM_ID FROM BAKERY_ITEMS WHERE BAKERY_ITEM_NAME = ?),5100,?), (DEFAULT,(SELECT BAKERY_ITEM_ID FROM BAKERY_ITEMS WHERE BAKERY_ITEM_NAME = ?),5200,?)";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1,bake.getBakeryItemName());
            pstmt.setInt(2,item.getQtyNeeded());
            pstmt.setString(3,bake.getBakeryItemName());
            pstmt.setInt(4,item.getQtyNeeded());
            pstmt.setString(5,bake.getBakeryItemName());
            pstmt.setInt(6,item.getQtyNeeded());
                        
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
                        
            pstmt.execute();
                        
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        
    }
     
     public void insertCherry(Recipe item, BakeryItems bake) {
        
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
            
            String sql2 = "SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_ID IS NULL";
            pstmt2 = con.prepareStatement(sql2);
            
            String sql = "INSERT INTO RECIPE (RECIPE_ID,BAKERY_ITEM_ID,INV_ID,INV_QTY_NEEDED) VALUES (DEFAULT,(SELECT BAKERY_ITEM_ID FROM BAKERY_ITEMS WHERE BAKERY_ITEM_NAME = ?),4900,?), (DEFAULT,(SELECT BAKERY_ITEM_ID FROM BAKERY_ITEMS WHERE BAKERY_ITEM_NAME = ?),5100,?), (DEFAULT,(SELECT BAKERY_ITEM_ID FROM BAKERY_ITEMS WHERE BAKERY_ITEM_NAME = ?),6100,?);";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1,bake.getBakeryItemName());
            pstmt.setInt(2,item.getQtyNeeded());
            pstmt.setString(3,bake.getBakeryItemName());
            pstmt.setInt(4,item.getQtyNeeded());
            pstmt.setString(5,bake.getBakeryItemName());
            pstmt.setInt(6,item.getQtyNeeded());
                        
            ResultSet rs = (ResultSet) pstmt2.executeQuery();
                        
            pstmt.execute();
                        
            con.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
     }

    @Override
    public void delete(Recipe item) {
        
    }

    @Override
    public List<Recipe> getItem() {
        
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
            
            String sql2 = "SELECT * FROM RECIPE";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
           
          if(rs != null) {
            while(rs.next()) {
                
                Recipe a = new Recipe(rs.getInt("RECIPE_ID"), rs.getInt("BAKERY_ITEM_ID"), rs.getInt("INV_ID"), rs.getInt("INV_QTY_NEEDED"));
                
                rec.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return rec;
        
    }
    
    public List<Recipe> getQNeeded() {
        
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
            
            String sql2 = "SELECT INV_QTY_NEEDED FROM RECIPE WHERE INV_ID = 5100 OR INV_ID = 5200 OR INV_ID = 5300";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
                       
          if(rs != null) {
            while(rs.next()) {
                
                Recipe a = new Recipe(rs.getInt("INV_QTY_NEEDED"));
                
                qneed.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return qneed;
    
    }
    
    public List<Recipe> getQNeededSour() {
        
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
            
            String sql2 = "SELECT INV_QTY_NEEDED FROM RECIPE WHERE INV_ID = 5000 OR INV_ID = 5100 OR INV_ID = 5200";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
                       
          if(rs != null) {
            while(rs.next()) {
                
                Recipe a = new Recipe(rs.getInt("INV_QTY_NEEDED"));
                
                qneed.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return qneed;
    
    }
    
    public List<Recipe> getQNeededCherry() {
        
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
            
            String sql2 = "SELECT INV_QTY_NEEDED FROM RECIPE WHERE INV_ID = 4900 OR INV_ID = 5100 OR INV_ID = 6100";
            pstmt = con.prepareStatement(sql2);
            
            ResultSet rs = (ResultSet) pstmt.executeQuery();
                       
          if(rs != null) {
            while(rs.next()) {
                
                Recipe a = new Recipe(rs.getInt("INV_QTY_NEEDED"));
                
                qneed.add(a);
                
            }
                        
            con.close();
          }   
        }catch (Exception ex) {
            ex.printStackTrace();
        }
       
       return qneed;
    
    }
    
}
