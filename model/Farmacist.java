package model;
import analiza.*;

import java.util.Objects;

public class Farmacist extends Angajat{
    private String nume, prenume, email;
    private int nrTelefon, aniExperienta;

    public Farmacist(int salariu, String nume, String prenume, String email, int nrTelefon, int aniExperienta) {
        super(salariu);
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.nrTelefon = nrTelefon;
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

    public int getNrTelefon() {
        return nrTelefon;
    }

    public int getAniExperienta() {
        return aniExperienta;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNrTelefon(int nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public void setAniExperienta(int aniExperienta) {
        this.aniExperienta = aniExperienta;
    }

    @Override
    public String toString() {
        return "Farmacist{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", nrTelefon=" + nrTelefon +
                ", aniExperienta=" + aniExperienta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Farmacist farmacist)) return false;
        return getNrTelefon() == farmacist.getNrTelefon() && getAniExperienta() == farmacist.getAniExperienta() && Objects.equals(getNume(), farmacist.getNume()) && Objects.equals(getPrenume(), farmacist.getPrenume()) && Objects.equals(getEmail(), farmacist.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNume(), getPrenume(), getEmail(), getNrTelefon(), getAniExperienta());
    }
}
