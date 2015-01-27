package com.sklep;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by Wojciech on 2014-12-08.
 */
public class Rejestracja {



    public static void noweKonto(String login, String haslo) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("users/"+login+".txt", "UTF-8");
        writer.println(login);
        writer.println(haslo);
        writer.close();
    }
}
