import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Encryption {
    public static void main(String[] args)
            throws FileNotFoundException, IOException
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("Note : Encryption Key act as Password to Decrypt the same Image,otherwise it will corrupt the Image.");

        // Here key is act as password to Encrypt and
        // Decrypt the Image
        System.out.print("Enter key for Encryption : ");
        int key = sc.nextInt();

        // Selecting a Image for operation
        FileInputStream fis = new FileInputStream(
                "C:\\Users\\3C Tech\\Music\\OOP CW\\My Java cw (Second one)\\Skin-image.jpg");
        FileInputStream fis2 = new FileInputStream(
                "C:\\Users\\3C Tech\\Music\\OOP CW\\My Java cw (Second one)\\outputNote2.txt");

        // Converting Image into byte array, create a
        // array of same size as Image size

        byte[] data = new byte[fis.available()];

        // Read the array
        fis.read(data);
        int i = 0;

        // Performing an XOR operation on each value of
        // byte array due to which every value of Image
        // will change.
        for (byte b : data) {
            data[i] = (byte)(b ^ key);
            i++;
        }

        // Opening a file for writing purpose
        FileOutputStream fos = new FileOutputStream(
                "C:\\Users\\3C Tech\\Music\\OOP CW\\My Java cw (Second one)\\Skin-image.jpg");
        FileOutputStream fos2 = new FileOutputStream(
                "C:\\Users\\3C Tech\\Music\\OOP CW\\My Java cw (Second one)\\outputNote2.txt");


        // Writing new byte array value to image which
        // will Encrypt it.

        fos.write(data);

        // Closing file
        fos.close();
        fis.close();
        System.out.println("Encryption Done...");
    }
    public static void SaveNote() throws IOException {
        File file = new File("savedNoteData2.ser");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Consultation c : Consultation.consultationList) {
            objectOutputStream.writeObject(c);
        }

        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("Data Successfully Saved");
    }


    public static void LoadNote() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("savedNoteData2.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Consultation> c = new ArrayList<>();

        while (true) {
            try {
                Consultation note = (Consultation) objectInputStream.readObject();
                c.add(note);

            } catch (IOException | ClassNotFoundException e) {
                break;
            }
        }
        System.out.println(c);

    }
    public static void storeConsultDetails() {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("outputNote2.txt"));

            for (Consultation f1 : Consultation.consultationList) {
                bw.write("\nNotes" + f1.getNotes());

            }


            bw.close();
            System.out.println("File Created");
        } catch (Exception var3) {
        }
    }


}
//C:\Users\3C Tech\Music\My Java cw (Second one)\outputNote2.txt