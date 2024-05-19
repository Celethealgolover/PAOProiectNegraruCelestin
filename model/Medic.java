package model;
import java.util.*;
import java.time.LocalDateTime;
public abstract class Medic extends Angajat {
     private  List<Asistent> la= new ArrayList();///relatie de tip agregare, "weak"
     private Map<LocalDateTime, Pacient> programari = new TreeMap<>();
     private String nume, prenume, email, grad, specializare;///gradul poate fi medic specialist sau primar
     private int  numarTelefon, aniExperienta, salariu;///numarul de telefon este considerat ca incepe cu prefixul +40
    public Medic(){}

    public Medic(String nume, String prenume, String email, String grad, String specializare, int numarTelefon, int aniExperienta, int salariu) {
        super(salariu);
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.grad = grad;
        this.specializare=specializare;
        this.numarTelefon = numarTelefon;
        this.aniExperienta = aniExperienta;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getEmail() {
        return email;
    }

    public String getGrad() {
        return grad;
    }
    public String getSpecializare(){return specializare;}

    public int getNumarTelefon() {
        return numarTelefon;
    }
    public int getAniExperienta() {
        return aniExperienta;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public void setNumarTelefon(int numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    public void setAniExperienta(int aniExperienta) {
        this.aniExperienta = aniExperienta;
    }

    public void setLa(List<Asistent> la) {
        this.la = la;
    }

    public void setProgramari(Map<LocalDateTime, Pacient> programari) {
        this.programari = programari;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }
    public void setSalariu(int salariu){this.salariu=salariu;}

    public  void adaugaAsistent(Asistent a)
    {
       la.add(a);
    }
    public  void eliminaAsistent(Asistent a)
    {
        la.remove(a);
    }
    public List<Asistent> getLisaAsistenti()
    {
        return this.la;
    }


    public abstract void consultPacient(Pacient p);
    public String toString() {
        return "Medic{" +
                "la=" + la +
                ", programari=" + programari +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", grad='" + grad + '\'' +
                ", numarTelefon=" + numarTelefon +
                ", aniExperienta=" + aniExperienta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medic medic)) return false;
        return getNumarTelefon() == medic.getNumarTelefon() && getAniExperienta() == medic.getAniExperienta() && Objects.equals(la, medic.la) && Objects.equals(programari, medic.programari) && Objects.equals(getNume(), medic.getNume()) && Objects.equals(getPrenume(), medic.getPrenume()) && Objects.equals(getEmail(), medic.getEmail()) && Objects.equals(getGrad(), medic.getGrad());
    }

    @Override
    public int hashCode() {
        return Objects.hash(la, programari, getNume(), getPrenume(), getEmail(), getGrad(), getNumarTelefon(), getAniExperienta());
    }
}
