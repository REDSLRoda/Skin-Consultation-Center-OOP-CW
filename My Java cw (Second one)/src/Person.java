
import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {
    private String name;//first name
    private String surname;//last name
    private String date; // date of birth


    public Person(String doctorname) {
    }

    public Person(int cabinNumber) {
    }

    public void setName(String pName) {
        this.name = pName;
    }

    public void setSurname(String pSurname) {
        this.surname = pSurname;
    }



    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDateOfBirth(String date) {
        this.date = date;
    }

    public String getDateOfBirth() {
        System.out.println("Enter Date of Birth");
        System.out.println("Date Format: " + "yyyy.mm.dd");
        System.out.println("");

        Scanner myScanner = new Scanner(System.in);
        String date = myScanner.next();

        this.setDate(date);
        System.out.println(this.getDate());


        return date;
    }
}

