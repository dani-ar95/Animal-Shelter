package Shelter;

class Cat extends Animal {
	
	//global variable
	private boolean neuter;
	
	
	//Constructor
	Cat(char type, String name, char gender, int age, boolean isSociable, boolean hasPatron, boolean neuter) {
		super(type, name, gender, age, isSociable, hasPatron);
		this.neuter = neuter;
	}
	
	
	//getters
	public boolean getPatron() {
		return hasPatron;
	}
	
	
	
	public boolean getNeuter() {
		return neuter;
	}

	
	
	public char getGender() {
		return gender;
	}

	
	
	@Override //toString
	public String toString() {
		return super.toString() +" Neutered: "+neuter;
	}
	
	
	
	@Override
	public double calculateExpenses(int numbDogs, int pdbDogs, int unneuteredCats) {
		double expenses = 0;
		
		if (hasPatron) {
			expenses = 0;
		}else {
			expenses = unneuteredCats*10.0;
		}
		
		return expenses;
	}
}
