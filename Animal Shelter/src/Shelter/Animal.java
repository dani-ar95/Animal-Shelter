package Shelter;

abstract class Animal{
	
	//global variables
	protected char type;
	protected String name;
	protected int age, numbRequest = 0;
	protected char gender;
	protected boolean isSociable, hasPatron;
	//List 
	protected Request[] listRequests = new Request[10];
	
	
	//Constructor
	Animal(char type, String name, char gender, int age, boolean isSociable, boolean hasPatron){
		this.type = type;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.isSociable = isSociable;
		this.hasPatron = hasPatron;
	}
	
	
	//getters
	public String getName() {
		return name;
	}
	
	
	
	public char getType() {
		return type;
	}
	
	
	
	public char getGender() {
		return gender;
	}
	
	
	
	public int getAge() {
		return age;
	}
	
	
	
	public boolean hasPatron() {
		return hasPatron;
	}
	
	
	
	public int getNumbRequest() {
		return numbRequest;
	}
	
	
	//toString
	public String toString() {
		return "Type: "+type+" Name: "+name+ " Age: "+age+" Gender: "+gender+" Sociable: "+isSociable+" Patrons: "+hasPatron+ " Number of requests: "+numbRequest;
	}
	
	
	
	public String[] showAllRequests() {
		String [] cadena = new String [numbRequest];
		for(int i=0; i<numbRequest; i++) {
			cadena[i] = listRequests[i].toString();
		}
		return cadena;
	}
	
	
	
	//List from request
	public void AddRequest(Request req) {
		try {
			if(numbRequest >= 10)
				throw new ExceededRequestsException();
			
		listRequests[numbRequest] = req;
		numbRequest++;
		System.out.println("The request was succesfully made\n");
		}catch(ExceededRequestsException e) {
			System.out.println("You can't make more requests for this animal\n");
		}
	}
	
	
	
	abstract double calculateExpenses(int numbDogs, int pdbDogs, int unneuteredCats);
}

class ExceededRequestsException extends Exception{}
