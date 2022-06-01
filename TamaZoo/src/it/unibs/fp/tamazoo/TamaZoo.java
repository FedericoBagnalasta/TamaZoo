package it.unibs.fp.tamazoo;

import java.util.ArrayList;
import it.unibs.fp.mylib.*;

public class TamaZoo {
	
	private static final String MORTE_DI_TUTTI_I_TAMAGOTCHI = "Tutti i Tamagotchi del tuo Zoo sono morti";
	private static final String NOME_TAMAGOTCHI = "Come vuoi chiamare il tuo Tamagotchi?";
	private static final String NUMERO_TAMAGOTCHI_DA_CREARE = "Quanti Tamagotchi vuoi avere?";
	private ArrayList <Tamagotchi> zoo = new ArrayList <Tamagotchi> ();

	private int tipoTama = -1;
		
	/**
	 * Metodo che permette all'utente di scegliere un numero di tamagotchi da creare
	 */
	public TamaZoo() {	
		int numTama = InputDati.leggiIntero(NUMERO_TAMAGOTCHI_DA_CREARE);
		
		for(int i = 0; i < numTama; i++) {
			tipoTama = NumeriCasuali.estraiIntero(0, 2);
			zoo.add(creaTama());
			}	
		}
	
	/**
	 * Metodo che crea un Tamagotchi di un tipo precedentemente estratto casualmente
	 * @return un oggetto Tamagotchi di tipo casuale
	 */
	private Tamagotchi creaTama() {
			String nome = InputDati.leggiStringa(NOME_TAMAGOTCHI);
			int gradoAffettivo = NumeriCasuali.estraiIntero(20, 99);
			int gradoSazieta = NumeriCasuali.estraiIntero(20, 99);
			
		switch(tipoTama) {
			//Creazione TamaBase
			case 0:
				return new Tamagotchi(nome, gradoAffettivo, gradoSazieta);
			//Creazione TamaTriste
			case 1: 
				return new TamaTriste (nome, gradoSazieta);	
			//Creazione TamaGordo
			case 2: 
				return new TamaGordo (nome, gradoSazieta);			
		}
		return null;			
	}
	
	/**
	 * Metodo che assegna a tutti i tamagotchi dello zoo un numero casuale di biscotti
	 */
	public void riceviBiscottiZoo() {
		int biscottiRandom = NumeriCasuali.estraiIntero(1, 10);
		
		for(int i = 0; i < zoo.size(); i++) {
			zoo.get(i).riceviBiscotti(biscottiRandom);
		}
	}
	
	/**
	 * Metodo che assegna a tutti i tamagotchi dello zoo un numero casuale di carezze
	 */	
	public void riceviCarezzeZoo() {	
	int carezzeRandom = NumeriCasuali.estraiIntero(1, 10);
		
		for(int i = 0; i < zoo.size(); i++) {
			zoo.get(i).riceviCarezze(carezzeRandom);
		}	
	}
	
	/**
	 * Metodo che rimuove un tamagotchi dallo zoo in caso di morte
	 */
	public void morteElementoZoo() {	
		for(int i = 0; i < zoo.size(); i++) {
			if(zoo.get(i).sonoMorto()) {
				zoo.remove(i);
				i--;
			}
		}
	}
	
	/**
	 * Metodo che verifica la morte di tutti i tamagotchi dello zoo
	 * @return false se tutti i Tamagotchi dello zoo sono morti
	 */
	public boolean morteZoo() {
		if (zoo.size() == 0) {
			System.out.println(MORTE_DI_TUTTI_I_TAMAGOTCHI);
			return false;
		}
		return true;
	}
	
	/**
	 * Metodo che restituisce il nome e lo stato di tutti i tamagotchi dello zoo
	 */
	public String toString() {
		StringBuffer elencoZoo = new StringBuffer();
		
		for(int i = 0; i < zoo.size(); i++) {
			elencoZoo.append(String.format("%s\n", zoo.get(i).toString()));
		}
		
		return elencoZoo.toString();
	}
}
