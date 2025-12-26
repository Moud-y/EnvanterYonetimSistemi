package com.envanter.ui;

import javax.swing.*;
import java.awt.*;

public class AnaPencere extends JFrame {

    public AnaPencere() {
        setTitle("Envanter Yönetim Sistemi");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // وسط الشاشة
        setLayout(new BorderLayout());

        // عنوان
        JLabel baslik = new JLabel("Envanter Yönetim Sistemi", SwingConstants.CENTER);
        baslik.setFont(new Font("Arial", Font.BOLD, 20));
        add(baslik, BorderLayout.NORTH);

        // لوحة الأزرار
        JPanel butonPanel = new JPanel();
        butonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton urunEkleBtn = new JButton("Ürün Ekle");
        JButton urunSilBtn = new JButton("Ürün Sil");
        JButton listeleBtn = new JButton("Ürünleri Listele");

        butonPanel.add(urunEkleBtn);
        butonPanel.add(urunSilBtn);
        butonPanel.add(listeleBtn);

        add(butonPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AnaPencere().setVisible(true);
        });
    }
    	// UI test

}
