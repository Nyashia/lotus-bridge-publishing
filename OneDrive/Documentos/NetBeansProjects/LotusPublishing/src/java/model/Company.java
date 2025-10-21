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

    private int companyId;
    private String companyName;
    private String contactInfo;
    private String type; // e.g., 'supplier', 'client', etc.

    // --- Constructors ---
    public Company() {
    }

    public Company(int companyId, String companyName, String contactInfo, String type) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.contactInfo = contactInfo;
        this.type = type;
    }

    // Overloaded constructor (without ID for inserts)
    public Company(String companyName, String contactInfo, String type) {
        this.companyName = companyName;
        this.contactInfo = contactInfo;
        this.type = type;
    }

    // --- Getters and Setters ---
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Company{"
                + "companyId=" + companyId
                + ", companyName='" + companyName + '\''
                + ", contactInfo='" + contactInfo + '\''
                + ", type='" + type + '\''
                + '}';
    }
}
