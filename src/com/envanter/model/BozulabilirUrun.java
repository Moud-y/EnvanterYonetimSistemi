package com.envanter.model;
import java.time.LocalDate;

public class BozulabilirUrun extends AbstractUrun {
    private LocalDate SonKullanmaTarihi;

    public LocalDate getSonKullanmaTarihi() {
        return SonKullanmaTarihi;
    }
    
    public BozulabilirUrun(int id, String ad, double fiyat, LocalDate sonKullanmaTarihi) {
        super(id, ad, fiyat);
        this.SonKullanmaTarihi = sonKullanmaTarihi;
    }
    // هل انتهت مدته ؟
    // منطق خاص بالمنتجات القابلة للتلف
    public boolean bozulmusmu() {
        return LocalDate.now().isAfter(SonKullanmaTarihi);
    }
     public void setSonKullanmaTarihi(LocalDate skt) {
        this.SonKullanmaTarihi = skt;
    }
     public String urunBilgisi() {
         return "ID: " + id +
        		"  |   Ürün: " + ad +
        		"      Fiyat: " + fiyat +
                "      Adet: " + adetMiktari +
                "      SKT: " + SonKullanmaTarihi +
         		"      Tedarikçi: " + (getTedarikci() != null ? getTedarikci() : "-");
     }
}