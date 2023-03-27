import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//This is the section made so that user can add an image for notes section
public class ImageAdder implements ActionListener {
    static JPanel jPanel;

    JButton button5 = new JButton("Back");

    JFrame frame = new JFrame();


    ImageAdder() {
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setBackground(new Color(0Xffcccb));

        button5.setFocusable(false);
        button5.addActionListener(this);
        button5.setBackground(new Color(0Xee98fb));
        button5.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xff77a9)));

        button5.setSize(100, 100);
        button5.setFont(new Font("Agency FB", Font.BOLD, 15));

        button5.setFocusable(false);
        JLabel label = new JLabel("to Main Menu");
        for (Consultation consultation : Consultation.consultationList) {
//Selecting image file to add

            Object[] setIcon = {consultation.getNotes()};

            label.setIcon(new ImageIcon("C:\\Users\\3C Tech\\Music\\OOP CW\\My Java cw (Second one)\\Skin-image.jpg"));
        }

        frame.add(label);


        frame.setSize(1000, 500);
        frame.setTitle("Image");
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());
        frame.add(jPanel, BorderLayout.SOUTH);
        jPanel.add(button5);
        jPanel.add(label);


    }

    {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(getParent());
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                FileInputStream picture = new FileInputStream(file);
                byte[] encryptArray = EncryptImage.encrypt(picture);


                FileOutputStream fos = new FileOutputStream("C:\\Users\\3C Tech\\Music\\w1867684_OOP CW(iit number 20210646)\\My Java cw (Second one)\\Encrypt2.jpg");

                fos.write(encryptArray);
                fos.close();
                picture.close();


            } catch (IOException ioe) {
                ioe.printStackTrace();
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }
    }


    private Component getParent() {
        return null;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button5) {
            MainMenu gui = new MainMenu();
            frame.dispose();
        }
    }
}


