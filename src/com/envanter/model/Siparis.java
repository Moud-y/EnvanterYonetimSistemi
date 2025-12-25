package com.envanter.model;

public class Siparis {

    private int siparisId;
    private Urun urun;
    private int adet;

    public Siparis(int siparisId, Urun urun, int adet) {
        this.siparisId = siparisId;
        this.urun = urun;
        this.adet = adet;
    }

    public int getSiparisId() {
        return siparisId;
    }

    public Urun getUrun() {
        return urun;
    }

    public int getAdet() {
        return adet;
    }
}
