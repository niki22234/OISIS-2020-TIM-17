package view;

import kontroler.DodavanjeLeka;

import javax.swing.*;
import java.awt.*;

public class DodajLek extends JDialog {

    private JLabel sifra;
    private JLabel ime;
    private JLabel proizvodjac;
    private JLabel izdajeSeNaRecept;
    private JLabel cena;

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

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;

        sifra = new JLabel("Sifra: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        panel.add(sifra, gridBagConstraints);

        sifraUnos = new JTextField(20);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        panel.add(sifraUnos, gridBagConstraints);

        ime = new JLabel("Ime: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        panel.add(ime, gridBagConstraints);

        imeUnos = new JTextField(20);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        panel.add(imeUnos, gridBagConstraints);

        proizvodjac = new JLabel("Proizvodjac: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        panel.add(proizvodjac, gridBagConstraints);

        proizvodjacUnos = new JTextField(20);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        panel.add(proizvodjacUnos, gridBagConstraints);

        izdajeSeNaRecept = new JLabel("Izdaje se na recept: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 1;
        panel.add(izdajeSeNaRecept, gridBagConstraints);

        String[] izdajeSeNaRecept = {"Ne", "Da"};
        izdajeSeNaReceptUnos = new JComboBox(izdajeSeNaRecept);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 1;
        panel.add(izdajeSeNaReceptUnos, gridBagConstraints);

        cena = new JLabel("cena: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        panel.add(cena, gridBagConstraints);

        cenaUnos = new JTextField(20);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        panel.add(cenaUnos, gridBagConstraints);

        prihvati = new JButton("Dodaj lek");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 1;
        prihvati.addActionListener(new DodavanjeLeka(this));
        panel.add(prihvati, gridBagConstraints);

        odbaci = new JButton("Odustani");
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 1;
        panel.add(odbaci, gridBagConstraints);

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
}
