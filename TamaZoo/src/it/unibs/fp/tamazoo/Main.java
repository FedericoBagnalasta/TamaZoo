package it.unibs.fp.tamazoo;

import it.unibs.fp.mylib.*;

public class Main {

	public static void main(String[] args) {
		
	System.out.println("Benvenuto nel TamaZoo");
	
	TamaZoo zoo = new TamaZoo();
	
	String [] voci = {};
	int scelta = 0;
	MyMenu menu = new MyMenu("Scegli un opzione: ", voci);
	do {
		
		scelta = menu.scegli();
		
		switch(scelta){
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
			
		}

	}while(scelta != 0 );
	

	}
}	
