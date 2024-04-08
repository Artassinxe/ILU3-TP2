package jeu;

import java.util.Set;

import cartes.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Jeu {

	private Set<Joueur> joueurs;
	private Sabot sabot;
	
	public Jeu() {
		this.joueurs = new HashSet<>();
		this.sabot = new Sabot(106);
	}
	
	public void inscrire(Joueur joueur) {
		this.joueurs.add(joueur);
	}
	
	public void remplirSabot(JeuDeCartes jeu) {
		List<Carte> liste = jeu.getListeCartes();
		for (Iterator<Carte> iterator = liste.iterator(); iterator.hasNext();) {
			Carte carte = (Carte) iterator.next();
			sabot.ajouterCarte(carte);
		}
	}
	
	public void distribuerCartes() {
	    int NBCARTES = 6;

	    for (Joueur joueur : joueurs) {
	        for (int i = 0; i < NBCARTES; i++) {
	            Carte carte = sabot.piocher();
	            if (carte != null) {
	                joueur.getMain().prendre(carte);
	            } else {
	                return;
	            }
	        }
	    }
	}

	
}
