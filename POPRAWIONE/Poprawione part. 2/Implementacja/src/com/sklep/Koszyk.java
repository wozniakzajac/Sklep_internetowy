package com.sklep;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Wojciech on 2015-01-30.
 */
public class Koszyk {

    public static List<Produkt> historia(int idKlienta) {
        Klient k = Main.b.selectKlient(idKlienta);
        List<Produkt> p = new LinkedList<Produkt>();
        String[] pid = k.getProdukty().split(", ");
        int ilosc = pid.length;

        for (int i = 0; i < ilosc; i++ ) {
            p.add(Main.b.selectProdukt(Integer.parseInt(pid[i])));
        }

        return p;
    }



}
