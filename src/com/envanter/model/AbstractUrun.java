package com.envanter.model;

public abstract class AbstractUrun {

	protected  int id;
    protected String ad;
    protected double fiyat;
    protected int adetMiktari;

    public AbstractUrun(int id, String ad, double fiyat) {
        this.id = id++;   // ID تلقائي
        this.ad = ad;
        this.fiyat = fiyat;
        this.adetMiktari = 0;
    }

    public void AdetArtir(int miktar) {
        if (miktar > 0) {
            adetMiktari += miktar;
        }
    }

    public void AdetAzalt(int miktar) {
        if (miktar > 0 && adetMiktari >= miktar) {
            adetMiktari -= miktar;
        }
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
    public int getadetMiktari() {
        return adetMiktari;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }
    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
    public void setAdetMiktari(int AdetMiktari) {
        this.adetMiktari = AdetMiktari;
    }
    // يمكن لكل منتج عرض معلوماته الخاصة بطريقة مختلفة.
    public abstract String urunBilgisi();
    
    public boolean dusukAdetMi() {
        return adetMiktari <= 5;
    }

}





