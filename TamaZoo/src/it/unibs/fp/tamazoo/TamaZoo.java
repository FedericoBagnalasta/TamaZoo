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
		tipoTama = NumeriCasuali.estraiIntero(0, 2);
		zoo.add(creaTama());
		}
	
	
	}

/**
 * Metodo che crea un Tamagotchi di un tipo precedentemente estratto
 * @return
 */
private Tamagotchi creaTama() { //Da verificare che restituisca un oggetto Tamagotchi 
		String nome = InputDati.leggiStringa("Come vuoi chiamare il tuo Tamagotchi?");
		int gradoAffettivo = NumeriCasuali.estraiIntero(20, 100);
		int gradoSazieta = NumeriCasuali.estraiIntero(20, 100);
		
	switch(tipoTama) {	
		case 0:
			return new Tamagotchi(nome, gradoAffettivo, gradoSazieta);
		case 1: 
			return new TamaTriste (nome, gradoSazieta);	
		case 2: 
			return new TamaGordo (nome, 100, gradoSazieta);
			
	}
	return null;
			
}


public void riceviBiscottiZoo() {
	int biscottiRandom = NumeriCasuali.estraiIntero(0, 20);
	
	for(int i = 0; i < zoo.size(); i++) {
		zoo.get(i).riceviBiscotti(biscottiRandom);
	}
	
}

public void riceviCarezzeZoo() {
	
int carezzeRandom = NumeriCasuali.estraiIntero(0, 20);
	
	for(int i = 0; i < zoo.size(); i++) {
		zoo.get(i).riceviCarezze(carezzeRandom);
	}
	
}


public String toString() {
	
	StringBuffer elencoZoo = new StringBuffer();
	
	for(int i = 0; i < zoo.size(); i++) {
		elencoZoo.append(String.format("%s\n", zoo.get(i).toString()));
	}
	
	return elencoZoo.toString();
}



}
