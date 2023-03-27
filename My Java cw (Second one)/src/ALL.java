import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//This clas is created to show all the Details of Consultation entered by user onto the GUI table.

public class ALL implements ActionListener {

    static JPanel jPanel;
    static String[] col;
    JButton button7 = new JButton("Back");

    JFrame frame = new JFrame();

    ALL(){
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setBackground(new Color(0Xffcccb));

        button7.setFocusable(false);
        button7.addActionListener(this);
        button7.setBackground(new Color(0Xee98fb));
        button7.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xff77a9)));

        button7.setSize(100,100);
        button7.setFont(new Font("Agency FB",Font.BOLD, 15));

        button7.setFocusable(false);

        JLabel label  = new JLabel("to Main Menu");



        frame.setSize(1000,500);
        frame.setTitle("Doctor List");
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());
        frame.add(jPanel, BorderLayout.SOUTH);
        jPanel.add(button7);
        jPanel.add(label);

//creating the table of the GUI

        col = new String[]{"Doctor Name","Specialization","Licence number", "Patient Name", "Patient id", "Notes ", "Costs", "Date"};

        DefaultTableModel table = new DefaultTableModel(col, 0);
        JTable jTable = new JTable(table);

        for (Doctor doctor: Consultation.doctorsList) {
            for (Patient patient : Consultation.patientList) {
                for (Consultation consultation : Consultation.consultationList) {



                    Object[] rows = {doctor.getDoctorname(),doctor.getSpecialization(),doctor.getMedicalLicenceNumber(), patient.getPatientname(), patient.getPatientid(), consultation.getNotes(), consultation.getCosts()};
                    table.addRow(rows);

                }
            }
        }

        jTable.setFont(new Font("Arial",Font.PLAIN, 16));
        JTableHeader jTableHeader = jTable.getTableHeader();
        JScrollPane scrollPane = new JScrollPane(jTable);
        frame.add(scrollPane);
        frame.setVisible(true);






    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainMenu launchPage = new MainMenu();
        frame.dispose();
    }
}
