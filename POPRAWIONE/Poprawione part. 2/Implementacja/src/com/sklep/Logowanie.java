package com.sklep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Wojciech on 2014-12-08.
 */
public class Logowanie {

    public static int weryfikacja(String login, String haslo) {

        List<Klient> klienci = Main.b.selectKlienciAll();
        for(Klient k: klienci) {
            if ( k.getLogin().equals(login) ) {
                //System.out.println("baza: "+k.getLogin()+" wprowadzone: "+login);
                if ( k.getHaslo().equals(haslo) ) {
                    //System.out.println("baza: "+k.getHaslo()+" wprowadzone: "+haslo);
                    Main.setLogin(k.getLogin());
                    Main.setCurrentUserID(k.getId());
                    return 0;
                } else {
                    return 2;
                }
            }
        }
        return 1;
    }


      /*  public static int wczytajDane(String login, String haslo) throws FileNotFoundException {
            String loginTmp = "";
            String hasloTmp = "";
            File file = new File("users/"+login+".txt");

            if(!file.exists()) {
                return 1;
            } else {
                Scanner in = new Scanner(file);
                loginTmp = in.nextLine();
                hasloTmp = new String(in.nextLine());
            }
            if (haslo.equals(hasloTmp) && login.equals(loginTmp)) {
                return 0;
            } else {
                return 2;
            }
        }*/



}
