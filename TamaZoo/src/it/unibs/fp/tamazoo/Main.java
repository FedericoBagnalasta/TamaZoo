package it.unibs.fp.tamazoo;

import it.unibs.fp.mylib.*;

public class Main {

	public static void main(String[] args) {
		
	System.out.println("Benvenuto nel TamaZoo");
	
	String [] voci = {"Dai biscotti ai Tamagotchi dello Zoo", "Dai carezze ai Tamagotchi dello Zoo"};
	
	TamaZoo zoo = new TamaZoo();
	
	System.out.println(zoo.toString());
	
	int scelta = 0;
	MyMenu menu = new MyMenu("Scegli un opzione: ", voci);
	do {
		
		scelta = menu.scegli();
		
		switch(scelta){
			/**
			 * Case 1: Da biscotti a tutti i Tamagotchi dello zoo
			 */
			case 1:
				zoo.riceviBiscottiZoo();
				break;
			/**
			 * Case 2: Da carezze a tutti i Tamagotchi dello zoo	
			 */
			case 2:
				zoo.riceviCarezzeZoo();
				break;
			default:
				break;
			
		}
		
		System.out.println(zoo.toString());
		

	}while(scelta != 0 ); //SE MUOIONO TUTTI ESCI
	

	}
}	
