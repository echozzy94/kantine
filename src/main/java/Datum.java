import java.util.*;
public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	/**
	 * Constructor
	 * @param dag De dag van de gewenste datum
	 * @param maand De maand van de gewenste datum
	 * @param jaar Het jaar van de gewenste datum
	 */
	public Datum(int dag, int maand, int jaar) {
		this.dag = 0;
		this.maand = 0;
		this.jaar = 0;
		if(bestaatDatum(dag, maand, jaar) == true) {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}

	public Datum() {
		dag = 0;
		maand = 0;
		jaar = 0;
	}

	/**
	 * Setter voor integer dag
	 * @param dag
	 */
	public void setDag(int dag) {
		this.dag = dag;
	}

	/**
	 * Setter voor integer maand
	 * @param maand
	 */
	public void setMaand(int maand) {
		this.maand = maand;
	}

	/**
	 * Setter voor integer jaar
	 * @param jaar
	 */
	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	/**
	 * Getter voor integer dag
	 * @return dag
	 */
	public int getDag() {
		return dag;
	}

	/**
	 * Getter voor integer maand
	 * @return maand
	 */
	public int getMaand() {
		return maand;
	}

	/**
	 * Getter voor integer jaar
	 * @return jaar
	 */
	public int getJaar() {
		return jaar;
	}

	/**
	 * Deze methode controleert of de ingevulde datum echt bestaat.
	 * @param dag De dag van de gewenste datum
	 * @param maand De maand van de gewenste datum
	 * @param jaar Het jaar van de gewenste datum
	 * @return False bij een onjuiste datum, True bij een correcte datum
	 */
	public boolean bestaatDatum(int dag, int maand, int jaar) {
		int vinden = maand;
		boolean found = false;
		int[] maand31 = {1, 3, 5, 7, 8, 10, 12};
		int[] maand30 = {4, 6, 9, 11};

		// Deze eerste loop controleert of het een maand met 30 of 31 dagen is.
		// Vervolgens wordt er gekeken of de datum wel of niet klopt.
		if (dag >= 1 && maand != 2 && jaar >= 1900 && jaar <= 2100){
			for (int n : maand31){
				if (n == vinden);
				found = true;
			} if (found == true && dag <= 31){
				return true;
			}
			for (int n : maand30){
				if (n == vinden);
				found = true;
			} if (found == true && dag <= 30){
				return true;
			}
			// Hier wordt er bij de maand februari gecontroleerd of het jaar wel of niet een schrikkeljaar is.
			// Vervolgens wordt er weer gekeken of de datum dan wel of niet klopt.
		} else if ( dag >= 1  && maand == 2 && jaar >= 1900 && jaar <= 2100){
			if (jaar % 4 == 0 && dag <= 29){
				return true;
			} else if (jaar % 400 == 0 && dag <= 29){
				return true;
			} else if (jaar % 4 != 0 && jaar % 100 != 0 && dag <= 28){
				return true;
			}
		}
		return false;
	}




	/**
	 * Getter voor Sting weergave van datum
	 *
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		// TODO
		String d = String.valueOf(dag);
		String m = String.valueOf(maand);
		String j = String.valueOf(jaar);
		return d + " " + m + " " + j;
	}

	/**
	 * toString methode voor output
	 * @return Dag, spatie, maand, spatie, jaar.
	 */
	@Override
	public String toString() {
		return "{" +
			" dag='" + getDag() + "'" +
			", maand='" + getMaand() + "'" +
			", jaar='" + getJaar() + "'" +
			"}";
	}


}
