package it.unibs.fp.tamazoo;

public class TamaTriste extends Tamagotchi {

	private static final String TIPO_TAMA_TRISTE = "\nTipo: TamaTriste";
	private static final String SPAZIO_PER_DELIMITARE = "\n======================================";

	/**
	 * Costruttore per TamaTriste che richiama il costruttore della superclasse Tamagotchi
	 * @param nome
	 * @param gradoSazieta
	 */
	public TamaTriste(String nome, int gradoSazieta) {
		super(nome, gradoSazieta);
	}
	
	/**
	 * Metodo che assegna al TamaTriste un numero di biscotti precedentemente estratto casualmente
	 */
	@Override
	public void riceviBiscotti(int numBiscotti) {
		for(int i = 0; i < numBiscotti; i++) {
			setGradoSazieta(Math.min(MAX_SAZIETA, getGradoSazieta()+getGradoSazieta()*FATTORE_AUMENTO_SAZIETA));
		}
	}

	/**
	 * Metodo che assegna al TamaTriste un numero di carezze precedentemente estratto casualmente
	 */
	@Override
	public void riceviCarezze(int numCarezze) {
		setGradoSazieta(Math.max(MIN_SAZIETA, getGradoSazieta()-numCarezze/FATTORE_DECREMENTO_SAZIETA));
	}

	/**
	 * Metodo per verificare se il TamaTriste e' triste (lo e' sempre)
	 */
	@Override
	public boolean sonoTriste() {
		return true;
	}

	/**
	 * Metodo per verificare se il TamaTriste e' morto
	 */
	@Override
	public boolean sonoMorto() {
		return getGradoSazieta() == MORTE_MAX_SAZIETA || getGradoSazieta() == MORTE_MIN_SAZIETA;
	}
	
	/**
	 * Metodo che restituisce il nome e lo stato del TamaTriste
	 */
	@Override
	public String toString() {
	StringBuffer descrizione=new StringBuffer();
			setGradoSazieta((double) (Math.round(getGradoSazieta()*100.0)/100.0));  
			descrizione.append(SPAZIO_PER_DELIMITARE);
			descrizione.append(NOME+getNome());
			descrizione.append(TIPO_TAMA_TRISTE);
			descrizione.append(SAZIETA+getGradoSazieta());
			descrizione.append(TRISTE);
			if(sonoMorto()) descrizione.append(MORTO);
			descrizione.append(SPAZIO_PER_DELIMITARE);
			return descrizione.toString();		
	}
}
