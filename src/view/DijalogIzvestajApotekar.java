package view;

import application.Main;
import kontroler.KreirajIzvestajApotekar;
import model.Korisnici;
import model.Korisnik;
import model.TipKorisnika;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DijalogIzvestajApotekar extends JDialog {

    private GlavniEkran parent;
    private DijalogIzvestaj dijalog;
    private JComboBox spisakApotekara;
    private JButton kreiraj;

    public DijalogIzvestajApotekar(GlavniEkran parent, DijalogIzvestaj dijalog) {
        super(parent, "Izaberi apotekara", true);
        dijalog.dispose();
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.setBackground(Color.WHITE);

        ArrayList<Korisnik> sviApotekari = Korisnici.getInstance().getLista();
        ArrayList<String> apotekari = new ArrayList<>();
        for(int i = 0; i<sviApotekari.size(); i++) {
            if(sviApotekari.get(i).getTipKorisnika().equals(TipKorisnika.APOTEKAR)) {
                if(!(apotekari.contains(sviApotekari.get(i).getKorisnickoIme()))) {
                    apotekari.add(sviApotekari.get(i).getKorisnickoIme());
                }
            }
        }

        JLabel apotekar = new JLabel("Apotekar: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        apotekar.setForeground(Main.tamnoPlava);
        panel.add(apotekar, gridBagConstraints);

        spisakApotekara = new JComboBox(apotekari.toArray());
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        spisakApotekara.setBackground(Main.nebeskoPlava);
        spisakApotekara.setForeground(Main.tamnoPlava);
        panel.add(spisakApotekara, gridBagConstraints);

        kreiraj = new JButton("Kreiraj izvestaj");
        kreiraj.addActionListener(new KreirajIzvestajApotekar(getSpisakApotekara().getSelectedItem().toString(), getDijalog()));
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        kreiraj.setBackground(Main.tamnoPlava);
        kreiraj.setForeground(Color.WHITE);
        panel.add(kreiraj, gridBagConstraints);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();

        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public DijalogIzvestajApotekar getDijalog() {
        return this;
    }

    public JComboBox getSpisakApotekara() {
        return spisakApotekara;
    }
}
