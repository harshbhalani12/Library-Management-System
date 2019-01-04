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
public class Books {
    private String Isbn10;
    private String Isbn13;
    private String Title;
    private String Cover;
    private String Publisher;
    private String Pages;

    public String getAvailable() {
        return Available;
    }

    public void setAvailable(String Available) {
        this.Available = Available;
    }
    private String Available;

    public String getAllAuthors() {
        return AllAuthors;
    }

    public void setAllAuthors(String AllAuthors) {
        this.AllAuthors = AllAuthors;
    }
    private String AllAuthors;

    
   
    
    public String getIsbn10() {
        return Isbn10;
    }

    public void setIsbn10(String Isbn10) {
        this.Isbn10 = Isbn10;
    }

    public String getIsbn13() {
        return Isbn13;
    }

    public void setIsbn13(String Isbn13) {
        this.Isbn13 = Isbn13;
    }

    

   

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getCover() {
        return Cover;
    }

    public void setCover(String Cover) {
        this.Cover = Cover;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }

    public String getPages() {
        return Pages;
    }

    public void setPages(String Pages) {
        this.Pages = Pages;
    }
}
