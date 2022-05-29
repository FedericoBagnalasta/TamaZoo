package it.unibs.fp.tamazoo;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class TamaTriste extends Tamagotchi {

	public TamaTriste(String nome, int gradoSazieta) {
		super(nome, gradoSazieta);
	}
	
	@Override
	public boolean sonoMorto() {
		return getSazieta() == MORTE_MAX_SAZIETA || getSazieta() == MORTE_MIN_SAZIETA;
	}
	
	@Override
	public String toString() {
	StringBuffer descrizione=new StringBuffer();
			gradoSazieta = (double) (Math.round(getSazieta()*100.0)/100.0);      //Non so come risolvere
			descrizione.append(NOME+getNome());
			descrizione.append(SODDISFAZIONE+getSoddisfazione());
			descrizione.append(SAZIETA+getSazieta());
			descrizione.append(TRISTE);
			if(sonoMorto()) descrizione.append(MORTO);
			return descrizione.toString();		
	}
}
