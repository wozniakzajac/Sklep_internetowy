package com.sklep;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Wojciech on 2014-12-09.
 */
public class DodajGUI extends JFrame {
    private JTextArea opisField;
    private JButton zapiszButton;
    private JButton wsteczButton;
    private JTextField cenaField;
    private JTextField nazwaField;
    private JComboBox dostBox;
    private JLabel nazwaLabel;
    private JLabel cenaLabel;
    private JLabel dostLabel;
    private JLabel opisLabel;
    private JPanel rootPanel;
    private JTextField iloscField;

    public DodajGUI() {
        super("Dodaj produkt");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(MainFrameGUI.EXIT_ON_CLOSE);
        setSize(Main.rozmiarOkna);
        setLocationRelativeTo(null);
        setVisible(true);
    }
/*
        zapiszButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean dostep;
                    if (dostBox.getSelectedIndex() == 0) dostep = true;
                    else dostep = false;
                    Dodaj.dodajProdukt(nazwaField.getText(), Float.parseFloat(cenaField.getText()),  Integer.parseInt(iloscField.getText()), opisField.getText());
                    JOptionPane.showMessageDialog(DodajGUI.this,
                            "Produkt został dodany!",
                            nazwaField.getText(),
                            JOptionPane.INFORMATION_MESSAGE);
                    DodajGUI.this.dispose();
                    PanelGUI mainWindow = new PanelGUI();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
            }
        });

        wsteczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DodajGUI.this.dispose();
                MainFrameGUI mainWindow = new MainFrameGUI();
            }
        });
    }*/
/*
nazwaField.enableInputMethods(true);
        nazwaField.enable(true);
        nazwaField.setText(Lista.produkty[id].getNazwa());
        //nazwaField.disable();
        cenaField.setText(String.valueOf(Lista.produkty[id].getCena()));
        if (Lista.produkty[id].isDostepnosc()) dostBox.setSelectedIndex(0);
        else dostBox.setSelectedIndex(1);
        opisField.setText(Lista.produkty[id].getOpis());
 */
    public DodajGUI(int action, final int id) {
        super("Edytuj produkt");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(MainFrameGUI.EXIT_ON_CLOSE);
        setSize(Main.rozmiarOkna);
        setLocationRelativeTo(null);
        setVisible(true);

        switch (action) {
            case 1: { // dodanie nowego produktu
                zapiszButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            boolean dostep;
                            //if (dostBox.getSelectedIndex() == 0) dostep = true;
                           // else dostep = false;
                            Dodaj.dodajProdukt(nazwaField.getText(), Float.parseFloat(cenaField.getText()),  Integer.parseInt(iloscField.getText()), opisField.getText());
                            JOptionPane.showMessageDialog(DodajGUI.this,
                                    "Produkt został dodany!",
                                    nazwaField.getText(),
                                    JOptionPane.INFORMATION_MESSAGE);
                            DodajGUI.this.dispose();
                            PanelGUI mainWindow = new PanelGUI();
                        } catch (java.io.IOException e1) {
                            e1.printStackTrace();
                        }


                    }
                });

                wsteczButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DodajGUI.this.dispose();
                        MainFrameGUI mainWindow = new MainFrameGUI();
                    }
                });
                break;
            }
            case 2: { // edycja istniejacego produktu

                System.out.println(Lista.produkty[id].getNazwa());
                System.out.println("ID: "+id);
                nazwaField.setText(Lista.produkty[id].getNazwa());
                cenaField.setText(Float.toString(Lista.produkty[id].getCena()));
                iloscField.setText(Integer.toString(Lista.produkty[id].getIlosc()));
                opisField.setText(Lista.produkty[id].getOpis());
                final String nazwaOld = nazwaField.getText();
                zapiszButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        try {
                           // boolean dostep;
                            //if (dostBox.getSelectedIndex() == 0) dostep = true;
                           // else dostep = false;

                            Dodaj.dodajProdukt(nazwaField.getText(), Float.parseFloat(cenaField.getText()), Integer.parseInt(iloscField.getText()), opisField.getText());

                            JOptionPane.showMessageDialog(DodajGUI.this,
                                    "Produkt został zapisany!",
                                    nazwaField.getText(),
                                    JOptionPane.INFORMATION_MESSAGE);
                            DodajGUI.this.dispose();
                            PanelGUI mainWindow = new PanelGUI();
                        } catch (java.io.IOException e1) {
                            e1.printStackTrace();
                        }

                        File f = new File("products/" + nazwaOld + ".txt");
                        f.setWritable(true);
                        f.delete();
                    }
                });

                wsteczButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DodajGUI.this.dispose();
                        MainFrameGUI mainWindow = new MainFrameGUI();
                    }
                });
                break;
            }
        }


    }
}
