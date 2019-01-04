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
public class LoanDetail {
    private int LoanId;
    private float FineAmt;
    private String paid;
    private Date DueDate, DateIn;

    public int getLoanId() {
        return LoanId;
    }

    public void setLoanId(int LoanId) {
        this.LoanId = LoanId;
    }

    public float getFineAmt() {
        return FineAmt;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public void setFineAmt(float FineAmt) {
        this.FineAmt = FineAmt;
    }

    

    public Date getDueDate() {
        return DueDate;
    }

    public void setDueDate(Date DueDate) {
        this.DueDate = DueDate;
    }

    public Date getDateIn() {
        return DateIn;
    }

    public void setDateIn(Date DateIn) {
        this.DateIn = DateIn;
    }
    
}
