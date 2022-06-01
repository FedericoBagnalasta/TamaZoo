package it.unibs.fp.tamazoo;

public class TamaGordo extends Tamagotchi{
	
	private static final String TIPO_TAMA_GORDO = "\nTipo: TamaGordo";
	private static final String SPAZIO_PER_DELIMITARE = "\n======================================";
	public static final int GRADO_AFFETTIVO_TAMAGORDO = 100;

	/**
	 * Costruttore per TamaGordo che richiama il costruttore della superclasse Tamagotchi
	 * @param nome
	 * @param gradoSazieta
	 */
	public TamaGordo(String nome, int gradoSazieta) {
		super(nome, GRADO_AFFETTIVO_TAMAGORDO, gradoSazieta);
	}
	
	/**
	 * Metodo che assegna al TamaGordo un numero di carezze precedentemente estratto casualmente
	 */
	@Override
	public void riceviCarezze(int numCarezze) {
		setGradoSazieta(Math.max(MIN_SAZIETA, getGradoSazieta()-2*numCarezze/FATTORE_DECREMENTO_SAZIETA));
	}
		
	/**
	 * Metodo che assegna al TamaGordo un numero di biscotti precedentemente estratto casualmente
	 */
	@Override
	public void riceviBiscotti(int numBiscotti) {
		for(int i = 0; i < numBiscotti; i++) {
			setGradoSazieta(Math.min(MAX_SAZIETA, getGradoSazieta()+getGradoSazieta()*FATTORE_AUMENTO_SAZIETA));
		}
	}
	
	/**
	 * Metodo per verificare se il TamaGordo e' morto
	 */
	@Override
	public boolean sonoMorto() {
		return getGradoSazieta() == MORTE_MIN_SAZIETA;
	}

	/**
	 * Metodo per verificare se il TamaGordo e' triste
	 */	
	@Override
	public boolean sonoTriste() {
		return(getGradoSazieta() < TRISTEZZA_MIN_SAZIETA);
	}
	
	/**
	 * Metodo che restituisce il nome e lo stato del TamaGordo
	 */
	@Override
	public String toString() {
	StringBuffer descrizione=new StringBuffer();
			setGradoSazieta((double) (Math.round(getGradoSazieta()*100.0)/100.0));
			descrizione.append(SPAZIO_PER_DELIMITARE);
			descrizione.append(NOME+getNome());     
			descrizione.append(TIPO_TAMA_GORDO);
			descrizione.append(SODDISFAZIONE+(float)GRADO_AFFETTIVO_TAMAGORDO);
			descrizione.append(SAZIETA+getGradoSazieta());
			if(sonoMorto()) descrizione.append(MORTO);
			descrizione.append(SPAZIO_PER_DELIMITARE);
			return descrizione.toString();
	}
}
