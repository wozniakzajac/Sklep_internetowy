package com.sklep;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Created by Wojciech on 2014-12-08.
 */
public class LogowanieGUI extends JFrame{
    private JTextField loginField;
    private JButton zalogujButton;
    private JButton rejestracjaButton;
    private JButton wyjscieButton;
    private JPasswordField passwordField;
    private JLabel loginLabel;
    private JLabel hasloLabel;
    private JPanel rootPanel;

    public LogowanieGUI() {
        super("Logowanie");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(MainFrameGUI.EXIT_ON_CLOSE);
        setSize(Main.rozmiarOkna);
        setLocationRelativeTo(null);
        setVisible(true);

        //System.out.println(Lista.produktyLista[0].getNazwa());
       // System.out.println(Lista.produktyLista[1].getNazwa());

        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int status = -1;
                try {
                    status = Logowanie.wczytajDane(loginField.getText(),  new String(passwordField.getPassword()));
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                switch (status) {
                    case 0: {
                        Main.setLogin(loginField.getText());
                        JOptionPane.showMessageDialog(LogowanieGUI.this,
                                "Witaj "+Main.getLogin()+"!",
                                "Zalogowano",
                                JOptionPane.INFORMATION_MESSAGE);
                        LogowanieGUI.this.dispose();
                        Main.setLogged(true);

                        MainFrameGUI mainWindow = new MainFrameGUI();
                        break;
                    }
                    case 1: {
                        JOptionPane.showMessageDialog(LogowanieGUI.this,
                                "Użytkownik o podanym loginie nie istnieje!",
                                "Zły login",
                                JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    case 2: {
                        JOptionPane.showMessageDialog(LogowanieGUI.this,
                                "Podane hasło jest nieprawidłowe!",
                                "Złe hasło",
                                JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
            }
        });

        rejestracjaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogowanieGUI.this.dispose();
                RejestracjaGUI rejestracjaWindow = new RejestracjaGUI();
            }
        });
        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogowanieGUI.this.dispose();
                MainFrameGUI mainWindow = new MainFrameGUI();
            }
        });


    }
}
