package view;

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

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;

        text = new JLabel("Sortiraj lekove po:  ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        panel.add(text, gridBagConstraints);

        String[] tipoviKorisnika = {"Imenu", "Proizvodjacu", "Ceni"};
        parametar = new JComboBox(tipoviKorisnika);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        panel.add(parametar, gridBagConstraints);

        sortiraj = new JButton("Sortiraj");
        sortiraj.addActionListener(new SortiranjeLekova(this));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
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
