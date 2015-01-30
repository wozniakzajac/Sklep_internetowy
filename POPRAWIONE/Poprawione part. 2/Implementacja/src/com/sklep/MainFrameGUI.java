package com.sklep;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Created by Wojciech on 2014-12-08.
 */
public class MainFrameGUI extends JFrame{
    private JPanel rootPanel;
    private JButton logowanieButton;
    private JButton listaProduktowButton;
    private JButton wyszukiwanieButton;
    private JButton wyjscieButton;
    private JLabel uzytkownikLabel;
    private JButton koszykButton;
    private JButton rejestracjaButton;

    public MainFrameGUI() {
        super("Sklep Internetowy");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(MainFrameGUI.EXIT_ON_CLOSE);
        setSize(Main.rozmiarOkna);
        setLocationRelativeTo(null);
        setVisible(true);

        if (Main.isLogged()) {
            uzytkownikLabel.setText("Zalogowoany jako: " + Main.getLogin());
            logowanieButton.setText("Wyloguj");
            rejestracjaButton.setEnabled(false);
            koszykButton.setVisible(true);
            if (Main.getLogin().equals("admin")) {
                koszykButton.setText("Panel");
            }
        }
        else {
            uzytkownikLabel.setText("Zalogowoany jako: Gość");
            logowanieButton.setText("Logowanie");
            koszykButton.setVisible(false);
            rejestracjaButton.setEnabled(true);

        }


        koszykButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Main.getLogin().equals("admin")) {
                    PanelGUI dodajWindow = new PanelGUI();
                    MainFrameGUI.this.dispose();
                } else {
                    Main.wasInBasket = true;
                    ListaGUI listaWindow = new ListaGUI(4);
                    MainFrameGUI.this.dispose();
                }
            }
        });

        wyszukiwanieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SzukajGUI szukajWindow = new SzukajGUI();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                MainFrameGUI.this.dispose();
            }
        });


        listaProduktowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Main.isLogged()) {
                        Main.wasInBasket = false;
                        ListaGUI produktyWindow = new ListaGUI(1);

                    MainFrameGUI.this.dispose();
                } else {
                    JOptionPane.showMessageDialog(MainFrameGUI.this,
                            "Aby zobaczyć listę produktów musisz być zalogowany!",
                            "Zaloguj się",
                            JOptionPane.WARNING_MESSAGE);
                }


            }
        });

        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        logowanieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Main.isLogged()) {
                    JOptionPane.showMessageDialog(MainFrameGUI.this,
                            "Żegnaj "+Main.getLogin()+"!",
                            "Wylogowano!",
                            JOptionPane.INFORMATION_MESSAGE);
                    Main.setLogged(false);
                    rejestracjaButton.setEnabled(true);
                    koszykButton.setVisible(false);
                    uzytkownikLabel.setText("Zalogowoany jako: Gość");
                    logowanieButton.setText("Logowanie");
                    Main.setLogin("");
                } else {
                    LogowanieGUI loginWindow = new LogowanieGUI();
                    MainFrameGUI.this.dispose();
                }



            }
        });


        rejestracjaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RejestracjaGUI registerWindow = new RejestracjaGUI();
                MainFrameGUI.this.dispose();
            }
        });
    }
}
