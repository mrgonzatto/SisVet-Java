package model;

import java.util.Date;

public class Attendance {
    
    private int id;
    private Date dateAttendance;
    private Animal animal;
    private Vet vet;
    private String details;

    public Attendance() {
    }

    public Attendance(int id, Date dateAttendance, Animal animal, Vet vet, String details) {
        this.id = id;
        this.dateAttendance = dateAttendance;
        this.animal = animal;
        this.vet = vet;
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateAttendance() {
        return dateAttendance;
    }

    public void setDateAttendance(Date dateAttendance) {
        this.dateAttendance = dateAttendance;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    
    @Override
    public String toString(){
        String retorno = "Detalhes do atendimento \n"  + 
                         "Id: " + this.getId() + "\n" + 
                         "Animal: " + this.getAnimal().getName() + "\n" + 
                         "Veterinário: " + this.getVet().getName() + "\n" + 
                         "Obs.: " + this.getDetails() + "\n" +
                         "Data: " + this.getDateAttendance().toString();
        return retorno;
    }
                
}
