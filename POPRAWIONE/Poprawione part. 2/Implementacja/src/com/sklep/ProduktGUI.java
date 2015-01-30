package com.sklep;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by Wojciech on 2014-12-09.
 */
public class ProduktGUI extends JFrame{
    private JTextArea textArea;
    private JLabel nazwaLabel;
    private JLabel cenaLabel;
    private JLabel dostLabel;
    private JButton KUPButton;
    private JButton wsteczButton;
    private JPanel rootPanel;
    private JLabel iloscLlb;

    public ProduktGUI(final int id) {
        super("Opis produktu");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(MainFrameGUI.EXIT_ON_CLOSE);
        setSize(Main.rozmiarOkna);
        setLocationRelativeTo(null);
        setVisible(true);

        final Produkt p;
        p = Main.b.selectProdukt(id);

        nazwaLabel.setText("Nazwa: "+p.getNazwa());
        cenaLabel.setText("Cena: "+Integer.toString(p.getCena()));
        iloscLlb.setText("Ilosc: "+Integer.toString(p.getIlosc()));
        textArea.setText(p.getOpis());

        if (p.getIlosc()>0) {
            dostLabel.setForeground(Color.green);
            dostLabel.setText("Dostępny");
            KUPButton.setEnabled(true);
        }
        else {
            dostLabel.setForeground(Color.red);
            dostLabel.setText("Niedostępny");
            KUPButton.setEnabled(false);
        }

        if (!Main.wasInBasket) {

            KUPButton.setText("KUP");
        } else {
            KUPButton.setText("Anuluj zakup");
        }
        wsteczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProduktGUI.this.dispose();
                if (!Main.wasInBasket) {
                    ListaGUI listaWindow = new ListaGUI(1);
                } else {
                    ListaGUI listaWindow = new ListaGUI(4);
                }

            }
        });


        KUPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!Main.wasInBasket) {

                    KUPButton.setText("KUP");
                    Kupowanie.kupowanie(p.getId(), Main.getCurrentUserID());
                    JOptionPane.showMessageDialog(ProduktGUI.this,
                            "Produkt został kupiony!",
                            p.getNazwa(),
                            JOptionPane.INFORMATION_MESSAGE);
                    ProduktGUI.this.dispose();
                    ListaGUI produktyWindow = new ListaGUI(1);
                    String t = "";
                    java.util.List<Produkt> dane = Main.b.selectProduktyAll();
                    for (Produkt d : dane) t += d.toString() + "\n";
                    System.out.println(t + "\n\n**********");
                    t = "";
                    java.util.List<Klient> kl = Main.b.selectKlienciAll();
                    for (Klient d : kl) t += d.toString() + "\n";
                    System.out.println(t + "\n\n**********");
                } else {
                    KUPButton.setText("Anuluj zakup");
                    Kupowanie.anulowanie(p.getId(), Main.getCurrentUserID());
                    JOptionPane.showMessageDialog(ProduktGUI.this,
                            "Zakup został anulowany!",
                            p.getNazwa(),
                            JOptionPane.INFORMATION_MESSAGE);
                    ProduktGUI.this.dispose();
                    ListaGUI produktyWindow = new ListaGUI(4);
                    String t = "";
                    java.util.List<Produkt> dane = Main.b.selectProduktyAll();
                    for (Produkt d : dane) t += d.toString() + "\n";
                    System.out.println(t + "\n\n**********");
                    t = "";
                    java.util.List<Klient> kl = Main.b.selectKlienciAll();
                    for (Klient d : kl) t += d.toString() + "\n";
                    System.out.println(t + "\n\n**********");
                }

            }
        });
    }
}
