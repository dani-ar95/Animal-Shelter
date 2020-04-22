package Shelter;

import java.io.*;
import java.util.*;

public class leerFichero {
	public static void main(String []args) throws IOException{
		
		readAnimals("C:\\Users\\Daniel\\Documents\\UNIVERSIDAD\\Segundo cuatri\\Programación 2\\Lab\\Animales.txt");
		
	}

  public static void readAnimals (String cadena)throws IOException{	  
    File f=new File(cadena);
    Scanner sc = new Scanner (f);
    while (sc.hasNext()){
      char dogOrCat = sc.next().charAt(0);
      String name = sc.next();
      char gender = sc.next().charAt(0);
      int age = sc.nextInt();
      boolean sociable = sc.nextBoolean();
   	  boolean patrons = sc.nextBoolean();
   	  	if(dogOrCat == 'p') {
   	  		String breed = sc.next();
   	  		int size = sc.nextInt();
   	  		boolean pdb = sc.nextBoolean();
   	  		boolean leishmania = sc.nextBoolean();
   	  		System.out.println(dogOrCat+" "+name+" "+gender+" "+age+" "+sociable+" "+patrons+" "+breed+" "+size+" "+pdb+" "+leishmania);
   	  	}else {
   	  		boolean neutered = sc.nextBoolean();
   	  	System.out.println(dogOrCat+" "+name+" "+gender+" "+" "+age+" "+sociable+" "+patrons+" "+neutered);
   	  	}
    }
    sc.close();
  }  
}