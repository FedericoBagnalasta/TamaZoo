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
	
	int numTama = InputDati.leggiIntero("Quanti Tamagotchi vuoi avere?");
	
	for(int i = 0; i <numTama; i++) {
		tipoTama = NumeriCasuali.estraiIntero(0, 2);
		zoo.add(creaTama());
		}
	
	
	}

//NON CREARE CON VALORI CHE CAUSANO MORTE

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
			return new TamaGordo (nome, gradoSazieta);
			
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


public void morteElementoZoo() {
	
	for(int i = 0; i < zoo.size(); i++) {
		if(zoo.get(i).sonoMorto()) {
			zoo.remove(i);
		}
	}
}

public boolean morteZoo() {
	if (zoo.size() == 0) {
		System.out.println("I Tamagotchi del tuo Zoo sono morti");
		return false;
	}
	return true;
}


public String toString() {
	
	StringBuffer elencoZoo = new StringBuffer();
	
	for(int i = 0; i < zoo.size(); i++) {
		elencoZoo.append(String.format("%s\n", zoo.get(i).toString()));
	}
	
	return elencoZoo.toString();
}



}
