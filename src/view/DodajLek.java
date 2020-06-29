package view;

import application.Main;
import kontroler.DodavanjeLeka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajLek extends JDialog {

    private JLabel sifra;
    private JLabel ime;
    private JLabel proizvodjac;
    private JLabel izdajeSeNaRecept;
    private JLabel cena;
    private JLabel poruka;

    private JTextField sifraUnos;
    private JTextField imeUnos;
    private JTextField proizvodjacUnos;
    private JComboBox izdajeSeNaReceptUnos;
    private JTextField cenaUnos;

    private JButton prihvati;
    private JButton odbaci;

    public DodajLek(GlavniEkran parent) {
        super(parent, "Dodavanje Leka", true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.setBackground(Color.WHITE);

        sifra = new JLabel("Sifra: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        sifra.setForeground(Main.tamnoPlava);
        panel.add(sifra, gridBagConstraints);

        sifraUnos = new JTextField(20);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        sifraUnos.setBackground(Main.nebeskoPlava);
        sifraUnos.setForeground(Main.tamnoPlava);
        panel.add(sifraUnos, gridBagConstraints);

        ime = new JLabel("Ime: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        ime.setForeground(Main.tamnoPlava);
        panel.add(ime, gridBagConstraints);

        imeUnos = new JTextField(20);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        imeUnos.setBackground(Main.nebeskoPlava);
        imeUnos.setForeground(Main.tamnoPlava);
        panel.add(imeUnos, gridBagConstraints);

        proizvodjac = new JLabel("Proizvodjac: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        proizvodjac.setForeground(Main.tamnoPlava);
        panel.add(proizvodjac, gridBagConstraints);

        proizvodjacUnos = new JTextField(20);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        proizvodjacUnos.setBackground(Main.nebeskoPlava);
        proizvodjacUnos.setForeground(Main.tamnoPlava);
        panel.add(proizvodjacUnos, gridBagConstraints);

        izdajeSeNaRecept = new JLabel("Izdaje se na recept: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 1;
        izdajeSeNaRecept.setForeground(Main.tamnoPlava);
        panel.add(izdajeSeNaRecept, gridBagConstraints);

        String[] izdajeSeNaRecept = {"Ne", "Da"};
        izdajeSeNaReceptUnos = new JComboBox(izdajeSeNaRecept);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 1;
        izdajeSeNaReceptUnos.setBackground(Main.nebeskoPlava);
        izdajeSeNaReceptUnos.setForeground(Main.tamnoPlava);
        panel.add(izdajeSeNaReceptUnos, gridBagConstraints);

        cena = new JLabel("cena: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        cena.setForeground(Main.tamnoPlava);
        panel.add(cena, gridBagConstraints);

        cenaUnos = new JTextField(20);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        cenaUnos.setBackground(Main.nebeskoPlava);
        cenaUnos.setForeground(Main.tamnoPlava);
        panel.add(cenaUnos, gridBagConstraints);

        prihvati = new JButton("Dodaj lek");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 1;
        prihvati.setBackground(Main.tamnoPlava);
        prihvati.setForeground(Color.WHITE);
        prihvati.addActionListener(new DodavanjeLeka(this));
        panel.add(prihvati, gridBagConstraints);

        odbaci = new JButton("Odustani");
        odbaci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDijalog().dispose();
            }
        });
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 1;
        odbaci.setBackground(Main.tamnoPlava);
        odbaci.setForeground(Color.WHITE);
        panel.add(odbaci, gridBagConstraints);

        poruka = new JLabel("");
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        poruka.setForeground(Color.red);
        panel.add(poruka, gridBagConstraints);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();

        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public JTextField getSifraUnos() {
        return sifraUnos;
    }

    public JTextField getImeUnos() {
        return imeUnos;
    }

    public JTextField getProizvodjacUnos() {
        return proizvodjacUnos;
    }

    public JComboBox getIzdajeSeNaReceptUnos() {
        return izdajeSeNaReceptUnos;
    }

    public JTextField getCenaUnos() {
        return cenaUnos;
    }

    public JLabel getPoruka() {
        return poruka;
    }

    public void setPoruka(JLabel poruka) {
        this.poruka = poruka;
    }

    public DodajLek getDijalog() {
        return this;
    }
}
