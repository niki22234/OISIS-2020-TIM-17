package model;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Korisnici {

    private static Korisnici instance;
    private String[] kolone = {"Korisnicko Ime", "Ime", "Prezime", "Tip Korisnika"};
    private Object[][] podaci;
    private ArrayList<Korisnik> lista;
    private DefaultTableModel model;

    public Korisnici() {
        if(model == null) {
            model = new DefaultTableModel(podaci, kolone);
        }
    }

    public static Korisnici getInstance() {
        if(instance == null) {
            instance = new Korisnici();
        }
        return instance;
    }

    public void setPodaci(ArrayList<Korisnik> korisnici) {
        lista = korisnici;
        int brojKorisnika = korisnici.size();
        podaci = new Object [brojKorisnika][];
        for(int i = 0; i < brojKorisnika; i++) {
            Object[] temp = {korisnici.get(i).getKorisnickoIme(), korisnici.get(i).getIme(), korisnici.get(i).getPrezime(), korisnici.get(i).getTipKorisnika()};
            podaci[i] = temp;
        }
        model = new DefaultTableModel(podaci, kolone);
    }

    public String[] getKolone() {
        return kolone;
    }

    public void setKolone(String[] kolone) {
        this.kolone = kolone;
    }

    public Object[][] getPodaci() {
        return podaci;
    }

    public ArrayList<Korisnik> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Korisnik> lista) {
        this.lista = lista;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
}
