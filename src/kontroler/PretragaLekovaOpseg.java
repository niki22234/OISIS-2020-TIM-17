package kontroler;

import model.Lek;
import model.Lekovi;
import view.DijalogPretragaLekovaOpseg;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PretragaLekovaOpseg implements ActionListener {

    private DijalogPretragaLekovaOpseg dijalog;

    public PretragaLekovaOpseg(DijalogPretragaLekovaOpseg dijalog) {
        this.dijalog = dijalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Lek> sviLekovi = Lekovi.getInstance().getLista();
        ArrayList<Lek> rezultat = new ArrayList<>();
        if(dijalog.getManji().getText().isEmpty()) {
            for(int i = 0; i < sviLekovi.size(); i++) {
                if(sviLekovi.get(i).getCena() < Float.valueOf(dijalog.getVeci().getText())) {
                    rezultat.add(sviLekovi.get(i));
                }
            }
        }
        if(dijalog.getVeci().getText().isEmpty()) {
            for(int i = 0; i < sviLekovi.size(); i++) {
                if(sviLekovi.get(i).getCena() > Float.valueOf(dijalog.getManji().getText())) {
                    rezultat.add(sviLekovi.get(i));
                }
            }
        }
        if(!(dijalog.getManji().getText().isEmpty()) && !(dijalog.getVeci().getText().isEmpty())) {
            for (int i = 0; i < sviLekovi.size(); i++) {
                if (sviLekovi.get(i).getCena() > Float.valueOf(dijalog.getManji().getText()) && sviLekovi.get(i).getCena() < Float.valueOf(dijalog.getVeci().getText())) {
                    rezultat.add(sviLekovi.get(i));
                }
            }
        }
        DefaultTableModel model = Lekovi.getInstance().getModel();
        model.setRowCount(0);
        for(int i = 0; i<rezultat.size(); i++) {
            Object[] red = {rezultat.get(i).getIme(), rezultat.get(i).getProizvodjac(), rezultat.get(i).getSifra(), rezultat.get(i).isIzdajeSeNaRecept(), rezultat.get(i).getCena()};
            model.addRow(red);
        }
        Lekovi.getInstance().setModel(model);
        dijalog.dispose();
    }
}
