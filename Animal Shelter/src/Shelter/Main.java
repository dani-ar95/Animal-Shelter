package Shelter;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		String [] list = new String[15];
		Animal [] animals = new Animal[15];
		String directory = "C:\\Users\\Daniel\\Documents\\UNIVERSIDAD\\Segundo cuatri\\Programación 2\\Lab\\Animales.txt"; //Directory where the Animales.txt document is located
		boolean stop = false; //flag variable
		try {
		animals=readAnimals(directory, list); 
		}catch(FileNotFoundException e) {
			System.out.println("This file doesn't exist");
			stop = true;
		}
		
		Shelter shel = new Shelter("Shelter MyPet", "Calle Ciruela 2", animals);
		Clinic clin = new Clinic("PetCare Clinic", 55.0);
		TownCouncil coun = new TownCouncil(130.2);
		
		if(!stop){
		manageShelter(shel,clin,coun);
		}
	}
	
	
	//METHOD TO READ THE ANIMALES.TXT FILE
	public static Animal [] readAnimals (String cadena, String [] list)throws IOException{	  
		    File f=new File(cadena);
		    Animal [] array = new Animal[15];
		    Scanner sc = new Scanner (f);
		    int counter=0;
		    while (sc.hasNext()){
		      char dogOrCat = sc.next().charAt(0);
		      String name = sc.next();
		      char gender = sc.next().charAt(0);
		      int age = sc.nextInt();
		      boolean sociable = sc.nextBoolean();
		   	  boolean patrons = sc.nextBoolean();
		   	  	if(dogOrCat == 'p') {
		   	  		String breed = sc.next();
		   	  		int size = sc.nextInt();
		   	  		boolean pdb = sc.nextBoolean();
		   	  		boolean leishmania = sc.nextBoolean();
		   	  		list[counter] = dogOrCat+" "+name+" "+gender+" "+age+" "+sociable+" "+patrons+" "+breed+" "+size+" "+pdb+" "+leishmania;
		   	  		array[counter] = new Dog(dogOrCat,name,gender,age,sociable,patrons,breed,size,pdb,leishmania);
		   	  	}else {
		   	  		boolean neutered = sc.nextBoolean();
		   	  	list[counter]=dogOrCat+" "+name+" "+gender+" "+" "+age+" "+sociable+" "+patrons+" "+neutered;
		   	  	array[counter]= new Cat(dogOrCat,name,gender,age,sociable,patrons,neutered);
		   	  	}
		   	  	counter++;
		    }
		    sc.close();
		    
		    return array;
	 }

	
	//METHOD TO MANAGE THE OPTIONS OF THE SHELTER PROGRAM
	private static void manageShelter(Shelter shel, Clinic clin, TownCouncil coun) {
		int option;
		System.out.println("----Welcome to our Shelter application----\n");
		do {
		option = chooseMenu(1,8);
		
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

	
	//OPTION 1
	private static void showInformation(Shelter shelter) {
		System.out.println(shelter.showInfo());
		
	}
	
	
	//OPTION 2
	private static void makeRequest(Shelter shelter) {
		int numb;
		String type;
		
		printAnimals(shelter);
		System.out.println("Choose an animal [1,15]");
		numb = inRange(1,15);
		
		do {
			System.out.println("Do you want to foster or to adopt?");
			type = sc.next();
		} while (!type.equalsIgnoreCase("foster") && !type.equalsIgnoreCase("adopt"));
		
		Request request = new Request(type);
		
		shelter.getList()[numb-1].AddRequest(request);
	}

	
	//OPTION 3
	private static void consultRequest(Shelter shelter) {
		int numb;
		printAnimals(shelter);
			
		System.out.println("Choose an animal [1,15]");
		numb = inRange(1,15);
		
		if(shelter.getList()[numb-1].getNumbRequest() == 0) {
			System.out.println("This animal doesn't have any requests\n");
		}else {
		for(int i=0;i<shelter.getList()[numb-1].getNumbRequest();i++)
			System.out.println("Request ["+(i+1)+"]: "+shelter.getList()[numb-1].showAllRequests()[i]);
		}
	}
	
	
	//OPTION 4
	private static void calculateExpenses(Shelter shelter) {
		System.out.println("The annual expenses of the shelter are: "+shelter.calculateExpenses()+"€\n");
	}
	
	
	//OPTION 5
	private static void calculateNeutering(Shelter shelter, Clinic clin) {
		System.out.println("The cost of the neutering programme for the cats is: "+shelter.calculateNeuter(clin)+"€\n");
	}

	
	//OPTION 6
	private static void estimateFood(Shelter shelter) {
		System.out.println("The estimated amount of food for each adult dog for each week is: "+shelter.calculateFood()+" kg\n");
	}
	
	
	//OPTION 7
	private static void calculateFunding(Shelter shelter, TownCouncil council) {
		System.out.println("The funding provided by the TownCouncil is: "+shelter.calculateFunding(council)+"€\n");
	}
	
	
	//METHOD TO CHOOSE THE OPTIONS OF THE MENU
	private static int chooseMenu(int min, int max) {
		printMenu();
		int option = 0;
		option = inRange(min,max);
		return option;
	}

	
	//METHOD TO PRINT THE OPTIONS OF THE MENU
	private static void printMenu() {
		System.out.println("Please choose an option: ");
		System.out.println("Option 1: Show all the info of the animals");
		System.out.println("Option 2: Make a request");
		System.out.println("Option 3: Consult the list of requests");
		System.out.println("Option 4: Calculate the annual veterinary expenses");
		System.out.println("Option 5: Calculate the cost of the neutering programme for the cats");
		System.out.println("Option 6: Estimate the amount of food required for each adult dog");
		System.out.println("Option 7: Calculate the funding provided by the Town Council");
		System.out.println("Option 8: Exit");
	}
	
	
	//METHOD TO READ AN INTEGER WITHIN A RANGE
	public static int inRange(int min,int max) {
		int num = 0;
		boolean repeat;
		do {
			repeat = false;
			try {
				num = readInt();
				if (num < min || num > max)
					throw new OutOfRangeException();
				
			} catch (OutOfRangeException e){
				System.out.println("Error. The number must be in this range: ["+min+","+max+"]");
				System.out.println("Please enter a number in this range: ["+min+","+max+"]");
				repeat = true;
			}
			
		} while (repeat);
		return num;
	}
	
	
	//METHOD TO READ AN INTEGER
	public static int readInt() {
		int inte = 0;
		boolean repeat = false;
		
		do {
		try {
		repeat = false;
		inte = sc.nextInt();
		
		}catch(InputMismatchException e) {
			System.out.println("You have entered a non numeric character");
			repeat = true;
		} finally {
			sc.nextLine();
		}
		
		}while(repeat);
		
		return inte;
	}
	
	
	//METHOD TO PRINT THE NAME OF THE ANIMALS OF THE LIST
	public static void printAnimals(Shelter shelter) {
		for(int i=0;i<shelter.getList().length;i++) {
			System.out.println("["+(i+1)+"] "+shelter.getList()[i].getName());
		}
	}
}

class OutOfRangeException extends Exception{}
