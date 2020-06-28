package view;

import application.Main;
import kontroler.KreirajIzvestaj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DijalogIzvestaj extends JDialog {

    private JComboBox vrstaIzvestajaUnos;
    private JButton dugme;

    public DijalogIzvestaj(GlavniEkran parent) {
        super(parent, "Kreiraj izvestaj", true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.setBackground(Color.WHITE);

        JLabel vrstaIzvestaja = new JLabel("Izaberite vrstu izvestaja");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        vrstaIzvestaja.setForeground(Main.tamnoPlava);
        panel.add(vrstaIzvestaja, gridBagConstraints);

        String[] vrsteIzvestaja = {"Prodaja svih lekova", "Prodaja lekova po proizvodjacu", "Prodaja lekova po apotekaru"};
        vrstaIzvestajaUnos = new JComboBox(vrsteIzvestaja);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        vrstaIzvestajaUnos.setBackground(Main.nebeskoPlava);
        vrstaIzvestajaUnos.setForeground(Main.tamnoPlava);
        panel.add(vrstaIzvestajaUnos, gridBagConstraints);

        dugme = new JButton("Kreiraj izvestaj");
        dugme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getVrstaIzvestajaUnos().getSelectedItem().toString().equals("Prodaja lekova po proizvodjacu")) {
                    DijalogIzvestajProizvodjac dijalog = new DijalogIzvestajProizvodjac(parent, getDijalog());
                } else if (getVrstaIzvestajaUnos().getSelectedItem().toString().equals("Prodaja lekova po apotekaru")) {
                    DijalogIzvestajApotekar dijalog = new DijalogIzvestajApotekar(parent, getDijalog());
                } else if (getVrstaIzvestajaUnos().getSelectedItem().toString().equals("Prodaja svih lekova")) {
                    KreirajIzvestaj izvestaj = new KreirajIzvestaj(getDijalog());
                    izvestaj.actionPerformed(e);
                }
            }
        });
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        dugme.setBackground(Main.tamnoPlava);
        dugme.setForeground(Color.WHITE);
        panel.add(dugme, gridBagConstraints);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();

        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public JComboBox getVrstaIzvestajaUnos() {
        return vrstaIzvestajaUnos;
    }

    public DijalogIzvestaj getDijalog() {
        return this;
    }
}
