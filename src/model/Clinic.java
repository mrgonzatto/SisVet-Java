
package model;

import java.util.ArrayList;

public class Clinic {
    
    private int id;
    private String name;    
    private Address address;
    
    private ArrayList<Vet> vets = new ArrayList<Vet>(); 
    
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    
    private ArrayList<Attendance> calls = new ArrayList<Attendance>();

    public Clinic() {
    }

    public Clinic(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Vet> getVets() {
        return vets;
    }

    public void setVets(ArrayList<Vet> vets) {
        this.vets = vets;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<Attendance> getCalls() {
        return calls;
    }

    public void setCalls(ArrayList<Attendance> calls) {
        this.calls = calls;
    }
    
    
                            
}
