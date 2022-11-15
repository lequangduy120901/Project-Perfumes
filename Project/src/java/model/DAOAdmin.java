/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAOAdmin extends DBConnect {

    public boolean login(String userName, String password) {
        try {
            String sql = "select * from Admin where username='" + userName + "' and password='" + password + "'";
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
        String sql = "select * from Admin where username=? and password=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, userName);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                if(userName.equals(rs.getString(2)) && password.equals(rs.getString(3))) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean checkpassword(int id, String passold) {
        String sql = "Select password from admin where adminID = '" + id + "'";
        ResultSet rs = getData(sql);
        try {
            if (rs.getString(3).equals(passold)) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean checkUnique1(String userName) {
        String sql = "select username from Admin";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                if (userName.equals(rs.getString(1))) {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public int insertAdmin(admin admin) {
        int n = 0;
        String sql = "insert into Admin values('" + admin.getUsername() + "'," + admin.getPassword() + ")";
        System.out.println(sql);
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int UpdatePassword(int adminID, String password) {
        int n = 0;
        String sql = "update Admin set password=? where adminID= ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, password);
            pre.setInt(2, adminID);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int removeAdmin(int adminID) {
        int n = 0;
        //code here
        String sql = "delete Admin where adminID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, adminID);
            n = pre.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAOAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public static void main(String[] args) {
        DAOAdmin dao = new DAOAdmin();
        int n = dao.insertAdmin(new admin(1, "Thinh", "12345678"));
        if (n > 0) {
            System.out.println("inserted");
        }

    }
}
