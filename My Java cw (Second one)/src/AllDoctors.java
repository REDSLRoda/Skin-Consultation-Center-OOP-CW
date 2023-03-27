import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllDoctors implements ActionListener {
    //This clas is created to show all the Doctors entered by user onto the GUI table.


    static JPanel jPanel;
    static String[] col;
    JButton button1 = new JButton("Back");

    JFrame frame = new JFrame();

    AllDoctors(){
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setBackground(new Color(0Xffcccb));

        button1.setFocusable(false);
        button1.addActionListener(this);
        button1.setBackground(new Color(0Xee98fb));
        button1.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xff77a9)));

        button1.setSize(100,100);
        button1.setFont(new Font("Agency FB",Font.BOLD, 15));

        button1.setFocusable(false);

        JLabel label  = new JLabel("to Main Menu");



        frame.setSize(1000,500);
        frame.setTitle("Doctor List");
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());
        frame.add(jPanel, BorderLayout.SOUTH);
        jPanel.add(button1);
        jPanel.add(label);
        //creating the table

        col = new String[]{"Name"};

        DefaultTableModel table = new DefaultTableModel(col, 0);
        JTable jTable = new JTable(table);
        for (Doctor doctor: WestminsterSkinConsultationManager.doctorsList){
            Object[] rows = {doctor.getDoctorname(),} ;
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
        if(e.getSource() == button1){
            MainMenu launchPage = new MainMenu();
            frame.dispose();
        }
    }
}
