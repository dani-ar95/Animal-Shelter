package Shelter;

public class Clinic {
	//global variables
	protected String name;
	protected double priceNeuter;
		
	
	//Constructor
	Clinic(String name, double priceNeuter){
		this.name = name;
		this.priceNeuter = priceNeuter;
	}

	
	
	public double getPriceNeuter() {
		return priceNeuter;
	}
}
