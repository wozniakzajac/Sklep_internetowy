package com.sklep;

/**
 * Created by Wojciech on 2015-01-30.
 */
public class Wlasciciel {

    public static void dodawanieProduktu(String nazwa, int cena, int ilosc, String opis) {
        Main.b.insertProdukt(nazwa,cena,ilosc,opis);
    }
    public static void modyfikacjaProduktu(int id, String nazwa, int cena, int ilosc, String opis) {
        Main.b.editProdukt(id,nazwa,cena,ilosc,opis);
    }
    public static void usuwanieProduktu(int id) {
        Main.b.deleteProdukt(id);
    }
}
