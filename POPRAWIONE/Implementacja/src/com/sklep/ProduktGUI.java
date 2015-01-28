package com.sklep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

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

        nazwaLabel.setText("Nazwa: "+Lista.produkty[id].getNazwa());
        cenaLabel.setText("Cena: "+Lista.produkty[id].getCena()+" zł");
        textArea.setText(Lista.produkty[id].getOpis());

        if (Lista.produkty[id].getIlosc()>0) {
            dostLabel.setForeground(Color.green);
            dostLabel.setText("Dostępny");
            KUPButton.setEnabled(true);
        }
        else {
            dostLabel.setForeground(Color.red);
            dostLabel.setText("Niedostępny");
            KUPButton.setEnabled(false);
        }

        iloscLlb.setText("Ilosc: "+Lista.produkty[id].getIlosc());


        wsteczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProduktGUI.this.dispose();
                try {
                    ListaGUI listaWindow = new ListaGUI(1);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });


        KUPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Klient.kupProdukt(id);
                    JOptionPane.showMessageDialog(ProduktGUI.this,
                            "Produkt został kupiony!",
                            Lista.produkty[id].getNazwa(),
                            JOptionPane.INFORMATION_MESSAGE);
                            ProduktGUI.this.dispose();
                            try {
                                ListaGUI listaWindow = new ListaGUI(1);
                            } catch (FileNotFoundException e1) {
                                e1.printStackTrace();
                            }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
