package com.envanter.service;
// فئة الخدمة
import java.util.List;
import com.envanter.model.AbstractUrun;
import com.envanter.model.Envanter;
import java.util.ArrayList;
import com.envanter.model.BozulabilirUrun;

public class DepoYoneticisi {

    private Envanter envanter;

    public DepoYoneticisi(Envanter envanter) {
        this.envanter = envanter;
    }
    // اضافة منتج
    public void urunEkle(AbstractUrun  urun) {
        envanter.getUrunler().add(urun);
    }
    // ازالة منتج
    public void urunSil(AbstractUrun  urun) {
        envanter.getUrunler().remove(urun);
    }

    public List<AbstractUrun > tumUrunleriGetir() {
        return envanter.getUrunler();
    }
    // الزر لاحقاً سيطلب ID
    // اما بصير UI يلف على القائمة
    // هذا منطق → service
    public AbstractUrun urunBulIdIle(int id) {
        for (AbstractUrun urun : envanter.getUrunler()) {
            if (urun.getId() == id) {
                return urun;
            }
        }
        return null;
    }

    public boolean dusukStokVarMi(AbstractUrun urun) {
        return urun.dusukStokMu();
    }
    
    public List<AbstractUrun> bozulabilirUrunleriGetir() {
        List<AbstractUrun> sonuc = new ArrayList<>();

        for (AbstractUrun urun : envanter.getUrunler()) {
            if (urun instanceof BozulabilirUrun) {
                sonuc.add(urun);
            }
        }
        return sonuc;
    }

}
