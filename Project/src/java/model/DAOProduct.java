/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Product;
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
public class DAOProduct extends DBConnect {

    public int addProduct(Product pro) {
        int n = 0;
        String sql = "insert into Product values('" + pro.getPid() + "','" + pro.getPname() + "'," + pro.getQuantity() + "," + pro.getPrice() + ",'" + pro.getImage() + "','" + pro.getDescription() + "'," + pro.getStatus() + "," + pro.getCateID() + ")";
        System.out.println(sql);
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int insertProduct(Product pro) {
        int n = 0;
        String sql = "insert into Product(pid,pname,quantity,price,image,description,status,cateID) "
                + "values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, pro.getPid());
            pre.setString(2, pro.getPname());
            pre.setInt(3, pro.getQuantity());
            pre.setDouble(4, pro.getPrice());
            pre.setString(5, pro.getImage());
            pre.setString(6, pro.getDescription());
            pre.setInt(7, pro.getStatus());
            pre.setInt(8, pro.getCateID());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateProduct(Product pro) {
        int n = 0;
        String sql = "update Product set pname=?,quantity=?,price=?,image=?,description=?,"
                + "status=?,cateID=? where pid=?";
        try {
            //code here
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, pro.getPname());
            pre.setInt(2, pro.getQuantity());
            pre.setDouble(3, pro.getPrice());
            pre.setString(4, pro.getImage());
            pre.setString(5, pro.getDescription());
            pre.setInt(6, pro.getStatus());
            pre.setInt(7, pro.getCateID());
            pre.setString(8, pro.getPid());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public void updateQuantity(String id, int quan) {
        int a = 0;
        String sql1 = "Select quantity from Product where pid=?";
        String sql = "update Product set quantity=? where pid=?";
        try {
            //code here
            PreparedStatement pre1 = conn.prepareStatement(sql1);
            pre1.setString(1, id);
            ResultSet rs = pre1.executeQuery();
            while (rs.next()) {
                a = rs.getInt(1);
            }
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, quan + a);
            pre.setString(2, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void changeStatus(String id, int status) {
//        String sql = "update Product set status=? where pid=?";
//        try {
//            //code here
//            PreparedStatement pre = conn.prepareStatement(sql);
//            pre.setInt(1, status);
//            pre.setString(2, id);
//            pre.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public void changeStatus(String id, int status) {
        //code here
        int n = 0;
        String sql = "update Product set status=" + status
                + " where pid='" + id + "'";
        getData(sql);
    }

    public int removeProduct1(String id) {
        int n = 0;
        String sql = "delete Product where pid=?";
        try {
            //code here
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public ArrayList<Product> getProduct() {
        ArrayList<Product> arr = new ArrayList<Product>();
        String sql = "Select * from Product";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String pid = rs.getString("pid");// String pid=rs.getString(1);
                String pname = rs.getString(2);//String pname=rs.getString("pname")
                int quantity = rs.getInt(3);
                double price = rs.getDouble(4);
                String image = rs.getString("image");
                String des = rs.getString("description");
                int status = rs.getInt("status");
                int cateid = rs.getInt(8);
                Product pro = new Product(pid, pname, quantity, price, image, des, status, cateid);
                arr.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ResultSet getPrice(double from, double to) {
        String sql = "Select * from Product where price between '" + from + "' and '" + to + "'";
        return getData(sql);
    }

    public ResultSet getName(String name) {
        String sql = "Select * from Product where pname like '%" + name + "%'";
        return getData(sql);
    }

    public void displayAll() {
        String sql = "Select * from Product";
        try {
            // synchronized
            //ResultSet.TYPE_SCROLL_SENSITIVE
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String pid = rs.getString("pid");// String pid=rs.getString(1);
                String pname = rs.getString(2);//String pname=rs.getString("pname")
                int quantity = rs.getInt(3);
                double price = rs.getDouble(4);
                String image = rs.getString("image");
                String des = rs.getString("description");
                int status = rs.getInt("status");
                int cateid = rs.getInt(8);
                Product pro = new Product(pid, pname, quantity, price, image, des, status, cateid);
                System.out.println(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int removeProduct(String id) {
        int n = 0;
        //check ben n co foreign key
        String sqlCheck = "select * from BillDetail where pid='" + id + "'";
        ResultSet rs1 = getData(sqlCheck);
        try {
            if (rs1.next()) {
                changeStatus(id, 0);
                // chang status from 1 to 0 : disable
            } else {
                String sql = "delete from Product where pid='" + id + "'";
                Statement state = conn.createStatement();
                n = state.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public ArrayList<Product> Display(ResultSet rs) {
        ArrayList<Product> arr = new ArrayList<Product>();
        try {
            while (rs.next()) {
                String pid = rs.getString("pid");// String pid=rs.getString(1);
                String pname = rs.getString(2);//String pname=rs.getString("pname")
                int quantity = rs.getInt(3);
                double price = rs.getDouble(4);
                String image = rs.getString("image");
                String des = rs.getString("description");
                int status = rs.getInt("status");
                int cateid = rs.getInt(8);
                Product pro = new Product(pid, pname, quantity, price, image, des, status, cateid);
                arr.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
}
