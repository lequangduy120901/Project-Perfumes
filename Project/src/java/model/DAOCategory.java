/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAOCategory extends DBConnect {
    public  int insertCategory(Category Cate){
        int n=0;
        String sql="insert into Category Values('"+Cate.getCateName()+"',"+Cate.getStatus()+")";
        System.out.println(sql);
        try{
            Statement state = conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int UpdateCategory(Category cat) {
        int n = 0;
        String sql = "update Category set cateName=?"+ ",status=? where cateID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cat.getCateName());
            pre.setInt(2, cat.getStatus());
            pre.setInt(3, cat.getCateID());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public void changeStatus(int id, int status){
        String sql="Update Category set Status=? where cateID=?";
        
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            
            pre.setInt(1,status);
            pre.setInt(2, id);
            
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public int removeCategory(int id) {
        int n = 0;
        //code here
        String sql = "delete Category\n" + "where cateID = ?;";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            n = pre.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
     
         public void displayAll(){
        String sql="Select * from Category";
        try {
           // synchronized
            //ResultSet.TYPE_SCROLL_SENSITIVE
            Statement state=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=state.executeQuery(sql);
            while(rs.next()){
                int cateID=rs.getInt(1);
                String cateName=rs.getString("cateName");
                int status=rs.getInt("status");
                Category cat = new Category(cateID, cateName, status);
                System.out.println(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public ArrayList<Category> Display(ResultSet rs){
        ArrayList<Category> arr=new ArrayList<Category>();
        try {
            while(rs.next()){
                int cateID=rs.getInt(1);
                String cateName=rs.getString("cateName");
                int status=rs.getInt("status");
                Category cat = new Category(cateID, cateName, status);
                arr.add(cat);               
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
   }
}
