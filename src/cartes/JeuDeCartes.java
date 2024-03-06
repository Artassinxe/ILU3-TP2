package cartes;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Arrays;

public class JeuDeCartes {
	private Carte[] typesDeCartes;
	private ArrayList<Carte> listeCartes = new ArrayList<>();
	
	public JeuDeCartes() {
		this.typesDeCartes = new Carte[19];
		//Bottes
		typesDeCartes[0] = new Botte(1,Type.FEU);
		typesDeCartes[1] = new Botte(1,Type.ESSENCE);
		typesDeCartes[2] = new Botte(1,Type.CREVAISON);
		typesDeCartes[3] = new Botte(1,Type.ACCIDENT);
		//Attaques
		typesDeCartes[4] = new Attaque(5,Type.FEU);
		typesDeCartes[5] = new Attaque(3,Type.ESSENCE);
		typesDeCartes[6] = new Attaque(3,Type.CREVAISON);
		typesDeCartes[7] = new Attaque(3,Type.ACCIDENT);
		//Début limite
		typesDeCartes[8] = new DebutLimite(4);
		//Parades
		typesDeCartes[9] = new Parade(14,Type.FEU);
		typesDeCartes[10] = new Parade(6,Type.ESSENCE);
		typesDeCartes[11] = new Parade(6,Type.CREVAISON);
		typesDeCartes[12] = new Parade(6,Type.ACCIDENT);
		//Fin limite
		typesDeCartes[13] = new FinLimite(6);
		//Bornes
		typesDeCartes[14] = new Borne(10,25);
		typesDeCartes[15] = new Borne(10,50);
		typesDeCartes[16] = new Borne(10,75);
		typesDeCartes[17] = new Borne(12,100);
		typesDeCartes[18] = new Borne(4,200);
		
		for (Carte carte : typesDeCartes) {
			int nbCarte = carte.nombreCarte;
			carte.setNombreCarte(1);
			for (int i = 0 ; i<nbCarte ; i++) {
				listeCartes.add(carte);
			}
		}
	}
	
	public int checkCount() {
		return this.listeCartes.size();
	}
	
	public int checkCount(Type type) {
		int count = 0;
		for (Carte carte : this.listeCartes) {
			if (carte instanceof Probleme && (((Probleme) carte).getType() == type))
				count++;
		}
		return count;
	}
	
	public int checkCount(Class<? extends Carte> type) {
	    int count = 0;
	    for (Carte carte : this.listeCartes) {
	        if (type.isInstance(carte)) {
	            count++;
	        }
	    }
	    return count;
	}


	/**
	 * @return the typesDeCartes
	 */
	public Carte[] getTypesDeCartes() {
		return typesDeCartes;
	}

	/**
	 * @return the listeCartes
	 */
	public ArrayList<Carte> getListeCartes() {
		return listeCartes;
	}

}
