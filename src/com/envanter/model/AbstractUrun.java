package com.envanter.model;

public abstract class AbstractUrun {

    private int id;
    private String ad;
    private double fiyat;
    private int stokMiktari;

    public AbstractUrun(int id, String ad, double fiyat, int stokMiktari) {
        this.id = id;
        this.ad = ad;
        this.fiyat = fiyat;
        this.stokMiktari = stokMiktari;
    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    public int getStokMiktari() {
        return stokMiktari;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public void setStokMiktari(int stokMiktari) {
        this.stokMiktari = stokMiktari;
    }

    // يمكن لكل منتج عرض معلوماته الخاصة بطريقة مختلفة.
    public abstract String urunBilgisi();
}
