package com.envanter.ui;

import javax.swing.*;
import java.awt.*;

import com.envanter.model.AbstractUrun;
import com.envanter.model.Envanter;
import com.envanter.model.Urun;
import com.envanter.service.DepoYoneticisi;
import com.envanter.model.NormalUrun;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class AnaPencere extends JFrame {

    // ✅ المتغيرات لازم تكون داخل الكلاس
    private Envanter envanter;
    private DepoYoneticisi depoYoneticisi;

    public AnaPencere() {
        // إنشاء المنطق (Model + Service)
    	// إعدادات الواجهة
        // إنشاء الأزرار
        // ربط الأزرار
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

        // ربط زر الأزرار
        urunEkleBtn.addActionListener(e -> urunEkle());
    	listeleBtn.addActionListener(e -> urunleriListele());
    	urunSilBtn.addActionListener(e -> urunSil());


    }
    	
    private int id = 1;
    
    private void urunEkle() {
        JTextField adField = new JTextField();
        JTextField fiyatField = new JTextField();
        JTextField adetMiktariField = new JTextField();

        Object[] mesaj = {
                "Ürün Adı:", adField,
                "Fiyat:", fiyatField,
                "adet:", adetMiktariField,
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
                int adet = Integer.parseInt(adetMiktariField.getText());

                AbstractUrun urun = new NormalUrun(id++, ad, fiyat);
                urun.setAdetMiktari(adet);
                depoYoneticisi.urunEkle(urun);

                JOptionPane.showMessageDialog(this, "Ürün eklendi");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Hatalı giriş!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void urunleriListele() {
        var urunler = depoYoneticisi.tumUrunleriGetir();

        if (urunler.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Henüz ürün eklenmemiş.",
                "Bilgi",
                JOptionPane.INFORMATION_MESSAGE
            );
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (var urun : urunler) {
            sb.append(urun.urunBilgisi()).append("\n");
            sb.append("-------------------\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(
            this,
            scrollPane,
            "Ürün Listesi",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    private void urunSil() {
        String input = JOptionPane.showInputDialog(
            this,
            "Silinecek ürün ID:",
            "Ürün Sil",
            JOptionPane.QUESTION_MESSAGE
        );

        if (input == null) return;

        try {
            int id = Integer.parseInt(input);
            AbstractUrun urun = depoYoneticisi.urunBulIdIle(id);
            if (urun == null) {
                JOptionPane.showMessageDialog(
                    this,
                    "Ürün bulunamadı!",
                    "Hata",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            depoYoneticisi.urunSil(urun);
            JOptionPane.showMessageDialog(this, "Ürün silindi.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                this,
                "Geçersiz ID!",
                "Hata",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AnaPencere().setVisible(true));
    }
}
