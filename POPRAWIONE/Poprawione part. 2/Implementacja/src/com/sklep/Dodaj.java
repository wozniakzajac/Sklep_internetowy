package com.sklep;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by Wojciech on 2014-12-09.
 */
public class Dodaj {
    public static void dodajProdukt(String nazwa, float cena, int ilosc, String opis) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("products/"+nazwa+".txt", "UTF-8");
        writer.println(nazwa);
        writer.println(cena);
        writer.println();
        writer.println("true");
        writer.println(ilosc);
        writer.println(opis);
        writer.close();
    }
}
