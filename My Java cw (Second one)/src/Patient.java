

public class Patient extends Person{
    private int id; //Patients national id number

    private  String patientname; //Patient first name
    private String patientlname; //patient last name
    private int mobilenumber; //patients mobile number
    private String date; // date of birth
    public Patient(String patientname, String patientlname, int id,int mobilenumber,String date) { //constructor built for add patient details in Consultation class.
        super(patientname);

        this.patientlname = patientlname;
        this.id=id; //Patients national id number
        this.mobilenumber= mobilenumber;
        this.date= date;
    }

    public Patient(String patientname, String patientlname, int expenses) {
        super(patientname);
        this.patientlname = patientlname;

        Expenses = expenses;// this is used to determine if the patients first visit or not , if its first visit then cost is $15
    }


    int Expenses;


// all the get set method that are needed for the patient class.

    public int getExpenses() {
        return Expenses;
    }

    public void setExpenses(int expenses) {
        Expenses = expenses;
    }




    public void setPatientid(int patientid){
        this.id = patientid;
    } //get,set method for patient id
    public int getPatientid(){
        return id;
    }
    public void setPatientmobile(int mobilenumber){
        this.mobilenumber = mobilenumber;
    }
    public int getPatientmobile(){
        return mobilenumber;
    }//get,set method for mobile number
    public void setPatientname(String patientname){
        this.patientname= patientname;
    }
    public  String getPatientname(){
        return patientname;
    }//get,set method for first name of patient

    public void setPatientlname(String patientlname){
        this.patientlname= patientlname;
    }
    public  String getPatientlname(){
        return this.patientlname;
    }//get,set method for last name of patient
    public void setDateOfBirth(String date) {
        this.date = date;
    }

    public String getDateOfBirth() {
        return this.date;
    }//get,set method for date of birth
}
