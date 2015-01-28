package com.sklep;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Wojciech on 2014-12-08.
 */
public class RejestracjaGUI extends JFrame{
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton zarejestrujButton;
    private JButton wyjscieButton;
    private JLabel loginLabel;
    private JLabel passwordLabel;
    private JPanel rootPanel;
    private JPasswordField repeatPasswordField;
    private JLabel repeatPasswordLabel;

    public RejestracjaGUI() {
        super("Rejestracja");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(MainFrameGUI.EXIT_ON_CLOSE);
        setSize(Main.rozmiarOkna);

        setLocationRelativeTo(null);
        setVisible(true);

        zarejestrujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f = new File("users/"+loginField.getText()+".txt");
                if(f.exists() && !f.isDirectory()) {
                    JOptionPane.showMessageDialog(RejestracjaGUI.this,
                            "Podany login jest zajęty!",
                            "Login zajęty",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if (!new String(passwordField.getPassword()).equals(new String(repeatPasswordField.getPassword()))) {
                        JOptionPane.showMessageDialog(RejestracjaGUI.this,
                                "Podane hasła są różne!",
                                "Złe hasło",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(RejestracjaGUI.this, "Zarejestrowano!");
                        try {
                            Rejestracja.noweKonto(loginField.getText(), new String(passwordField.getPassword()));
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        } catch (UnsupportedEncodingException e1) {
                            e1.printStackTrace();
                        }
                        RejestracjaGUI.this.dispose();
                        LogowanieGUI logowanieWindow = new LogowanieGUI();
                    }
                }
            }
        });

        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RejestracjaGUI.this.dispose();
                LogowanieGUI logowanieWindow = new LogowanieGUI();
            }
        });


    }
}
