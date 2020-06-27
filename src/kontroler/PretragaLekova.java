package kontroler;

import model.Lek;
import model.Lekovi;
import view.DijalogPretragaLekova;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PretragaLekova implements ActionListener {

    private String parametar;
    private DijalogPretragaLekova dijalog;

    public PretragaLekova(String parametar, DijalogPretragaLekova dijalog) {
        this.parametar = parametar;
        this.dijalog = dijalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Lek> sviLekovi = Lekovi.getInstance().getLista();
        ArrayList<Lek> rezultat = new ArrayList<>();
        if(parametar.equals("Sifra leka")) {
            for(int i = 0; i < sviLekovi.size(); i++) {
                if(sviLekovi.get(i).getSifra().equals(dijalog.getUnos().getText())) {
                    rezultat.add(sviLekovi.get(i));
                }
            }
        } else if (parametar.equals("Ime leka")) {
            for(int i = 0; i < sviLekovi.size(); i++) {
                if(sviLekovi.get(i).getIme().toLowerCase().equals(dijalog.getUnos().getText().toLowerCase()) || sviLekovi.get(i).getIme().toLowerCase().contains(dijalog.getUnos().getText().toLowerCase())) {
                    rezultat.add(sviLekovi.get(i));
                }
            }
        } else if (parametar.equals("Proizvodjac")) {
            for(int i = 0; i < sviLekovi.size(); i++) {
                if(sviLekovi.get(i).getProizvodjac().toLowerCase().equals(dijalog.getUnos().getText().toLowerCase()) || sviLekovi.get(i).getProizvodjac().toLowerCase().contains(dijalog.getUnos().getText().toLowerCase())) {
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
