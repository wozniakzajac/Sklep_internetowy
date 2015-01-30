package com.sklep;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class Main {
    public static Dimension rozmiarOkna = new Dimension(300,400);
    private static String currentUser = "";
    private static int currentUserID;
    private static boolean logged = false;
    public static boolean wasInBasket = false;
    //public static Produkt[] produktyLista = new Produkt[Lista.listOfFiles.length];
    public static BazaDanych b = new BazaDanych();
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {


        MainFrameGUI mainWindow = new MainFrameGUI();

       // Koszyk.historia(2);



        //Rejestracja.noweKonto("test","test","test");

       // b.insertKlient("wojtek","wojtek","email@email.com","1, 2, 3, 4, 5");

       // TimeUnit.SECONDS.sleep(3);

       // System.out.println(b.selectProduktyAll(1));

       // b.insertProdukt("prod3",100,23,"asdasdasdas");
       // b.insertProdukt("prod4",25,3,"123123123");
/*
        String t = "";
        List<Produkt> dane = b.selectProduktyAll();
        for(Produkt d: dane) t += d.toString() + "\n";
        System.out.println(t+"\n\n**********");
        t = "";
        List<Klient> kl = b.selectKlienciAll();
        for(Klient d: kl) t += d.toString() + "\n";
        System.out.println(t+"\n\n**********");
/*
        t = "";
        List<Produkt> dane2 = b.selectProduktyAll();
        for(Produkt d: dane2) t += d.toString() + "\n";
        System.out.println(t);

*/
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

    public static void setCurrentUserID(int currentUserID) {
        Main.currentUserID = currentUserID;
    }

    public static int getCurrentUserID() {
        return currentUserID;
    }
}
