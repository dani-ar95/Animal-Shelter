package Shelter;

public class Shelter implements IShel {
	
	//global variables
	protected String name;
	protected String address;
	protected Animal[] list = new  Animal[15];
	
	//Constructor
	Shelter(String name, String address, Animal[] listAnimal) {
		this.name = name;
		this.address = address;
		list = listAnimal;
	}
	
	//methods
	public Animal[] getList() {
		return list;
	}
	
	public String showInfo() {
		String cadena = "";
		
		for(int i=0;i<list.length;i++) {
			cadena += list[i].toString();
			cadena += "\n";
		}
		
		return cadena;
	}
	
	public double calculateFunding(TownCouncil fund) {
		return fund.getFunding() + fund.getFixedAmount();		
	}
	
	public double calculateNeuter(Clinic neut) {
		double neuter = 0;
		
		for(int i=0;i<list.length;i++) {
			if(list[i].getType() == 'g') {
				Cat cat = (Cat) list[i];
				if(cat.getGender() == 'h') {
					if(cat.getNeuter() == false)
					neuter += neut.getPriceNeuter();
				}
			}
		}
		return neuter;
	}
	
	public double calculateExpenses() {
		double expenses = 0;
		for(int i=0; i<list.length; i++) {
			if(list[i].hasPatron() == false) {
				
				if (list[i].getType() == 'p' ) {
					Dog d1 = (Dog) list[i];
					expenses += LEISHEXPENSES*12 + RABIESVACCINE;
					if (d1.getPdb() == true) {
						expenses += RABIESVACCINE*12;
					}
				}
				if (list[i].getType() == 'c') {
					Cat c1 = (Cat) list[i];
					if(c1.getNeuter() == false) {
						expenses += UNNEUTEREDTREAT*12;
					}
				}
			}
		}
		return expenses;
	}
	
	public double calculateFood() {
		double kilos = 0;
		
		for(int i=0;i<list.length;i++) {
			if(list[i].getType() == 'p') {
				Dog dog = (Dog) list[i];
				if(dog.getAge() > 1) {
					if(dog.getSize() < 15) {
						kilos += FOODSMALL*7;
					}else if(15 < dog.getSize() && dog.getSize() < 25) {
						kilos += FOODMEDIUM*7;
					}else {
						kilos += dog.getSize()*0.015;
					}
				}
			}
		}
		
		return kilos;
	}
	
}

