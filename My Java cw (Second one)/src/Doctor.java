import java.io.Serializable;


public class Doctor extends Person implements Serializable {

// all the variables include for doctor class.

    private  String doctorname; // Doctors first name

    private String doclname;// Doctors last name
    private  String specialization;// Doctors specialization

    private String medicalLicenceNumber;// Doctors licence number
    private  int totalDoctors;// total number of Doctors, max number is 10.
    private int totalPatients;
    public Doctor(String doctorname,String doclname, String specialization, String medicalLicenceNumber) {//constructor built for add doctor details in WestminsterSkinConsultationManager class.

        super(doctorname);
        this.doclname = doclname;
        this.specialization = specialization;
        this.medicalLicenceNumber=medicalLicenceNumber;
    }


    private boolean empty;
    private int doctorNumber; //Doctors number to identify the order, (this is not the licence number)

    public Doctor(int cabinNumber) {
        super(cabinNumber);
        this.doctorNumber = cabinNumber;//cabin number and doctor number is same (doctor is in cabin).
        this.empty = true;
    }

    public Doctor(String d4Name, String d5Name) {//this used in the doctor remove method
        super(d4Name);
        this.doclname=d5Name;
    }


//get, set methods used for doctor class.

    public int getDoctorNumber() {
        return doctorNumber + 1;
    }

    public void setDoctorNumber(int doctorNumber) {
        this.doctorNumber = doctorNumber;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }



    public Doctor(String doctorname) {
        super(doctorname);
    }




    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public void setDoclname(String doclname) {
        this.doclname = doclname;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setMedicalLicenceNumber(String medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    public  String getDoctorname() {
        return doctorname;
    }

    public  String getDoclname() {
        return doclname;
    }

    public  String getSpecialization() {
        return specialization;
    }

    public  String getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    public int getTotalDoctors() {
        return totalDoctors;
    }

    public void setTotalDoctors(int totalDoctors) {
        this.totalDoctors = totalDoctors;
    }


    }












