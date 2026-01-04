package com.envanter.model;

public class NormalUrun extends AbstractUrun {

	public NormalUrun(int id, String ad, double fiyat) {
	    super(id, ad, fiyat);
	}

    public String urunBilgisi() {
        return "ID: " + id +
               "        Ürün: " + ad +
               "        Fiyat: " + fiyat +
               "        Adet: " + adetMiktari;
    }
}
