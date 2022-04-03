package controller;

import data.DataSetClinica;
import java.util.ArrayList;
import model.Vet;

public class VetController implements IVetController {

    @Override
    public void insertVet(int idClinic, Vet vet) {        
        DataSetClinica.data.get(idClinic).getVets().add(vet);
    }

    @Override
    public Vet updateVet(int idClinic, Vet vet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vet deleteVet(int idClinic, Vet vet) {
        DataSetClinica.data.get(idClinic).getVets().remove(vet);
        return vet;
    }

    @Override
    public Vet searchVet(int idClinic, int id) {            
        Vet retorno = null;
        for( Vet v : DataSetClinica.data.get(idClinic).getVets() ){
            if( v.getId() == id ){
                retorno = v;
                break;
            }
        }
        return retorno;
    }

    @Override
    public Vet searchVet(int idClinic, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getNextId( int idClinic ){
        int retorno = 0;
        for( Vet v : DataSetClinica.data.get(idClinic).getVets() )
            if( v.getId() > retorno )
                retorno = v.getId();
        
        return (retorno + 1);
    }
    
    public ArrayList<Vet> getVets( int idClinic ){
        return DataSetClinica.data.get(idClinic).getVets();
    }
    
}