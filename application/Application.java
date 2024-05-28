package application;

import analiza.*;
import dao.*;
import model.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            MedicDao medicDao = MedicDao.getInstance();
            AsistentDao asistentDao = AsistentDao.getInstance();
            FarmacistDao farmacistDao = FarmacistDao.getInstance();
            PacientDao pacientDao = PacientDao.getInstance();
            while (true) {
                System.out.println("==== Meniu Principal ====");
                System.out.println("1. Gestionare Medici");
                System.out.println("2. Gestionare Asistenti");
                System.out.println("3. Gestionare Farmacisti");
                System.out.println("4. Gestionare Pacienti");
                System.out.println("5. Validare Reteta");
                System.out.println("0. Iesire");
                System.out.print("Selectati optiunea: ");
                int optiune = scanner.nextInt();
                scanner.nextLine();
                switch (optiune) {
                    case 1:
                        gestionareMedici(scanner, medicDao);
                        break;
                    case 2:
                        gestionareAsistenti(scanner, asistentDao);
                        break;
                    case 3:
                        gestionareFarmacisti(scanner, farmacistDao);
                        break;
                    case 4:
                        gestionarePacienti(scanner, pacientDao);
                        break;
                    case 5:
                        validareReteta(scanner);
                        break;
                    case 0:
                        System.out.println("La revedere!");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Optiune invalida. Incercati din nou.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Eroare la initializarea DAO-urilor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void gestionareMedici(Scanner scanner, MedicDao medicDao) {
        try {
            System.out.println("=== Gestionare Medici ===");
            System.out.println("1. Creare Medic");
            System.out.println("2. Citire Medic");
            System.out.println("3. Actualizare Medic");
            System.out.println("4. Stergere Medic");
            System.out.print("Selectati optiunea: ");

            int optiune = scanner.nextInt();
            scanner.nextLine();
            switch (optiune) {
                case 1:
                    System.out.print("Introduceti numele: ");
                    String nume = scanner.nextLine();
                    System.out.print("Introduceti prenumele: ");
                    String prenume = scanner.nextLine();
                    System.out.print("Introduceti email-ul: ");
                    String email = scanner.nextLine();
                    System.out.print("Introduceti gradul: ");
                    String grad = scanner.nextLine();
                    System.out.print("Introduceti specializare: ");
                    String specializare = scanner.nextLine();
                    System.out.print("Introduceti telefonul: ");
                    int telefon = scanner.nextInt();
                    System.out.print("Introduceti vechimea: ");
                    int vechime = scanner.nextInt();
                    System.out.print("Introduceti salariul: ");
                    int salariu = scanner.nextInt();
                    scanner.nextLine();
                    Medic medic = new MedicGastroenterolog(nume, prenume, email, grad, specializare, telefon, vechime, salariu);
                    medicDao.create(medic);
                    System.out.println("Medic creat cu succes!");
                    break;
                case 2:
                    System.out.print("Introduceti numele medicului pentru citire: ");
                    String numeCitire = scanner.nextLine();
                    Medic medicCitit = medicDao.read(numeCitire);
                    if(medicCitit!=null)
                    {System.out.println("Detalii medic: " + medicCitit);}
                    else{
                        System.out.println("Medicul nu a fost gasit!");
                    }
                    break;
                case 3:
                    System.out.print("Introduceti numele medicului pentru actualizare: ");
                    String numeActualizare = scanner.nextLine();
                    Medic medicActualizare = medicDao.read(numeActualizare);
                    if (medicActualizare != null) {
                        System.out.print("Introduceti noul email: ");
                        medicActualizare.setEmail(scanner.nextLine());
                        medicDao.update(medicActualizare);
                        System.out.println("Medic actualizat cu succes!");
                    } else {
                        System.out.println("Medicul nu a fost gasit!");
                    }
                    break;
                case 4:
                    System.out.print("Introduceti numele medicului pentru stergere: ");
                    String numeStergere = scanner.nextLine();
                    Medic medicStergere=medicDao.read(numeStergere);
                    if(medicStergere!=null) {
                        medicDao.delete(medicStergere);
                        System.out.println("Medic sters cu succes!");
                    }
                    else{
                        System.out.println("Medicul nu a fost gasit!");
                    }
                    break;
                default:
                    System.out.println("Optiune invalida.");
            }
        } catch (SQLException e) {
            System.err.println("Eroare la gestionarea medicilor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void gestionareAsistenti(Scanner scanner, AsistentDao asistentDao) {
        try {
            System.out.println("=== Gestionare Asistenti ===");
            System.out.println("1. Creare Asistent");
            System.out.println("2. Citire Asistent");
            System.out.println("3. Actualizare Asistent");
            System.out.println("4. Stergere Asistent");
            System.out.print("Selectati optiunea: ");

            int optiune = scanner.nextInt();
            scanner.nextLine();
            switch (optiune) {
                case 1:
                    System.out.print("Introduceti salariul: ");
                    int salariu = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Introduceti numele: ");
                    String nume = scanner.nextLine();
                    System.out.print("Introduceti prenumele: ");
                    String prenume = scanner.nextLine();
                    System.out.print("Introduceti email-ul: ");
                    String email = scanner.nextLine();
                    System.out.print("Introduceti telefonul: ");
                    int telefon = scanner.nextInt();
                    scanner.nextLine();
                    Asistent asistent = new Asistent(salariu, nume, prenume, email, telefon);
                    asistentDao.create(asistent);
                    System.out.println("Asistent creat cu succes!");
                    break;
                case 2:
                    System.out.print("Introduceti numele asistentului pentru citire: ");
                    String numeCitire = scanner.nextLine();
                    Asistent asistentCitit = asistentDao.read(numeCitire);
                    if(asistentCitit!=null)
                    {System.out.println("Detalii asistent: " + asistentCitit);}
                    else{
                        System.out.println("Asistentul nu a fost gasit!");
                    }
                    break;
                case 3:
                    System.out.print("Introduceti numele asistentului pentru actualizare: ");
                    String numeActualizare = scanner.nextLine();
                    Asistent asistentActualizare = asistentDao.read(numeActualizare);
                    if (asistentActualizare != null) {
                        System.out.print("Introduceti noul telefon: ");
                        asistentActualizare.setNr_telefon(scanner.nextInt());
                        scanner.nextLine();
                        asistentDao.update(asistentActualizare);
                        System.out.println("Asistent actualizat cu succes!");
                    } else {
                        System.out.println("Asistentul nu a fost gasit!");
                    }
                    break;
                case 4:
                    System.out.print("Introduceti numele asistentului pentru stergere: ");
                    String numeStergere = scanner.nextLine();
                    Asistent asistentStergere=asistentDao.read(numeStergere);
                    if(asistentStergere!=null) {
                        asistentDao.delete(asistentStergere);
                        System.out.println("Asistent sters cu succes!");
                    }
                    else{
                        System.out.println("Asistentul nu a fost gasit!");
                    }
                    break;
                default:
                    System.out.println("Optiune invalida.");
            }
        } catch (SQLException e) {
            System.err.println("Eroare la gestionarea asistentilor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void gestionareFarmacisti(Scanner scanner, FarmacistDao farmacistDao) {
        try {
            System.out.println("=== Gestionare Farmacisti ===");
            System.out.println("1. Creare Farmacist");
            System.out.println("2. Citire Farmacist");
            System.out.println("3. Actualizare Farmacist");
            System.out.println("4. Stergere Farmacist");
            System.out.print("Selectati optiunea: ");

            int optiune = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (optiune) {
                case 1:
                    System.out.print("Introduceti salariul: ");
                    int salariu = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Introduceti numele: ");
                    String nume = scanner.nextLine();
                    System.out.print("Introduceti prenumele: ");
                    String prenume = scanner.nextLine();
                    System.out.print("Introduceti email-ul: ");
                    String email = scanner.nextLine();
                    System.out.print("Introduceti telefonul: ");
                    int telefon = scanner.nextInt();
                    System.out.print("Introduceti vechimea: ");
                    int vechime = scanner.nextInt();
                    scanner.nextLine();
                    Farmacist farmacist = new Farmacist(salariu, nume, prenume, email, telefon, vechime);
                    farmacistDao.create(farmacist);
                    System.out.println("Farmacist creat cu succes!");
                    break;
                case 2:
                    System.out.print("Introduceti numele farmacistului pentru citire: ");
                    String numeCitire = scanner.nextLine();
                    Farmacist farmacistCitit = farmacistDao.read(numeCitire);
                    if(farmacistCitit!=null)
                    {System.out.println("Detalii farmacist: " + farmacistCitit);}
                    else{
                        System.out.println("Farmacistul nu a fost gasit!");
                    }
                    break;
                case 3:
                    System.out.print("Introduceti numele farmacistului pentru actualizare: ");
                    String numeActualizare = scanner.nextLine();
                    Farmacist farmacistActualizare = farmacistDao.read(numeActualizare);
                    if (farmacistActualizare != null) {
                        System.out.print("Introduceti noul email: ");
                        farmacistActualizare.setEmail(scanner.nextLine());
                        farmacistDao.update(farmacistActualizare);
                        System.out.println("Farmacist actualizat cu succes!");
                    } else {
                        System.out.println("Farmacistul nu a fost gasit!");
                    }
                    break;
                case 4:
                    System.out.print("Introduceti numele farmacistului pentru stergere: ");
                    String numeStergere = scanner.nextLine();
                    Farmacist farmacistStergere=farmacistDao.read(numeStergere);
                    if(farmacistStergere!=null) {
                        farmacistDao.delete(farmacistStergere);
                        System.out.println("Farmacist sters cu succes!");
                    }
                    else{
                        System.out.println("Farmacistul nu a fost gasit!");
                    }
                    break;
                default:
                    System.out.println("Optiune invalida.");
            }
        } catch (SQLException e) {
            System.err.println("Eroare la gestionarea farmacistilor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void gestionarePacienti(Scanner scanner, PacientDao pacientDao) {
        try {
            System.out.println("=== Gestionare Pacienti ===");
            System.out.println("1. Creare Pacient");
            System.out.println("2. Citire Pacient");
            System.out.println("3. Actualizare Pacient");
            System.out.println("4. Stergere Pacient");
            System.out.print("Selectati optiunea: ");

            int optiune = scanner.nextInt();
            scanner.nextLine();
            switch (optiune) {
                case 1:
                    System.out.print("Introduceti numele: ");
                    String nume = scanner.nextLine();
                    System.out.print("Introduceti prenumele: ");
                    String prenume = scanner.nextLine();
                    System.out.print("Introduceti CNP-ul: ");
                    int cnp = scanner.nextInt();
                    scanner.nextLine();
                    Pacient pacient = new Pacient(nume, prenume, cnp);
                    pacientDao.create(pacient);
                    System.out.println("Pacient creat cu succes!");
                    break;
                case 2:
                    System.out.print("Introduceti numele pacientului pentru citire: ");
                    String numeCitire = scanner.nextLine();
                    Pacient pacientCitit = pacientDao.read(numeCitire);
                    if(pacientCitit!=null)
                    {System.out.println("Detalii pacient: " + pacientCitit);}
                    else{
                        System.out.println("Pacientul nu a fost gasit!");
                    }
                    break;
                case 3:
                    System.out.print("Introduceti numele pacientului pentru actualizare: ");
                    String numeActualizare = scanner.nextLine();
                    Pacient pacientActualizare = pacientDao.read(numeActualizare);
                    if (pacientActualizare != null) {
                        System.out.print("Introduceti noul prenume: ");
                        pacientActualizare.setPrenume(scanner.nextLine());
                        pacientDao.update(pacientActualizare);
                        System.out.println("Pacient actualizat cu succes!");
                    } else {
                        System.out.println("Pacientul nu a fost gasit!");
                    }
                    break;
                case 4:
                    System.out.print("Introduceti numele pacientului pentru stergere: ");
                    String numeStergere = scanner.nextLine();
                    Pacient pacientStergere=pacientDao.read(numeStergere);
                    if(pacientStergere!=null) {
                        pacientDao.delete(pacientStergere);
                        System.out.println("Pacient sters cu succes!");
                    }
                    else{
                        System.out.println("Pacientul nu a fost gasit!");
                }
                    break;
                default:
                    System.out.println("Optiune invalida.");
            }
        } catch (SQLException e) {
            System.err.println("Eroare la gestionarea pacientilor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void validareReteta(Scanner scanner) {
        System.out.println("=== Validare Reteta ===");
        System.out.print("Introduceti descrierea retetei:");
        String descriere = scanner.nextLine();
        AnalizaReteta analiza = new AnalizaRetetaPsihoactive();
        boolean rezultat = analiza.validareReteta(descriere);
        System.out.println(rezultat);
    }
}
