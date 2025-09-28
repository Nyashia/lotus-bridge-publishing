/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nyash
 */
public class Company {

    int companyID;
    String companyName;
    String contactInfo;
    String type;
    
    
    public Company(int companyID, String companyName, String contactInfo, String type){
        this.companyID = companyID;
        this.companyName = companyName;
        this.contactInfo = contactInfo;
        this.type = type;
    }
    
    ////////////////Setters and Getters///////////////////
      //companyID
     public int companyID() {
        return companyID;
    }

    public void companyID(int companyID) {
        this.companyID = companyID;
    }
      //companyID
     public String companyName() {
        return companyName;
    }

    public void companyName(String companyName) {
        this.companyName = companyName;
    }
       //companyID
     public String contactInfo() {
        return contactInfo;
    }

    public void contactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
       //companyID
     public String type() {
        return type;
    }

    public void type(String type) {
        this.type = type;
    }
}
