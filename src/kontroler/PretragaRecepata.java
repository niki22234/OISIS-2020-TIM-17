package kontroler;

import model.Lek;
import model.Recept;
import model.Recepti;
import view.DijalogPretragaRecepata;
import view.GlavniEkran;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class PretragaRecepata implements ActionListener {

    private GlavniEkran parent;
    private DijalogPretragaRecepata dijalog;
    String lekoviKolicinaSvi;
    private String datumFormat;

    public PretragaRecepata(GlavniEkran parent, DijalogPretragaRecepata dijalog) {
        this.parent = parent;
        this.dijalog = dijalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Recept> sviRecepti = Recepti.getInstance().getLista();
        ArrayList<Recept> rezultati = new ArrayList<>();
        if(dijalog.getParametar().getSelectedItem().toString().equals("Sifra recepta")) {
            for(int i = 0; i < sviRecepti.size(); i++) {
                if(sviRecepti.get(i).getSifra() == Integer.valueOf(dijalog.getUnos().getText())) {
                    rezultati.add(sviRecepti.get(i));
                }
            }
        }
        if(dijalog.getParametar().getSelectedItem().toString().equals("Lekar")) {
            for(int i = 0; i < sviRecepti.size(); i++) {
                if(sviRecepti.get(i).getKorisnickoImeLekara().toLowerCase().equals(dijalog.getUnos().getText().toLowerCase()) || sviRecepti.get(i).getKorisnickoImeLekara().toLowerCase().contains(dijalog.getUnos().getText().toLowerCase())) {
                    rezultati.add(sviRecepti.get(i));
                }
            }
        }
        if(dijalog.getParametar().getSelectedItem().toString().equals("JMBG pacijenta")) {
            for(int i = 0; i < sviRecepti.size(); i++) {
                if(sviRecepti.get(i).getJmbg().equals(dijalog.getUnos().getText())) {
                    rezultati.add(sviRecepti.get(i));
                }
            }
        }
        if(dijalog.getParametar().getSelectedItem().toString().equals("Po jednom leku")) {
            for(int i = 0; i < sviRecepti.size(); i++) {
                Hashtable lekoviKolicina = (Hashtable) sviRecepti.get(i).getLekoviKolicina();
                Set<Lek> keys = lekoviKolicina.keySet();
                for(Lek key : keys) {
                    if(key.getIme().toLowerCase().equals(dijalog.getUnos().getText().toLowerCase()) || key.getIme().toLowerCase().contains(dijalog.getUnos().getText().toLowerCase())) {
                        rezultati.add(sviRecepti.get(i));
                    }
                }
            }
        }
        DefaultTableModel model = Recepti.getInstance().getModel();
        model.setRowCount(0);
        for(int i = 0; i<rezultati.size(); i++) {
            Hashtable sviLekovi = (Hashtable) rezultati.get(i).getLekoviKolicina();
            Set<Lek> lekoviRecepta = sviLekovi.keySet();
            lekoviKolicinaSvi = "";
            for(Lek key : lekoviRecepta) {
                lekoviKolicinaSvi = lekoviKolicinaSvi.concat(key.getIme()).concat(" ").concat(sviLekovi.get(key).toString());
            }
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            datumFormat = format.format(rezultati.get(i).getDatumVreme());
            Object[] red = {rezultati.get(i).getSifra(), rezultati.get(i).getKorisnickoImeLekara(), rezultati.get(i).getJmbg(), lekoviKolicinaSvi, datumFormat, rezultati.get(i).getUkupnaCena()};
            model.addRow(red);
        }
        Recepti.getInstance().setModel(model);
        dijalog.dispose();
    }
}
