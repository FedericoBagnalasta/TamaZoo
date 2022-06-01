package it.unibs.fp.tamazoo;

import it.unibs.fp.mylib.*;

public class Main {

	private static final String SCEGLI_UN_OPZIONE = "Scegli un'opzione: ";
	private static final String DAI_CAREZZE_AI_TAMAGOTCHI_DELLO_ZOO = "Dai carezze ai Tamagotchi dello Zoo";
	private static final String DAI_BISCOTTI_AI_TAMAGOTCHI_DELLO_ZOO = "Dai biscotti ai Tamagotchi dello Zoo";
	private static final String MSG_BENVENUTO = "Benvenuto nel TamaZoo";

	public static void main(String[] args) {
		
	System.out.println(MSG_BENVENUTO);
	
	String [] voci = {DAI_BISCOTTI_AI_TAMAGOTCHI_DELLO_ZOO, DAI_CAREZZE_AI_TAMAGOTCHI_DELLO_ZOO};
	
	TamaZoo zoo = new TamaZoo();
	
	System.out.println(zoo.toString());
	
	int scelta = 0;
	MyMenu menu = new MyMenu(SCEGLI_UN_OPZIONE, voci);
		do {
		
			scelta = menu.scegli();
		
			switch(scelta){
				/**
				 * Case 1: Da' biscotti a tutti i Tamagotchi dello Zoo
				 */
				case 1:
					zoo.riceviBiscottiZoo();
					break;
				/**
				* Case 2: Da' carezze a tutti i Tamagotchi dello Zoo	
				*/
				case 2:
					zoo.riceviCarezzeZoo();
					break;
				default:
					break;			
			}
		
			System.out.println(zoo.toString());
		
			zoo.morteElementoZoo();

		}while(scelta != 0 && zoo.morteZoo());
	}
}	
