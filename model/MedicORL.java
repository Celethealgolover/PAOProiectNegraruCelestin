package model;
public class MedicORL extends Medic{
    private static ServiciuPret[] listaServiciiORL;
    static{
        listaServiciiORL = new ServiciuPret[3];
        listaServiciiORL[0] = new ServiciuPret("pretConsultatie",250);
        listaServiciiORL[1] = new ServiciuPret("pretSpalaturaUrechi",350);
        listaServiciiORL[2] = new ServiciuPret("pretEndoscopie",400);
    }
    public MedicORL(String nume, String prenume, String email, String grad, String specializare, int numarTelefon, int aniExperienta, int salariu)
    {
        super(nume,prenume,email,grad,specializare,numarTelefon,aniExperienta, salariu);
    }
    public void consultPacient(Pacient p)
    {
        System.out.println("Clientul " + p.getNume() + " " + p.getPrenume() + " a fost consultat de medicul ORL " + this.getNume() + "!");

    }
    public void spalaturaUrechiPacient(Pacient p)
    {
        System.out.println("Pacientul " + p.getNume() + " " + p.getPrenume() + " a efectuat o spalatura in urechi la medicul " + this.getGrad() + " " + this.getNume() + " " + this.getPrenume());
    }
    public void endoscopieORLPacient(Pacient p)
    {
        System.out.println("Pacientul " + p.getNume() + " " + p.getPrenume() + " a efectuat o endoscopie ORL la medicul " + this.getGrad() + " " + this.getNume() + " " + this.getPrenume());
    }
    public void afisareListaServiciiORL()
    {
        if(this.getGrad().equals("specialist")) {
            System.out.println("Servicii medic specialist:");
            for (ServiciuPret i : listaServiciiORL) {
                System.out.println(i.getServiciuMedical() + " " + i.getPret());
            }
        }
        else{
            System.out.println("Servicii medic primar:");
            for(ServiciuPret i : listaServiciiORL)
            {
                int aux=i.getPret()+100;
                System.out.println(i.getServiciuMedical() + " " + aux);
            }
        }
    }

}
