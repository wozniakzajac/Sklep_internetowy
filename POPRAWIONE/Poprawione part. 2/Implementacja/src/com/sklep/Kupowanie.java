package com.sklep;

/**
 * Created by Wojciech on 2015-01-30.
 */
public class Kupowanie {
    public static void kupowanie(int idProduktu, int idKlienta) {
        Produkt p = Main.b.selectProdukt(idProduktu);
        Klient k = Main.b.selectKlient(idKlienta);

        int nowaIlosc = p.getIlosc() - 1;
        System.out.println(nowaIlosc);

        String noweProdukty = k.getProdukty() + p.getId() + ", ";
        System.out.println(noweProdukty);


        Main.b.editProdukt(p.getId(),p.getNazwa(),p.getCena(),nowaIlosc,p.getOpis());
        Main.b.editKlient(idKlienta,noweProdukty);
    }

    public static void anulowanie(int idProduktu, int idKlienta) {
        Produkt p = Main.b.selectProdukt(idProduktu);
        Klient k = Main.b.selectKlient(idKlienta);
        boolean usuniete = false;
        int nowaIlosc = p.getIlosc() + 1;
        System.out.println(nowaIlosc);
        String noweProdukty = "";

        String[] pid = k.getProdukty().split(", ");
        int ilosc = pid.length;

        for (int i = 0; i < ilosc; i++ ) {
           if (idProduktu != Integer.parseInt(pid[i])) {
               noweProdukty += pid[i]+", ";
           } else {
               if (usuniete == false) {
                   usuniete = true;
               } else {
                   noweProdukty += pid[i]+", ";
               }
           }

        }



        System.out.println(noweProdukty);


        Main.b.editProdukt(p.getId(),p.getNazwa(),p.getCena(),nowaIlosc,p.getOpis());
        Main.b.editKlient(idKlienta,noweProdukty);
    }
}
