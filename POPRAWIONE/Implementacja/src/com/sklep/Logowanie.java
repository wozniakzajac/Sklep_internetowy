package com.sklep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Wojciech on 2014-12-08.
 */
public class Logowanie {


        public static int wczytajDane(String login, String haslo) throws FileNotFoundException {
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

        }


}
