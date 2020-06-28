package view;

import application.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DijalogPrikaziSifruKupca extends JDialog {

    public DijalogPrikaziSifruKupca(GlavniEkran parent, String ime, String prezime, Integer sifra) {
        super(parent, "Novi kupac", true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.setBackground(Color.WHITE);

        JLabel noviKupac = new JLabel("Dodat kupac " + ime + " " + prezime + " sa sifrom " + sifra);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        noviKupac.setBackground(Main.svetloPlava);
        noviKupac.setForeground(Main.tamnoPlava);
        panel.add(noviKupac, gridBagConstraints);

        JButton zatvori = new JButton("Zatvori");
        zatvori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDijalog().dispose();
            }
        });
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        zatvori.setBackground(Main.tamnoPlava);
        zatvori.setForeground(Color.WHITE);
        panel.add(zatvori, gridBagConstraints);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();

        setLocationRelativeTo(parent);
        setVisible(true);
        setResizable(true);

    }

    public DijalogPrikaziSifruKupca getDijalog() {
        return this;
    }
}
