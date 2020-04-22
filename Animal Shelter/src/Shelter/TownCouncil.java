package Shelter;

public class TownCouncil implements IShel{
	
	//global variable
	protected double funding;
	
	
	//Constructors
	TownCouncil(double funding){
		this.funding = funding;
	}

	
	//getters
	public double getFunding() {
		return funding;
	}

	
	
	public double getFixedAmount() {
		return FIXEDAMOUNT;
	}
}
