import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



public class MainMenu implements ActionListener {


    //main menu of the GUI
    //adding the buttons and the text fields to the frame and the jpanel
    JFrame frame = new JFrame();
    JButton button1 = new JButton("All Doctors");
    JButton button2 = new JButton("Doctor list alphabetically");
    JButton button3 = new JButton("Recorded Consultations");
    JButton button4 = new JButton("Patient Info");
    JButton button5 = new JButton("Add Image");
    JButton button6 = new JButton("Notes");
    JButton button7 = new JButton("ALL");

    JLabel label = new JLabel();

    //creating the panel
    JPanel panel = new JPanel();



    MainMenu() {

        frame.setLayout(new BorderLayout());
        frame.setTitle("Skin Care Consultation Center");
        frame.add(panel, BorderLayout.NORTH);
        frame.getContentPane().setBackground(new Color(0x60FFEC));
        panel.setBackground(new Color(0x60FFC7));



        panel.add(button6);
        panel.add(label);




        frame.pack();


        frame.setSize(1000, 1200);
        panel.setBounds(0, 500, 1000, 100);

        //adding the buttons to the frame

        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);


        button1.setBounds(300, 160, 400, 40);
        button1.setFocusable(false);
        button1.addActionListener(this);
        button1.setBackground(new Color(0Xffcccb));
        button1.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0x000000)));
        button1.setFont(new Font("Arial", Font.BOLD, 18));

        button2.setBounds(300, 200, 400, 40);
        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setBackground(new Color(0Xffcccb));
        button2.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0x000000)));
        button2.setFont(new Font("Arial", Font.BOLD, 18));

        button3.setBounds(300, 240, 400, 40);
        button3.setFocusable(false);
        button3.addActionListener(this);
        button3.setBackground(new Color(0Xffcccb));
        button3.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0x000000)));
        button3.setFont(new Font("Arial", Font.BOLD, 18));

        button4.setBounds(300, 280, 400, 40);
        button4.setFocusable(false);
        button4.addActionListener(this);
        button4.setBackground(new Color(0Xffcccb));
        button4.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0x000000)));
        button4.setFont(new Font("Arial", Font.BOLD, 18));

        button5.setBounds(300, 320, 400, 40);
        button5.setFocusable(false);
        button5.addActionListener(this);
        button5.setBackground(new Color(0Xffcccb));
        button5.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0x000000)));
        button5.setFont(new Font("Arial", Font.BOLD, 18));

        button6.setBounds(300, 400, 400, 40);
        button6.setFocusable(false);
        button6.addActionListener(this);
        button6.setBackground(new Color(0Xffcccb));
        button6.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0x000000)));
        button6.setFont(new Font("Arial", Font.BOLD, 18));

        button7.setBounds(300, 360, 400, 40);
        button7.setFocusable(false);
        button7.addActionListener(this);
        button7.setBackground(new Color(0Xffcccb));
        button7.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0x000000)));
        button7.setFont(new Font("Arial", Font.BOLD, 18));




    }
    //functioning the buttons according to the relevant methods

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button2) {// Functioning the button for sort the table in alphabetical order
            AlphabeticalOrder a2 = new AlphabeticalOrder();
            frame.dispose();

        }
        if (e.getSource() == button1) {// Functioning the button for the table includes all the doctors
            AllDoctors a1 = new AllDoctors();
            frame.dispose();

        }
        if (e.getSource() == button3) {// Functioning the button for sorting the consultation details
            Consultation a3 = new Consultation();
            frame.dispose();


        }
        if (e.getSource() == button4) {// Functioning the button for all the patient details.
            PatientInfo a4 = new PatientInfo();
            frame.dispose();


        }
        if (e.getSource() == button6) {// Functioning the button for all the notes included.
            Notes a6 = new Notes();
            try {
                Encryption.SaveNote();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                Encryption.LoadNote();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Encryption.storeConsultDetails();
            frame.dispose();

        }
        if (e.getSource() == button5) {
            ImageAdder a5 = new ImageAdder();
            frame.dispose();

        }
        if (e.getSource() == button7) {
            ALL a7 = new ALL();
            frame.dispose();


        }
    }
        public static void main (String[]args){
            MainMenu p1 = new MainMenu();


        }

    }


