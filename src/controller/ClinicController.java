package controller;

import data.DataSetClinica;
import model.Clinic;

public class ClinicController implements IClinicController {

    @Override
    public void insertClinic(Clinic clinic) {
        DataSetClinica.data.add(clinic);
    }

    @Override
    public Clinic updateClinic(Clinic clinic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Clinic deleteClinic(Clinic clinic) {
        DataSetClinica.data.remove(clinic);
        return clinic;
    }

    @Override
    public Clinic searchClinic(int id) {
        Clinic retorno = null;
        for( Clinic c : DataSetClinica.data ){
            if( c.getId() == id ){
                retorno = c;
                break;
            }
        }
        return retorno;
    }

    @Override
    public Clinic searchClinic(String name) {
        Clinic retorno = new Clinic();
        for( Clinic c : DataSetClinica.data )
            if( c.getName().equals(name) )
                retorno = c;
        
        return retorno;
    }
    
    public int getNextId(){
        int id = 0;
        for( Clinic c : DataSetClinica.data ){
            if( c.getId() > id )
                id = c.getId();
        }
        return (id + 1);
    }
    
    public int getClinicIndex( int idClinic ){
        return DataSetClinica.data.indexOf( 
                    searchClinic(idClinic)
               );
    }
    
}
