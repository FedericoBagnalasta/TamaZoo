package it.unibs.fp.tamazoo;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class TamaGordo extends Tamagotchi{
	
	private double gradoSoddisfazione = 100.0;

	public TamaGordo(String nome, int gradoAffettivo, int gradoSazieta) {
		super(nome, gradoAffettivo, gradoSazieta);
	}
	
	//NUOVO COSTRUTTORE SENZA SODDISFAZIONE PER TEST
	
	@Override
	public void riceviCarezze(int numCarezze) {
		setGradoSazieta(Math.max(MIN_SAZIETA, 2*(getGradoSazieta()-numCarezze/FATTORE_DECREMENTO_SAZIETA)));
	}
	
	
	
	@Override
	public void riceviBiscotti(int numBiscotti) {
		for(int i = 0; i < numBiscotti; i++) {
			setGradoSazieta(Math.min(MAX_SAZIETA, getGradoSazieta()+getGradoSazieta()*FATTORE_AUMENTO_SAZIETA));
		}
	}

	@Override
	public boolean sonoMorto() {
		return getGradoSazieta() == MORTE_MIN_SAZIETA;
	}
	
	@Override
	public boolean sonoTriste() {
		return(getGradoSazieta() < TRISTEZZA_MIN_SAZIETA);
	}
	

	@Override
	public String toString() {
	StringBuffer descrizione=new StringBuffer();
			setGradoSazieta((double) (Math.round(getGradoSazieta()*100.0)/100.0));
			descrizione.append("\n======================================");
			descrizione.append(NOME+getNome());     
			descrizione.append("\nTipo: TamaGordo");
			descrizione.append(SODDISFAZIONE+getGradoSoddisfazione());
			descrizione.append(SAZIETA+getGradoSazieta());
			if(sonoMorto()) descrizione.append(MORTO);
			descrizione.append("\n======================================");
			return descrizione.toString();
	}
}
