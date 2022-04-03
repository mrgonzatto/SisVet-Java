package view;

import data.DataSetClinica;
import java.util.Scanner;
import model.Clinic;
import controller.ClinicController;

public class ClinicView {
    
    private Clinic clinic = new Clinic();
    private ClinicController clinicController = new ClinicController();
    private Scanner sc = new Scanner(System.in);

    public ClinicView() {
        
        DataSetClinica.data.add(
            new Clinic(1, "Vida Veterinária", null)
        );
        
        DataSetClinica.data.add(
            new Clinic(2, "Bicho Amigo", null)
        );
        
        this.InitClinicView();
    }
    
    private void InitClinicView(){
        System.out.println("*******************");
        System.out.println("BEM VINDO AO SISVET");
        System.out.println("*******************");
        System.out.println("");
        
        System.out.println( DataSetClinica.data.size() + 
                            " clinicas cadastradas." );
        System.out.println("");
        
        int op = 0;
        do{
            System.out.println("****");
            System.out.println("MENU");
            System.out.println("****");
            System.out.println("1 - Incluir clínica");
            System.out.println("2 - Selecionar clínica");
            System.out.println("0 - Sair");
            op = sc.nextInt();
            
            switch( op ){
                case 1 : 
                    this.InsertClinic();
                    break;
                case 2 : 
                    this.SelectClinic();
                    this.ShowMenuClinic();
                    break;
                case 0:
                    break;
                default : 
                    System.out.println("Opção inválida");
                    break;                            
            }
            
        }while(op != 0);        
    }            
        
    private void SelectClinic(){        
        int opcao = 0;
        this.clinic = null;
        do{            
            System.out.println("Selecione o código da clínica");
            for( Clinic c : DataSetClinica.data ){
                System.out.println( c.getId() + " - " + c.getName() );
            }
            opcao = sc.nextInt();
            // Buscar a clínica selecionada
            this.clinic = this.clinicController.searchClinic(opcao);
            if( this.clinic == null ){
                System.out.println("Clínica inválida!");
                opcao = 0;
            } else {
                DataSetClinica.selectedClinic = this.clinic;
            }          
        } while( opcao == 0 );        
    }
    
    private void InsertClinic(){
        System.out.println("********************");
        System.out.println("Inserir Nova Clínica");
        System.out.println("********************");
        Clinic newClinic = new Clinic();
        newClinic.setId( this.clinicController.getNextId() );
        System.out.println("Nome:");
        String name = sc.nextLine();
        name = sc.nextLine();
        newClinic.setName(name);
        this.clinicController.insertClinic(newClinic);
    }
    
    private void ShowMenuClinic()
    {
        int opcao = 0;
        do{            
            System.out.println("************");
            System.out.println("MENU CLÍNICA");
            System.out.println("************");
            System.out.println(
                "CLÍNICA: " + this.clinic.getId() + " - " + 
                              this.clinic.getName()
            );
            System.out.println("");
            
            System.out.println("1 - Veterinário");
            System.out.println("2 - Animal");
            System.out.println("3 - Atendimento");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            
            switch( opcao ){
                case 1 :
                    VetView vetView = new VetView( this.clinicController.getClinicIndex( this.clinic.getId() ) );
                    break;
                case 2 : 
                    AnimalView animalView = new AnimalView();
                    break;
                case 3 : 
                    AttendanceView attendanceView = new AttendanceView();
                    break;
                case 0 : 
                    break;
                default : 
                    System.out.println("Opção inválida");
                    opcao = 0;
                    break;
            }
            
        } while(opcao != 0);
    }
}
