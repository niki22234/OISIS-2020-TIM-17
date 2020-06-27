package kontroler;

import model.Korisnici;
import model.Korisnik;
import model.TipKorisnika;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DodavanjeKorisnika implements ActionListener {

    private view.DodajKorisnika dijalog;

    public DodavanjeKorisnika(view.DodajKorisnika dialog) {
        this.dijalog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String korisnickoIme = dijalog.getKorisnickoImeUnos().getText();
        ArrayList<Korisnik> lista = Korisnici.getInstance().getLista();
        for(int i = 0; i<lista.size(); i++) {
            if(lista.get(i).getKorisnickoIme().equalsIgnoreCase(korisnickoIme)){
                dijalog.getPoruka().setText("Korisnicko ime vec postoji!");
                return;
            }
        }
        String lozinka = dijalog.getLozinkaUnos().getText();
        String ime = dijalog.getImeUnos().getText();
        String prezime = dijalog.getPrezimeUnos().getText();
        String tipKorisnika = String.valueOf(dijalog.getTip().getSelectedItem());
        TipKorisnika tipKorisnikaEnum = TipKorisnika.ADMINISTRATOR;
        if(tipKorisnika.equals("Apotekar")) {
            tipKorisnikaEnum = TipKorisnika.APOTEKAR;
        } else if (tipKorisnika.equals("Lekar")) {
            tipKorisnikaEnum = TipKorisnika.LEKAR;
        }
        Object[] korisnik = {korisnickoIme, ime, prezime, tipKorisnikaEnum};
        DefaultTableModel model = Korisnici.getInstance().getModel();
        model.addRow(korisnik);
        Korisnik korisnikModel = new Korisnik(korisnickoIme, lozinka, ime, prezime, tipKorisnikaEnum);
        lista.add(korisnikModel);
        Korisnici.getInstance().setLista(lista);
        dijalog.dispose();
    }
}
