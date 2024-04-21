package jeu;

import java.util.Set;
import java.util.TreeSet;

import cartes.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NavigableSet;

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
	
	public void inscrire(Joueur... joueurs) {
		for(Joueur j : joueurs) {
			this.joueurs.add(j);
		}
	}
	
	public void remplirSabot(JeuDeCartes jeu) {
		List<Carte> liste = jeu.getListeCartes();
		ListIterator<Carte> listeIterator = liste.listIterator();
		while(listeIterator.hasNext()) {
			Carte carte = listeIterator.next();
			listeIterator.remove();
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
	        	if(!sabotEstVide()) {
	        		Carte carte = sabot.piocher();
	        		joueur.getMain().prendre(carte);
	        	}
	        }
	    }
	}
	
	public void jouerTour(Joueur joueur) {
		String nom = joueur.getNom();
		System.out.print(nom+"\n");
		MainAsList main = joueur.getMain();
		Carte carte = joueur.prendreCarte(sabot);
        System.out.println("\t"+sabot.getNbCartes());
        if (carte != null) {
        	System.out.println("\t Pioche : " + carte);
            System.out.println("\t"+main);
            Coup coup = joueur.choisirCoup(joueurs);
            Carte carteCoup = coup.getCarte();
            joueur.retirerDeLaMain(carteCoup);
            if (coup.getCible() == null) {
                sabot.ajouterCarte(carteCoup);
                System.out.println("\t Coup  : " + coup);
            } else {
                coup.getCible().getZoneDeJeu().deposer(carteCoup);
                System.out.println("\t Déposer la carte '" + carteCoup + "' dans la zone de jeu de " + coup.getCible().getNom());
            }
        } else {
            System.out.println("Le sabot est vide, le tour est terminé.");
            return;
        }
	}
	
	public List<Joueur> classement() {
		Comparator<Joueur> comparateur = new Comparator<>() {

			@Override
			public int compare(Joueur j1, Joueur j2) {
				ZoneDeJeu z1 = j1.getZoneDeJeu();
				ZoneDeJeu z2 = j2.getZoneDeJeu();
				int d1 = z1.donnerKmParcourus();
				int d2 = z2.donnerKmParcourus();
				return d1-d2;
			}
			
		};
	    NavigableSet<Joueur> classementSet = new TreeSet<>(comparateur);
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
