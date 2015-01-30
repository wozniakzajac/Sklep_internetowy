package com.sklep;

/**
 * Created by Wojciech on 2014-12-09.
 */
public class Produkt2 {
    private String nazwa;
    private float cena;
    private String zdjecie;
    private boolean dostepnosc;
    private int ilosc;
    private String opis;

    public Produkt2() {

    }

    public Produkt2(String addNazwa, float addCena, String addZdjecie, boolean addDostepnosc, String addOpis, int addIlosc){
        nazwa = addNazwa;
        cena = addCena;
        zdjecie = addZdjecie;
        dostepnosc = addDostepnosc;
        opis = addOpis;
        ilosc = addIlosc;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public String getNazwa() {
        return nazwa;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }
    public float getCena() {
        return cena;
    }

    public void setZdjecie(String zdjecie) {
        this.zdjecie = zdjecie;
    }
    public String getZdjecie() {
        return zdjecie;
    }

    public void setDostepnosc(boolean dostepnosc) {
        this.dostepnosc = dostepnosc;
    }
    public boolean isDostepnosc() {
        return dostepnosc;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    public String getOpis() {
        return opis;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
    public int getIlosc() {
        return ilosc;
    }
}
