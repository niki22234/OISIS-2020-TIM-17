package kontroler;

import model.Lek;
import model.Lekovi;
import utils.CuvanjePodataka;
import view.DijalogIzmeniLek;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IzmenaLeka implements ActionListener {

    private DijalogIzmeniLek dijalog;

    public IzmenaLeka(DijalogIzmeniLek dijalog) {
        this.dijalog = dijalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel model = Lekovi.getInstance().getModel();
        String sifraLeka = dijalog.getSifraUnos().getText();
        String imeLeka = dijalog.getImeUnos().getText();
        String proizvodjac = dijalog.getProizvodjacUnos().getText();
        String izdajeSeNaRecept = dijalog.getIzdajeSeNaReceptUnos().getSelectedItem().toString();
        boolean izdajeSeNaReceptBool = false;
        if(izdajeSeNaRecept.equals("Da")) {
            izdajeSeNaReceptBool = true;
        }
        float cena = Float.valueOf(dijalog.getCenaUnos().getText());
        ArrayList<Lek> lista = Lekovi.getInstance().getLista();
        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getSifra().equals(sifraLeka)) {
                if(!(imeLeka.isEmpty())) {
                    lista.get(i).setIme(imeLeka);
                    Lekovi.getInstance().getModel().setValueAt(imeLeka,i,0);
                }
                if(!(proizvodjac.isEmpty())) {
                    lista.get(i).setProizvodjac(proizvodjac);
                    Lekovi.getInstance().getModel().setValueAt(proizvodjac,i,1);
                }
                lista.get(i).setIzdajeSeNaRecept(izdajeSeNaReceptBool);
                Lekovi.getInstance().getModel().setValueAt(sifraLeka,i,2);
                if(!(dijalog.getCenaUnos().getText().isEmpty())) {
                    lista.get(i).setCena(cena);
                    Lekovi.getInstance().getModel().setValueAt(cena,i,4);
                }
            }
        }
        CuvanjePodataka.sacuvajLekove(lista);
        Lekovi.getInstance().setModel(model);
        dijalog.dispose();
    }
}
