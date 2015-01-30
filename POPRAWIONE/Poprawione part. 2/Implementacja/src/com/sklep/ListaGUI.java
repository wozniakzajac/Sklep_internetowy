package com.sklep;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wojciech on 2014-12-09.
 */
public class ListaGUI extends JFrame {
    private JButton zobaczOpisKUPButton;
    private JButton wyjscieButton;
    private JPanel rootPanel;
    private JList list1;
    DefaultListModel model, historia;

    public void init() {

        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(MainFrameGUI.EXIT_ON_CLOSE);
        setSize(Main.rozmiarOkna);
        setLocationRelativeTo(null);
        setVisible(true);

        //Lista.wczytajProdukty();

        model = new DefaultListModel();
        int i = 0;
        List<Produkt> produkty = Main.b.selectProduktyAll();
        for(Produkt k: produkty) {
            model.insertElementAt("["+k.getId()+"] "+k.getNazwa()+" ("+k.getCena()+" PLN)",i++);
        }



        list1.setModel(model);
        list1.updateUI();
        list1.repaint();


    }

    public ListaGUI(int action) {
        super("Lista produktów");
        init();

        switch (action) {
            case 1: {
                //Main.wasInBasket = true;
                zobaczOpisKUPButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        List<Produkt> produkty = Main.b.selectProduktyAll();
                        int j = 0;
                        int index = -1;
                        for(Produkt k: produkty) {
                            if (j == list1.getSelectedIndex()) {
                                index = k.getId();
                                break;
                            }
                            j++;
                        }

                        ListaGUI.this.dispose();
                        ProduktGUI produktWindow = new ProduktGUI(index);
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
                        List<Produkt> produkty = Main.b.selectProduktyAll();
                        int j = 0;
                        int index = -1;
                        for(Produkt k: produkty) {
                            if (j == list1.getSelectedIndex()) {
                                index = k.getId();
                                break;
                            }
                            j++;
                        }

                            Wlasciciel.usuwanieProduktu(index);
                            JOptionPane.showMessageDialog(ListaGUI.this,
                                    "Produkt został usunięty!",
                                    "Produkt usunięty",
                                    JOptionPane.INFORMATION_MESSAGE);
                            ListaGUI.this.dispose();
                            ListaGUI list = new ListaGUI(2);
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
                        List<Produkt> produkty = Main.b.selectProduktyAll();
                        int j = 0;
                        int index = -1;
                        for(Produkt k: produkty) {
                            if (j == list1.getSelectedIndex()) {
                                index = k.getId();
                                break;
                            }
                            j++;
                        }

                        WlascicielGUI dodajWindow = new WlascicielGUI(2, index);
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
            case 4: {
               // Main.wasInBasket = true;
                final List<Produkt> pr = Koszyk.historia(Main.getCurrentUserID());
                historia = new DefaultListModel();
                int i = 0;
                for(Produkt k: pr) {
                    historia.insertElementAt("["+k.getId()+"] "+k.getNazwa()+" ("+k.getCena()+" PLN)",i++);
                }

                list1.setModel(historia);
                list1.updateUI();
                list1.repaint();

                zobaczOpisKUPButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        List<Produkt> produkty = Main.b.selectProduktyAll();
                        int j = 0;
                        int index = -1;
                        for(Produkt k: pr) {
                            if (j == list1.getSelectedIndex()) {
                                index = k.getId();
                                break;
                            }
                            j++;
                        }

                        ListaGUI.this.dispose();
                        ProduktGUI produktWindow = new ProduktGUI(index);
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
        }
    }
}
