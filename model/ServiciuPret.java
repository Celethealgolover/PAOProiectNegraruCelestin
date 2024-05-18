package model;

import java.util.Objects;

public class ServiciuPret {
    private String serviciuMedical;
    private int pret;
    public ServiciuPret(String serviciuMedical, int pret) {
        this.serviciuMedical = serviciuMedical;
        this.pret = pret;
    }

    public String getServiciuMedical() {
        return serviciuMedical;
    }

    public int getPret() {
        return pret;
    }

    public void setServiciuMedical(String serviciuMedical) {
        this.serviciuMedical = serviciuMedical;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiciuPret that)) return false;
        return getPret() == that.getPret() && Objects.equals(getServiciuMedical(), that.getServiciuMedical());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getServiciuMedical(), getPret());
    }

    @Override
    public String toString() {
        return "ServiciuPret{" +
                "serviciuMedical='" + serviciuMedical + '\'' +
                ", pret=" + pret +
                '}';
    }
}
