package controller;

import model.Animal;
import model.Attendance;
import model.Vet;
import data.DataSetClinica;
import java.util.ArrayList;

public class AttendanceController implements IAttendanceController {

    @Override
    public void insertAttendance(int idClinic, Attendance attendance) {
        DataSetClinica.data.get(idClinic).getCalls().add(attendance);
    }

    @Override
    public Attendance updateAttendance(int idClinic, Attendance attendance) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Attendance deleteAttendance(int idClinic, Attendance attendance) {
        DataSetClinica.data.get(idClinic).getCalls().remove(attendance);
        return attendance;
    }

    @Override
    public Attendance searchAttendance(int idClinic, int id) {
        Attendance retorno = null;
        for( Attendance a : DataSetClinica.data.get(idClinic).getCalls() ){
            if( a.getId() == id ){
                retorno = a;
                break;
            }
        }
        return retorno;
    }

    @Override
    public ArrayList<Attendance> searchAttendance(int idClinic, Vet vet) {
        ArrayList<Attendance> retorno = new ArrayList<Attendance>();
        for( Attendance a : DataSetClinica.data.get(idClinic).getCalls() ){
            if( a.getVet().equals(vet) ){
                retorno.add(a);                
            }
        }
        return retorno;
    }

    @Override
    public ArrayList<Attendance> searchAttendance(int idClinic, Animal animal) {
        ArrayList<Attendance> retorno = new ArrayList<Attendance>();
        for( Attendance a : DataSetClinica.data.get(idClinic).getCalls()){
            if( a.getAnimal().equals(animal) ){
                retorno.add(a);                
            }
        }
        return retorno;
    }
    
    public int getNextId( int idClinic ){
        int retorno = 0;
        for( Attendance a : DataSetClinica.data.get(idClinic).getCalls())
            if( a.getId() > retorno )
                retorno = a.getId();
        
        return (retorno + 1);
    }    
    
    public ArrayList<Attendance> getAttendancies(int iClinic){
        return DataSetClinica.data.get(iClinic).getCalls();
    }
    
}
