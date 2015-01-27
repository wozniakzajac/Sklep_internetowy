package com.sklep;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Created by Wojciech on 2014-12-09.
 */
public class SzukajGUI extends JFrame{
    private JPanel rootPanel;
    private JTextField textField1;
    private JButton szukajButton;
    private JList list1;
    private JButton zobaczProduktButton;
    private JButton wsteczButton;
    DefaultListModel model;

    public SzukajGUI() throws FileNotFoundException {
        super("Wyszukaj produkt");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(MainFrameGUI.EXIT_ON_CLOSE);
        setSize(Main.rozmiarOkna);
        setLocationRelativeTo(null);
        setVisible(true);

        Lista.wczytajProdukty();

        model = new DefaultListModel();

        szukajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.clear();
                for (int i = 0; i < Lista.listOfFiles.length; i++) {
                    int k = 0;
                    if (Lista.produkty[i].getNazwa().contains(textField1.getText())) {
                        model.insertElementAt(Lista.produkty[i].getNazwa()+" (cena "+Lista.produkty[i].getCena()+" zł)",k);
                    }

                }
                list1.setModel(model);
                list1.updateUI();
                list1.repaint();
            }
        });

        wsteczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameGUI mainWindow = new MainFrameGUI();
                SzukajGUI.this.dispose();
            }
        });
    }
}
