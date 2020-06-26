package view;

import application.Main;
import kontroler.SacuvajKorisnike;
import kontroler.SacuvajLekove;
import model.Korisnik;
import model.Prodaja;
import model.TipKorisnika;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GlavniEkran extends JFrame {

    private static GlavniEkran instance;
    private Korisnik trenutniKorisnik;

    private JPanel meni;
    private JTabbedPane tabovi;

    private JLabel logoIkonica;
    private JButton pretraga;
    private JButton registracijaKartice;
    private JButton login;
    private JButton korpa;

    private JPanel listaLekara;
    private JPanel banerPopust;

    private JLabel spisakLekara;
    private JLabel popustBaner;

    private JTable korisniciTabela;

    private JLabel zbirProdajeVrednost;

    private static ArrayList<Prodaja> sveProdaje;

    public GlavniEkran() {
        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void postaviGUI() {
        meni = new JPanel();
        meni.setBackground(Main.svetloPlava);
        ImageIcon logo = new ImageIcon("images/LOGO_PNG.png");
        logoIkonica = new JLabel(logo);
        meni.add(logoIkonica);
        ImageIcon pretragaIkonica = new ImageIcon("images/search1.png");
        Image image = pretragaIkonica.getImage(); // transform it
        Image newimg = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        pretragaIkonica = new ImageIcon(newimg);  // transform it back
        pretraga = new JButton(pretragaIkonica);
        pretraga.setBackground(Main.tamnoPlava);
        pretraga.setForeground(Color.WHITE);
        pretraga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tab = getTabovi().getSelectedIndex();
                if (tab == 1) {
                    DijalogPretragaLekovaParametar dijalog = new DijalogPretragaLekovaParametar(GlavniEkran.getInstance());
                } else if (tab == 2) {
                    DijalogPretragaRecepata dijalog = new DijalogPretragaRecepata(GlavniEkran.getInstance());
                }
            }
        });
        meni.add(pretraga);
        registracijaKartice = new JButton("Registracija Kartice");
        registracijaKartice.setBackground(Main.tamnoPlava);
        registracijaKartice.setForeground(Color.WHITE);
        meni.add(registracijaKartice);
        login = new JButton("Login");
        login.setBackground(Main.tamnoPlava);
        login.setForeground(Color.WHITE);
        meni.add(login);
        if(trenutniKorisnik != null & trenutniKorisnik.getTipKorisnika().equals(TipKorisnika.APOTEKAR)) {
            korpa = new JButton("Korpa");
            korpa.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Korpa korpa = new Korpa(GlavniEkran.getInstance());
                }
            });
            meni.add(korpa);
        }
        this.add(meni, BorderLayout.NORTH);

        listaLekara = new JPanel();
        listaLekara.setBackground(Main.nebeskoPlava);
        spisakLekara = new JLabel("Spisak Lekara");
        spisakLekara.setForeground(Main.tamnoPlava);
        listaLekara.add(spisakLekara);
        this.add(listaLekara, BorderLayout.EAST);

        banerPopust = new JPanel();
        banerPopust.setBackground(Main.nebeskoPlava);
        popustBaner = new JLabel("Baner za popust");
        popustBaner.setForeground(Main.tamnoPlava);
        banerPopust.add(popustBaner);
        this.add(banerPopust, BorderLayout.SOUTH);

        this.setResizable(true);
        pack();
    }

    public void tabele() {
        if(tabovi == null) {
            tabovi = new JTabbedPane();
        }
        if(trenutniKorisnik != null && trenutniKorisnik.getTipKorisnika().equals(TipKorisnika.ADMINISTRATOR)) {
            //korisnici ako je korisnik administrator
            JPanel korisniciGlavni = new JPanel();
            korisniciGlavni.setBackground(Main.tamnoPlava);
            korisniciGlavni.setLayout(new BoxLayout(korisniciGlavni, BoxLayout.PAGE_AXIS));
            JPanel top = new JPanel();
            top.setBackground(Main.tamnoPlava);
            JLabel korisniciLabel = new JLabel("Korisnici");
            korisniciLabel.setForeground(Color.WHITE);
            top.add(korisniciLabel);
            JButton sortiraj = new JButton("Sortiraj");
            sortiraj.setBackground(Main.tamnoPlava);
            sortiraj.setForeground(Color.WHITE);
            sortiraj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DijalogSortiranjeKorisnika dijalog = new DijalogSortiranjeKorisnika(GlavniEkran.getInstance());
                }
            });
            top.add(sortiraj);
            korisniciGlavni.add(top);
            korisniciTabela = Korisnici.getInstance();
            JScrollPane korisnici = new JScrollPane(korisniciTabela);
            korisniciGlavni.add(korisnici);
            JPanel dugmici = new JPanel();
            dugmici.setBackground(Main.svetloPlava);
            JButton dodajKorisnika = new JButton("Dodaj Korisnika");
            dodajKorisnika.setBackground(Main.tamnoPlava);
            dodajKorisnika.setForeground(Color.WHITE);
            dodajKorisnika.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DodajKorisnika dialog = new DodajKorisnika(GlavniEkran.getInstance());
                }
            });
            JButton sacuvaj = new JButton("Sacuvaj");
            sacuvaj.setBackground(Main.tamnoPlava);
            sacuvaj.setForeground(Color.WHITE);
            sacuvaj.addActionListener(new SacuvajKorisnike());
            dugmici.add(dodajKorisnika);
            dugmici.add(sacuvaj);
            korisniciGlavni.add(dugmici);
            tabovi.addTab("Korisnici", korisniciGlavni);
        }
        //lekovi
        JPanel lekoviGlavni = new JPanel();
        lekoviGlavni.setBackground(Main.tamnoPlava);
        lekoviGlavni.setLayout(new BoxLayout(lekoviGlavni, BoxLayout.PAGE_AXIS));
        JPanel lekoviTop = new JPanel();
        lekoviTop.setBackground(Main.tamnoPlava);
        JLabel lekoviLabel = new JLabel("Lekovi");
        lekoviLabel.setForeground(Color.WHITE);
        lekoviTop.add(lekoviLabel);
        JButton sortirajLekove = new JButton("Sortiraj");
        sortirajLekove.setBackground(Main.tamnoPlava);
        sortirajLekove.setForeground(Color.WHITE);
        sortirajLekove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DijalogSortiranjeLekova dijalog = new DijalogSortiranjeLekova(GlavniEkran.getInstance());
            }
        });
        lekoviTop.add(sortirajLekove);
        lekoviGlavni.add(lekoviTop);
        JTable lekoviTabela = Lekovi.getInstance();
        JScrollPane lekovi = new JScrollPane(lekoviTabela);
        lekoviGlavni.add(lekovi);
        JPanel lekoviDugmici = new JPanel();
        lekoviDugmici.setBackground(Main.svetloPlava);
        if(trenutniKorisnik != null && trenutniKorisnik.getTipKorisnika().equals(TipKorisnika.ADMINISTRATOR) || trenutniKorisnik.getTipKorisnika().equals(TipKorisnika.APOTEKAR)) {
            JButton dodajLek = new JButton("Dodaj lek");
            dodajLek.setForeground(Color.WHITE);
            dodajLek.setBackground(Main.tamnoPlava);
            dodajLek.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DodajLek dijalog = new DodajLek(GlavniEkran.getInstance());
                }
            });
            JButton izmeniLek = new JButton("Izmeni lek");
            izmeniLek.setBackground(Main.tamnoPlava);
            izmeniLek.setForeground(Color.WHITE);
            izmeniLek.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DijalogIzmeniLek dijalog = new DijalogIzmeniLek(GlavniEkran.getInstance());
                }
            });
            JButton sacuvajLek = new JButton("Sacuvaj");
            sacuvajLek.setForeground(Color.WHITE);
            sacuvajLek.setBackground(Main.tamnoPlava);
            sacuvajLek.addActionListener(new SacuvajLekove());
            lekoviDugmici.add(dodajLek);
            lekoviDugmici.add(izmeniLek);
            lekoviDugmici.add(sacuvajLek);
            lekoviGlavni.add(lekoviDugmici);
        }
        tabovi.addTab("Lekovi", lekoviGlavni);
        //recepti
        JPanel receptiGlavni = new JPanel();
        receptiGlavni.setBackground(Main.tamnoPlava);
        receptiGlavni.setLayout(new BoxLayout(receptiGlavni, BoxLayout.PAGE_AXIS));
        JPanel receptiTop = new JPanel();
        receptiTop.setBackground(Main.tamnoPlava);
        JLabel receptiLabel = new JLabel("Recepti");
        receptiLabel.setForeground(Color.WHITE);
        receptiTop.add(receptiLabel);
        JButton receptiSortiraj = new JButton("Sortiraj");
        receptiSortiraj.setBackground(Main.tamnoPlava);
        receptiSortiraj.setForeground(Color.WHITE);
        receptiSortiraj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DijalogSortiranjeRecepata dijalog = new DijalogSortiranjeRecepata(GlavniEkran.getInstance());
            }
        });
        receptiTop.add(receptiSortiraj);
        receptiGlavni.add(receptiTop);
        JTable receptiTabela = Recepti.getInstance();
        JScrollPane recepti = new JScrollPane(receptiTabela);
        receptiGlavni.add(recepti);
        if(trenutniKorisnik != null && trenutniKorisnik.getTipKorisnika().equals(TipKorisnika.LEKAR)) {
            JPanel receptiDugme = new JPanel();
            receptiDugme.setBackground(Main.svetloPlava);
            JButton dodajRecept = new JButton("Dodaj recept");
            dodajRecept.setForeground(Color.WHITE);
            dodajRecept.setBackground(Main.tamnoPlava);
            dodajRecept.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DodajRecept dijalog = new DodajRecept(GlavniEkran.getInstance());
                }
            });
            receptiDugme.add(dodajRecept);
            receptiGlavni.add(receptiDugme);
        }
        tabovi.addTab("Recepti", receptiGlavni);
        if(trenutniKorisnik != null && trenutniKorisnik.getTipKorisnika().equals(TipKorisnika.ADMINISTRATOR)) {
            JPanel izvestajGlavni = new JPanel();
            izvestajGlavni.setBackground(Main.tamnoPlava);
            izvestajGlavni.setLayout(new BoxLayout(izvestajGlavni, BoxLayout.PAGE_AXIS));
            JPanel izvestajTop = new JPanel();

            izvestajTop.setBackground(Main.tamnoPlava);
            JLabel izvestajLabel = new JLabel("Izvestaj");
            izvestajLabel.setBackground(Main.tamnoPlava);
            izvestajLabel.setForeground(Color.WHITE);
            izvestajTop.add(izvestajLabel);
            JButton kreirajIzvestaj = new JButton("Kreiraj Izvestaj");
            kreirajIzvestaj.setBackground(Main.tamnoPlava);
            kreirajIzvestaj.setForeground(Color.WHITE);
            kreirajIzvestaj.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DijalogIzvestaj dijalog = new DijalogIzvestaj(GlavniEkran.getInstance());
                }
            });
            izvestajTop.add(kreirajIzvestaj);
            izvestajGlavni.add(izvestajTop);
            JTable izvestajTabela = Izvestaj.getInstance();
            JScrollPane izvestaj = new JScrollPane(izvestajTabela);
            izvestajGlavni.add(izvestaj);
            JPanel izvestajUkupno = new JPanel();
            izvestajUkupno.setBackground(Main.svetloPlava);
            JLabel zbirProdaje = new JLabel("Zbir prodaje :");
            zbirProdaje.setBackground(Main.svetloPlava);
            zbirProdajeVrednost = new JLabel("");
            zbirProdajeVrednost.setBackground(Main.svetloPlava);
            izvestajUkupno.add(zbirProdaje);
            izvestajUkupno.add(zbirProdajeVrednost);
            izvestajGlavni.add(izvestajUkupno);
            tabovi.addTab("Izvestaj", izvestajGlavni);
        }
        this.add(tabovi, BorderLayout.CENTER);

        pack();

    }

    public static GlavniEkran getInstance() {
        if(instance == null) {
            instance = new GlavniEkran();
        }
        return instance;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik = trenutniKorisnik;
    }

    public JLabel getZbirProdajeVrednost() {
        return zbirProdajeVrednost;
    }

    public void setZbirProdajeVrednost(JLabel zbirProdajeVrednost) {
        this.zbirProdajeVrednost = zbirProdajeVrednost;
    }

    public static ArrayList<Prodaja> getSveProdaje() {
        return sveProdaje;
    }

    public static void setSveProdaje(ArrayList<Prodaja> sveProdajepar) {
        sveProdaje = sveProdajepar;
    }

    public JTabbedPane getTabovi() {
        return tabovi;
    }
}
