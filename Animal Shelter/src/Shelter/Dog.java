package Shelter;

public class Dog extends Animal {
	
	//global variables
	protected String breed;
	protected int size;
	protected boolean pdb;
	protected boolean leish;
	
	
	//Constructor
	Dog(char type, String name, char gender, int age, boolean isSociable, boolean hasPatron, String breed, int size, boolean pdb, boolean leish) {
		super(type, name, gender, age, isSociable, hasPatron);
		this.breed = breed;
		this.size = size;
		this.pdb = pdb;
		this.leish = leish;
	}
	
	
	//getters
	public int getSize() {
		return size;
	}

	
	
	public boolean getSociable() {
		return isSociable;
	}
	
	
	
	public boolean getPatron() {
		return hasPatron;
	}
	
	
	
	public boolean getPdb() {
		return pdb;
	}

	
	
	public boolean getLeish() {
		return leish;
	}

	
	@Override //toString
	public String toString() {
		return super.toString()+ " Breed: "+breed+" Size: "+size+" PDB: "+pdb+" Leishmania: "+leish;
	}
	
	
	@Override
	double calculateExpenses(int numbDogs, int numbPdb, int unneuteredCats) {
		double expenses = 0;
		
		if(hasPatron) {
			expenses = 0;
		}else {
			expenses = (25.0*numbDogs*12) + (30.0*numbDogs) + numbPdb*8.0;
		}
		
		return expenses;
	}
}
