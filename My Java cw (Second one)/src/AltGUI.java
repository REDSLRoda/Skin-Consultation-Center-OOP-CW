import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
//This is an  alternative GUI made to Display the Availability of the Doctors.
public class AltGUI implements ActionListener {
    JFrame frame = new JFrame();
    JButton button1 = new JButton("Availability");
    JLabel label = new JLabel();
    JPanel panel = new JPanel();

    AltGUI() {

        frame.setLayout(new BorderLayout());
        frame.setTitle("Skin Care Consultation Center");
        frame.add(panel, BorderLayout.NORTH);
        frame.getContentPane().setBackground(new Color(0x60FFEC));
        panel.setBackground(new Color(0x60FFC7));


        panel.add(label);


        frame.pack();


        frame.setSize(1000, 1200);
        panel.setBounds(0, 500, 1000, 100);

        //adding the buttons to the frame

        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(button1);

        button1.setBounds(300, 160, 400, 40);
        button1.setFocusable(false);
        button1.addActionListener(this);
        button1.setBackground(new Color(0Xffcccb));
        button1.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0x000000)));
        button1.setFont(new Font("Arial", Font.BOLD, 18));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {// Functioning the button for sort the table in ascending order



                Availability availability = new Availability();
                Scanner input = new Scanner(System.in);



            }



        }


    public static void main(String[] args) {
        AltGUI p1 = new AltGUI();
    }
}
