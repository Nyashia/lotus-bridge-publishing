/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nyash
 */
import java.util.Date;

public class Payment {

    private int paymentId;
    private int employeeId; 
    private int authorId;   
    private double amount;
    private Date paymentDate;
    private String type; 

    public Payment() {
    }

    public Payment(int paymentId, int employeeId, int authorId, double amount, Date paymentDate, String type) {
        this.paymentId = paymentId;
        this.employeeId = employeeId;
        this.authorId = authorId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.type = type;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
   

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
