package com.envanter.model;
import java.time.LocalDate;

public abstract class BozulabilirUrun extends AbstractUrun {
	
    public BozulabilirUrun(int id, String ad, double fiyat, LocalDate sonKullanmaTarihi) {
        super(id, ad, fiyat);
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }
    
    public boolean sonKullanmaTarihiGectiMi() {
        if (sonKullanmaTarihi == null) {
            return false;
        }
        return LocalDate.now().isAfter(sonKullanmaTarihi);
    }
    
    public boolean duskAdetmi() {
        return adetMiktari <= 2;
    }
}