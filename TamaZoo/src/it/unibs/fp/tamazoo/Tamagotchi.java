package it.unibs.fp.tamazoo;
import it.unibs.fp.mylib.EstrazioniCasuali;

public class Tamagotchi {
	private static final String I_VALORI_INSERITI_NON_SONO_PERMESSI = "I valori inseriti non sono permessi";
	private static final String TIPO_BASE = "\nTipo: TamaBase";
	private static final String SPAZIO_PER_DELIMITARE = "\n======================================";
	public static final String NUMERO_DI_CAREZZE_DATE = "\nIl numero di carezze date al Tamagotchi e': %d\n";
	public static final String NUMERO_DI_BISCOTTI_DATI = "\nIl numero di biscotti dati al Tamagotchi e': %d\n";
	public static final int MAX_CAREZZE = 20;
	public static final int MIN_CAREZZE = 0;
	public static final int MAX_BISCOTTI = 20;
	public static final int MIN_BISCOTTI = 0;
	public static final double FATTORE_AUMENTO_SAZIETA = 0.1;
	public static final int FATTORE_DECREMENTO_SODDISFAZIONE = 4;
	public static final int FATTORE_DECREMENTO_SAZIETA = 2;
	public static final int TRISTEZZA_MAX_SAZIETA = 80;
	public static final int TRISTEZZA_MIN_SAZIETA = 30;
	public static final int TRISTEZZA_MIN_SODDISFAZIONE = 30;
	public static final int MORTE_MIN_SODDISFAZIONE = 0;
	public static final int MORTE_MIN_SAZIETA = 0;
	public static final int MORTE_MAX_SAZIETA = 100;
	public static final int MIN_SAZIETA = 0;
	public static final int MAX_SODDISFAZIONE = 100;
	public static final int MIN_SODDISFAZIONE = 0;
	public static final int MAX_SAZIETA = 100;
	public final String TRISTE = "\nSono triste!";
	public final String MORTO = "\nSono morto";
	public static final String SODDISFAZIONE = "\nSoddisfazione:";
	public static final String SAZIETA = "\nSazietà:";
	public static final String NOME = "\nNome:";
	private String nome;
	private double gradoSazieta;
	private double gradoAffettivo;
	
	/**
	 * Costruttore della classe Tamagotchi e TamaGordo
	 * @param nome
	 * @param gradoAffetivo
	 * @param gradoSazieta
	 */
	public Tamagotchi(String nome, int gradoAffettivo, int gradoSazieta){
		if(gradoAffettivo < 0 || gradoSazieta < 0) throw new IllegalArgumentException (I_VALORI_INSERITI_NON_SONO_PERMESSI);
		this.nome = nome;
		this.gradoAffettivo = gradoAffettivo;
		this.gradoSazieta = gradoSazieta;
	}
	
	/**
	 * Costruttore per TamaTriste
	 * @param nome
	 * @param gradoSazieta
	 */
	public Tamagotchi(String nome, int gradoSazieta) {                
		this.nome = nome;
		this.gradoSazieta = gradoSazieta;
	}
	
	/**
	 * Metodo per assegnare un numero scelto dall'utente di biscotti
	 * @param numBiscotti
	 */
	public void riceviBiscotti(int numBiscotti){
		for(int i = 0; i < numBiscotti; i++) {
			gradoSazieta=Math.min(MAX_SAZIETA, gradoSazieta+gradoSazieta*FATTORE_AUMENTO_SAZIETA);
		}
		gradoAffettivo=Math.max(MIN_SODDISFAZIONE, gradoAffettivo-numBiscotti/FATTORE_DECREMENTO_SODDISFAZIONE);
	}
	
	/**
	 * Metodo per assegnare un numero scelto dall'utente di carezze
	 * @param numCarezze
	 */
	public void riceviCarezze(int numCarezze) {
		gradoAffettivo=Math.min(MAX_SODDISFAZIONE, gradoAffettivo+numCarezze);
		gradoSazieta=Math.max(MIN_SAZIETA, gradoSazieta-numCarezze/FATTORE_DECREMENTO_SAZIETA);
	}
	
	/**
	 * Metodo per assegnare un numero casuale di biscotti
	 */
	public void riceviBiscotti(){
		int numBiscotti = EstrazioniCasuali.estraiIntero(MIN_BISCOTTI, MAX_BISCOTTI);
		for(int i = 0; i < numBiscotti; i++) {
			gradoSazieta=Math.min(MAX_SAZIETA, gradoSazieta+gradoSazieta*FATTORE_AUMENTO_SAZIETA);
		}
		gradoAffettivo=Math.max(MIN_SODDISFAZIONE, gradoAffettivo-numBiscotti/FATTORE_DECREMENTO_SODDISFAZIONE);
		System.out.printf(NUMERO_DI_BISCOTTI_DATI, numBiscotti);
	}

	/**
	 * Metodo per assegnare un numero casuale di carezze
	 */
	public void riceviCarezze() {
		int numCarezze = EstrazioniCasuali.estraiIntero(MIN_CAREZZE, MAX_CAREZZE);
		gradoAffettivo=Math.min(MAX_SODDISFAZIONE, gradoAffettivo+numCarezze);
		gradoSazieta=Math.max(MIN_SAZIETA, gradoSazieta-numCarezze/FATTORE_DECREMENTO_SAZIETA);
		System.out.printf(NUMERO_DI_CAREZZE_DATE, numCarezze);
	}
	
	/**
	 * Metodo per verificare la morte di un Tamagotchi
	 */
	public boolean sonoMorto() {
		return gradoSazieta == MORTE_MAX_SAZIETA || gradoSazieta == MORTE_MIN_SAZIETA || gradoAffettivo == MORTE_MIN_SODDISFAZIONE;
	}
	
	public double getGradoSazieta() {
		return gradoSazieta;
	}

	public double getGradoAffettivo() {
		return gradoAffettivo;
	}
	
	public void setGradoSazieta(double gradoSazieta) {
		this.gradoSazieta = gradoSazieta;
	}

	public void setGradoAffettivo(double gradoAffettivo) {
		this.gradoAffettivo = gradoAffettivo;
	}

	public String getNome() {
		return nome;
	}
	
	/**
	 * Metodo per verificare se un Tamagotchi e' triste
	 * @return
	 */
	public boolean sonoTriste() {
		return(gradoAffettivo<TRISTEZZA_MIN_SODDISFAZIONE || gradoSazieta<TRISTEZZA_MIN_SAZIETA || gradoSazieta>TRISTEZZA_MAX_SAZIETA);
	}
	
	/**
	 * Metodo che restituisce il nome e lo stato del Tamagotchi
	 */
	public String toString() {
	StringBuffer descrizione=new StringBuffer();
			gradoSazieta = (double) (Math.round(gradoSazieta*100.0)/100.0);
			gradoAffettivo = (double) (Math.round(gradoAffettivo*100.0)/100.0);
			descrizione.append(SPAZIO_PER_DELIMITARE);
			descrizione.append(NOME+nome);
			descrizione.append(TIPO_BASE);
			descrizione.append(SODDISFAZIONE+gradoAffettivo);
			descrizione.append(SAZIETA+gradoSazieta);
			if(sonoTriste()) descrizione.append(TRISTE);
			if(sonoMorto()) descrizione.append(MORTO);
			descrizione.append(SPAZIO_PER_DELIMITARE);
			return descrizione.toString();		
	}
}
