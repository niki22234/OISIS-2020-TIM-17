package utils;

import model.Lek;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CuvanjePodataka {
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

    
}
