package view;

import application.Main;
import kontroler.PretragaLekova;

import javax.swing.*;
import java.awt.*;

public class DijalogPretragaLekova extends JDialog {

    private JTextField unos;
    private JComboBox parametar;

    public DijalogPretragaLekova(GlavniEkran parent, DijalogPretragaLekovaParametar dijalog) {
        super(parent, "Pretraga korisnika", true);
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
        unos.setBackground(Main.svetloPlava);
        unos.setForeground(Main.tamnoPlava);
        panel.add(unos, gridBagConstraints);

        JButton pretraga = new JButton("Pretrazi");
        pretraga.addActionListener(new PretragaLekova(dijalog.getParametar().getSelectedItem().toString(), getDijalog()));
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        pretraga.setBackground(Main.tamnoPlava);
        pretraga.setForeground(Color.WHITE);
        panel.add(pretraga, gridBagConstraints);

        getContentPane().add(panel, BorderLayout.CENTER);

        dijalog.dispose();

        pack();

        setLocationRelativeTo(parent);
        setVisible(true);
        setResizable(true);
    }

    public JTextField getUnos() {
        return unos;
    }

    public JComboBox getParametar() {
        return parametar;
    }

    public DijalogPretragaLekova getDijalog() {
        return this;
    }
}
