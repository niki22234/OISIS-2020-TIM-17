package application;

import utils.UcitavanjePodataka;
import view.GlavniEkran;
import view.Login;

import java.awt.*;

public class Main {

    public static final Color svetloPlava = new Color(142, 196, 234);
    public static final Color tamnoPlava = new Color(1, 74, 129);
    public static final Color nebeskoPlava = new Color(176, 215,244);

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UcitavanjePodataka.ucitajPodatkeKorisnika();
                    UcitavanjePodataka.ucitajPodatkeLekova();
                    UcitavanjePodataka.ucitajPodatkeRecepta();
                    UcitavanjePodataka.ucitajPodatkeProdaja();
                    UcitavanjePodataka.ucitajPodatkeKupaca();
                    GlavniEkran glavniEkran = GlavniEkran.getInstance();
                    glavniEkran.setSize(17*70, 9*70);
                    Login login = new Login(glavniEkran);
                    login.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
