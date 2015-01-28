package com.sklep;

import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Wojciech on 2014-12-09.
 */
public class ListaGUI extends JFrame {
    private JButton zobaczOpisKUPButton;
    private JButton wyjscieButton;
    private JPanel rootPanel;
    private JList list1;
    DefaultListModel model;

    public void init() throws FileNotFoundException {

        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(MainFrameGUI.EXIT_ON_CLOSE);
        setSize(Main.rozmiarOkna);
        setLocationRelativeTo(null);
        setVisible(true);

        Lista.wczytajProdukty();

        model = new DefaultListModel();
        for (int i = 0; i < Lista.listOfFiles.length; i++) {
            model.insertElementAt(Lista.produkty[i].getNazwa() + " (cena " + Lista.produkty[i].getCena() + " zł)", i);
        }
        list1.setModel(model);
        list1.updateUI();
        list1.repaint();


    }

    public ListaGUI(int action) throws FileNotFoundException {
        super("Lista produktów");
        init();

        switch (action) {
            case 1: {
                zobaczOpisKUPButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ListaGUI.this.dispose();
                        ProduktGUI produktWindow = new ProduktGUI(list1.getSelectedIndex());
                    }
                });

                wyjscieButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ListaGUI.this.dispose();
                        MainFrameGUI mainWindow = new MainFrameGUI();
                    }
                });
                break;
            }
            case 2: {
                wyjscieButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ListaGUI.this.dispose();
                        PanelGUI panelWindow = new PanelGUI();
                    }
                });
                zobaczOpisKUPButton.setText("Usuń");
                zobaczOpisKUPButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        File f = new File("products/" + Lista.produkty[list1.getSelectedIndex()].getNazwa() + ".txt");
                        f.setWritable(true);
                        if (f.delete()) {
                            JOptionPane.showMessageDialog(ListaGUI.this,
                                    "Produkt został usunięty!",
                                    "Produkt usunięty",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        ;
                        try {
                            Lista.wczytajProdukty();
                            ListaGUI.this.repaint();
                            model = new DefaultListModel();
                            for (int i = 0; i < Lista.liczbaProduktow(); i++) {
                                model.insertElementAt(Lista.produkty[i].getNazwa() + " (cena " + Lista.produkty[i].getCena() + " zł)", i);
                            }
                            list1.setModel(model);
                            list1.updateUI();
                            list1.repaint();
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                break;
            }
            case 3: {
                wyjscieButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ListaGUI.this.dispose();
                        PanelGUI panelWindow = new PanelGUI();
                    }
                });
                zobaczOpisKUPButton.setText("Edytuj");
                zobaczOpisKUPButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DodajGUI dodajWindow = new DodajGUI(2, list1.getSelectedIndex());
                        System.out.println(list1.getSelectedIndex());
                        /*if (f.delete()) {
                            JOptionPane.showMessageDialog(ListaGUI.this,
                                    "Produkt został usunięty!",
                                    "Produkt usunięty",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        ;
                        try {
                            Lista.wczytajProdukty();
                            ListaGUI.this.repaint();
                            model = new DefaultListModel();
                            for (int i = 0; i < Lista.liczbaProduktow(); i++) {
                                model.insertElementAt(Lista.produkty[i].getNazwa() + " (cena " + Lista.produkty[i].getCena() + " zł)", i);
                            }
                            list1.setModel(model);
                            list1.updateUI();
                            list1.repaint();
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }*/
                    }
                });
                break;
            }

        }
    }
}
