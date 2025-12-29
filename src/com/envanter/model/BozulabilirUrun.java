package com.envanter.model;
import java.time.LocalDate;

public abstract class BozulabilirUrun extends AbstractUrun {
	
    private LocalDate sonKullanmaTarihi;

    public LocalDate getSonKullanmaTarihi() {
        return sonKullanmaTarihi;
    }
    
    public BozulabilirUrun(int id, String ad, double fiyat, LocalDate sonKullanmaTarihi) {
        super(id, ad, fiyat);
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }
    // هل انتهت مدته ؟
    // منطق خاص بالمنتجات القابلة للتلف
    public boolean bozulmusmu() {
        if (sonKullanmaTarihi == null) {
            return false;
        }
        return LocalDate.now().isAfter(sonKullanmaTarihi);
    }
     public void setSonKullanmaTarihi(LocalDate sonKullanmaTarihi) {
        this.sonKullanmaTarihi = sonKullanmaTarihi;
    }
    public String urunBilgisi() {
        return "Bozulabilir Ürün: " + ad +
               " | Fiyat: " + fiyat +
               " | Stok: " + adetMiktari +
               " | SKT: " + sonKullanmaTarihi;
    }
}