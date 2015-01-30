package com.sklep;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;



public class BazaDanych {

    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:klienci2.db";

    private Connection conn;
    private Statement stat;

    public BazaDanych() {
        try {
            Class.forName(BazaDanych.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }

        createTablesKlienci();
        createTablesProdukty();
    }

    public boolean createTablesKlienci()  {

        String createDane = "CREATE TABLE IF NOT EXISTS klienci (ide INTEGER PRIMARY KEY AUTOINCREMENT, login varchar(255), haslo varchar(255), email varchar(255), produkty varchar(255))";

        try {
            stat.execute(createDane);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean createTablesProdukty()  {

        String createDane = "CREATE TABLE IF NOT EXISTS produkty (ide INTEGER PRIMARY KEY AUTOINCREMENT, nazwa varchar(255), cena int, ilosc int, opis varchar(255))";

        try {
            stat.execute(createDane);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertKlient(String login, String haslo, String email, String produkty) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into klienci values (NULL, ?, ?, ?, ?);");
            prepStmt.setString(1, login);
            prepStmt.setString(2, haslo);
            prepStmt.setString(3, email);
            prepStmt.setString(4, produkty);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy zapisie");
            return false;
        }
        return true;
    }

    public boolean insertProdukt(String nazwa, int cena, int ilosc, String opis) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into produkty values (NULL, ?, ?, ?, ?);");
            prepStmt.setString(1, nazwa);
            prepStmt.setInt(2, cena);
            prepStmt.setInt(3, ilosc);
            prepStmt.setString(4, opis);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy zapisie");
            return false;
        }
        return true;
    }

    public boolean editProdukt(int id, String nazwa, int cena, int ilosc, String opis)  {
        PreparedStatement preparedStatement = null;

        String sql = "update produkty set nazwa=? , cena=? , ilosc=? , opis=? where ide=?";

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nazwa);
            preparedStatement.setInt(2, cena);
            preparedStatement.setInt(3, ilosc);
            preparedStatement.setString(4, opis);
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean editKlient(int id, String produkty)  {
        PreparedStatement preparedStatement = null;

        String sql = "update klienci set produkty=? where ide=?";

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, produkty);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleteProdukt(int id)  {
        PreparedStatement preparedStatement = null;

        String sql = "delete from produkty where ide=?";

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }


    public List<Klient> selectKlienciAll() {
        List<Klient> dane = new LinkedList<Klient>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM klienci");
            int id;
            String login, haslo, email, produkty;
            while(result.next()) {
                id = result.getInt("ide");
                login = result.getString("login");
                haslo = result.getString("haslo");
                email = result.getString("email");
                produkty = result.getString("produkty");
                dane.add(new Klient(id, login, haslo, email, produkty));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dane;
    }

    public List<Klient> selectKlienci() {
        List<Klient> dane = new LinkedList<Klient>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM klienci");
            int id;
            String login, haslo, email;
            while(result.next()) {
                id = result.getInt("ide");
                login = result.getString("login");
                haslo = result.getString("haslo");
                email = result.getString("email");
                dane.add(new Klient(id, login, haslo, email, ""));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dane;
    }

    public List<Produkt> selectProduktyAll() {
        List<Produkt> dane = new LinkedList<Produkt>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM produkty");
            int id, cena, ilosc;
            String nazwa, opis;
            while(result.next()) {
                id = result.getInt("ide");
                nazwa = result.getString("nazwa");
                cena = result.getInt("cena");
                ilosc = result.getInt("ilosc");
                opis = result.getString("opis");
                dane.add(new Produkt(id, nazwa, cena, ilosc, opis));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return dane;
    }

    public Produkt selectProdukt(int id) {
        Produkt p;
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM produkty WHERE ide="+id);
            int cena, ilosc;
            String nazwa, opis;

           // id = result.getInt("ide");
            nazwa = result.getString("nazwa");
            cena = result.getInt("cena");
            ilosc = result.getInt("ilosc");
            opis = result.getString("opis");
            p = new Produkt(id, nazwa, cena, ilosc, opis);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return p;
    }

    public Klient selectKlient(int id) {
        Klient k;
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM klienci WHERE ide="+id);
            String login, haslo, email, produkty;

            id = result.getInt("ide");
            login = result.getString("login");
            haslo = result.getString("haslo");
            email = result.getString("email");
            produkty = result.getString("produkty");
            k = new Klient(id, login, haslo, email, produkty);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return k;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}