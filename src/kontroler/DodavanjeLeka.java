package kontroler;

import model.Lek;
import model.Lekovi;
import view.DodajLek;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DodavanjeLeka implements ActionListener {

    private DodajLek dijalog;

    public DodavanjeLeka(DodajLek dijalog) {
        this.dijalog = dijalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sifraLeka = dijalog.getSifraUnos().getText();
        ArrayList<Lek> lista = Lekovi.getInstance().getLista();
        for(int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getSifra().equalsIgnoreCase(sifraLeka)) {
                dijalog.getPoruka().setText("Sifra leka vec postoji!");
                return;
            }
        }
        String imeLeka = dijalog.getImeUnos().getText();
        String proizvodjac = dijalog.getProizvodjacUnos().getText();
        String izdajeSeNaRecept = dijalog.getIzdajeSeNaReceptUnos().getSelectedItem().toString();
        boolean izdajeSeNaReceptBool = false;
        if(izdajeSeNaRecept.equals("Da")) {
            izdajeSeNaReceptBool = true;
        }
        float cena = Float.valueOf(dijalog.getCenaUnos().getText());
        Object[] lek = {imeLeka, proizvodjac, sifraLeka, izdajeSeNaReceptBool, cena};
        DefaultTableModel model = Lekovi.getInstance().getModel();
        model.addRow(lek);
        Lek lekModel = new Lek(sifraLeka, imeLeka, proizvodjac, izdajeSeNaReceptBool, cena);
        lista.add(lekModel);
        Lekovi.getInstance().setPodaci(lista);
        dijalog.dispose();
    }
}
