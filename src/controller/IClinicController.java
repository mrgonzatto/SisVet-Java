package controller;

import model.Clinic;

public interface IClinicController {    
    public void insertClinic(Clinic clinic);
    public Clinic updateClinic(Clinic clinic);
    public Clinic deleteClinic(Clinic clinic);
    public Clinic searchClinic(int id);
    public Clinic searchClinic(String name);    
}
