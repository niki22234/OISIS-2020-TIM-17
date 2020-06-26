package view;

import application.Main;
import kontroler.Logovanje;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JDialog {

    public JLabel text;
    public JLabel korisnickoIme;
    public JLabel password;
    public JTextField korisnickoImeUnos;
    public JTextField passwordUnos;
    public JButton potvrda;

    public Login(Frame parent) {
        super(parent, "Login", true);
        this.setBackground(new Color(1, 74, 129));
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        panel.setBackground(Color.WHITE);

        text = new JLabel("Login");
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        text.setForeground(Main.tamnoPlava);
        panel.add(text, gridBagConstraints);

        korisnickoIme = new JLabel("Korisnicko ime: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        korisnickoIme.setForeground(Main.tamnoPlava);
        panel.add(korisnickoIme, gridBagConstraints);

        korisnickoImeUnos = new JTextField(15);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        korisnickoImeUnos.setBackground(Main.nebeskoPlava);
        panel.add(korisnickoImeUnos, gridBagConstraints);

        password = new JLabel("Password: ");
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        password.setForeground(Main.tamnoPlava);
        panel.add(password, gridBagConstraints);

        passwordUnos = new JTextField(15);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        passwordUnos.setBackground(Main.nebeskoPlava);
        panel.add(passwordUnos, gridBagConstraints);

        panel.setBorder(new EmptyBorder(30,10,10,10));

        potvrda = new JButton("Potvrdi");
        potvrda.setBackground(Main.tamnoPlava);
        potvrda.setForeground(Color.WHITE);

        potvrda.addActionListener(new Logovanje(this));

        JPanel potvrdi = new JPanel();
        potvrdi.setBackground(Color.WHITE);
        potvrdi.add(potvrda);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(potvrdi, BorderLayout.SOUTH);

        pack();

        this.setResizable(false);
        this.setLocationRelativeTo(parent);

    }

    public JLabel getPoruka() {
        return text;
    }

    public String getUsername() {
        return korisnickoImeUnos.getText();
    }

    public String getPassword() {
        return passwordUnos.getText();
    }

    public Login getDijalog() {
        return this;
    }

    public JTextField getKorisnickoImeUnos() {
        return korisnickoImeUnos;
    }

    public JTextField getPasswordUnos() {
        return passwordUnos;
    }
}
