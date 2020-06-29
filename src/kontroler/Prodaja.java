package kontroler;

import model.Korisnik;
import model.Kupac;
import model.Lek;
import model.Lekovi;
import utils.CuvanjePodataka;
import view.GlavniEkran;
import view.Korpa;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;

public class Prodaja implements ActionListener {

    private Korpa dijalog;
    private model.Prodaja prodaja;
    private Kupac kupac;

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
            ArrayList<model.Prodaja> sveProdaje = GlavniEkran.getSveProdaje();
            ArrayList<Kupac> sviKupci = GlavniEkran.getSviKupci();
            for(int i = 0; i < sviKupci.size(); i++) {
                if(sviKupci.get(i).getSifraKupca().compareTo(sifra) == 0) {
                    kupac = sviKupci.get(i);
                }
            }
            float zbirRacunaZaPoslednjiMesec = 0;
            Date danasnjiDatum = new Date();
            long mesecDana = danasnjiDatum.getTime() - 30l * 24 * 60 * 60 * 1000;
            Date mesec = new Date(mesecDana);
            for(int i = 0; i < sveProdaje.size(); i++) {
                if(sveProdaje.get(i).getSifraKupca() != null) {
                    if(sveProdaje.get(i).getSifraKupca().compareTo(sifra) == 0 && sveProdaje.get(i).getDatum().after(mesec)) {
                        zbirRacunaZaPoslednjiMesec += sveProdaje.get(i).getCena();
                    }
                }
            }
            if(zbirRacunaZaPoslednjiMesec < 1000) {
                cena = cena - (cena/100 * 5);
                GlavniEkran.getInstance().getPopustBaner().setText("Kupac " + kupac.getIme() + " " + kupac.getPrezime() + " je ostvario popust od 5%! Racun: " + cena);
            }
            else if (zbirRacunaZaPoslednjiMesec > 1000 && zbirRacunaZaPoslednjiMesec < 5000) {
                cena = cena - (cena/100 * 10);
                GlavniEkran.getInstance().getPopustBaner().setText("Kupac " + kupac.getIme() + " " + kupac.getPrezime() + " je ostvario popust od 10%! Racun: " + cena);
            }
            else if(zbirRacunaZaPoslednjiMesec > 5000) {
                cena = cena - (cena/100 * 20);
                GlavniEkran.getInstance().getPopustBaner().setText("Kupac " + kupac.getIme() + " " + kupac.getPrezime() + " je ostvario popust od 20%! Racun: " + cena);
            }
            prodaja = new model.Prodaja(prodavac, racun, cena, sifra, new Date());
        } else {
            prodaja = new model.Prodaja(prodavac, racun, cena, new Date());
        }
        ArrayList<model.Prodaja> sveProdaje = GlavniEkran.getSveProdaje();
        sveProdaje.add(prodaja);
        CuvanjePodataka.sacuvajProdaje(sveProdaje);
        dijalog.dispose();
    }
}
