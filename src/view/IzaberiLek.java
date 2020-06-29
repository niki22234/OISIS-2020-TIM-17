package view;

import application.Main;
import model.Lek;
import model.Lekovi;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IzaberiLek extends JDialog {

    private JComboBox lekovi;
    private JTextField kolicina;

    public IzaberiLek(DodajRecept parent) {
        super(parent, "Izaberi Lek", true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.setBackground(Color.WHITE);

        ArrayList<Lek> sviLekovi = Lekovi.getInstance().getLista();
        int brojLekova = sviLekovi.size();
        String[] spisakLekova = new String[brojLekova];
        for(int i = 0; i < brojLekova; i++) {
            spisakLekova[i] = sviLekovi.get(i).getIme();
        }

        lekovi = new JComboBox(spisakLekova);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        lekovi.setForeground(Main.tamnoPlava);
        lekovi.setBackground(Main.nebeskoPlava);
        panel.add(lekovi, gridBagConstraints);

        kolicina = new JTextField(5);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        kolicina.setBackground(Main.nebeskoPlava);
        kolicina.setForeground(Main.tamnoPlava);
        panel.add(kolicina, gridBagConstraints);

        JButton dodaj = new JButton("Dodaj izabrani lek i kolicinu");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        dodaj.setBackground(Main.tamnoPlava);
        dodaj.setForeground(Color.WHITE);
        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = parent.getModel();
                Object[] lek = {getLekovi().getSelectedItem(), getKolicina().getText()};
                model.addRow(lek);
                getDijalog().dispose();
            }
        });
        panel.add(dodaj, gridBagConstraints);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();

        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public JComboBox getLekovi() {
        return lekovi;
    }

    public JTextField getKolicina() {
        return kolicina;
    }

    public JDialog getDijalog() {
        return this;
    }
}
