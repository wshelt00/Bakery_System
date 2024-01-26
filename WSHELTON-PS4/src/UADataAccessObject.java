/************************************************************
* name William Shelton
* user uafs415
* date 5 November 2021
* assign Problem Set 5
************************************************************/


import com.ibm.db2.jcc.am.ResultSet;
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
public interface UADataAccessObject<UABakery> {
    
     public void insert(UABakery item);
     
     public void delete(UABakery item);
     
     public List<UABakery> getItem();
     
}
