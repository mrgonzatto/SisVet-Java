package controller;

import model.Vet;

public interface IVetController {
    
    public void insertVet( int idClinic, Vet vet );
    public Vet updateVet( int idClinic, Vet vet );
    public Vet deleteVet( int idClinic, Vet vet );
    public Vet searchVet( int idClinic, int id );
    public Vet searchVet( int idClinic, String name );
    
}
