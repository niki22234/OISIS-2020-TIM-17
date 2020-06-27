package view;

import application.Main;
import kontroler.DodavanjeKorisnika;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajKorisnika extends JDialog {

    private JLabel korisnickoIme;
    private JLabel lozinka;
    private JLabel ime;
    private JLabel prezime;
    private JLabel tipKorisnika;
    private JLabel poruka;

    private JTextField korisnickoImeUnos;
    private JTextField lozinkaUnos;
    private JTextField imeUnos;
    private JTextField prezimeUnos;
    private JComboBox tip;

    private JButton dodaj;
    private JButton odustani;

    public DodajKorisnika(GlavniEkran parent) {
        super(parent, "Dodavanje Korisnika", true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.setBackground(Color.WHITE);

        korisnickoIme = new JLabel("Korisnicko ime: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        korisnickoIme.setForeground(Main.tamnoPlava);
        panel.add(korisnickoIme, gridBagConstraints);

        korisnickoImeUnos = new JTextField(20);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        korisnickoImeUnos.setBackground(Main.nebeskoPlava);
        korisnickoImeUnos.setForeground(Main.tamnoPlava);
        panel.add(korisnickoImeUnos, gridBagConstraints);

        lozinka = new JLabel("Lozinka: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        lozinka.setForeground(Main.tamnoPlava);
        panel.add(lozinka, gridBagConstraints);

        lozinkaUnos = new JTextField(20);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        lozinkaUnos.setForeground(Main.tamnoPlava);
        lozinkaUnos.setBackground(Main.nebeskoPlava);
        panel.add(lozinkaUnos, gridBagConstraints);

        ime = new JLabel("Ime: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        ime.setForeground(Main.tamnoPlava);
        panel.add(ime, gridBagConstraints);

        imeUnos = new JTextField(20);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        imeUnos.setBackground(Main.nebeskoPlava);
        imeUnos.setForeground(Main.tamnoPlava);
        panel.add(imeUnos, gridBagConstraints);

        prezime = new JLabel("Prezime: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 1;
        prezime.setForeground(Main.tamnoPlava);
        panel.add(prezime, gridBagConstraints);

        prezimeUnos = new JTextField(20);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 1;
        prezimeUnos.setForeground(Main.tamnoPlava);
        prezimeUnos.setBackground(Main.nebeskoPlava);
        panel.add(prezimeUnos, gridBagConstraints);

        tipKorisnika = new JLabel("Tip korisnika: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        tipKorisnika.setForeground(Main.tamnoPlava);
        panel.add(tipKorisnika, gridBagConstraints);

        String[] tipoviKorisnika = {"Apotekar", "Lekar"};
        tip = new JComboBox(tipoviKorisnika);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        tip.setForeground(Main.tamnoPlava);
        tip.setBackground(Main.nebeskoPlava);
        panel.add(tip, gridBagConstraints);

        poruka = new JLabel("");
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        poruka.setForeground(Color.RED);
        panel.add(poruka, gridBagConstraints);


        dodaj = new JButton("Dodaj korisnika");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 1;
        dodaj.setBackground(Main.tamnoPlava);
        dodaj.setForeground(Color.WHITE);
        dodaj.addActionListener(new DodavanjeKorisnika(this));
        panel.add(dodaj, gridBagConstraints);


        odustani = new JButton("Odustani");
        odustani.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDijalog().dispose();
            }
        });
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 1;
        odustani.setBackground(Main.tamnoPlava);
        odustani.setForeground(Color.WHITE);
        panel.add(odustani, gridBagConstraints);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();

        setLocationRelativeTo(parent);
        setVisible(true);
    }


    public JTextField getKorisnickoImeUnos() {
        return korisnickoImeUnos;
    }

    public JTextField getLozinkaUnos() {
        return lozinkaUnos;
    }

    public JTextField getImeUnos() {
        return imeUnos;
    }

    public JTextField getPrezimeUnos() {
        return prezimeUnos;
    }

    public JComboBox getTip() {
        return tip;
    }

    public JLabel getPoruka() {
        return poruka;
    }

    public void setPoruka(JLabel poruka) {
        this.poruka = poruka;
    }

    public DodajKorisnika getDijalog() {
        return this;
    }
}
