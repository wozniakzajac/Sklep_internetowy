package com.sklep;

public class Produkt {
    private int id;
    private String nazwa;
    private int cena;
    private int ilosc;
    private String opis;



    public void setId(int id) {
        this.id = id;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getId() {
        return id;
    }

    public int getCena() {
        return cena;
    }

    public int getIlosc() {
        return ilosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public Produkt() {}
    public Produkt(int id, String nazwa, int cena, int ilosc, String opis) {
        this.id = id;
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
        this.opis = opis;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nazwa + " (" + ilosc + ") " + cena + " zł, [" + opis + "]";
    }
}