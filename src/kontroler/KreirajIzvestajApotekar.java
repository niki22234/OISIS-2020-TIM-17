package kontroler;

import model.Izvestaj;
import model.Lek;
import model.Lekovi;
import model.Prodaja;
import view.DijalogIzvestajApotekar;
import view.GlavniEkran;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Set;

public class KreirajIzvestajApotekar implements ActionListener {

    private String apotekar;
    private DijalogIzvestajApotekar dijalog;

    public KreirajIzvestajApotekar(String apotekar, DijalogIzvestajApotekar dijalog) {
        this.apotekar = apotekar;
        this.dijalog = dijalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Prodaja> sveProdaje = GlavniEkran.getSveProdaje();
        DefaultTableModel model = Izvestaj.getInstance().getModel();
        if(model.getRowCount() != 0) {
            model.setRowCount(0);
        }
        Dictionary<String, Integer> izvestaj = new Hashtable();
        for(int i = 0; i<sveProdaje.size(); i++) {
            if(sveProdaje.get(i).getProdavac().getKorisnickoIme().equals(apotekar)) {
                Hashtable racun = (Hashtable) sveProdaje.get(i).getLekIKolicina();
                Set<Lek> keys = racun.keySet();
                for(Lek key : keys) {
                    if(!(((Hashtable) izvestaj).keySet().contains(key.getIme()))) {
                        izvestaj.put(key.getIme(), (Integer) racun.get(key));
                    } else {
                        Integer kolicina = izvestaj.get(key.getIme());
                        kolicina += (Integer) racun.get(key);
                        izvestaj.put(key.getIme(), kolicina);
                    }
                }
            }
        }
        ArrayList<Lek> sviLekovi = Lekovi.getInstance().getLista();
        Set<String> lekoviIzvestaj = ((Hashtable) izvestaj).keySet();
        float ukupnaCena = 0;
        for(String key: lekoviIzvestaj) {
            float cenaLeka = 0;
            for(int i = 0; i <sviLekovi.size(); i++) {
                if(key.equals(sviLekovi.get(i).getIme())) {
                    cenaLeka = sviLekovi.get(i).getCena();
                }
            }
            Object[] lek = {key, izvestaj.get(key), (Integer)izvestaj.get(key) * cenaLeka};
            ukupnaCena += (Integer)izvestaj.get(key) * cenaLeka;
            model.addRow(lek);
        }
        Izvestaj.getInstance().setModel(model);
        GlavniEkran.getInstance().getZbirProdajeVrednost().setText(String.valueOf(ukupnaCena));
        dijalog.dispose();
    }
}
