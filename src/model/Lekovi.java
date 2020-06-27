package model;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Lekovi {

    private static Lekovi instance;
    private String[] kolone = {"Ime", "Proizvodjac", "Sifra", "Recept", "Cena"};
    private Object[][] podaci;
    private ArrayList<Lek> lista;
    private DefaultTableModel model;

    public Lekovi() {
        if(model == null){
            model = new DefaultTableModel(podaci, kolone);
        }
    }

    public static Lekovi getInstance() {
        if(instance == null) {
            instance = new Lekovi();
        }
        return instance;
    }

    public void setPodaci(ArrayList<Lek> lekovi) {
        lista = lekovi;
        int brojLekova = lekovi.size();
        podaci = new Object [brojLekova][];
        for(int i = 0; i < brojLekova; i++) {
            Object[] temp = {lekovi.get(i).getIme(), lekovi.get(i).getProizvodjac(), lekovi.get(i).getSifra(), lekovi.get(i).isIzdajeSeNaRecept(), lekovi.get(i).getCena()};
            podaci[i] = temp;
        }
        model = new DefaultTableModel(podaci, kolone);
    }

    public String[] getKolone(){
        return kolone;
    }

    public Object[][] getPodaci() {
        return podaci;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public ArrayList<Lek> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Lek> lista) {
        this.lista = lista;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

}
