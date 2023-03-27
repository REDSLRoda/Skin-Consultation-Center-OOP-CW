

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Availability availability = new Availability();

        do {//Displaying the Console menu

            System.out.println(" ");
            System.out.println("        Welcome to the Consultation ");
            System.out.println("                     Menu                  ");
            System.out.println("Choose from the following numbers/letters: ");
            System.out.println(" ");
            System.out.println("1: Add a new doctor");
            System.out.println("2: Delete a Doctor");
            System.out.println("3: Print the list of the doctors in oder");
            System.out.println("4: Detailed Doctor Table");
            System.out.println("5: Save to a File");
            System.out.println("6: Load data from File");
            System.out.println("7: New Consultation");
            System.out.println("8: Save and Load New Consultation");


            System.out.println("9: Open GUI");
            System.out.println("10: Availability of doctors");


            System.out.println(" ");

            Scanner input = new Scanner(System.in);
            String press = input.next();


            switch (press) {
                case "1":

                    ArrayList<Doctor> test = new ArrayList<>();
                    WestminsterSkinConsultationManager.addDoctor(test);
                    break;

                case "2":
                    WestminsterSkinConsultationManager.removeDoctor();
                    break;
                case "3":
                    WestminsterSkinConsultationManager.sort();
                    break;
                case "4":
                    WestminsterSkinConsultationManager.sortDetails();


                    break;
                case "5":
                    WestminsterSkinConsultationManager.storeDetails();
                    try {
                        WestminsterSkinConsultationManager.Save();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "6":
                    try {
                        WestminsterSkinConsultationManager.Load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "7":
                    Consultation.Consultation2();

                    break;

                case "8":
                    Consultation.SaveConsult();
                    Consultation.LoadConsult();
                    Consultation.storeConsultDetails();
                    break;


                case "9":
                    MainMenu p1 = new MainMenu();
                    break;

                case "10":
                    AltGUI p2 = new AltGUI();
                    System.out.println("V: View all Doctors");
                    System.out.println("A:Adds customer to Doctors");
                    System.out.println("-------------------- Additional options --------------- ");
                    System.out.println("E: Display available doctors");
                    System.out.println("T: Total expenses of appointment ");
                    System.out.println(" Q: Exit the Program");

                    System.out.println(" ");
                    System.out.print("Enter letter of your choice:  ");
                    System.out.println(" ");

                    String press2 = input.next();

                    switch (press2) {
                        case "V":  //to check the current status
                            availability.displayAllDoctors();
                            break;


                        case "E": //viewing all empty
                            availability.displayAvailableDoctors();
                            break;


                        case "A":
                            //adding a passenger

                            System.out.println(" Types ");
                            System.out.println("Type 1 for doctor 1");
                            System.out.println("Type 2 for doctor2");
                            System.out.println("Type 3 for doctor 3");
                            System.out.println("Type 4 for doctor 4");
                            System.out.println("Type 5 for doctor 5");
                            System.out.println("Type 6 for doctor 6");
                            System.out.println("Type 7 for doctor 7");
                            System.out.println("Type 8 for doctor 8");
                            System.out.println("Type 9 for doctor 9");
                            System.out.println("Type 10 for doctor 10");
                            System.out.println("Type 11 for doctor 11");
                            System.out.println("Type 12 for doctor 12");
                            System.out.println("You can only add 1 person to single doctor");

                            System.out.print("Enter the Number:  ");
                            System.out.println(" ");
                            int number = input.nextInt();

                            switch (number) {
                                case 1:
                                    if (availability.currentDoctorStatusAL.get(0) == null) {

                                        System.out.println("You are assigned to doctor 1");

                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();
                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }






                                    } else {
                                        System.out.println("Doctor 1 is Currently Full");
                                        System.out.println("You will be moved to next available doctor");


                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();
                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }


                                        System.out.println("You are now moved to doctor no 2 ");
                                        System.out.println("Patient name: " + availability.currentDoctorStatusAL.get(1));
                                    }

                                    break;

                                case 2:
                                    if (availability.currentDoctorStatusAL.get(1) == null) {

                                        System.out.println("You are assigned to doctor 2");
                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }


                                    } else {
                                        System.out.println("doctor 2 is Currently Full");
                                        System.out.println("You will be moved to next available doctor");

                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }



                                        System.out.println("You are now moved to doctor no 3");
                                        System.out.println("Patient name: " + availability.currentDoctorStatusAL.get(2));
                                    }

                                    break;

                                case 3:
                                    if (availability.currentDoctorStatusAL.get(2) == null) {

                                        System.out.println("You are assigned to doctor 3");
                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }


                                    } else {
                                        System.out.println("doctor 3 is Currently Full");
                                        System.out.println("You will be moved to next available doctor");

                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }


                                        System.out.println("You are now moved to doctor no 4");
                                        System.out.println("Patient name: " + availability.currentDoctorStatusAL.get(3));
                                    }

                                    break;

                                case 4:
                                    if (availability.currentDoctorStatusAL.get(3) == null) {

                                        System.out.println("You are assigned to cabin 4");
                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }


                                    } else {
                                        System.out.println("Cabin 4 is Currently Full");
                                        System.out.println("You will be moved to next available doctor");

                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }


                                        System.out.println("You are now moved to doctor no 5");
                                        System.out.println("Patient name: " + availability.currentDoctorStatusAL.get(4));
                                    }

                                    break;

                                case 5:
                                    if (availability.currentDoctorStatusAL.get(4) == null) {

                                        System.out.println("You are assigned to cabin 5");
                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }


                                    } else {
                                        System.out.println("Cabin 5 is Currently Full");
                                        System.out.println("You will be moved to next available doctor");

                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }


                                        System.out.println("You are now moved to  doctor no 6");
                                        System.out.println("Patient name: " + availability.currentDoctorStatusAL.get(5));
                                    }

                                    break;

                                case 6:
                                    if (availability.currentDoctorStatusAL.get(5) == null) {

                                        System.out.println("You are assigned to cabin 6");
                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();
                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }


                                    } else {
                                        System.out.println("Cabin 6 is Currently Full");
                                        System.out.println("You will be moved to next available doctor");

                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }


                                        System.out.println("You are now moved to doctor no 7");
                                        System.out.println("Patient name: " + availability.currentDoctorStatusAL.get(6));
                                    }

                                    break;

                                case 7:
                                    if (availability.currentDoctorStatusAL.get(6) == null) {
                                        System.out.println("You are assigned to cabin 7");

                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }


                                    } else {
                                        System.out.println("Cabin 7 is Currently Full");
                                        System.out.println("You will be moved to next available doctor");

                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }

                                        System.out.println("You are now moved to doctor no 8");
                                        System.out.println("Patient name: " + availability.currentDoctorStatusAL.get(7));
                                    }

                                    break;

                                case 8:
                                    if (availability.currentDoctorStatusAL.get(7) == null) {

                                        System.out.println("You are assigned to cabin 8");
                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }



                                    } else {
                                        System.out.println("Cabin 8 is Currently Full");
                                        System.out.println("You will be moved to next available doctor");

                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }



                                        System.out.println("You are now moved to doctor no 9");
                                        System.out.println("Patient name: " + availability.currentDoctorStatusAL.get(8));
                                    }

                                    break;

                                case 9:
                                    if (availability.currentDoctorStatusAL.get(8) == null) {

                                        System.out.println("You are assigned to cabin 9");
                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }

                                    } else {
                                        System.out.println("Cabin 9 is Currently Full");
                                        System.out.println("You will be moved to next available doctor");

                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }


                                        System.out.println("You are now moved to doctor no 10");
                                        System.out.println("Patient name: " + availability.currentDoctorStatusAL.get(9));
                                    }

                                    break;

                                case 10:
                                    if (availability.currentDoctorStatusAL.get(9) == null) {

                                        System.out.println("You are assigned to doctor no 10");
                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }


                                    } else {
                                        System.out.println("Doctor 10 is Currently Full");
                                        System.out.println("You will be moved to next available doctor");

                                        System.out.println("Enter First Name: ");
                                        String firstName = input.next();

                                        System.out.println("Enter Last Name: ");

                                        String lastName = input.next();

                                        System.out.println("IF this is Your First appointment press 1 ");
                                        System.out.println("IF this is Not Your First appointment press 2 ");


                                        int expenses = input.nextInt();

                                        availability.addPassenger(0, firstName);
                                        availability.addPassenger01Details(firstName, lastName, expenses);

                                        switch (expenses) {
                                            case 1 -> {
                                                int expenses1 = 15;
                                                System.out.println("Cost For Appointment: " + expenses1);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour first time: " + expenses1);


                                                        }

                                                    }


                                                }
                                            }
                                            case 2 -> {
                                                int expenses2 = 25;
                                                System.out.println("Cost For Appointment: " + expenses2);
                                                for (int i = 0; i < Availability.patientList.length; i++) {
                                                    for (Patient patient : Availability.patientList) {
                                                        String name = patient.getPatientname();
                                                        String sname = patient.getPatientlname();

                                                        if (patient.getPatientname().equalsIgnoreCase(name) && patient.getPatientlname().equalsIgnoreCase(sname)) {
                                                            System.out.println("Patient no :" + (1 + i) + " Patient first Name: " + name + "  cost per hour not first time: " + expenses2);


                                                        }

                                                    }


                                                }
                                            }
                                        }

                                        System.out.println("You are now moved to doctor");
                                        System.out.println("Patient name: " + availability.currentDoctorStatusAL.get(10));
                                    }

                                    break;


                            }

                            break;


                        case "T":
                            availability.viewAdditionalDetails();


                            break;

                        case "O":
                            availability.sortPassengers();


                            break;


                        case "Q":
                            System.out.println("Thank You for visiting our Skincare center");

                            return;
                        default:
                            System.out.println("You have entered a Wrong Value");
                    }
                    break;


            }
        } while (true);
    }
}












