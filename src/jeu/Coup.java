package jeu;

import cartes.*;

public class Coup {
	
	private Carte carte;
	private Joueur cible;
	
	public Coup(Carte carte, Joueur cible) {
		this.carte = carte;
		this.cible = cible;
		//la cible peut être null, ce qui signifie que le coup consiste à remettre la carte dans le sabot.
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public Joueur getCible() {
		return cible;
	}

	public void setCible(Joueur cible) {
		this.cible = cible;
	}
	
	
	
}
