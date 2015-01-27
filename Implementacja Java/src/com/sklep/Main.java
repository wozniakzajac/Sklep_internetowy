package com.sklep;

import java.awt.*;
import java.io.FileNotFoundException;

public class Main {
    public static Dimension rozmiarOkna = new Dimension(300,400);
    private static String currentUser = "";
    private static boolean logged = false;
    //public static Produkt[] produktyLista = new Produkt[Lista.listOfFiles.length];

    public static void main(String[] args) throws FileNotFoundException {

        MainFrameGUI mainWindow = new MainFrameGUI();





        //int status = Logowanie.wczytajDane("wojtek", "21");
        //System.out.println("Status: "+status);
    }
    public static boolean isLogged() {
        return logged;
    }
    public static void setLogged(boolean status) {
        logged = status;
    }
    public static String getLogin() {
        return currentUser;
    }
    public static void setLogin(String login) {
        currentUser = login;
    }
}
