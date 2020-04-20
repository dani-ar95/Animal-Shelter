package lab2;

public class Shelter {

	private String name, adress;
	private Animal[] list = new  Animal[10];
	
	
	Shelter (String name, String address, Animal[] listAnimal) {
	}
	
	public Animal[] get_list(Animal[] list) {
		return list;
	}
	
	public double calculate_Funding(TownCouncil fund) {
		double funding = 0;
		return funding;		
	}
	
	public double calculate_Neuter(Clinic neut) {
		double neuter = 0;
		
		for(int i=0; i<list.length; i++) {
			if(list[i].get_type().charAt(0) == 'g') {
				Cats c1 = (Cats) list[i];
				if (c1.get_gender() == 'h'){
					if(!c1.getNeuter()) 
						neuter += neut.getPriceNeuter(c1);
					}
				}
			}
		return neuter;
		}
	
	
	
	public double calculate_expenses(Animal [] list) {
		double expenses = 0;
		for(int i=0; i<list.length; i++) {
			if(list[i].hasPatron = false) {
				
				if (list[i].get_type().charAt(0) == 'd' ) {
					Dogs d1 = (Dogs) list[i];
					expenses += 25*12 + 30;
					if (d1.getPdb() == true) {
						expenses += 8*12;
					}
				}
				if (list[i].get_type().charAt(0) == 'c') {
					Cats c1 = (Cats) list[i];
					if( c1.getNeuter() == false) {
						expenses += 10*12;
					}
				}
			}
		}
		return expenses;
	}
	
	public double calculate_food(Dogs dog) {
		double total = 0;
		if (dog.age < 18) {
			total += 0;
			}
		if (dog.age > 18) {
			if(dog.size < 15) {
				total += 200 * 365;
					}
		if (dog.size < 25 || dog.size > 15) {
			total += 300 * 365;
				}
		else{
			total += ((1.5 * dog.size) / 100) * 365;
				}
			}
		return total;
		}
	
	
	public String showInfo() {
		String cadena = null;
		
		for(int i=0;i<list.length;i++) {
			cadena += list[i].toString();
		}
		
		return cadena;
	}
	}

