package view;

import application.Main;
import kontroler.DodavanjeKupca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DijalogDodajKarticu extends JDialog {

    private JTextField imeUnos;
    private JTextField prezimeUnos;

    public DijalogDodajKarticu(GlavniEkran parent) {
        super(parent, "Dodaj karticu", true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.setBackground(Color.WHITE);

        JLabel ime = new JLabel("Ime: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        ime.setForeground(Main.tamnoPlava);
        panel.add(ime, gridBagConstraints);

        imeUnos = new JTextField(20);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        imeUnos.setBackground(Main.nebeskoPlava);
        imeUnos.setForeground(Main.tamnoPlava);
        panel.add(imeUnos, gridBagConstraints);

        JLabel prezime = new JLabel("Prezime: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        prezime.setForeground(Main.tamnoPlava);
        panel.add(prezime, gridBagConstraints);

        prezimeUnos = new JTextField(20);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        prezimeUnos.setBackground(Main.nebeskoPlava);
        panel.add(prezimeUnos, gridBagConstraints);

        JButton dodaj = new JButton("Dodaj kupca");
        dodaj.addActionListener(new DodavanjeKupca(getDijalog()));
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        dodaj.setBackground(Main.tamnoPlava);
        dodaj.setForeground(Color.WHITE);
        panel.add(dodaj, gridBagConstraints);

        JButton odustani = new JButton("Odustani");
        odustani.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDijalog().dispose();
            }
        });
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        odustani.setBackground(Main.tamnoPlava);
        odustani.setForeground(Color.WHITE);
        panel.add(odustani, gridBagConstraints);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();

        setLocationRelativeTo(parent);
        setVisible(true);
        setResizable(true);
    }

    public DijalogDodajKarticu getDijalog() {
        return this;
    }

    public JTextField getImeUnos() {
        return imeUnos;
    }

    public JTextField getPrezimeUnos() {
        return prezimeUnos;
    }
}
