package lab2;

public class Cats extends Animal {
	
	//parameters
	private boolean neuter;
	
	//constructor
	public Cats(String name, int age, char gender, boolean isSociable, boolean hasPatron, boolean neuter){
		super(name, age, gender, isSociable, hasPatron);
		
		this.neuter = neuter;
				
		
	}
	
	public boolean getNeuter() {
		return neuter;
	}
	
	public char get_gender() {
		return this.gender;
	}
}
