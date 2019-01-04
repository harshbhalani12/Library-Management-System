/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class ManageBooks {
    private String Isbn10;
    private String CardId;
    private String BName;
    private String CheckOutDate;
    private String NotFound;

    public String getDueDate() {
        return DueDate;
    }

    public String getNotFound() {
        return NotFound;
    }

    public void setNotFound(String NotFound) {
        this.NotFound = NotFound;
    }

    public void setDueDate(String DueDate) {
        this.DueDate = DueDate;
    }
    private String DueDate;

    public String getIsbn10() {
        return Isbn10;
    }

    public void setIsbn10(String Isbn10) {
        this.Isbn10 = Isbn10;
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String CardId) {
        this.CardId = CardId;
    }

    public String getBName() {
        return BName;
    }

    public void setBName(String BName) {
        this.BName = BName;
    }

    public String getCheckOutDate() {
        return CheckOutDate;
    }

    public void setCheckOutDate(String CheckOutDate) {
        this.CheckOutDate = CheckOutDate;
    }
    
}
