package jframekonto;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mauri
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenster implements ActionListener {

    public Fenster() {
        
        Fenster.setLayout(new FlowLayout());
        read();

    }
    JFrame Fenster = new JFrame();
    JButton button1 = new JButton("Button");
    JTextField Benutzername = new JTextField("Geben sie ihren Benutzernamen ein.");
    JPanel panelA = new JPanel();

    void los() {

        Fenster.setSize(700, 700);
        button1.setSize(500, 50);

        //add Area ------------------------------
        Fenster.add(panelA);
        Fenster.getContentPane().add(button1);
        Fenster.getContentPane().add(Benutzername);
        panelA.add(button1);
        panelA.add(Benutzername);

        //ActionListener-Button---------------------
        Fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.addActionListener(this);
        Benutzername.addActionListener(this);
        //booleans-----------------------------------
        Fenster.setVisible(true);
        Benutzername.setEditable(true);
        panelA.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        if (event.getSource() == button1) {

            button1.setText("ich wurde geklickt");
        } else if (event.getSource() == Benutzername) {

            String text = Benutzername.getText();
            Benutzername.selectAll();
            System.out.println(text);
            try {
                write(text);
            } catch (IOException ex) {
                Logger.getLogger(Fenster.class.getName()).log(Level.SEVERE, null, ex);
            }
            read();
        }
    }

    public static void write(String s) throws IOException {

        try {

            FileWriter fWriter = new FileWriter("src/Benutzername/Benutzername.txt");

            fWriter.write(String.valueOf(s));

            fWriter.close();

        } catch (IOException ex) {

            ex.printStackTrace();

        }

    }

    public void read() {

        String text;

        try {

            File meineDatei = new File("src/Benutzername/Benutzername.txt");
            FileReader fileReader = new FileReader(meineDatei);

            BufferedReader reader = new BufferedReader(fileReader);

            String zeile = null;

            if ((zeile = reader.readLine()) != null) {

                text = zeile;
                System.out.println(text);
            }
            reader.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

}
