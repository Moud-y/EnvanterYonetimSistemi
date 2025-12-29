package com.envanter.service;
import com.envanter.model.Envanter;
import com.envanter.model.Urun;
import java.util.List;

public class DepoYoneticisi {

    private Envanter envanter;

    public DepoYoneticisi(Envanter envanter) {
        this.envanter = envanter;
    }

    public void urunEkle(Urun urun) {
        envanter.getUrunler().add(urun);
    }

    public void urunSil(Urun urun) {
        envanter.getUrunler().remove(urun);
    }

    public List<Urun> tumUrunleriGetir() {
        return envanter.getUrunler();
    }
}
