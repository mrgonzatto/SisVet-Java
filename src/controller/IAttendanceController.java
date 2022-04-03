package controller;

import java.util.ArrayList;
import model.Attendance;
import model.Vet;
import model.Animal;

public interface IAttendanceController {
    public void insertAttendance(int idClinic, Attendance attendance);
    public Attendance updateAttendance(int idClinic, Attendance attendance);
    public Attendance deleteAttendance(int idClinic, Attendance attendance);
    public Attendance searchAttendance(int idClinic, int id);
    public ArrayList<Attendance> searchAttendance(int idClinic, Vet vet);
    public ArrayList<Attendance> searchAttendance(int idClinic, Animal animal);
}
