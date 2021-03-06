package view;

import application.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DijalogPretragaLekovaParametar extends JDialog {

    private JComboBox parametar;

    public DijalogPretragaLekovaParametar(GlavniEkran parent) {
        super(parent, "Izaberite parametar pretrage lekova", true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.setBackground(Color.WHITE);


        JLabel text = new JLabel("Izaberite parametar pretrage");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        text.setForeground(Main.tamnoPlava);
        panel.add(text, gridBagConstraints);

        String[] parametri = {"Sifra leka", "Ime leka", "Proizvodjac", "Opseg cene"};
        parametar = new JComboBox(parametri);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        parametar.setBackground(Main.nebeskoPlava);
        parametar.setForeground(Main.tamnoPlava);
        panel.add(parametar, gridBagConstraints);

        JButton potvrdi = new JButton("Potvrdi");
        potvrdi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getParametar().getSelectedItem().toString().equals("Opseg cene")) {
                    DijalogPretragaLekovaOpseg dijalog = new DijalogPretragaLekovaOpseg(parent, getDijalog());
                } else {
                    DijalogPretragaLekova dijalog = new DijalogPretragaLekova(parent, getDijalog());
                }
            }
        });
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        potvrdi.setBackground(Main.tamnoPlava);
        potvrdi.setForeground(Color.WHITE);
        panel.add(potvrdi, gridBagConstraints);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();

        setLocationRelativeTo(parent);
        setVisible(true);
        setResizable(true);
    }

    public JComboBox getParametar() {
        return parametar;
    }

    public DijalogPretragaLekovaParametar getDijalog() {
        return this;
    }
}
