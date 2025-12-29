package com.envanter.model;

public abstract class Urun extends AbstractUrun {

    private static final int DUSUK_ADET_LIMITI = 5;

    public Urun(int id, String ad, double fiyat) {
    	/*  super يعني:
			روح نفذ
			constructor
			الأب (AbstractUrun)» */
        super(id, ad, fiyat);
    }

    public boolean dusukAdetMu() {
        return adetMiktari <= DUSUK_ADET_LIMITI;
    }

    public void depoyaEkle() {
    	AdetArtir(1);
    }

    public void depodanSil() {
    	AdetAzalt(1);
    }
}
