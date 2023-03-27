



import java.util.*;
import java.util.List;


public class  Availability   {

    Doctor[] doctorsList;

    String[] currentDoctorStatus = new String[10];
    List<String> currentDoctorStatusAL = new ArrayList<>(Arrays.asList(currentDoctorStatus));
    static Patient[] patientList;



    ArrayList<String> customers = new ArrayList<>();


    public Availability() {
        this.doctorsList = new Doctor[10];
        this.patientList = new Patient[1];

        initialize(this.doctorsList);
        initialize2(this.patientList);

    }


    private void initialize(Doctor[] doctorsavlb) {
        for (int i = 0; i < doctorsavlb.length; i++) {
            doctorsavlb[i] = new Doctor(i);
        }


    }

    private void initialize2(Patient[] patients) {
        for (int i = 0; i < patients.length; i++) {
            String patientname = "-";
            String patientlname = " ";
            int expenses = 0;
            patients[i] = new Patient(patientname, patientlname ,expenses);

        }

    }


    public void addPassenger01Details(String patientname, String patientlname, int expenses) {
        for (Patient patient : patientList) {
            patient.setPatientname(patientname);
            patient.setPatientlname(patientlname);
            patient.setExpenses(expenses);
        }

    }


    public void viewAdditionalDetails() {

        for (Patient patient : patientList) {


            System.out.println("First Name: " + patient.getPatientname());
            System.out.println("Last Name: " + patient.getPatientlname());
            System.out.println("Expenses: " + patient.getExpenses());

            break;

        }


        System.out.println("Total Expenses for doctor are:  ");
        for (Patient patient : patientList)

            System.out.println(patient.getExpenses());

    }


    public void displayAllDoctors() {

        for (Doctor cabin : doctorsList) {


            System.out.println("Doctor Number " + cabin.getDoctorNumber());
            System.out.println("Empty : " + cabin.isEmpty());
            System.out.println(" ");


        }
        for (int i = 0; i < currentDoctorStatus.length; i++) {
            if (currentDoctorStatusAL.get(i) == null) {


            } else {
                System.out.println("Patient in Doctor " + ": " + currentDoctorStatusAL.get(i));
            }

        }
    }

    public void displayAvailableDoctors() {
        System.out.println("--------Available Doctors--------");


        for (Doctor cabin : doctorsList) {
            if (cabin.isEmpty()) {

                System.out.println("Doctor Number " + cabin.getDoctorNumber());
            }

        }

    }

    public void addPassenger(int doctorNumber, String customerName) {
        doctorsList[doctorNumber].setEmpty(false);

        customers.add(customerName);


        currentDoctorStatusAL.add(doctorNumber, customerName);


    }




    public void sortPassengers() {
        Collections.sort(customers);
        System.out.println(customers);
    }






    }

