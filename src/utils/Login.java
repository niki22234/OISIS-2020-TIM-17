package utils;

import model.Korisnici;
import model.Korisnik;
import view.GlavniEkran;

import java.util.ArrayList;

public class Login {

    Korisnik korisnik;

    public static boolean autentikacija(String korisnickoIme, String password) {

        Korisnik korisnik = new Korisnik();

        ArrayList<Korisnik> sviKorisnici = Korisnici.getInstance().getLista();
        for(int i = 0; i<sviKorisnici.size(); i++) {
            if(sviKorisnici.get(i).getKorisnickoIme().equals(korisnickoIme)) {
                korisnik = sviKorisnici.get(i);
            }
        }

        if(korisnik == null) {
            return false;
        }

        if(korisnickoIme.equals(korisnik.getKorisnickoIme()) && password.equals(korisnik.getLozinka())) {
            GlavniEkran.getInstance().setTrenutniKorisnik(korisnik);
            GlavniEkran.getInstance().postaviGUI();
            GlavniEkran.getInstance().tabele();
            return true;
        }

        return false;
    }
}
