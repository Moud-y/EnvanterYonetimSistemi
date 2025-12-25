package com.envanter.model;

import java.time.LocalDate;

public class BozulabilirUrun extends Urun {

	private LocalDate sonKullanmaTarihi;

    public BozulabilirUrun(int id, String ad, double fiyat, int Adetmiktari, LocalDate sonKullanmaTarihi) {
        super(id, ad, fiyat, Adetmiktari);
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }

    public LocalDate getExpiryDate() {
        return sonKullanmaTarihi;
    }
}
