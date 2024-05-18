package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pacient {
    private String nume, prenume;
    private long cnp;

    public Pacient(String nume, String prenume, long cnp) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public long getCnp() {
        return cnp;
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", cnp=" + cnp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pacient pacient)) return false;
        return getCnp() == pacient.getCnp() && Objects.equals(getNume(), pacient.getNume()) && Objects.equals(getPrenume(), pacient.getPrenume());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNume(), getPrenume(), getCnp());
    }
}
