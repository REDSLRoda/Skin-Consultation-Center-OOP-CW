import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientInfo implements ActionListener {
    static JPanel jPanel;
    static String[] col;
    JButton button4 = new JButton("Back");

    JFrame frame = new JFrame();

    PatientInfo() {
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setBackground(new Color(0Xffcccb));

        button4.setFocusable(false);
        button4.addActionListener(this);
        button4.setBackground(new Color(0Xee98fb));
        button4.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xff77a9)));

        button4.setSize(100, 100);
        button4.setFont(new Font("Agency FB", Font.BOLD, 15));

        button4.setFocusable(false);

        JLabel label = new JLabel("to Main Menu");


        frame.setSize(1000, 500);
        frame.setTitle("Patient Info");
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());
        frame.add(jPanel, BorderLayout.SOUTH);
        jPanel.add(button4);
        jPanel.add(label);
        //creating the table

        col = new String[]{"Patient First Name","Last Name", "Patient id", "Date of Birth","Mobile Number"};

        DefaultTableModel table = new DefaultTableModel(col, 0);
        JTable jTable = new JTable(table);
        for (Patient patient : Consultation.patientList) {
            Object[] rows = {patient.getPatientname(),patient.getPatientlname(), patient.getPatientid(),patient.getDateOfBirth(),patient.getPatientmobile()};
            table.addRow(rows);
        }
        jTable.setFont(new Font("Arial", Font.PLAIN, 16));
        JTableHeader jTableHeader = jTable.getTableHeader();
        JScrollPane scrollPane = new JScrollPane(jTable);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button4) {
            MainMenu l = new MainMenu();
            frame.dispose();

        }
    }
}





