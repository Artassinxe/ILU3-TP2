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
	
	public void jouerTour() {
	    for (Joueur joueur : joueurs) {
	        Carte carte = sabot.piocher();
	        if (carte != null) {
	        	System.out.println("Le joueur " + joueur.getNom() + " a pioché " + carte);
	            System.out.println("Il a dans sa main : " + joueur.getMain());
	            Coup coup = joueur.choisirCoup(joueurs);
	            Carte carteCoup = coup.getCarte();
	            joueur.retirerDeLaMain(carteCoup);
	            if (coup.getCible() == null) {
	                sabot.ajouterCarte(carteCoup);
	                System.out.println("Il joue le coup " + coup);
	            } else {
	                coup.getCible().getZoneDeJeu().deposer(carteCoup);
	                System.out.println("Déposer la carte '" + carteCoup + "' dans la zone de jeu de " + coup.getCible().getNom());
	            }
	        } else {
	            System.out.println("Le sabot est vide, le tour est terminé.");
	            return;
	        }
	    }
	}


	
}
