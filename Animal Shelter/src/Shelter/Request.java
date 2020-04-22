package Shelter;

public class Request {
	
	//global variable
	protected String type;
	
	//Constructor
	Request(String type){
		this.type = type;
	}
	
	
	//getters and setters
	public String getType() {
		return this.type;
	}

	
	
	public void setType(String newType) {
		this.type = newType;
	}
	
	
	
	public String toString() {
		return "Type: "+type;
	}
	
}
