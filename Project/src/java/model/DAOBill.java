/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Bill;
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
public class DAOBill extends DBConnect {

    public int insertBill(Bill bill) {
        int n = 0;
        String sql = "insert into Bill values('" + bill.getoID() + "','" + bill.getDateCreate()
                + "','" + bill.getCname() + "',"
                + "'" + bill.getCphone() + "',"
                + "'" + bill.getcAddress() + "',"
                + bill.getTotal() + ","
                + bill.getStatus() + ","
                + bill.getCid()
                + ")";
        System.out.println(sql);
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int insertBill1(Bill bill) {
        int n = 0;
        String sql = "insert into Bill(oID, cname, cphone, cAddress, total, status, cid) values('" + bill.getoID() + "','"
                + bill.getCname() + "',"
                + "'" + bill.getCphone() + "',"
                + "'" + bill.getcAddress() + "',"
                + bill.getTotal() + ","
                + bill.getStatus() + ","
                + bill.getCid()
                + ")";
        System.out.println(sql);
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updatebill(Bill bill) {
        int n = 0;
        String sql = "update Bill set DateCreate=?,Cname=?,Cphone=?,cAddress=? where getoID=?";
        try {
            //code here
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, bill.getDateCreate());
            pre.setString(2, bill.getCname());
            pre.setString(3, bill.getCphone());
            pre.setString(4, bill.getcAddress());
            pre.setString(5, bill.getoID());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updatebill(String oid, String cname, String cphone, String cAddress) {
        int n = 0;
        String sql = "update Bill set cname=?,cphone=?,cAddress=? where oID=?";
        try {
            //code here
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cname);
            pre.setString(2, cphone);
            pre.setString(3, cAddress);
            pre.setString(4, oid);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public void changeStatus(String id, int status) {
        String sql = "update Bill set status=? where oID=?";
        try {
            //code here
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, status);
            pre.setString(2, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int removeBill(String id) {
        int n = 0;
        String sql = "delete Product where getoID=?";
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

    public void displayAll() {
        String sql = "Select * from Bill";
        try {
            // synchronized
            //ResultSet.TYPE_SCROLL_SENSITIVE
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                String oid = rs.getString(1);
                String dateCreate = rs.getString(2);//String pname=rs.getString("pname")
                String cname = rs.getString(3);//String pname=rs.getString("pname")
                String cphone = rs.getString(4);//String pname=rs.getString("pname")
                String cAddress = rs.getString(5);//String pname=rs.getString("pname")
                double total = rs.getDouble(6);
                int cid = rs.getInt(7);
                int status = rs.getInt("status");
                Bill bill = new Bill(oid, dateCreate, cname, cphone, cAddress, total, cid, status);
                System.out.println(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Bill> Display(ResultSet rs) {
        ArrayList<Bill> arr = new ArrayList<Bill>();
        try {
            while (rs.next()) {
                String oid = rs.getString(1);
                String dateCreate = rs.getString(2);//String pname=rs.getString("pname")
                String cname = rs.getString(3);//String pname=rs.getString("pname")
                String cphone = rs.getString(4);//String pname=rs.getString("pname")
                String cAddress = rs.getString(5);//String pname=rs.getString("pname")
                double total = rs.getDouble(6);
                int cid = rs.getInt(7);
                int status = rs.getInt("status");
                Bill bill = new Bill(oid, dateCreate, cname, cphone, cAddress, total, cid, status);
                arr.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
}
