package view;

import kontroler.PretragaLekova;

import javax.swing.*;
import java.awt.*;

public class DijalogPretragaLekova extends JDialog {

    private JTextField unos;
    private JComboBox parametar;

    public DijalogPretragaLekova(GlavniEkran parent, DijalogPretragaLekovaParametar dijalog) {
        super(parent, "Pretraga korisnika", true);
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;

        unos = new JTextField(20);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        panel.add(unos, gridBagConstraints);

        JButton pretraga = new JButton("Pretrazi");
        pretraga.addActionListener(new PretragaLekova(dijalog.getParametar().getSelectedItem().toString(), getDijalog()));
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
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
