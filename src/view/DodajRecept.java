package view;

import application.Main;
import kontroler.DodavanjeRecepta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DodajRecept extends JDialog {

    private JLabel jmbgPacijenta;
    private JLabel datum;
    private JLabel vreme;
    private JLabel spisakLekova;
    private JTable spisak;
    private DefaultTableModel model;
    private JTextField jmbgUnos;
    private JSpinner vremeUnos;
    private JLabel poruka;

    public DodajRecept(GlavniEkran parent) {
        super(parent, "Dodavanje recepta", true);
        this.setLayout(new BorderLayout());
        this.setSize(400, 300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.setBackground(Color.WHITE);

        jmbgPacijenta = new JLabel("JMBG pacijenta: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        jmbgPacijenta.setForeground(Main.tamnoPlava);
        panel.add(jmbgPacijenta, gridBagConstraints);

        jmbgUnos = new JTextField(10);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        jmbgUnos.setBackground(Main.nebeskoPlava);
        jmbgUnos.setForeground(Main.tamnoPlava);
        panel.add(jmbgUnos, gridBagConstraints);

        vreme = new JLabel("Datum i vreme: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        vreme.setForeground(Main.tamnoPlava);
        panel.add(vreme, gridBagConstraints);

        vremeUnos = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(vremeUnos, "dd/MM/yyyy HH:mm");
        DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        vremeUnos.setForeground(Main.tamnoPlava);
        vremeUnos.setBackground(Main.nebeskoPlava);
        panel.add(vremeUnos, gridBagConstraints);

        spisakLekova = new JLabel("Spisak lekova: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        spisakLekova.setForeground(Main.tamnoPlava);
        panel.add(spisakLekova, gridBagConstraints);

        String[] kolone = {"Lek", "Kolicina"};
        model = new DefaultTableModel(null, kolone);
        spisak = new JTable(model);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 10;
        panel.add(spisak, gridBagConstraints);

        JButton dodajLek = new JButton("Dodaj lek");
        dodajLek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IzaberiLek dijalog = new IzaberiLek(getDijalog());
            }
        });
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        dodajLek.setBackground(Main.tamnoPlava);
        dodajLek.setForeground(Color.WHITE);
        panel.add(dodajLek, gridBagConstraints);

        JButton sacuvajRecept = new JButton("Sacuvaj");
        sacuvajRecept.addActionListener(new DodavanjeRecepta(this));
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 1;
        sacuvajRecept.setBackground(Main.tamnoPlava);
        sacuvajRecept.setForeground(Color.WHITE);
        panel.add(sacuvajRecept, gridBagConstraints);

        poruka = new JLabel("");
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        poruka.setForeground(Main.tamnoPlava);
        panel.add(poruka, gridBagConstraints);

        getContentPane().add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(parent);
        setVisible(true);
        setResizable(true);
    }

    public DodajRecept getDijalog() {
        return this;
    }

    public JTable getTabela() {
        return spisak;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JTable getSpisak() {
        return spisak;
    }

    public JTextField getJmbgUnos() {
        return jmbgUnos;
    }

    public JSpinner getVremeUnos() {
        return vremeUnos;
    }

    public JLabel getPoruka() {
        return poruka;
    }

    public void setPoruka(JLabel poruka) {
        this.poruka = poruka;
    }
}
