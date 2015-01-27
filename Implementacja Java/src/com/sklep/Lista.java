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
                produkty[i].setOpis(in.nextLine());
            }
        }
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
