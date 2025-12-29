package com.envanter.model;
import java.time.LocalDate;

public abstract class AbstractUrun {

    protected int id;
    protected String ad;
    protected double fiyat;
    protected int adetMiktari;
    protected LocalDate sonKullanmaTarihi;

    public AbstractUrun(int id, String ad, double fiyat) {
        this.ad = ad;
        this.fiyat = fiyat;
        this.adetMiktari = 0;
        this.sonKullanmaTarihi = null; // قد لا يكون المنتج قابلاً للتلف

    }
    
    
    protected void AdetArtir(int miktar) {
        if (miktar > 0) {
            adetMiktari += miktar;
        }
    }

    protected void AdetAzalt(int miktar) {
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
    public LocalDate getSonKullanmaTarihi() {
        return sonKullanmaTarihi;
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
    public void setSonKullanmaTarihi(LocalDate sonKullanmaTarihi) {
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }
    // يمكن لكل منتج عرض معلوماته الخاصة بطريقة مختلفة.
    public abstract String urunBilgisi();
    
}





