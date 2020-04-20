package lab2;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		//Inicializar datos
		Animal list[] = new Animal[0];
		list [0] = new Dogs("perro",20, "h", true,  true, "azul", 12, true, false);
		Shelter refugio = new Shelter("refugio", "Puertollano", lista[]);
		
		
		//Main loop
		menu();

	}
	
	public static void menu() {
		String choose;
		Scanner sc = new Scanner(System.in);
		System.out.println("This is the main menu of the program, choose an option:\n");
		System.out.println("1. Show all information of the animals at the shelter");
		System.out.println("2. Make a request");
		System.out.println("3. Consult the list of request for the adoption of an animal");
		System.out.println("4. Calculate the annual expenses");
		System.out.println("5. Calculate the cost of neutering programme");
		System.out.println("6. Estimate the amount of dogs food for this week");
		System.out.println("7. Calculate the funding provided by the Town Council");
		
		choose = sc.next();
		
		switch (choose) {
		
		case "2":
			
			
		}
		
		
	}
	
	public static void make_request(Animal [] list) {
		Scanner sc = new Scanner(System.in);
		int choose = 0;
		int type = 0;
		System.out.println("These are the available animals to request for");
		for (int i=0; i<list.length; i++) {
			System.out.print(i +". " + list[i].get_name());
		}
		System.out.println("Choose one");
		choose = sc.nextInt();
		System.out.println("Type 1 for foster, 2 for adopt");
		type = sc.nextInt();
		for(int i=0; i<10; i++) {
			if(list[choose].get_list() != null) {
				Request r = new Request ("Alvaro", 123);
				list[choose].set_list(choose, r);
			}
		}
	}
}


