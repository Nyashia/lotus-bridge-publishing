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
    private Date dateCreated;
    private Date dateDue;
    private double totalAmount;
    private String status; // Paid, Unpaid
    private String notes;

    

    public Invoice(int invoiceId, int companyId, Date dateCreated, Date dateDue, 
            double totalAmount, String status, String notes) {
        this.invoiceId = invoiceId;
        this.companyId = companyId;
        this.dateCreated = dateCreated;
        this.dateDue = dateDue;
        this.totalAmount = totalAmount;
        this.status = status;
        this.notes = notes;
    }

   
}
