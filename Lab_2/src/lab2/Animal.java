package lab2;

abstract class Animal {
	
	protected String name, type;
	protected int age;
	protected char gender;
	protected boolean isSociable, hasPatron;
	
	//List 
	private Request[] listRequests = new Request[10];
	
	Animal(String name, int age, char gender, boolean isSociable, boolean hasPatron){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.isSociable = isSociable;
		this.hasPatron = hasPatron;
	
	}
	
	public boolean get_sociable() {
		return this.isSociable;	
	}

	public boolean get_Patron() {
		return this.hasPatron;
	}
	
	//List from request
	public Request[] get_list() {
		return this.listRequests;
	}
	
	public void set_name(String name) {
		this.name = name;
	}
	
	public String get_type() {
		return this.type;
	}

	public abstract double calculateExpenses();
		
	public String get_name() {
		return this.name;
	}
	
	public void set_list(int i, Request r){
		this.listRequests[i] = r;
	}
	
	
	
}
