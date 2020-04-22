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

	
	
	public void setType(String new_type) {
		this.type = new_type;
	}
	
	
	
	public String toString() {
		return "Type: "+type;
	}
	
}
