package view;

import kontroler.PretragaLekova;
import kontroler.PretragaLekovaOpseg;

import javax.swing.*;
import java.awt.*;

public class DijalogPretragaLekovaOpseg extends JDialog {

    private JTextField manji;
    private JTextField veci;

    public DijalogPretragaLekovaOpseg(GlavniEkran parent, DijalogPretragaLekovaParametar dijalog) {
        super(parent, "Pretraga lekova", true);
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;

        JLabel text = new JLabel("Opseg cene leka: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        panel.add(text, gridBagConstraints);

        manji = new JTextField(7);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        panel.add(manji, gridBagConstraints);

        JLabel text2 = new JLabel(" do ");
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        panel.add(text2, gridBagConstraints);

        veci = new JTextField(7);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        panel.add(veci, gridBagConstraints);

        JButton pretraga = new JButton("Pretrazi");
        pretraga.addActionListener(new PretragaLekovaOpseg(getDijalog()));
        gridBagConstraints.gridx = 5;
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

    public DijalogPretragaLekovaOpseg getDijalog() {
        return this;
    }

    public JTextField getManji() {
        return manji;
    }

    public JTextField getVeci() {
        return veci;
    }
}
