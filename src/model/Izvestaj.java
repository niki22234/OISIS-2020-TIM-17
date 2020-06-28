package model;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Izvestaj {

    private static Izvestaj instance;
    private String[] kolone = {"Lek", "Kolicina", "Zarada"};
    private Object[][] podaci;
    private ArrayList<Korisnik> lista;
    private DefaultTableModel model;

    public Izvestaj() {
        model = new DefaultTableModel(podaci, kolone);
    }

    public static Izvestaj getInstance() {
        if(instance == null) {
            instance = new Izvestaj();
        }
        return instance;
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
