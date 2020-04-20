package lab2;

public class TownCouncil {
	
	//parameters
	public int telephone;
	public double funding;
	public double fixedAmount;
	
	//constructor
	TownCouncil(int telephone, double funding, double fixedAmount){
		this.telephone = telephone;
		this.funding = funding;
		this.fixedAmount = fixedAmount;
	}

	public double getFunding() {
		return funding;
	}

	public double getFixedAmount() {
		return fixedAmount;
	}
}
