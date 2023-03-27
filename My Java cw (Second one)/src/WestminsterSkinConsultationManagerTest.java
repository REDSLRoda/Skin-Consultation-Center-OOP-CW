import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class WestminsterSkinConsultationManagerTest {



    @Test
    void AddDoctor() {
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("John","Snow","Specialist","MED01"));
        ArrayList<Doctor> test =new ArrayList<>();
        String intput ="John Snow Specialist MED01";
        InputStream in = new ByteArrayInputStream(intput.getBytes());
        System.setIn(in);

        WestminsterSkinConsultationManager.addDoctor(test);

        assertEquals(doctors.get(0).getDoctorname(),test.get(0).getDoctorname());
        assertEquals(doctors.get(0).getDoclname(),test.get(0).getDoclname());
        assertEquals(doctors.get(0).getSpecialization(),test.get(0).getSpecialization());
        assertEquals(doctors.get(0).getMedicalLicenceNumber(),test.get(0).getMedicalLicenceNumber());


    }
@Test
    void removeDoctor() {

        ArrayList<Doctor> doctorsList = new ArrayList<>();
        doctorsList.remove(new Doctor("John","Snow"));
        ArrayList<Doctor> testDoc2 = new ArrayList<>();
        String input2 = "John Snow" ;
        InputStream in = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in);
        WestminsterSkinConsultationManager.removeDoctor();
        assertEquals(doctorsList.get(0).getDoctorname(),testDoc2.get(0).getDoctorname());
        assertEquals(doctorsList.get(0).getDoclname(),testDoc2.get(0).getDoclname());


    }

    @Test
    void save() {

    }

    @Test
    void load() {
    }

    @Test
    void storeDetails() {
    }

    @Test
    void sortDetails() {
    }
}