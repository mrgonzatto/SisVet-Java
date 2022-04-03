package controller;

import model.Animal;

public interface IAnimalController {
    public void insertAnimal(int idClinic, Animal animal);
    public Animal updateAnimal(int idClinic, Animal animal);
    public Animal deleteAnimal(int idClinic, Animal animal);
    public Animal searchAnimal(int idClinic, int id);
    public Animal searchAnimal(int idClinic, String name);    
}
