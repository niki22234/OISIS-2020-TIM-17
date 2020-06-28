package view;

import application.Main;
import kontroler.KreirajIzvestajProizvodjac;
import model.Lek;
import model.Lekovi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DijalogIzvestajProizvodjac extends JDialog {

    private GlavniEkran parent;
    private DijalogIzvestaj dijalog;
    private JComboBox spisakProizvodjaca;
    private JButton kreiraj;

    public DijalogIzvestajProizvodjac(GlavniEkran parent, DijalogIzvestaj dijalog) {
        super(parent, "Izaberi proizvodjaca", true);
        dijalog.dispose();
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.setBackground(Color.WHITE);

        ArrayList<Lek> sviLekovi = Lekovi.getInstance().getLista();
        ArrayList<String> proizvodjaci = new ArrayList<>();
        for(int i = 0; i<sviLekovi.size(); i++) {
            String proizvodjac = sviLekovi.get(i).getProizvodjac();
            if(!(proizvodjaci.contains(proizvodjac))) {
                proizvodjaci.add(proizvodjac);
            }
        }

        JLabel proizvodjac = new JLabel("Proizvodjac: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        proizvodjac.setForeground(Main.tamnoPlava);
        panel.add(proizvodjac, gridBagConstraints);

        spisakProizvodjaca = new JComboBox(proizvodjaci.toArray());
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        spisakProizvodjaca.setBackground(Main.nebeskoPlava);
        spisakProizvodjaca.setForeground(Main.tamnoPlava);
        panel.add(spisakProizvodjaca, gridBagConstraints);

        kreiraj = new JButton("Kreiraj izvestaj");
        kreiraj.addActionListener(new KreirajIzvestajProizvodjac(getSpisakProizvodjaca().getSelectedItem().toString(), getDijalog()));
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        kreiraj.setForeground(Color.WHITE);
        kreiraj.setBackground(Main.tamnoPlava);
        panel.add(kreiraj, gridBagConstraints);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();

        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public JComboBox getSpisakProizvodjaca() {
        return spisakProizvodjaca;
    }

    public DijalogIzvestajProizvodjac getDijalog() {
        return this;
    }
}
