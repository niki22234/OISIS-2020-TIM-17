package utils;

import model.*;
import view.GlavniEkran;

import java.io.*;
import java.util.ArrayList;

public class UcitavanjePodataka {

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
