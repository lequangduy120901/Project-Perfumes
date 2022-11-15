/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Bill {
    private String oID,cname,cphone,cAddress;
    private double total;
    private int cid,status;
    private String dateCreate;

    public Bill() {
    }

    public Bill(String oID, String dateCreate, String cname, String cphone, String cAddress, double total, int status, int cid) {
        this.oID = oID;
        this.cname = cname;
        this.cphone = cphone;
        this.cAddress = cAddress;
        this.total = total;
        this.cid = cid;
        this.status = status;
        this.dateCreate = dateCreate;
    }

    public Bill(String oID, String dateCreate, String cname, String cphone, String cAddress, double total) {
        this.oID = oID;
        this.cname = cname;
        this.cphone = cphone;
        this.cAddress = cAddress;
        this.total = total;
        this.dateCreate = dateCreate;
    }
    

    public String getoID() {
        return oID;
    }

    public void setoID(String oID) {
        this.oID = oID;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Override
    public String toString() {
        return "Bill{" + "oID=" + oID + ", cname=" + cname + ", cphone=" + cphone + ", cAddress=" + cAddress + ", total=" + total + ", cid=" + cid + ", status=" + status + ", dateCreate=" + dateCreate + '}';
    }
    
    
}
