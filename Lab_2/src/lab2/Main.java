package lab2;


import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		//Data initialization 
		String [] list = new String[15];
		Animal [] animals = new Animal[15];
		String directory = "C:\\Users\\Daniel\\Desktop";
		
		animals=readAnimals(directory, list); //Directory where the Animales.txt document is located
	
		Shelter shel = new Shelter("Shelter MyPet", "Calle Ciruela 2", animals);
		Clinic clin = new Clinic("PetCare Clinic", 926422391, 55.0);
		TownCouncil coun = new TownCouncil(943234678, 130.2);
		manageShelter(shel,clin,coun);
		
	}
	
	

	public static Animal [] readAnimals (String directory, String [] list)throws FileNotFoundException{	  
		    
			Animal [] array = new Animal[15];
			try {
				File f=new File(directory);
			    Scanner sc = new Scanner (f);
			    int counter=0;
			    while (sc.hasNext()){
			    	//We start reading common attributes
			      char dogOrCat = sc.next().charAt(0);
			      String name = sc.next();
			      char gender = sc.next().charAt(0);
			      int age = sc.nextInt();
			      boolean sociable = sc.nextBoolean();
			   	  boolean patrons = sc.nextBoolean();
			   	  	//We read specific attributes for Dog 
			   	  	if(dogOrCat == 'p') {
			   	  		String breed = sc.next();
			   	  		int size = sc.nextInt();
			   	  		boolean pdb = sc.nextBoolean();
			   	  		boolean leishmania = sc.nextBoolean();
			   	  		//We create the object Dog	
			   	  		list[counter] = dogOrCat+" "+name+" "+gender+" "+age+" "+sociable+" "+patrons+" "+breed+" "+size+" "+pdb+" "+leishmania;
			   	  		array[counter] = new Dog(dogOrCat,name,gender,age,sociable,patrons,breed,size,pdb,leishmania);
			   	  	}else {
			   	  	//We read specific attributes for Cat
			   	  		boolean neutered = sc.nextBoolean();
			   	  		//We create object Cat
			   	  	list[counter]=dogOrCat+" "+name+" "+gender+" "+" "+age+" "+sociable+" "+patrons+" "+neutered;
			   	  	array[counter]= new Cat(dogOrCat,name,gender,age,sociable,patrons,neutered);
			   	  	}
			   	  	counter++;
			    }
			    sc.close();
			}catch(FileNotFoundException e) {
				System.out.println("The file is not there");
			}
		    return array;
	 }

	
	private static void manageShelter(Shelter shel, Clinic clin, TownCouncil coun) {
		int option;
		do {
		option = chooseMenu();
		
		switch(option) {
		case 1:
			showInformation(shel);
			break;
		case 2:
			makeRequest(shel);
			break;
		case 3:
			consultRequest(shel);
			break;
		case 4:
			calculateExpenses(shel);
			break;
		case 5:
			calculateNeutering(shel, clin);
			break;
		case 6:
			estimateFood(shel);
			break;
		case 7:
			calculateFunding(shel,coun);
		case 8:
			System.out.println("Thank you for using our application");
			break;
		}
		
		} while (option != 8);
	}

	
	private static void showInformation(Shelter shelter) {
		System.out.println(shelter.showInfo());
		
	}
	
	private static void makeRequest(Shelter shelter) throws InputMismatchException {
		
		String req;
		
		System.out.println("Choose an animal [1-15]");
		int numb = introduceNumber(1,15);
		
		do {
			try {
				System.out.println("Do you want to foster or to adopt?");
				req = sc.next();
			} catch (InputMismatchException e) {
				System.out.println("Please wirte: foster or adopt");
			}
			} while (!req.equalsIgnoreCase("foster") && !req.equalsIgnoreCase("adopt"));
		
		Request reque = new Request(req);
		
		shelter.getList()[numb-1].AddRequest(reque);
	}

	private static void consultRequest(Shelter shelter) {
		int numb = introduceNumber(1,15);
		
		for(int i=0;i<shelter.getList()[numb-1].getNumbRequest();i++)
		System.out.println("Request ["+(i+1)+"]: "+shelter.getList()[numb-1].showAllRequests()[i]);
	}
	
	private static void calculateExpenses(Shelter shelter) {
		System.out.println("The annual expenses of the shelter are: "+shelter.calculateExpenses()+"€");
	}
	
	private static void calculateNeutering(Shelter shelter, Clinic clin) {
		System.out.println("The cost of the neutering programme for the cats is: "+shelter.calculateNeuter(clin)+"€");
	}

	private static void estimateFood(Shelter shelter) {
		System.out.println("The estimated amount of food for each adult dog for each week is: "+shelter.calculateFood()+" kg");
	}
	
	private static void calculateFunding(Shelter shelter, TownCouncil council) {
		System.out.println("The funding provided by the TownCouncil is: "+shelter.calculateFunding(council)+"€");
	}
	
	
	private static int chooseMenu() {
		printMenu();
		int option = introduceNumber(0,9);
		
		return option;
	}

	private static void printMenu() {
		System.out.println("Option 1: Show all the info of the animals");
		System.out.println("Option 2: Make a request");
		System.out.println("Option 3: Consult the list of requests");
		System.out.println("Option 4: Calculate the annual veterinary expenses");
		System.out.println("Option 5: Calculate the cost of the neutering programme for the cats");
		System.out.println("Option 6: Estimate the amount of food required for each adult dog");
		System.out.println("Option 7: Calculate the funding provided by the Town Council");
		System.out.println("Option 8: Exit");
	}
	
	int cet =introduceNumber(1,15);
	
	private static int introduceNumber(int a, int b) throws InputMismatchException{
		int numb = 0;
		try {
			do {
			numb = sc.nextInt();
			} while (numb < a  || numb > b );
		} catch(InputMismatchException e) {
			System.out.println("Introduce a number between " + a + " and " + b);
		}
		return numb;
	}
}
