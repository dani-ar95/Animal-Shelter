package lab2;

public class Clinic {
	//parameters
	public String name;
	public int telephone;
	private double priceNeuter;
		
	//constructor
	Clinic(String name, int telephone){
		this.name = name;
		this.telephone = telephone;
	}

	public double getPriceNeuter(Cats gato) {
		double priceNeuter = 0;
		
		if(gato.getNeuter() == false) {
			priceNeuter += 10*12;
		}
		
		
		
		return priceNeuter;
	}
}
