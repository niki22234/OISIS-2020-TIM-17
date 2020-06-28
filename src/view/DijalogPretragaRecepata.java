package view;

import application.Main;
import kontroler.PretragaRecepata;

import javax.swing.*;
import java.awt.*;

public class DijalogPretragaRecepata extends JDialog {

    private JTextField unos;
    private JComboBox parametar;

    public DijalogPretragaRecepata(GlavniEkran parent) {
        super(parent, "Pretraga recepata", true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.setBackground(Color.WHITE);

        unos = new JTextField(20);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        unos.setForeground(Main.tamnoPlava);
        unos.setBackground(Main.nebeskoPlava);
        panel.add(unos, gridBagConstraints);

        JLabel text = new JLabel("Po parametru: ");
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        text.setForeground(Main.tamnoPlava);
        panel.add(text, gridBagConstraints);

        String[] parametri = {"Sifra recepta", "Lekar", "JMBG pacijenta", "Po jednom leku"};
        parametar = new JComboBox(parametri);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        parametar.setBackground(Main.nebeskoPlava);
        parametar.setForeground(Main.tamnoPlava);
        panel.add(parametar, gridBagConstraints);

        JButton dugme = new JButton("Pretrazi");
        dugme.addActionListener(new PretragaRecepata(parent, getDijalog()));
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        dugme.setBackground(Main.tamnoPlava);
        dugme.setForeground(Color.WHITE);
        panel.add(dugme, gridBagConstraints);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();

        setLocationRelativeTo(parent);
        setVisible(true);
        setResizable(true);
    }

    public DijalogPretragaRecepata getDijalog() {
        return this;
    }

    public JTextField getUnos() {
        return unos;
    }

    public JComboBox getParametar() {
        return parametar;
    }
}
