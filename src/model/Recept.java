package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Dictionary;

public class Recept implements Serializable {

    private int sifra;

    private String korisnickoImeLekara;

    private String jmbg;

    private Date datumVreme;

    private Dictionary<String, Integer> lekoviKolicina;

    private float ukupnaCena;

    public Recept(int sifra, String korisnickoImeLekara, String jmbg, Date datumVreme, Dictionary lekoviKolicina, float cena) {
        this.sifra = sifra;
        this.korisnickoImeLekara = korisnickoImeLekara;
        this.jmbg = jmbg;
        this.datumVreme = datumVreme;
        this.lekoviKolicina = lekoviKolicina;
        this.ukupnaCena = cena;
    }

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getKorisnickoImeLekara() {
        return korisnickoImeLekara;
    }

    public void setKorisnickoImeLekara(String korisnickoImeLekara) {
        this.korisnickoImeLekara = korisnickoImeLekara;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public Dictionary getLekoviKolicina() {
        return lekoviKolicina;
    }

    public void setLekoviKolicina(Dictionary lekoviKolicina) {
        this.lekoviKolicina = lekoviKolicina;
    }

    public float getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(float ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

}
