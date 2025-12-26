package com.envanter.model;

public class Urun implements Depolanabilir {

    private int id;
    private String ad;
    private double fiyat;
    private int adetMiktari;

    private static final int DUSUK_ADET_LIMITI = 5;

    public Urun(int id, String ad, double fiyat, int adetMiktari) {
        this.id = id;
        this.ad = ad;
        this.fiyat = fiyat;
        this.adetMiktari = adetMiktari;
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
    public int getAdetkMiktari() {
        return adetMiktari;
    }
    public void fiyatAyarla(double fiyat) {
        if (fiyat >= 0) {
            this.fiyat = fiyat;
        }
    }
    public void stokArtir(int miktar) {
        if (miktar > 0) {
        	adetMiktari += miktar;
        }
    }
    public void stokAzalt(int miktar) {
        if (miktar > 0 && adetMiktari >= miktar) {
        	adetMiktari -= miktar;
        }
    }
    public boolean dusukStokMu() {
        return adetMiktari <= DUSUK_ADET_LIMITI;
    }
    public void depoyaEkle() {
        stokArtir(1);
    }
    public void depodanSil() {
        stokAzalt(1);
    }
}
