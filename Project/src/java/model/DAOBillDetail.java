/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.BillDetail;
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
public class DAOBillDetail extends DBConnect{
    public int insertBillDetail(BillDetail billdetail) {
        int n=0;
        String sql = "insert into BillDetail values('" + billdetail.getPid() + "','" 
                + billdetail.getoID() +"',"+
                billdetail.getQuantity()+","+
                billdetail.getPrice()+","+
                billdetail.getTotal()+
                ")";
        System.out.println(sql);
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
        public int updatebilldetail(BillDetail bill){
        int n=0;
         String sql="update Product set quantity=?,price=? where pid=?";
         
        try {
            //code here
            PreparedStatement pre= conn.prepareStatement(sql);
            pre.setInt(1, bill.getQuantity());
            pre.setDouble(2, bill.getPrice());
            pre.setString(3, bill.getPid());
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return n;
    }
    
    public void updateQuantity(String pid, String oid, int quan) {
        String sql = "update BillDetail\n" +
        "set quantity=quantity+? where pid=? and oID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, quan);
            pre.setString(2, pid);
            pre.setString(3, oid);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBillDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateQuantityandTotal(String pid, String oid, int quan) {
        updateQuantity(pid, oid, quan);
        String sql = "update BillDetail\n"
                + "set total = quantity*price where pid=? and oID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, pid);
            pre.setString(2, oid);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOBillDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        public void updatePrice(String id, int pri){
        int a=0;
            String sql1="Select quantity from BillDetail where pid=?";
            String sql="update BillDetail set price=? ,total=? where pid=?";
        try {
            //code here
            PreparedStatement pre1= conn.prepareStatement(sql1);
            pre1.setString(1, id);
            ResultSet rs= pre1.executeQuery();
            while(rs.next()){
                 a= rs.getInt(1);
            }
            PreparedStatement pre= conn.prepareStatement(sql);
            pre.setInt(1, pri);
            pre.setDouble(2,pri*a);
            pre.setString(3, id);

            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public int removeBilldetail(String id){
        int n=0;
        String sql="delete Product where pid=?";
        try {
            //code here
            PreparedStatement pre= conn.prepareStatement(sql);
            pre.setString(1,id);
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return n;
    }  
        
            public void displayAll(){
        String sql="Select * from BillDetail";
        try {
           // synchronized
            //ResultSet.TYPE_SCROLL_SENSITIVE
            Statement state=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=state.executeQuery(sql);
            while(rs.next()){
                String pid=rs.getString(1);// String pid=rs.getString(1);
                String oid=rs.getString(2);//String pname=rs.getString("pname")
                int quantity=rs.getInt(3);
                double price=rs.getDouble(4);
                double total=rs.getDouble(5);
                
                BillDetail billD = new BillDetail(pid, oid, quantity, price, total);
                System.out.println(billD);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
    public ArrayList<BillDetail> Display(ResultSet rs){
        ArrayList<BillDetail> arr=new ArrayList<BillDetail>();
        try {
            while(rs.next()){
                String pid=rs.getString(1);// String pid=rs.getString(1);
                String oid=rs.getString(2);//String pname=rs.getString("pname")
                int quantity=rs.getInt(3);
                double price=rs.getDouble(4);
                double total=rs.getDouble(5);
                
                BillDetail billD = new BillDetail(pid, oid, quantity, price, total);
                arr.add(billD);               
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
   }
    
}
