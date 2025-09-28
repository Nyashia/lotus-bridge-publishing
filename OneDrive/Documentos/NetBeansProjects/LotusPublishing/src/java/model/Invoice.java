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

public class Invoice {

    private int invoiceId;
    private int companyId;
    private Date invoiceDate;
    private double amount;
    private String status; // Paid, Unpaid, Overdue

    public Invoice() {
    }

    public Invoice(int invoiceId, int companyId, Date invoiceDate, double amount, String status) {
        this.invoiceId = invoiceId;
        this.companyId = companyId;
        this.invoiceDate = invoiceDate;
        this.amount = amount;
        this.status = status;
    }

    // Getters and Setters
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
