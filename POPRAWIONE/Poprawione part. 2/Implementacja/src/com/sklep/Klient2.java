package com.sklep;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Wojciech on 2015-01-28.
 */
public class Klient2 {

    public static void kupProdukt(int id) throws IOException {
        String nazwa = Lista.produkty[id].getNazwa();
        String user = "users/"+Main.getLogin()+".txt";

        PrintWriter klient = new PrintWriter(new BufferedWriter(new FileWriter(user, true)));
        klient.println(nazwa);
        klient.println(true); //czy aktualne
        klient.close();



        Dodaj.dodajProdukt(Lista.produkty[id].getNazwa(), Lista.produkty[id].getCena(),  Lista.produkty[id].getIlosc()-1, Lista.produkty[id].getOpis());

    }

}
