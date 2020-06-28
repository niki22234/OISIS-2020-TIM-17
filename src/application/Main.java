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
                    GlavniEkran glavniEkran = GlavniEkran.getInstance();
                    glavniEkran.setSize(17*50, 9*50);
                    Login login = new Login(glavniEkran);
                    login.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static Color getSvetloPlava() {
        return svetloPlava;
    }

    public static Color getTamnoPlava() {
        return tamnoPlava;
    }
}
