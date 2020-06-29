package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Dictionary;

public class Prodaja implements Serializable {

    public Prodaja(Korisnik prodavac, Dictionary lekIKolicina, float cena, Date datum) {
        this.prodavac = prodavac;
        this.lekIKolicina = lekIKolicina;
        this.cena = cena;
        this.sifraKupca = null;
        this.datum = datum;
    }

    public Prodaja(Korisnik prodavac, Dictionary lekIKolicina, float cena, Integer sifraKupca, Date datum) {
        this.prodavac = prodavac;
        this.lekIKolicina = lekIKolicina;
        this.cena = cena;
        this.sifraKupca = sifraKupca;
        this.datum = datum;
    }

    private Korisnik prodavac;

    private Dictionary lekIKolicina;

    private float cena;

    private Integer sifraKupca;

    private Date datum;

    public Korisnik getProdavac() {
        return prodavac;
    }

    public void setProdavac(Korisnik prodavac) {
        this.prodavac = prodavac;
    }

    public Dictionary getLekIKolicina() {
        return lekIKolicina;
    }

    public void setLekIKolicina(Dictionary lekIKolicina) {
        this.lekIKolicina = lekIKolicina;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public Integer getSifraKupca() {
        return sifraKupca;
    }

    public void setSifraKupca(Integer sifraKupca) {
        this.sifraKupca = sifraKupca;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
