package model;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Farmacie {///clasa de tipul singleton
    private static Farmacie farmacie;
    private List<Farmacist> lf = new ArrayList<>();
    private Farmacie(){}
    public static Farmacie getFarmacie()
    {
        if(farmacie==null)
        {
            farmacie=new Farmacie();
        }
        return farmacie;
    }
    public List<Farmacist> getListaFarmacisti()
    {
        return lf;
    }
    public void addFarmacist(Farmacist f)
    {
        lf.add(f);
    }

    @Override
    public String toString() {
        return "Farmacie{" +
                "lf=" + lf +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Farmacie farmacie)) return false;
        return Objects.equals(lf, farmacie.lf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lf);
    }
}
