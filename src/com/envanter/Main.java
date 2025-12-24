package com.envanter;

import com.envanter.model.Urun;

public class Main {

    public static void main(String[] args) {

        Urun urun = new Urun(1, "Kalem", 5.0, 3);

        System.out.println("Ürün adı: " + urun.getAd());
        System.out.println("Stok miktarı: " + urun.getStokMiktari());
        System.out.println("Düşük stok mu? " + urun.dusukStokMu());

        urun.stokArtir(5);
        System.out.println("Yeni stok miktarı: " + urun.getStokMiktari());
    }
}
