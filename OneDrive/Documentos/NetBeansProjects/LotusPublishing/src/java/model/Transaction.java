/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nyash
 */
import java.sql.Date;

public class Transaction {

    private int id;
    private String type;            // 'income' or 'expense'
    private double amount;
    private String category;
    private String description;
    private Date date;
    private int referenceId;
    private String referenceType;   // e.g. 'invoice', 'salary', etc.

    // --- Constructors ---
    public Transaction() {
    }

    public Transaction(int id, String type, double amount, String category,
            String description, Date date, Integer referenceId,
            String referenceType) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
        this.referenceId = referenceId;
        this.referenceType = referenceType;
    }

    // Overloaded constructor (for inserts, without ID)
    public Transaction(String type, double amount, String category,
            String description, Date date, Integer referenceId,
            String referenceType) {
        this.type = type;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
        this.referenceId = referenceId;
        this.referenceType = referenceType;
    }

    // --- Getters and Setters ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    @Override
    public String toString() {
        return "Transaction{"
                + "id=" + id
                + ", type='" + type + '\''
                + ", amount=" + amount
                + ", category='" + category + '\''
                + ", description='" + description + '\''
                + ", date=" + date
                + ", referenceId=" + referenceId
                + ", referenceType='" + referenceType + '\''
                + '}';
    }
}
