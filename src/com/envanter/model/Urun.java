package com.envanter.model;

public class Urun implements Depolanabilir {

    private int id;
    private String ad;
    private double fiyat;
    private int stokMiktari;

    private static final int DUSUK_STOK_LIMITI = 5;

    public Urun(int id, String ad, double fiyat, int stokMiktari) {
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

    public void fiyatAyarla(double fiyat) {
        if (fiyat >= 0) {
            this.fiyat = fiyat;
        }
    }

    public void stokArtir(int miktar) {
        if (miktar > 0) {
            stokMiktari += miktar;
        }
    }

    public void stokAzalt(int miktar) {
        if (miktar > 0 && stokMiktari >= miktar) {
            stokMiktari -= miktar;
        }
    }

    public boolean dusukStokMu() {
        return stokMiktari <= DUSUK_STOK_LIMITI;
    }

    @Override
    public void depoyaEkle() {
        stokArtir(1);
    }

    @Override
    public void depodanSil() {
        stokAzalt(1);
    }
}
