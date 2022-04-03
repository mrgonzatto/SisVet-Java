package view;

import data.DataSetClinica;
import java.util.Scanner;
import model.Vet;
import controller.VetController;
import controller.ClinicController;

public class VetView {
    
    private Vet vet = new Vet();
    private VetController vetController = new VetController();
    private Scanner sc = new Scanner(System.in);

    public VetView() {       
        this.InitVetView();        
    }
    
    public VetView( int indexClinic ){
        
        DataSetClinica.data.get(indexClinic).getVets().add(  
            new Vet(1, "Mauricio Roberto Gonzatto", "123456")
        );
        
        DataSetClinica.data.get(indexClinic).getVets().add(  
            new Vet(2, "Alechandre Friebel", "246810")
        );      
        
        this.InitVetView();
    }
    
    private void InitVetView(){
        System.out.println("************");
        System.out.println("VETERINÁRIOS");
        System.out.println("************");
        System.out.println("");
        
        System.out.println( DataSetClinica.selectedClinic.getVets().size() + 
                            " veterinários cadastrados." );
        System.out.println("");
        
        int op = 0;
        do{
            System.out.println("****");
            System.out.println("MENU");
            System.out.println("****");
            System.out.println("1 - Incluir veterinário");
            System.out.println("2 - Selecionar veterinário");
            System.out.println("0 - Sair");
            op = sc.nextInt();
            
            switch( op ){
                case 1 : 
                    this.InsertVet();
                    break;
                case 2 : 
                    //this.SelectClinic();
                    //this.ShowMenuClinic();
                    break;
                case 0:
                    break;
                default : 
                    System.out.println("Opção inválida");
                    break;                            
            }
            
        }while(op != 0);        
    }            
    
    private void InsertVet()
    {
        System.out.println("************************");
        System.out.println("Inserir Novo Veterinário");
        System.out.println("************************");
        Vet newVet = new Vet();        
        
        ClinicController clinicController = new ClinicController();
        int iClinic =  clinicController.getClinicIndex( DataSetClinica.selectedClinic.getId() );
        
        newVet.setId( this.vetController.getNextId( iClinic ) );
        System.out.println("Nome:");
        String name = sc.nextLine();
        name = sc.nextLine();        
        System.out.println("CRV:");
        String crv = sc.nextLine();                
        newVet.setName(name);
        newVet.setCRV(crv);        
        this.vetController.insertVet(iClinic, newVet);
    }    
    
    
}
