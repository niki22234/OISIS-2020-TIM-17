package view;

import application.Main;
import kontroler.SortiranjeKorisnika;

import javax.swing.*;
import java.awt.*;

public class DijalogSortiranjeKorisnika extends JDialog {

    private GlavniEkran parent;
    private JLabel text;
    private JComboBox parametar;
    private JButton sortiraj;

    public DijalogSortiranjeKorisnika(GlavniEkran parent) {
        super(parent, "Sortiranje korisnika ", true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.setBackground(Color.WHITE);

        text = new JLabel("Sortiraj korisnike po:  ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        text.setForeground(Main.tamnoPlava);
        panel.add(text, gridBagConstraints);

        String[] tipoviKorisnika = {"Ime", "Prezime", "Tip korisnika"};
        parametar = new JComboBox(tipoviKorisnika);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        parametar.setForeground(Main.tamnoPlava);
        parametar.setBackground(Main.nebeskoPlava);
        panel.add(parametar, gridBagConstraints);

        sortiraj = new JButton("Sortiraj");
        sortiraj.addActionListener(new SortiranjeKorisnika(this));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        sortiraj.setBackground(Main.tamnoPlava);
        sortiraj.setForeground(Color.WHITE);
        panel.add(sortiraj, gridBagConstraints);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();

        setLocationRelativeTo(parent);
        setVisible(true);

    }

    public JComboBox getParametar() {
        return parametar;
    }
}
