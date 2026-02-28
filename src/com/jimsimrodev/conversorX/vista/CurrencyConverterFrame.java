package com.jimsimrodev.conversorX.vista;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CurrencyConverterFrame extends JFrame {

    public static CurrencyConverterFrame newInsatance() {

        CurrencyConverterFrame frame = new CurrencyConverterFrame();
        frame.setTitle("Conversor de Divisas");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 800));
        frame.setLocationRelativeTo(null);
        return frame;
    }

    private CurrencyConverterFrame() {

    }

    void main() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CurrencyConverterFrame frame = CurrencyConverterFrame.newInsatance();

                frame.setVisible(true);
            }
        });
    }

}
