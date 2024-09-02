package com.example.tp1_moviles;

import java.io.Serializable;

public class Palabra implements Serializable {

    private String espanol, english;
    private int idImg;

    public Palabra(String espanol, String english, int idImg) {
        this.espanol = espanol;
        this.english = english;
        this.idImg = idImg;
    }

    public String getEspanol() {
        return espanol;
    }

    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }
}
