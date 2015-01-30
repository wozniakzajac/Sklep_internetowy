package com.sklep;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Wojciech on 2014-12-09.
 */
public class PanelGUI extends JFrame {
    private JPanel rootPanel;
    private JButton dodajProduktButton;
    private JButton usunProduktButton;
    private JButton edytujProduktButton;
    private JButton wyjscieButton;

    public PanelGUI() {
        super("Panel administracyjny");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(MainFrameGUI.EXIT_ON_CLOSE);
        setSize(Main.rozmiarOkna);
        setLocationRelativeTo(null);
        setVisible(true);


        dodajProduktButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WlascicielGUI dodajWindow = new WlascicielGUI(1,1);
                PanelGUI.this.dispose();
            }
        });

        edytujProduktButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    ListaGUI listaWindow = new ListaGUI(3);

                PanelGUI.this.dispose();
            }
        });

        usunProduktButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    ListaGUI listaWindow = new ListaGUI(2);

                PanelGUI.this.dispose();
            }
        });

        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrameGUI mainWindow = new MainFrameGUI();
                PanelGUI.this.dispose();
            }
        });
    }


}
