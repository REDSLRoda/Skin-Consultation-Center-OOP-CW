import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlphabeticalOrder implements ActionListener {
    //Creating the new GUI frame with alphabetical order table


    static JPanel jPanel;
    static String[] col;
    JButton button2 = new JButton("Back");

    JFrame frame = new JFrame();

    AlphabeticalOrder(){
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setBackground(new Color(0Xffcccb));

        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setBackground(new Color(0Xee98fb));
        button2.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xff77a9)));

        button2.setSize(100,100);
        button2.setFont(new Font("Agency FB",Font.BOLD, 15));

        button2.setFocusable(false);

        JLabel label  = new JLabel("to Main Menu");



        frame.setSize(1000,500);
        frame.setTitle("Doctor List");
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());
        frame.add(jPanel, BorderLayout.SOUTH);
        jPanel.add(button2);
        jPanel.add(label);
        //creating the table

        col = new String[]{"Name", "Specialization", "Licence", "Consultations ", "Patients"};

        DefaultTableModel table = new DefaultTableModel(col, 0);
        JTable jTable = new JTable(table);
        for (Doctor doctor: WestminsterSkinConsultationManager.doctorsList){
            Object[] rows = {doctor.getDoctorname(),doctor.getSpecialization(),doctor.getMedicalLicenceNumber()} ;
            table.addRow(rows);

        }
        jTable.setFont(new Font("Arial",Font.PLAIN, 16));
        JTableHeader jTableHeader = jTable.getTableHeader();
        JScrollPane scrollPane = new JScrollPane(jTable);
        frame.add(scrollPane);
        frame.setVisible(true);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button2){
            MainMenu l = new MainMenu();
            frame.dispose();
        }
    }
}
