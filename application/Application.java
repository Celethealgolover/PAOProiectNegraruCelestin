package application;

import analiza.*;
import dao.*;
import model.*;

import java.sql.SQLException;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        try {
            // Instantiere DAOs
            MedicDao medicDao = MedicDao.getInstance();
            AsistentDao asistentDao = AsistentDao.getInstance();
            FarmacistDao farmacistDao = FarmacistDao.getInstance();
            PacientDao pacientDao = PacientDao.getInstance();
            // Creare entitati
            Medic medic = new MedicGastroenterolog("Ion", "Popescu", "i.popE@gmail.com", "primar", "Gastroenterologie", 987654321, 10,5000);
            Asistent asistent = new Asistent(3000, "Ana", "Popa", "a.popa@gmail.com", 123456789);
            Asistent asistent2 = new Asistent(4000, "Maria", "Popa", "m.popa@gmail.com", 123465789);
            Farmacist farmacist = new Farmacist(4000, "Maria", "Ionescu", "m.ionescu@gmail.com", 987654321, 15);
            Pacient pacient1 = new Pacient("Andrei", "Vasile", 1234);
            // Operatii CRUD pentru Medic
            medicDao.create(medic);
            System.out.println("Citire medic: " + medicDao.read("Ion"));
            medic.setEmail("I.pope@gmail.com");
            medicDao.update(medic);
            System.out.println("Medicul actualizat: " + medicDao.read("Ion"));
            // Operatii CRUD pentru Asistent
            asistentDao.create(asistent);
            System.out.println("Citire asistent: " + asistentDao.read("Ana"));
            asistent.setNr_telefon(1122334455);
            asistentDao.update(asistent);
            System.out.println("Asistentul actualizat: " + asistentDao.read("Ana"));
            // Operatii CRUD pentru Farmacist
            farmacistDao.create(farmacist);
            System.out.println("Citire farmacist: " + farmacistDao.read("Maria"));
            farmacist.setEmail("m.popa@gmail.com");
            farmacistDao.update(farmacist);
            System.out.println("Farmacistul actualizat: " + farmacistDao.read("Maria"));
            // Operatii CRUD pentru Pacient
            pacientDao.create(pacient1);
            System.out.println("Citire pacient: " + pacientDao.read("Andrei"));
            pacient1.setPrenume("Vasilescu");
            pacientDao.update(pacient1);
            System.out.println("Pacientul actualizat: " + pacientDao.read("Andrei"));
            medic.adaugaAsistent(asistent2);
            List<Asistent> la=medic.getLisaAsistenti();
            // Gestionarea retetelor
            AnalizaReteta analiza = new AnalizaRetetaPsihoactive();
            System.out.println(analiza.validareReteta("Pacientul Andrei cu CNP-ul 1960515123456 primeste tratament cu benzodiazepine"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
