package com.envanter;

import com.envanter.ui.AnaPencere;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new AnaPencere().setVisible(true);
        });
    }
}
