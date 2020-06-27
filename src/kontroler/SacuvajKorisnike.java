package kontroler;

import model.Korisnici;
import model.Korisnik;
import utils.CuvanjePodataka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SacuvajKorisnike implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Korisnik> lista = Korisnici.getInstance().getLista();
        CuvanjePodataka.sacuvajKorisnike(lista);
    }
}
