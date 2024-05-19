package model;

import java.util.Objects;

public class Asistent extends Angajat{
    private String nume, prenume, email;
    private int nr_telefon;

    public Asistent(int salariu, String nume, String prenume, String email, int nr_telefon) {
        super(salariu);
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.nr_telefon = nr_telefon;
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

    public int getNr_telefon() {
        return nr_telefon;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setNr_telefon(int nr_telefon) {
        this.nr_telefon = nr_telefon;
    }

    @Override
    public String toString() {
        return "Asistent{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", nr_telefon=" + nr_telefon +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asistent asistent)) return false;
        return getNr_telefon() == asistent.getNr_telefon() && Objects.equals(getNume(), asistent.getNume()) && Objects.equals(getPrenume(), asistent.getPrenume()) && Objects.equals(getEmail(), asistent.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNume(), getPrenume(), getEmail(), getNr_telefon());
    }
}
