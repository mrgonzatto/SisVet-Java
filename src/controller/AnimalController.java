
package controller;

import data.DataSetClinica;
import java.util.ArrayList;
import model.Animal;

public class AnimalController implements IAnimalController {

    @Override
    public void insertAnimal(int idClinic, Animal animal) {
        DataSetClinica.data.get(idClinic).getAnimals().add(animal);
    }

    @Override
    public Animal updateAnimal(int idClinic, Animal animal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Animal deleteAnimal(int idClinic, Animal animal) {
        DataSetClinica.data.get(idClinic).getAnimals().remove(animal);
        return animal;
    }

    @Override
    public Animal searchAnimal(int idClinic, int id) {
        Animal retorno = null;
        for( Animal a : DataSetClinica.data.get(idClinic).getAnimals() ){
            if( a.getId() == id ){
                retorno = a;
                break;
            }
        }
        return retorno;
    }

    @Override
    public Animal searchAnimal(int idClinic, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getNextId( int idClinic ){
        int retorno = 0;
        for( Animal a : DataSetClinica.data.get(idClinic).getAnimals() )
            if( a.getId() > retorno )
                retorno = a.getId();
        
        return (retorno + 1);
    }    
    
    public ArrayList<Animal> getAnimals(int idClinic){
        return DataSetClinica.data.get(idClinic).getAnimals();
    }
    
}
