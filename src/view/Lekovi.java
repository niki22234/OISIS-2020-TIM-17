package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Lekovi extends JTable {

    private static Lekovi instance;

    public Lekovi(DefaultTableModel model) {
        super(model);
    }

    public static Lekovi getInstance() {
        if(instance == null) {
            instance = new Lekovi(model.Lekovi.getInstance().getModel());
        }
        return instance;
    }

}
