package lab2;

public class Dogs extends Animal {
	//INICIO DE GITHUB
	
	//parameters
	public String breed;
	public int size;
	public boolean pdb;
	public boolean leish;
	
	//constructor
	Dogs(String name, int age , char gender, boolean isSociable, boolean hasPatron, String breed, int size, boolean pdb, boolean leish) {
		super(name, age, gender, isSociable, hasPatron);
		this.breed = breed;
		this.size = size;
		this.pdb = pdb;
		this.leish = leish;
	}
	
	//methods
	
	@Override
	public String toString() {
		return super.toString()+ " Breed: "+breed+" Size: "+size+" PDB: "+pdb+" Leishmania: "+leish;
	}

	protected boolean getSociable() {
		return isSociable;
	}
	
	protected boolean getPatron() {
		return hasPatron;
	}
	
	public boolean getPdb() {
		return pdb;
	}

	public boolean getLeish() {
		return leish;
	}

	
	public double calculateExpenses() {
		double expenses = 0;
		
		if(hasPatron) {
			expenses = 0;
		}else {
			
		}
		
		return expenses;
	}
}
