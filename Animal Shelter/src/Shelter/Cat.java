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
	public boolean getNeuter() {
		return neuter;
	}
	
	
	@Override //toString
	public String toString() {
		return super.toString() +" Neutered: "+neuter;
	}
	
	
	public double calculateExpenses(int numbDogs, int pdbDogs, int unneuteredCats) {
		double expenses = 0;
		
		if (super.patrons) {
			expenses = 0;
		}else {
			expenses = unneuteredCats*10.0;
		}
		
		return expenses;
	}
}
