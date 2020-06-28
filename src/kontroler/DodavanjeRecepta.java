package kontroler;

import model.*;
import utils.CuvanjePodataka;
import view.DodajRecept;
import view.GlavniEkran;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class DodavanjeRecepta implements ActionListener {

    private DodajRecept dijalog;
    private ArrayList<Recept> lista;
    private String lekoviKolicina;
    private String[] lekoviKolicinaSvi;
    private Date datum;
    private String datumFormat;
    private ArrayList<Lek> lekoviModel;

    public DodavanjeRecepta(DodajRecept dijalog) {
        this.dijalog = dijalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        lista = Recepti.getInstance().getLista();
        int sifra = lista.size() + 1;
        Korisnik lekar = GlavniEkran.getInstance().getTrenutniKorisnik();
        String imeLekara = lekar.getKorisnickoIme();
        String jmbg = dijalog.getJmbgUnos().getText();
        String lekovi = "";
        JTable tabela = dijalog.getTabela();
        Dictionary lekoviKolicinaModel = new Hashtable();
        TableModel model = tabela.getModel();
        int brojDodatihlekova = model.getRowCount();
        lekoviKolicinaSvi = new String[brojDodatihlekova];
        for(int i = 0; i < brojDodatihlekova; i++) {
            lekoviKolicina = lekovi.concat(model.getValueAt(i,0).toString()).concat(" ").concat(model.getValueAt(i,1).toString().concat(" "));
            lekoviKolicinaSvi[i] = lekoviKolicina;
        }
        JSpinner spiner = dijalog.getVremeUnos();
        datum = (Date) spiner.getValue();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        datumFormat = format.format(datum);
        ArrayList<Lek> sviLekovi = Lekovi.getInstance().getLista();
        float cena = 0;
        for(int j = 0; j<sviLekovi.size(); j++) {
            for(int k = 0; k<brojDodatihlekova; k++) {
                if((sviLekovi.get(j).getIme()).equals(model.getValueAt(k,0).toString())) {
                    cena += sviLekovi.get(j).getCena() * Integer.valueOf( (String)model.getValueAt(k,1));
                    lekoviKolicinaModel.put(sviLekovi.get(j), Integer.valueOf( (String)model.getValueAt(k,1)));
                }
            }
        }
        Object[] recept = {sifra, imeLekara, jmbg, Arrays.toString(lekoviKolicinaSvi), datumFormat, cena};
        DefaultTableModel modelTabela = Recepti.getInstance().getModel();
        modelTabela.addRow(recept);
        Recept receptModel = new Recept(sifra, imeLekara, jmbg, datum, lekoviKolicinaModel , cena);
        lista.add(receptModel);
        Recepti.getInstance().setLista(lista);
        CuvanjePodataka.sacuvajRecepte(lista);
        dijalog.dispose();
    }
}
