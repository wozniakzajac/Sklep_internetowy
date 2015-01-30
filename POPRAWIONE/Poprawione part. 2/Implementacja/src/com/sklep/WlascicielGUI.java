package com.sklep;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Wojciech on 2014-12-09.
 */
public class WlascicielGUI extends JFrame {
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

    public WlascicielGUI() {
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
    public WlascicielGUI(int action, final int id) {
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
                        Wlasciciel.dodawanieProduktu(nazwaField.getText(), Integer.parseInt(cenaField.getText()), Integer.parseInt(iloscField.getText()), opisField.getText());

                        JOptionPane.showMessageDialog(WlascicielGUI.this,
                                "Produkt został zapisany!",
                                nazwaField.getText(),
                                JOptionPane.INFORMATION_MESSAGE);
                        WlascicielGUI.this.dispose();
                        PanelGUI mainWindow = new PanelGUI();



                    }
                });

                wsteczButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        WlascicielGUI.this.dispose();
                        MainFrameGUI mainWindow = new MainFrameGUI();
                    }
                });
                break;
            }
            case 2: { // edycja istniejacego produktu
                Produkt p;
                p = Main.b.selectProdukt(id);

                nazwaField.setText(p.getNazwa());
                cenaField.setText(Integer.toString(p.getCena()));
                iloscField.setText(Integer.toString(p.getIlosc()));
                opisField.setText(p.getOpis());



                zapiszButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        //Dodaj.dodajProdukt(nazwaField.getText(), Float.parseFloat(cenaField.getText()), Integer.parseInt(iloscField.getText()), opisField.getText());
                        Wlasciciel.modyfikacjaProduktu(id, nazwaField.getText(), Integer.parseInt(cenaField.getText()), Integer.parseInt(iloscField.getText()), opisField.getText());


                        JOptionPane.showMessageDialog(WlascicielGUI.this,
                                "Produkt został zapisany!",
                                nazwaField.getText(),
                                JOptionPane.INFORMATION_MESSAGE);
                        WlascicielGUI.this.dispose();
                        PanelGUI mainWindow = new PanelGUI();
                    }
                });

                wsteczButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        WlascicielGUI.this.dispose();
                        MainFrameGUI mainWindow = new MainFrameGUI();
                    }
                });
                break;
            }
        }


    }
}
