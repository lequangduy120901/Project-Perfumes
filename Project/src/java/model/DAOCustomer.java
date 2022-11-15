/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Customer;
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
public class DAOCustomer extends DBConnect {

    public int addCustomer(Customer cus) {
        int n = 0;
        String sql = "insert into Customer values('" + cus.getCname() + "','" + cus.getCphone() + "','" + cus.getcAddress() + "','" + cus.getUsername() + "','" + cus.getPassword() + "'," + cus.getStatus() + ")";
        System.out.println(sql);
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public boolean checkUnique1(String userName) {
        String sql = "select username from Customer";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                if (userName.equals(rs.getString(1))) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public int insertCustomer(Customer cus) {
        int n = 0;
        String sql = "insert into Customer (cname,cphone,cAddress,username,password,status)"
                + "values(?,?,?,?,?,?)";
        System.out.println(sql);
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cus.getCname());
            pre.setString(2, cus.getCphone());
            pre.setString(3, cus.getcAddress());
            pre.setString(4, cus.getUsername());
            pre.setString(5, cus.getPassword());
            pre.setInt(6, cus.getStatus());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public boolean checkpassword(String username, String passold) {
        String sql = "Select password from Customer where username = '" + username + "'";
        ResultSet rs = getData(sql);
        try {
            if (rs.getString(1).equalsIgnoreCase(passold) == false) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public int UpdatePassword(String username, String password) {
        int n = 0;
        String sql = "update Customer set password=? where username= ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, password);
            pre.setString(2, username);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateCustomer(Customer cus) {
        int n = 0;
        String sql = "Update Customer set cname=?,cphone=?,cAddress=?,username=?,password=?,status=? where cid=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, cus.getCname());
            pre.setString(2, cus.getCphone());
            pre.setString(3, cus.getcAddress());
            pre.setString(4, cus.getUsername());
            pre.setString(5, cus.getPassword());
            pre.setInt(6, cus.getStatus());
            pre.setInt(7, cus.getCid());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public void changeStatus(int id, int status) {
        String sql = "update Customer set status=? where cid=?";
        try {
            //code here
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, status);
            pre.setInt(2, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int removeCustomer(int id) {
        int n = 0;
        String sql = "delete Customer where cid=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public void displayAll() {
        String sql = "Select * from Customer";
        try {
            // synchronized
            //ResultSet.TYPE_SCROLL_SENSITIVE
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                int cid = rs.getInt("cid");// String pid=rs.getString(1);
                String cname = rs.getString(2);//String pname=rs.getString("pname")
                String cphone = rs.getString(3);
                String cAddress = rs.getString(4);
                String username = rs.getString("username");
                String password = rs.getString("password");
                int status = rs.getInt("status");
                Customer cus = new Customer(cid, cname, cphone, cAddress, username, password, status);
                System.out.println(cus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Customer> Display(ResultSet rs) {
        ArrayList<Customer> arr = new ArrayList<Customer>();
        try {
            while (rs.next()) {
                int cid = rs.getInt("cid");// String pid=rs.getString(1);
                String cname = rs.getString(2);//String pname=rs.getString("pname")
                String cphone = rs.getString(3);
                String cAddress = rs.getString(4);
                String username = rs.getString("username");
                String password = rs.getString("password");
                int status = rs.getInt("status");
                Customer cus = new Customer(cid, cname, cphone, cAddress, username, password, status);
                arr.add(cus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public boolean login(String userName, String password) {
        try {
            String sql = "select * from Customer where username='" + userName + "' and password='" + password + "'";
            ResultSet rs = getData(sql);
            while (rs.next()) {
                if (rs.getString(1) != null) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean login1(String userName, String password) {
        String sql = "select * from Customer where username=? and password=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, userName);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                if(userName.equals(rs.getString(5)) && password.equals(rs.getString(6))) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
//    public static void main(String[] args) {
//        DAOCustomer dao = new DAOCustomer();
//        dao.updateCustomer(new Customer(1, "Nguyen", cphone, cAddress, username, password, 0))
//    }
}
