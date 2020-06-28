package kontroler;

import model.Korisnik;
import model.Lek;
import model.Lekovi;
import utils.CuvanjePodataka;
import view.GlavniEkran;
import view.Korpa;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Prodaja implements ActionListener {

    private Korpa dijalog;
    private model.Prodaja prodaja;

    public Prodaja(Korpa dijalog) {
        this.dijalog = dijalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Korisnik prodavac = GlavniEkran.getInstance().getTrenutniKorisnik();
        DefaultTableModel model = dijalog.getModel();
        ArrayList<Lek> sviLekovi = Lekovi.getInstance().getLista();
        Dictionary racun = new Hashtable();
        for(int i = 0; i< model.getRowCount(); i++) {
            for(int j = 0; j<sviLekovi.size(); j++) {
                if(sviLekovi.get(j).getIme().equals(model.getValueAt(i, 0))) {
                    racun.put(sviLekovi.get(j), model.getValueAt(i, 1));
                }
            }
        }
        float cena = Float.valueOf(dijalog.getCena().getText());
        if(!(dijalog.getSifraKorisnika().getText().isEmpty())) {
            Integer sifra = Integer.valueOf(dijalog.getSifraKorisnika().getText());
            prodaja = new model.Prodaja(prodavac, racun, cena, sifra);
        } else {
            prodaja = new model.Prodaja(prodavac, racun, cena);
        }
        ArrayList<model.Prodaja> sveProdaje = GlavniEkran.getSveProdaje();
        sveProdaje.add(prodaja);
        CuvanjePodataka.sacuvajProdaje(sveProdaje);
        dijalog.dispose();
    }
}
