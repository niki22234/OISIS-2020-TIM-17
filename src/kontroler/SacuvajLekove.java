package kontroler;

import model.Lek;
import model.Lekovi;
import utils.CuvanjePodataka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SacuvajLekove implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Lek> lista = Lekovi.getInstance().getLista();
        CuvanjePodataka.sacuvajLekove(lista);
    }
}
