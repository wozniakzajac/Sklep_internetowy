package com.sklep;

/**
 * Created by Wojciech on 2014-12-09.
 */
public class Produkt {
    private String nazwa;
    private float cena;
    private String zdjecie;
    private boolean dostepnosc;
    private String opis;

    public Produkt() {

    }

    public Produkt(String addNazwa, float addCena, String addZdjecie, boolean addDostepnosc, String addOpis){
        nazwa = addNazwa;
        cena = addCena;
        zdjecie = addZdjecie;
        dostepnosc = addDostepnosc;
        opis = addOpis;
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
}
