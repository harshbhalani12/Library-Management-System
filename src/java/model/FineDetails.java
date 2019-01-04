/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class FineDetails {

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
    private int CardId,LoanId;
    private float fine;
    private String FirstName, LastName;
    private Date DateOut,DateIn, DueDate;
    private String Title;

    public Date getDateOut() {
        return DateOut;
    }

    public void setDateOut(Date DateOut) {
        this.DateOut = DateOut;
    }

    public Date getDateIn() {
        return DateIn;
    }

    public void setDateIn(Date DateIn) {
        this.DateIn = DateIn;
    }

    public Date getDueDate() {
        return DueDate;
    }

    public void setDueDate(Date DueDate) {
        this.DueDate = DueDate;
    }

    public int getCardId() {
        return CardId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setCardId(int CardId) {
        this.CardId = CardId;
    }

    public int getLoanId() {
        return LoanId;
    }

    public void setLoanId(int LoanId) {
        this.LoanId = LoanId;
    }

    public float getFine() {
        return fine;
    }

    public void setFine(float fine) {
        this.fine = fine;
    }

    public String getPaid() {
        return Paid;
    }

    public void setPaid(String Paid) {
        this.Paid = Paid;
    }
    private String Paid;
}
