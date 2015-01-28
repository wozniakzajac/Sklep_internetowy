package com.sklep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Wojciech on 2014-12-09.
 */
public class Lista {
    private static File folder = new File("products");
    public static File[] listOfFiles = folder.listFiles();

    public static Produkt[] produkty = new Produkt[listOfFiles.length+10];
    public static Produkt[] zakupy = new Produkt[listOfFiles.length+10];

    public static int liczbaProduktow() {
        File folder = new File("products");
        File[] listOfFiles = folder.listFiles();
        return listOfFiles.length;
    }


    public static void wczytajProdukty() throws FileNotFoundException {
        File folder = new File("products");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                Scanner in = new Scanner(listOfFiles[i]);
                produkty[i] = new Produkt();
                produkty[i].setNazwa(in.nextLine());
                produkty[i].setCena(Float.parseFloat(in.nextLine()));
                produkty[i].setZdjecie(in.nextLine());
                produkty[i].setDostepnosc(Boolean.parseBoolean(in.nextLine()));
                produkty[i].setIlosc(Integer.parseInt(in.nextLine()));
                produkty[i].setOpis(in.nextLine());
            }
        }
    }

    public static void wczytajZakupy() throws FileNotFoundException {
        String loginTmp = "";
        String hasloTmp = "";
        int i = 0;
        String tmp = "";
        String [] kupione = new String[listOfFiles.length+10];
        File file = new File("users/"+Main.getLogin()+".txt");

        System.out.println(Main.getLogin());

        if(!file.exists()) {
            System.out.println("User not found.");
        } else {
            Scanner in = new Scanner(file);
            loginTmp = in.nextLine();
            hasloTmp = new String(in.nextLine());


            while(true) {
                if (in.hasNextLine()) {
                    tmp = in.nextLine();
                    if (Boolean.parseBoolean(in.nextLine()) == true) {
                        kupione[i] = tmp;
                        i++;
                    }
                }
            }
        }

        for (int j = 0; j < kupione.length; j++) {
            System.out.println(kupione[j]);
        }



       /* File folder = new File("products");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                Scanner in = new Scanner(listOfFiles[i]);
                produkty[i] = new Produkt();
                produkty[i].setNazwa(in.nextLine());
                produkty[i].setCena(Float.parseFloat(in.nextLine()));
                produkty[i].setZdjecie(in.nextLine());
                produkty[i].setDostepnosc(Boolean.parseBoolean(in.nextLine()));
                produkty[i].setIlosc(Integer.parseInt(in.nextLine()));
                produkty[i].setOpis(in.nextLine());
            }
        }*/
    }
/*
    public static void aktualizujListe() throws FileNotFoundException {
        File folder = new File("products");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                Scanner in = new Scanner(listOfFiles[i]);
                produkty[i] = new Produkt();
                produkty[i].setNazwa(in.nextLine());
                produkty[i].setCena(Float.parseFloat(in.nextLine()));
                produkty[i].setZdjecie(in.nextLine());
                produkty[i].setDostepnosc(Boolean.parseBoolean(in.nextLine()));
                produkty[i].setOpis(in.nextLine());
            }
        }

    }*/
}
