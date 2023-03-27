import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Notes implements ActionListener {
    static JPanel jPanel;
    static String[] col;
    JButton button6 = new JButton("Back");

    JFrame frame = new JFrame();




    Notes() {
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setBackground(new Color(0Xffcccb));

        button6.setFocusable(false);
        button6.addActionListener(this);
        button6.setBackground(new Color(0Xee98fb));
        button6.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xff77a9)));

        button6.setSize(100, 100);
        button6.setFont(new Font("Agency FB", Font.BOLD, 15));

        button6.setFocusable(false);
        JLabel label = new JLabel("to Main Menu");


        frame.setSize(1000, 500);
        frame.setTitle("Notes");
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());
        frame.add(jPanel, BorderLayout.SOUTH);
        jPanel.add(button6);
        jPanel.add(label);


        //creating the table

        col = new String[]{" Notes "};

        DefaultTableModel table = new DefaultTableModel(col, 0);
        JTable jTable = new JTable(table);



        for (Consultation consultation : Consultation.consultationList) {


            Object[] rows = {consultation.getNotes()};
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
        if (e.getSource() == button6) {
            MainMenu gui = new MainMenu();
            frame.dispose();
        }
    }
}


