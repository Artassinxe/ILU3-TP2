package jeu;

import java.util.Set;
import java.util.TreeSet;

import cartes.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class Jeu {

	private Set<Joueur> joueurs;
	private Iterator<Joueur> joueurIterator;
	private Sabot sabot;
	
	public Jeu() {
		this.joueurs = new LinkedHashSet<>();
		this.sabot = new Sabot(106);
		this.joueurIterator = this.joueurs.iterator();
	}
	
	public Joueur donnerJoueurSuivant() {
        if (joueurIterator == null || !joueurIterator.hasNext()) {
            this.joueurIterator = joueurs.iterator();
        }
        return joueurIterator.next();
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
	
	public boolean sabotEstVide() {
		return this.sabot.estVide();
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
	
	public void jouerTour(Joueur joueur) {
	        Carte carte = sabot.piocher();
	        System.out.println(sabot.getPioche().length);
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
	
	public List<Joueur> classement() {
	    Comparator<Joueur> comparateur = Comparator.comparingInt(joueur -> joueur.getZoneDeJeu().donnerKmParcourus());
	    Set<Joueur> classementSet = new TreeSet<>(comparateur);
	    classementSet.addAll(this.joueurs);
	    List<Joueur> classement = new ArrayList<>(classementSet);
	    return classement;
	}

	public List<Joueur> lancer() {
		Boolean jouer = !this.sabotEstVide();
		Joueur joueur = this.donnerJoueurSuivant();
		while(jouer) {
			this.jouerTour(joueur);
			jouer = !this.sabotEstVide() && (joueur.getZoneDeJeu().donnerKmParcourus() < 1000);
			joueur = this.donnerJoueurSuivant();
		}
		List<Joueur> classement = this.classement();
		System.out.println(classement.get(classement.size()-1));
		return classement;
	}
	
	public Sabot getSabot() {
		return this.sabot;
	}

	
}
