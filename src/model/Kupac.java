package model;

import java.io.Serializable;

public class Kupac implements Serializable {

    String ime;

    String prezime;

    Integer sifraKupca;

    public Kupac(String ime, String prezime, Integer sifraKupca) {
        this.ime = ime;
        this.prezime = prezime;
        this.sifraKupca = sifraKupca;
    }
}
