package model;

import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.*;

public class Recepti {

    private static Recepti instance;
    private String[] kolone = {"Sifra", "Lekar", "JMBG Pacijenta", "Lek i kolicina", "Datum/Vreme", "Cena"};
    private Object[][] podaci;
    private ArrayList<Recept> lista;
    private DefaultTableModel model;
    private String lekoviKolicinaSvi;
    private String datumFormat;

    public Recepti() {
        if(model == null) {
            model = new DefaultTableModel(podaci, kolone);
        }
    }

    public static Recepti getInstance() {
        if(instance == null) {
            instance = new Recepti();
        }
        return instance;
    }

    public String[] getKolone(){
        return kolone;
    }

    public Object[][] getPodaci() {
        return podaci;
    }

    public void setPodaci(ArrayList<Recept> recepti) {
        lista = recepti;
        int brojRecepta = recepti.size();
        podaci = new Object [brojRecepta][];
        for(int i = 0; i < brojRecepta; i++) {
            Hashtable lekoviKolicina = (Hashtable) recepti.get(i).getLekoviKolicina();
            Set<Lek> keys = lekoviKolicina.keySet();
            lekoviKolicinaSvi = "";
            for(Lek key: keys){
                lekoviKolicinaSvi = lekoviKolicinaSvi.concat(key.getIme()).concat(" ").concat(lekoviKolicina.get(key).toString());
            }
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            datumFormat = format.format(recepti.get(i).getDatumVreme());
            Object[] temp = {recepti.get(i).getSifra(), recepti.get(i).getKorisnickoImeLekara(), recepti.get(i).getJmbg(), lekoviKolicinaSvi, datumFormat, recepti.get(i).getUkupnaCena()};
            podaci[i] = temp;
        }
        model = new DefaultTableModel(podaci, kolone);
    }

    public ArrayList<Recept> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Recept> lista) {
        this.lista = lista;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
}
