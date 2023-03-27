import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    //arrayList that carries all the doctor objects
    public static ArrayList<Doctor> doctorsList = new ArrayList<Doctor>();


    private static int totalDoctors;

    public WestminsterSkinConsultationManager() {
    }


    public static void sort() {
        LinkedList<Doctor> doctorsInOrderLinkedList = new LinkedList<>(doctorsList);
        if (doctorsInOrderLinkedList.size() == 0) {
            System.err.println("********************   There are no Doctors Added   ********************");
        } else {
            if (!(doctorsInOrderLinkedList.size() == 1)) {

                for (int j = 0; j < (doctorsInOrderLinkedList.size()); j++) {
                    String nammeI = doctorsInOrderLinkedList.get(j).getDoctorname();
                    int i = 1;
                    String nammeJ = doctorsInOrderLinkedList.get(i).getDoctorname();
                    if (nammeJ.compareTo(nammeI) < 0) {

                        Collections.swap(doctorsInOrderLinkedList, i, j);
                        for (j = 1; j < (doctorsInOrderLinkedList.size()); j++) {

                            nammeJ = doctorsInOrderLinkedList.get(j).getDoctorname();
                            if (nammeJ.compareTo(nammeI) < 1) {

                                Collections.swap(doctorsInOrderLinkedList, j, i);



                            }


                        }
                        break;
                    }


                }
                for (Doctor temp : doctorsInOrderLinkedList)
                    System.out.println("" + temp.getDoctorname());
            }
        }
    }

    /**this function for adding new doctor to doctors list
     *
     */
    public static void addDoctor(ArrayList<Doctor> test) {

        Scanner input = new Scanner(System.in);
        System.out.println("Add Doctor's Name: \n");
        System.out.println("(Please enter the initials of first name)");
        String doctorname = input.next();

        System.out.println("Add Doctor Surname: ");
        String doclname = input.next();

        System.out.println("Add Doctor's Specialization: ");
        String specialization = input.next();

        System.out.println("Add Doctor's Medical Licence Number(Example-MED01): ");
        String medicalLicenceNumber = input.next();


        Doctor f1 = new Doctor(doctorname,doclname,specialization,medicalLicenceNumber);
         f1.setDoctorname(doctorname);
         f1.setDoclname(doclname);
         f1.setSpecialization(specialization);
         f1.setMedicalLicenceNumber(medicalLicenceNumber);

        doctorsList.add(f1);
        totalDoctors++;

        System.out.println("Selected Doctor Details:\n" +
                "name " + f1.getDoctorname() + "   surname " +f1.getDoclname() +
                "\nspecialization: " + f1.getSpecialization() + "\nmedical Licence Number: " + f1.getMedicalLicenceNumber());
    }

    public static void removeDoctor() {
        Scanner input = new Scanner(System.in);
        System.out.println("Add Doctor's First Name: ");
        String d4Name = input.next();
        System.out.println("Add Last Name: ");
        String d5Name = input.next();
        totalDoctors--;
        Doctor f2 = new Doctor(d4Name,d5Name);
        f2.setDoctorname(d4Name);
        f2.setDoclname(d5Name);
        doctorsList.removeIf(doctor -> doctor.getDoctorname().equalsIgnoreCase(d4Name)&& doctor.getDoclname().equalsIgnoreCase(d5Name));
        System.out.println("Selected Doctor " + d4Name+" "+ d5Name +" has been Removed");
    }


    public static void Save() throws IOException {
        File file = new File("savedData.ser");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Doctor doctor : doctorsList) {
            objectOutputStream.writeObject(doctor);
        }
        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("Data Successfully Saved");
    }

    public static void Load() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("savedData.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Doctor> doc = new ArrayList<>();
        while (true) {
            try {
                Doctor doctor = (Doctor) objectInputStream.readObject();
                doc.add(doctor);
            } catch (IOException | ClassNotFoundException e) {
                break;
            }
        }
        System.out.println(doc);
    }




    public static void storeDetails() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output2.txt"));

            for (Doctor f1 : doctorsList) {
                bw.write("\nDoctor's Name " + f1.getDoctorname());

            }


            bw.close();
            System.out.println("File Created");
        } catch (Exception var3) {
        }
    }

    public static void sortDetails() {

        LinkedList<Doctor> doctorsInOrderLinkedList = new LinkedList<>(doctorsList);
        String leftAlignFormat = "|      %-11s |      %-11s |      %-11s |     %-11s |%n";


        System.out.format("|==================|===================|==================|==================|%n");
        System.out.format("|       Name       |      Surname      |  Specialization  |   Licence        |%n");
        System.out.format("|==================|===================|==================|==================|%n");
        Iterator var7 = doctorsInOrderLinkedList.iterator();

        while(var7.hasNext()){
            Doctor doctorTable = (Doctor)var7.next();
            System.out.format(leftAlignFormat, doctorTable.getDoctorname(),doctorTable.getDoclname(), doctorTable.getSpecialization(), doctorTable.getMedicalLicenceNumber());

        }

        //displaying the last updated date

    }


    /*public static void Doctors() {



        if (totalDoctors == 0) {
            System.err.println("********************   There are no Doctors Added   ********************");
        } else {
            if (!(totalDoctors == 1)) {
                System.out.println(doctorsList);

            }
        }
    }*/

    /*public static void sort() {
        LinkedList<Doctor> doctorsInOrderLinkedList = new LinkedList<>(doctorsList);
        if (doctorsInOrderLinkedList.size() != 1) {
            int i;
            for(i = 0 ; (doctorsInOrderLinkedList.get(i)).getDoctorname() != (doctorsInOrderLinkedList.get(i + 1)).getDoctorname(); ++i) {
            }


            Collections.swap(doctorsInOrderLinkedList, i, i + 1);
        }

        Iterator var8 = doctorsInOrderLinkedList.iterator();
        while (var8.hasNext()) {
            Doctor doctor = (Doctor) var8.next();
            System.out.format("Display doctor names in order " + doctor.getDoctorname());
        }
    }*/



}






















/* References
https://stackoverflow.com/questions/5367916/cant-serialize-an-arraylist
https://stackoverflow.com/questions/17293991/how-to-write-and-read-java-serialized-objects-into-a-file
https://mkyong.com/java/how-to-read-and-write-java-object-to-a-file/
https://www.geeksforgeeks.org/serialization-in-java/
https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
https://www.baeldung.com/java-comparator-comparable
https://www.javatpoint.com/java-swing



 */


