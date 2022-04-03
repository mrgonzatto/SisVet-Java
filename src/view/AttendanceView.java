package view;

import data.DataSetClinica;
import java.util.Scanner;
import model.Attendance;
import controller.AttendanceController;
import controller.VetController;
import controller.AnimalController;
import controller.ClinicController;
import java.util.ArrayList;
import java.util.Date;
import model.Animal;
import model.Vet;

public class AttendanceView {
    
    private Attendance attendace = new Attendance();
    private AttendanceController attendanceController = 
            new AttendanceController();
    private Scanner sc = new Scanner(System.in);    
    
    int iClinic;
    
    public AttendanceView() { 
        ClinicController clinicController = new ClinicController();
         iClinic = clinicController.getClinicIndex( DataSetClinica.selectedClinic.getId() );
                
        this.InitAttendanceView();        
    }    
    
    private void InitAttendanceView(){
        System.out.println("************");
        System.out.println("ATENDIMENTOS");
        System.out.println("************");
        System.out.println("");
        
        System.out.println( DataSetClinica.selectedClinic.getCalls().size() + 
                            " atendimentos cadastrados." );
        System.out.println("");
        
        int op = 0;
        do{
            System.out.println("****");
            System.out.println("MENU");
            System.out.println("****");
            System.out.println("1 - Incluir atendimento");
            System.out.println("2 - Mostrar atendimentos");
            System.out.println("3 - Atendimentos Veterinário");
            System.out.println("4 - Atendimentos Animal");
            System.out.println("0 - Sair");
            op = sc.nextInt();
            
            switch( op ){
                case 1 : 
                    this.InsertAttendance();
                    break;
                case 2 :                     
                    this.ShowAttendancies();
                    break;
                case 3 : 
                    // busca atendimentos veterinário
                    break;
                case 4 :
                    // busca atendimentos animal
                    break;
                case 0:
                    break;
                default : 
                    System.out.println("Opção inválida");
                    break;                            
            }
            
        }while(op != 0);        
    }      

    private void InsertAttendance()
    {
        System.out.println("************************");
        System.out.println("Inserir Novo Atendimento");
        System.out.println("************************");
        Attendance newAttendance = new Attendance();        
               
        newAttendance.setId( this.attendanceController.getNextId( iClinic ) );
        
        Date date = new Date();        
        System.out.println("Data " + date.toString());
        newAttendance.setDateAttendance(date);        
                
        // SELECIONA ANIMAL
        System.out.println("Lista de animais");
        System.out.println("****************");
        AnimalController animalController = new AnimalController();
        ArrayList<Animal> animals = animalController.getAnimals(iClinic);
        for( Animal a : animals ){
            System.out.println( a.getId() + " - " + a.getName() );
        }
        System.out.println("Selecione pelo código:");
        int idAnimal = sc.nextInt();        
        Animal animal = 
            animalController.searchAnimal(iClinic, idAnimal);        
        newAttendance.setAnimal( animal );
        
        // SELECIONA VETERINÁRIO
        System.out.println("");
        System.out.println("Lista de Médicos Veterinários");
        System.out.println("*****************************");
        VetController vetController = new VetController();
        ArrayList<Vet> vets = vetController.getVets(iClinic);
        for( Vet v : vets ){
            System.out.println( v.getId() + " - " + v.getName() );
        }
        System.out.println("Selecione pelo código:");
        int idVet = sc.nextInt();
        newAttendance.setVet( 
            vetController.searchVet(iClinic, idVet)
        );           
        
        System.out.println("Observações:");
        String obs = sc.nextLine();
        newAttendance.setDetails(obs);
        
        this.attendanceController.insertAttendance(iClinic, newAttendance);
    }  
    
    private void ShowAttendancies(){
        ArrayList<Attendance> attendancies = 
                attendanceController.getAttendancies(iClinic);
        for( Attendance a : attendancies ){
            System.out.println( a );
        }
    }
}
