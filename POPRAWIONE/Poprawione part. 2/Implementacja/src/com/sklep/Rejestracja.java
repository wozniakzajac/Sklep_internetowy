package com.sklep;

import java.util.List;

/**
 * Created by Wojciech on 2014-12-08.
 */
public class Rejestracja {
/*
    public static void noweKonto(String login, String haslo, String email) {
        Main.b.insertKlient(login,haslo,email,"");
    }
*/
    public static int noweKonto(String login, String haslo, String hasloRepeat, String email) {

        List<Klient> klienci = Main.b.selectKlienci();
        for(Klient k: klienci) {
            if ( login.equals("") || k.getLogin().equals(login) ) {
                System.out.println("Login błąd");
                return 1;
            }
            if ( email.equals("") || k.getEmail().equals(email) ) {
                System.out.println("Email błąd");
                return 2;
            }
        }

        if ( haslo.equals("") || !haslo.equals(hasloRepeat) ) {
            System.out.println("Hasla błąd");
            return 3;
        }

        Main.b.insertKlient(login, haslo, email, "");

        return 0;
    }
}
