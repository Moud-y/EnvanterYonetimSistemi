package com.envanter.service;
// فئة الخدمة
import java.util.List;
import com.envanter.model.AbstractUrun;
import com.envanter.model.Envanter;
import java.util.ArrayList;
import com.envanter.model.BozulabilirUrun;

public class DepoYoneticisi {
	// منطق
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
    
    //بحث عن طريق الاي دي
    public AbstractUrun urunBulIdIle(int id) {
        for (AbstractUrun urun : envanter.getUrunler()) {
            if (urun.getId() == id) {
                return urun;
            }
        }
        return null;
    }

    public boolean dusukAdetVarMi(AbstractUrun urun) {
        return urun.dusukAdetMi();
    }
    
    //بحث عن طريق الاسم
    public AbstractUrun urunBulAdGore(String ad) {
        for (AbstractUrun urun : envanter.getUrunler()) {
            if (urun.getAd().equalsIgnoreCase(ad)) {
                return urun;
            }
        }
        return null;
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
    //هذا الميثود مسؤول عن تحديث المخزون لأي منتج، سواء زيادة او تقصان
    public void AdetGuncelle(AbstractUrun urun, int miktar) {
        if (miktar > 0) {
            urun.AdetArtir(miktar);
        } else if (miktar < 0) {
            urun.AdetAzalt(Math.abs(miktar));
        }
    }


}
