/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Category {
    private int cateID,status;
    private String cateName;

    public Category() {
    }

    public Category(int cateID, String cateName, int status) {
        this.cateID = cateID;
        this.status = status;
        this.cateName = cateName;
    }

    public Category(String cateName) {
        this.cateName = cateName;
    }

    public Category( String cateName,int status) {
        this.status = status;
        this.cateName = cateName;
    }
    
    

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Override
    public String toString() {
        return "Category{" + "cateID=" + cateID + ", status=" + status + ", cateName=" + cateName + '}';
    }

}
