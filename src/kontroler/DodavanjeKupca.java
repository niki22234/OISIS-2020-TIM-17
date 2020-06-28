package kontroler;

import model.Kupac;
import utils.CuvanjePodataka;
import view.DijalogDodajKarticu;
import view.DijalogPrikaziSifruKupca;
import view.GlavniEkran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DodavanjeKupca implements ActionListener {

    private DijalogDodajKarticu dijalog;

    public DodavanjeKupca(DijalogDodajKarticu dijalog) {
        this.dijalog = dijalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ime = dijalog.getImeUnos().getText();
        String prezime = dijalog.getPrezimeUnos().getText();
        Integer sifra = GlavniEkran.getInstance().getSviKupci().size() + 1;
        Kupac kupac = new Kupac(ime, prezime, sifra);
        ArrayList<Kupac> sviKupci = GlavniEkran.getInstance().getSviKupci();
        sviKupci.add(kupac);
        GlavniEkran.getInstance().setSviKupci(sviKupci);
        CuvanjePodataka.sacuvajKupce(sviKupci);
        dijalog.dispose();
        DijalogPrikaziSifruKupca dijalogKupca = new DijalogPrikaziSifruKupca(GlavniEkran.getInstance(), ime, prezime, sifra);
    }
}
