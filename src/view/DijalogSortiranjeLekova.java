package view;

import application.Main;
import kontroler.SortiranjeKorisnika;
import kontroler.SortiranjeLekova;

import javax.swing.*;
import java.awt.*;

public class DijalogSortiranjeLekova extends JDialog {

    private GlavniEkran parent;
    private JLabel text;
    private JComboBox parametar;
    private JButton sortiraj;

    public DijalogSortiranjeLekova(GlavniEkran parent) {
        super(parent, "Sortiranje lekova ", true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.setBackground(Color.WHITE);

        text = new JLabel("Sortiraj lekove po:  ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        text.setForeground(Main.tamnoPlava);
        panel.add(text, gridBagConstraints);

        String[] tipoviKorisnika = {"Imenu", "Proizvodjacu", "Ceni"};
        parametar = new JComboBox(tipoviKorisnika);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        parametar.setBackground(Main.nebeskoPlava);
        parametar.setForeground(Main.tamnoPlava);
        panel.add(parametar, gridBagConstraints);

        sortiraj = new JButton("Sortiraj");
        sortiraj.addActionListener(new SortiranjeLekova(this));
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
