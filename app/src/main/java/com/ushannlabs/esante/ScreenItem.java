package com.ushannlabs.esante;

public class ScreenItem {

    String Title,Description;
    int ScrennImg;



    public ScreenItem(String title, String description, int scrennImg) {
        Title = title;
        Description = description;
        ScrennImg = scrennImg;
    }//end


    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getScrennImg() {
        return ScrennImg;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setScrennImg(int scrennImg) {
        ScrennImg = scrennImg;
    }
}
