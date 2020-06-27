package utils;

import model.*;
import view.GlavniEkran;

import java.io.*;
import java.util.ArrayList;

public class UcitavanjePodataka {
	
	public static void ucitajPodatkeKorisnika() {
        try {
            File korisnici = new File("korisnici.apoteka");
            if (korisnici.exists()) {
                FileInputStream fileInputStream = new FileInputStream("korisnici.apoteka");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                ArrayList<Korisnik> listaKorisnika = (ArrayList<Korisnik>) objectInputStream.readObject();
                Korisnici.getInstance().setPodaci(listaKorisnika);
                objectInputStream.close();
                fileInputStream.close();
            } else {
                Korisnik Admin = new Korisnik("Admin", "Admin", "A1", "A2", TipKorisnika.ADMINISTRATOR);
                FileOutputStream fileOutputStream = new FileOutputStream("korisnici.apoteka");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                ArrayList<Korisnik> listaKorisnika = new ArrayList<>();
                listaKorisnika.add(Admin);
                objectOutputStream.writeObject(listaKorisnika);
                objectOutputStream.close();
                fileOutputStream.close();
                ucitajPodatkeKorisnika();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ucitajPodatkeLekova() {
        try {
            File lekovi = new File("lekovi.apoteka");
            if (lekovi.exists()) {
                FileInputStream fileInputStream = new FileInputStream("lekovi.apoteka");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                ArrayList<Lek> listaLekova = (ArrayList<Lek>) objectInputStream.readObject();
                Lekovi.getInstance().setPodaci(listaLekova);
                objectInputStream.close();
                fileInputStream.close();
            } else {
                FileOutputStream fileOutputStream = new FileOutputStream("lekovi.apoteka");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                ArrayList<Lek> listaLekova = new ArrayList<>();
                objectOutputStream.writeObject(listaLekova);
                objectOutputStream.close();
                fileOutputStream.close();
                ucitajPodatkeLekova();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
