/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nyash
 */
public class Author {

    private int authorId;
    private String firstName;
    private String lastName;
    private String contactInfo;
    private double royaltyRate;

    public Author() {
    }

    public Author(int authorId, String firstName, String lastName, String contactInfo, double royaltyRate) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactInfo = contactInfo;
        this.royaltyRate = royaltyRate;
    }

    // Getters and Setters
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public double getRoyaltyRate() {
        return royaltyRate;
    }

    public void setRoyaltyRate(double royaltyRate) {
        this.royaltyRate = royaltyRate;
    }
}
