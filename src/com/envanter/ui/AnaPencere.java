package com.envanter.ui;

import javax.swing.*;
import java.awt.*;

import com.envanter.model.AbstractUrun;
import com.envanter.model.Envanter;
import com.envanter.model.Urun;
import com.envanter.service.DepoYoneticisi;
import com.envanter.model.NormalUrun;


public class AnaPencere extends JFrame {

    // ✅ المتغيرات لازم تكون داخل الكلاس
    private Envanter envanter;
    private DepoYoneticisi depoYoneticisi;

    public AnaPencere() {
        // إنشاء المنطق (Model + Service)
        envanter = new Envanter();
        depoYoneticisi = new DepoYoneticisi(envanter);

        setTitle("Envanter Yönetim Sistemi");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // العنوان
        JLabel baslik = new JLabel("Envanter Yönetim Sistemi", SwingConstants.CENTER);
        baslik.setFont(new Font("Arial", Font.BOLD, 20));
        add(baslik, BorderLayout.NORTH);

        // الأزرار
        JPanel butonPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton urunEkleBtn = new JButton("Ürün Ekle");
        JButton urunSilBtn = new JButton("Ürün Sil");
        JButton listeleBtn = new JButton("Ürünleri Listele");

        butonPanel.add(urunEkleBtn);
        butonPanel.add(urunSilBtn);
        butonPanel.add(listeleBtn);

        add(butonPanel, BorderLayout.CENTER);

        // ربط زر الإضافة
        urunEkleBtn.addActionListener(e -> urunEkle());
    }

    private void urunEkle() {
        JTextField adField = new JTextField();
        JTextField fiyatField = new JTextField();

        Object[] mesaj = {
                "Ürün Adı:", adField,
                "Fiyat:", fiyatField
        };

        int sonuc = JOptionPane.showConfirmDialog(
                this,
                mesaj,
                "Ürün Ekle",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (sonuc == JOptionPane.OK_OPTION) {
            try {
                String ad = adField.getText();
                double fiyat = Double.parseDouble(fiyatField.getText());

                AbstractUrun urun = new NormalUrun(1, ad, fiyat);
                depoYoneticisi.urunEkle(urun);

                JOptionPane.showMessageDialog(this, "Ürün başarıyla eklendi");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Hatalı giriş!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AnaPencere().setVisible(true));
    }
}
