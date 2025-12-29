package com.envanter.service;
//Service class , فئة الخدمة
import java.util.List;
import com.envanter.model.AbstractUrun;
import com.envanter.model.Envanter;

public class DepoYoneticisi {

    private Envanter envanter;

    public DepoYoneticisi(Envanter envanter) {
        this.envanter = envanter;
    }

    public void urunEkle(AbstractUrun  urun) {
        envanter.getUrunler().add(urun);
    }

    public void urunSil(AbstractUrun  urun) {
        envanter.getUrunler().remove(urun);
    }

    public List<AbstractUrun > tumUrunleriGetir() {
        return envanter.getUrunler();
    }
}
