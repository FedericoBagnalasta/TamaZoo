package it.unibs.fp.tamazoo;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class TamaGordo extends Tamagotchi{
	
	private double gradoSoddisfazione = 100.0;

	public TamaGordo(String nome, int gradoAffettivo) {
		super(nome, gradoAffettivo);
	}
	
	@Override
	public void riceviCarezze() {
		int numCarezze = EstrazioniCasuali.estraiIntero(MIN_CAREZZE, MAX_CAREZZE);
		gradoAffettivo=Math.min(MAX_SODDISFAZIONE, getSoddisfazione()+numCarezze);                      //Non so come risolvere
		gradoSazieta=Math.max(MIN_SAZIETA, 2*(getSazieta()-numCarezze/FATTORE_DECREMENTO_SAZIETA));             //Non so come risolvere
		System.out.printf(NUMERO_DI_CAREZZE_DATE, numCarezze);
	}
	
	@Override
	public boolean sonoMorto() {
		return getSazieta() == MORTE_MIN_SAZIETA;
	}
	
	@Override
	public boolean sonoTriste() {
		return(getSazieta() < TRISTEZZA_MIN_SAZIETA);
	}
	
	public double getSoddisfazione() {        //Non so se sia da mettere in Override
		return gradoSoddisfazione;
	}

	@Override
	public String toString() {
	StringBuffer descrizione=new StringBuffer();
			gradoSazieta = (double) (Math.round(getSazieta()*100.0)/100.0);
			descrizione.append(NOME+getNome());                                   //Non so come risolvere
			descrizione.append(SODDISFAZIONE+getSoddisfazione());
			descrizione.append(SAZIETA+getSazieta());
			if(sonoTriste()) descrizione.append(TRISTE);
			if(sonoMorto()) descrizione.append(MORTO);
			return descrizione.toString();
	}
}
