package com.sklep;
public class Klient {
    private int id;
    private String login;
    private String haslo;
    private String email;
    private String produkty;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProdukty() {
        return produkty;
    }

    public void setProdukty(String produkty) {
        this.produkty = produkty;
    }

    public Klient() {}
    public Klient(int id, String login, String haslo, String email, String produkty) {
        this.id = id;
        this.login = login;
        this.haslo = haslo;
        this.email = email;
        this.produkty = produkty;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + login + " (" + haslo + "), " + email + " | Produkty: " + produkty;
    }
}