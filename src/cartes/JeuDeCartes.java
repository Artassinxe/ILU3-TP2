package cartes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Utils;

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
		    int nbCarte = carte.getNombreCarte();
		    for (int i = 0; i < nbCarte; i++) {
		    	Carte carteToAdd;
		    	if (carte instanceof Attaque) {
		    		carteToAdd = new Attaque(1, ((Probleme) carte).getType());
		    	}else if (carte instanceof Parade) {
		    		carteToAdd = new Parade(1, ((Probleme) carte).getType());
		    	}else if (carte instanceof Botte) {
		    		carteToAdd = new Botte(1, ((Probleme) carte).getType());
		    	}else if (carte instanceof DebutLimite) {
		    		carteToAdd = new DebutLimite(1);
		    	}else if (carte instanceof FinLimite) {
		    		carteToAdd = new FinLimite(1);
		    	}else {
		    		carteToAdd = new Borne(1, ((Borne) carte).getKm());
		    	}
		        listeCartes.add(carteToAdd);
		    }
		}
		
		this.listeCartes = (ArrayList<Carte>) Utils.melanger(listeCartes);

	}
	
	@Override
	public String toString() {
		StringBuilder stringB = new StringBuilder();
		for(Carte carte : listeCartes) {
			stringB.append(carte.nombreCarte);
			stringB.append(' ');
			stringB.append(carte.toString()+'\n');
		}
		return stringB.toString();
	}
	
	public boolean checkCount() {
		for (Carte carte : typesDeCartes) {
			if (carte.nombreCarte != Collections.frequency(listeCartes, carte)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @return the listeCartes
	 */
	public List<Carte> getListeCartes() {
		return listeCartes;
	}


	public void setListeCartes(ArrayList<Carte> listeCartes) {
		this.listeCartes = listeCartes;
	}

}
