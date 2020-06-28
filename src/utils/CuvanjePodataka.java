package utils;

import model.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CuvanjePodataka {

    public static void sacuvajKorisnike(ArrayList<Korisnik> korisnici) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("korisnici.apoteka");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(korisnici);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sacuvajLekove(ArrayList<Lek> lekovi) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("lekovi.apoteka");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(lekovi);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sacuvajRecepte(ArrayList<Recept> recepti) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("recepti.apoteka");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(recepti);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sacuvajProdaje(ArrayList<Prodaja> prodaje) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("prodaje.apoteka");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(prodaje);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sacuvajKupce(ArrayList<Kupac> kupci) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("kupci.apoteka");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(kupci);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
