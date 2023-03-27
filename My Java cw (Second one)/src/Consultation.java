import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Scanner;

public class Consultation implements ActionListener {
    public static ArrayList<Doctor> doctorsList = new ArrayList<>();
    public static ArrayList<Patient> patientList = new ArrayList<>();
    public static ArrayList<Consultation> consultationList = new ArrayList<>();
    static ArrayList<String> datetimes = new ArrayList<>();
    private  String note;
    private static String datetime;

    private  int cost;


    public Consultation(String notes, int costs) {
    }

    public static String getDatetime() {
        return datetime;
    }

    public static void setDatetime(String datetime) {
        Consultation.datetime = datetime;
    }

    public  String getNotes() {
        return note;
    }

    public  int getCosts() {
        return cost;
    }

    public void setNotes(String notes) {
        this.note = notes;
    }

    public void setCosts(int costs) {
        this.cost = costs;
    }

    public static void Consultation2() {
        System.out.println("Welcome to the Consultation");
        System.out.println("Please enter Doctor name for Consultation");


//for doctor class
        Scanner input = new Scanner(System.in);
        System.out.println("Add doctor name: ");
        String doctorname = input.next();


        //for patient class
        System.out.println("Add patient first name: ");
        String patientname = input.next();

        System.out.println("Add Patient surname: ");
        String patientlname = input.next();

        System.out.println("Add notes: ");
        String notes = input.next();


        int costs;
        while (true) {
            Scanner input3 = new Scanner(System.in);
            try {
                System.out.println("Cost of Consultation: ");
                costs = input3.nextInt();
                break;
            } catch (Exception var10) {
                System.err.println("Invalid input. Please add an integer");
            }
        }
        int id;
        while (true) {
            Scanner input4 = new Scanner(System.in);
            try {
                System.out.println("Patient id: ");
                id = input4.nextInt();
                break;
            } catch (Exception var10) {
                System.err.println("Invalid input. Please add an integer");
            }
        }
        int mobilenumber;
        while (true) {
            Scanner input4 = new Scanner(System.in);
            try {
                System.out.println("Patient mobile number: ");
                mobilenumber = input4.nextInt();
                break;
            } catch (Exception var10) {
                System.err.println("Invalid input. Please add an integer");
            }
        }
        System.out.println("Enter Date of Birth");
        System.out.println("Date Format: " + "yyyy.mm.dd");
        System.out.println("");
        String date = input.next();

        Consultation f4 = new Consultation(notes, costs);
        f4.setCosts(costs);
        f4.setNotes(notes);

        Doctor f2 = new Doctor(doctorname);
        f2.setDoctorname(doctorname);

        Patient f3 = new Patient(patientname,patientlname, id, mobilenumber,date);
        f3.setPatientname(patientname);
        f3.setPatientlname(patientlname);
        f3.setPatientid(id);
        f3.setPatientmobile(mobilenumber);
        f3.setDateOfBirth(date);
        doctorsList.add(f2);
        patientList.add(f3);
        consultationList.add(f4);


        System.out.println("Patient: " + f3.getPatientname() +" " + f3.getPatientlname() + " has been allocated to Dr." + f2.getDoctorname());
        System.out.println("Patient id: " + f3.getPatientid());
        System.out.println("Additional Notes: " + f4.getNotes());
        System.out.println("Cost for Consultation: " + f4.getCosts());
        System.out.println("Enter the Date and Time of appointment (Please enter date format yyyy.mm.dd) ");
        Scanner myScanner = new Scanner(System.in);
        String datetime = myScanner.next();
        setDatetime(datetime);
        datetimes.add(datetime);
        Collections.sort(datetimes);
        System.out.println("Your date of appointment is: " + Consultation.getDatetime());

    }

    public static void SaveConsult() throws IOException {
        File file = new File("savedConsultData2.ser");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Doctor doctor : doctorsList) {
            objectOutputStream.writeObject(doctor);
        }
        for (Patient patient : patientList) {
            objectOutputStream.writeObject(patient);
        }
        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("Data Successfully Saved");
    }


    public static void LoadConsult() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("savedConsultData2.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Doctor> doc = new ArrayList<>();
        ArrayList<Patient> pat = new ArrayList<>();
        while (true) {
            try {
                Doctor doctor = (Doctor) objectInputStream.readObject();
                doc.add(doctor);
                Patient patient = (Patient) objectInputStream.readObject();
                pat.add(patient);
            } catch (IOException | ClassNotFoundException e) {
                break;
            }
        }
        System.out.println(doc);
        System.out.println(pat);
    }

    public static void storeConsultDetails() {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("outputConsult2.txt"));

            for (Doctor f1 : doctorsList) {
                bw.write("\nDoctor's Name " + f1.getDoctorname());

            }
            for (Patient f1 : patientList) {
                bw.write("\nPatent's Name " + f1.getPatientname());

            }


            bw.close();
            System.out.println("File Created");
        } catch (Exception var3) {
        }
    }


    static JPanel jPanel;
    static String[] col;
    JButton button3 = new JButton("Back");

    JFrame frame = new JFrame();

    Consultation() {
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setBackground(new Color(0Xffcccb));

        button3.setFocusable(false);
        button3.addActionListener(this);
        button3.setBackground(new Color(0Xee98fb));
        button3.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xff77a9)));

        button3.setSize(100, 100);
        button3.setFont(new Font("Agency FB", Font.BOLD, 15));

        button3.setFocusable(false);

        JLabel label = new JLabel("to Main Menu");


        frame.setSize(1000, 500);
        frame.setTitle("Doctor List");
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());
        frame.add(jPanel, BorderLayout.SOUTH);
        jPanel.add(button3);
        jPanel.add(label);
        //creating the table

        col = new String[]{"Doctor Name", "Patient Name", "Patient id", "Notes ", "Costs", "Date"};

        DefaultTableModel table = new DefaultTableModel(col, 0);
        JTable jTable = new JTable(table);

        for (Doctor doctor: Consultation.doctorsList) {
            for (Patient patient : Consultation.patientList) {
                for (Consultation consultation : Consultation.consultationList) {



                        Object[] rows = {doctor.getDoctorname(), patient.getPatientname(), patient.getPatientid(), consultation.getNotes(), consultation.getCosts(),datetimes};
                        table.addRow(rows);

                    }
                }
            }


        jTable.setFont(new Font("Arial", Font.PLAIN, 16));
        JTableHeader jTableHeader = jTable.getTableHeader();
        JScrollPane scrollPane = new JScrollPane(jTable);
        frame.add(scrollPane);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button3) {
            MainMenu gui = new MainMenu();
            frame.dispose();

        }
    }
}


