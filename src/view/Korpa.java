package view;

import application.Main;
import kontroler.Prodaja;
import model.Lek;
import model.Lekovi;
import model.Recept;
import model.Recepti;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class Korpa extends JDialog {

    public JLabel dodajPoSifriLeka;
    public JLabel dodajPoSifriRecepta;
    public JLabel ukupnaCena;
    public JLabel cena;
    public JTextField sifraLeka;
    public JTextField sifraRecepta;
    public JTextField kolicinaLek;
    public JTextField kolicinaReceptUnos;
    public JTextField sifraKorisnika;
    public JButton dodajLek;
    public JButton dodajRecept;
    public JButton kupovina;
    public JButton odustani;
    public JTable tabela;
    public DefaultTableModel model;

    public Korpa(GlavniEkran parent) {
        super(parent, "Korpa", true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.LINE_AXIS));

        dodajPoSifriLeka = new JLabel("Dodaj po sifri leka: ");
        dodajPoSifriLeka.setForeground(Main.tamnoPlava);
        sifraLeka = new JTextField(10);
        sifraLeka.setBackground(Main.nebeskoPlava);
        sifraLeka.setForeground(Main.tamnoPlava);
        JLabel kolicina = new JLabel("Kolicina");
        kolicina.setForeground(Main.tamnoPlava);
        kolicinaLek = new JTextField(2);
        kolicinaLek.setBackground(Main.nebeskoPlava);
        kolicinaLek.setForeground(Main.tamnoPlava);
        dodajLek = new JButton("Dodaj lek");
        dodajLek.setBackground(Main.tamnoPlava);
        dodajLek.setForeground(Color.WHITE);
        dodajLek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sifra = getKorpa().getSifraLeka().getText();
                ArrayList<Lek> lekovi = Lekovi.getInstance().getLista();
                for(int i = 0; i<lekovi.size(); i++) {
                    if(lekovi.get(i).getSifra().equals(sifra)) {
                        Object[] lek = {lekovi.get(i).getIme(), Integer.valueOf(getKorpa().getKolicinaLek().getText())};
                        DefaultTableModel model = getModel();
                        model.addRow(lek);
                        Float trenutnaCena = Float.valueOf(cena.getText());
                        trenutnaCena += lekovi.get(i).getCena() * Integer.valueOf(getKorpa().getKolicinaLek().getText());
                        cena.setText(trenutnaCena.toString());
                    }
                }
            }
        });
        dodajPoSifriRecepta = new JLabel("Dodaj po sifri recepta: ");
        dodajPoSifriRecepta.setForeground(Main.tamnoPlava);
        sifraRecepta = new JTextField(10);
        sifraRecepta.setBackground(Main.nebeskoPlava);
        sifraRecepta.setForeground(Main.tamnoPlava);
        dodajRecept = new JButton("Dodaj recept");
        dodajRecept.setBackground(Main.tamnoPlava);
        dodajRecept.setForeground(Color.WHITE);
        dodajRecept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sifra = getKorpa().getSifraRecepta().getText();
                Integer sifraInt = Integer.valueOf(sifra);
                ArrayList<Recept> recepti = Recepti.getInstance().getLista();
                for(int i = 0; i<recepti.size(); i++) {
                    if(recepti.get(i).getSifra() == sifraInt) {
                        Hashtable lekoviKolicina = (Hashtable) recepti.get(i).getLekoviKolicina();
                        Set<Lek> keys = lekoviKolicina.keySet();
                        for(Lek key: keys){
                            Object[] lek = {key.getIme(), lekoviKolicina.get(key)};
                            DefaultTableModel model = getModel();
                            model.addRow(lek);
                            Float trenutnaCena = Float.valueOf(cena.getText());
                            trenutnaCena += key.getCena() * (Integer) lekoviKolicina.get(key);
                            cena.setText(trenutnaCena.toString());
                        }
                    }
                }
            }
        });

        panelTop.add(dodajPoSifriLeka);
        panelTop.add(sifraLeka);
        panelTop.add(kolicina);
        panelTop.add(kolicinaLek);
        panelTop.add(dodajLek);
        panelTop.add(dodajPoSifriRecepta);
        panelTop.add(sifraRecepta);
        panelTop.add(dodajRecept);

        panel.add(panelTop, BorderLayout.NORTH);

        String[] kolone = {"Lek", "Kolicina"};

        model = new DefaultTableModel(null, kolone);
        tabela = new JTable(model);
        tabela.setIntercellSpacing(new Dimension(0,0));
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setBackground(Main.nebeskoPlava);
        tabela.setShowVerticalLines(false);
        TableColumnModel tableColumnModel = tabela.getColumnModel();
        JTableHeader tableHeader = tabela.getTableHeader();
        tableHeader.setBackground(Main.nebeskoPlava);
        tableHeader.setForeground(Main.tamnoPlava);
        tableColumnModel.getColumn(0).setCellRenderer(renderer);
        DefaultTableCellRenderer renderer2 = new DefaultTableCellRenderer();
        renderer2.setBackground(Main.svetloPlava);
        tabela.getColumnModel().getColumn(1).setCellRenderer(renderer2);
        JScrollPane tabelaPane = new JScrollPane(tabela);

        panel.add(tabelaPane, BorderLayout.CENTER);

        JPanel panelBot = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;

        JLabel sifraKorisnikaLabel = new JLabel("Sifra korisnika");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        sifraKorisnikaLabel.setForeground(Main.tamnoPlava);
        panelBot.add(sifraKorisnikaLabel, gridBagConstraints);

        sifraKorisnika = new JTextField(10);
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        sifraKorisnika.setBackground(Main.nebeskoPlava);
        sifraKorisnika.setForeground(Main.tamnoPlava);
        panelBot.add(sifraKorisnika, gridBagConstraints);

        ukupnaCena = new JLabel("Ukupno: ");
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        ukupnaCena.setForeground(Main.tamnoPlava);
        panelBot.add(ukupnaCena, gridBagConstraints);

        cena = new JLabel("0");
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        cena.setForeground(Main.tamnoPlava);
        panelBot.add(cena, gridBagConstraints);

        odustani = new JButton("Odustani");
        odustani.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getKorpa().dispose();
            }
        });
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        panelBot.add(odustani, gridBagConstraints);

        kupovina = new JButton("Kupovina");
        kupovina.addActionListener(new Prodaja(getKorpa()));
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        panelBot.add(kupovina, gridBagConstraints);

        panel.add(panelBot, BorderLayout.SOUTH);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();

        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JTextField getSifraLeka() {
        return sifraLeka;
    }

    public JTextField getSifraRecepta() {
        return sifraRecepta;
    }

    public JLabel getCena() {
        return cena;
    }

    public Korpa getKorpa() {
        return this;
    }

    public JTextField getKolicinaLek() {
        return kolicinaLek;
    }

    public JTextField getKolicinaReceptUnos() {
        return kolicinaReceptUnos;
    }

    public JTextField getSifraKorisnika() {
        return sifraKorisnika;
    }
}
