package it.unibs.fp.tamazoo;

import java.util.ArrayList;
import it.unibs.fp.mylib.*;

public class TamaZoo {
	
private ArrayList <Tamagotchi> zoo = new ArrayList <Tamagotchi> ();
/**
 * Tipo di Tamagotchi:
 * 0 Tamagotchi
 * 1 TamaTriste
 * 2 TamaGordo
 */
private int tipoTama = -1;
	
public TamaZoo() {
	
	System.out.println("Quanti Tamagotchi vuoi avere?");
	
	int numTama = InputDati.leggiIntero();
	
	for(int i = 0; i <numTama; i++) {
		tipoTama = NumeriCasuali.estraiIntero(0, 3);
		zoo.add(creaTama());
		}
	
	
	}

/**
 * Metodo che crea un Tamagotchi di un tipo precedentemente estratto
 * @return
 */
private Tamagotchi creaTama() {
		String nome = InputDati.leggiStringa("Come vuoi chiamare il tuo Tamagotchi?");
		int gradoAffettivo = NumeriCasuali.estraiIntero(20, 100);
		int gradoSazieta = NumeriCasuali.estraiIntero(20, 100);
		
	switch(tipoTama) {	
		case 0:
			return new Tamagotchi(nome, gradoAffettivo, gradoSazieta);
		case 1: 
			return new TamaTriste (nome, gradoSazieta);	
		case 2: 
			return new TamaGordo (nome, gradoAffettivo);
			
	}
	return null;
			
}



}
/*
	String [] voci = {};
	
	MyMenu menu = new MyMenu ("Scegli un opzione", voci);
	int scelta = 0;
	
	do {
		
		scelta = menu.scegli();
		
		switch(scelta) {
			case 1: 
				break;
			case 2:
				break;
			default:
				break;
			}
		
		}while (scelta != 0);
	
	}	
*/