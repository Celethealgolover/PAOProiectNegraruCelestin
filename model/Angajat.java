package model;

public class Angajat {
    private static int id=0;
    private int idAngajat;
    private int salariu;
    public Angajat(){}
    public Angajat(int salariu)///de fiecare data cand se insereaza un nou angajat, fie el medic, farmacist, asistent sau receptioner m id ul se va incrementa automat, garantandu se unicitatea
    {
        id++;
        this.salariu=salariu;
        this.idAngajat=id;
    }
    public  int getIdAngajat()
    {
        return idAngajat;
    }
    public int getSalariu()
    {
        return this.salariu;
    }
}
