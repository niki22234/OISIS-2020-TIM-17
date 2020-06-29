package kontroler;

import utils.Login;
import view.GlavniEkran;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logovanje implements ActionListener {

    private view.Login dijalog;

    public Logovanje(view.Login dijalog) {
        this.dijalog = dijalog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int pokusaj = dijalog.getPoksaj();
        pokusaj++;
        dijalog.setPoksaj(pokusaj);
        if(dijalog.getPoksaj() > 3) {
            dijalog.dispose();
        }
        if(Login.autentikacija(dijalog.getUsername(), dijalog.getPassword()) == true) {
            dijalog.dispose();
            GlavniEkran.getInstance().setVisible(true);
        } else {
            dijalog.getPoruka().setText("Neuspesno logovanje.");
        }
    }
}
