package org.example.pojo;

import javax.naming.Name;

public class Bateau {
    private String name;

    private Integer taille;

    private String surnom;

    public Bateau (String name, int taille, String surnom) {
        this.name = name;
        this.taille = taille;
        this.surnom = surnom;
    }

    public Bateau () {
        name = "";
        taille = 0;
        surnom = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }


}
