package view;

import data.DataSetClinica;
import java.util.Scanner;
import model.Animal;
import controller.AnimalController;
import controller.ClinicController;

public class AnimalView {
    
    private Animal vet = new Animal();
    private AnimalController animalController = new AnimalController();
    private Scanner sc = new Scanner(System.in);    
    
    public AnimalView() {       
        this.InitAnimalView();        
    }    
    
    private void InitAnimalView(){
        System.out.println("*******");
        System.out.println("ANIMAIS");
        System.out.println("*******");
        System.out.println("");
        
        System.out.println( DataSetClinica.selectedClinic.getAnimals().size() + 
                            " animais cadastrados." );
        System.out.println("");
        
        int op = 0;
        do{
            System.out.println("****");
            System.out.println("MENU");
            System.out.println("****");
            System.out.println("1 - Incluir animal");
            System.out.println("2 - Selecionar animal");
            System.out.println("0 - Sair");
            op = sc.nextInt();
            
            switch( op ){
                case 1 : 
                    this.InsertAnimal();
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
    
    private void InsertAnimal()
    {
        System.out.println("*******************");
        System.out.println("Inserir Novo Animal");
        System.out.println("*******************");
        Animal newAnimal = new Animal();        
        
        ClinicController clinicController = new ClinicController();
        int iClinic =  clinicController.getClinicIndex( DataSetClinica.selectedClinic.getId() );
        
        newAnimal.setId( this.animalController.getNextId( iClinic ) );
        
        System.out.println("Nome:");
        String name = sc.nextLine();
        name = sc.nextLine();       
        
        System.out.println("Tipo:");
        String tipo = sc.nextLine();
        
        System.out.println("Cor:");
        String cor = sc.nextLine();
        
        System.out.println("Tamanho:");
        double tamanho = sc.nextDouble();
        
        System.out.println("Peso:");
        double peso = sc.nextDouble();
        
        newAnimal.setName(name);
        newAnimal.setType(tipo);
        newAnimal.setColor(cor);
        newAnimal.setSize(tamanho);
        newAnimal.setWeight(peso);
        this.animalController.insertAnimal(iClinic, newAnimal);
    }        
    
}
