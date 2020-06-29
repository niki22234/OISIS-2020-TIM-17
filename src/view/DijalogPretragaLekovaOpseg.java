package view;

import application.Main;
import kontroler.PretragaLekovaOpseg;

import javax.swing.*;
import java.awt.*;

public class DijalogPretragaLekovaOpseg extends JDialog {

    private JTextField manji;
    private JTextField veci;

    public DijalogPretragaLekovaOpseg(GlavniEkran parent, DijalogPretragaLekovaParametar dijalog) {
        super(parent, "Pretraga lekova", true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.setBackground(Color.WHITE);

        JLabel text = new JLabel("Opseg cene leka: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        text.setForeground(Main.tamnoPlava);
        panel.add(text, gridBagConstraints);

        manji = new JTextField(7);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        manji.setForeground(Main.tamnoPlava);
        manji.setBackground(Main.nebeskoPlava);
        panel.add(manji, gridBagConstraints);

        JLabel text2 = new JLabel(" do ");
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        text2.setForeground(Main.tamnoPlava);
        panel.add(text2, gridBagConstraints);

        veci = new JTextField(7);
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        veci.setBackground(Main.nebeskoPlava);
        veci.setForeground(Main.tamnoPlava);
        panel.add(veci, gridBagConstraints);

        JButton pretraga = new JButton("Pretrazi");
        pretraga.addActionListener(new PretragaLekovaOpseg(getDijalog()));
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        pretraga.setForeground(Color.WHITE);
        pretraga.setBackground(Main.tamnoPlava);
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
