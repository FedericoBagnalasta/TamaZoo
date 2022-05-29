package it.unibs.fp.tamazoo;

public class TamaTriste extends Tamagotchi {

	public TamaTriste(String nome, int gradoSazieta) {
		super(nome, gradoSazieta);
	}
	
	
	
	@Override
	public void riceviBiscotti(int numBiscotti) {
		for(int i = 0; i < numBiscotti; i++) {
			setGradoSazieta(Math.min(MAX_SAZIETA, getGradoSazieta()+getGradoSazieta()*FATTORE_AUMENTO_SAZIETA));
		}
	}



	@Override
	public void riceviCarezze(int numCarezze) {
		setGradoSazieta(Math.max(MIN_SAZIETA, getGradoSazieta()-numCarezze/FATTORE_DECREMENTO_SAZIETA));
	}



	
	@Override
	public boolean sonoTriste() {
		return true;
	}



	@Override
	public boolean sonoMorto() {
		return getGradoSazieta() == MORTE_MAX_SAZIETA || getGradoSazieta() == MORTE_MIN_SAZIETA;
	}
	
	@Override
	public String toString() {
	StringBuffer descrizione=new StringBuffer();
			setGradoSazieta((double) (Math.round(getGradoSazieta()*100.0)/100.0));  
			descrizione.append("\n======================================");
			descrizione.append(NOME+getNome());
			descrizione.append("\nTipo: TamaTriste");
			descrizione.append(SAZIETA+getGradoSazieta());
			descrizione.append(TRISTE);
			if(sonoMorto()) descrizione.append(MORTO);
			descrizione.append("\n======================================");
			return descrizione.toString();		
	}
}
