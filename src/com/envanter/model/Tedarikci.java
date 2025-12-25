package com.envanter.model;

public class Tedarikci {

    private int id;
    private String ad;
    private String İletisimbilgileri;

    public Tedarikci(int id, String name, String İletisimbilgileri) {
        this.id = id;
        this.ad = name;
        this.İletisimbilgileri = İletisimbilgileri;
    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public String getIletisimbilgileri() {
        return İletisimbilgileri;
    }
}
