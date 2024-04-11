package jeu;

import cartes.*;

public class Coup {
	
	private Carte carte;
	private Joueur cible;
	
	public Coup(Carte carte, Joueur cible) {
	    if (carte == null) {
	        throw new IllegalArgumentException("La carte ne peut pas être null");
	    }
	    this.carte = carte;
	    this.cible = cible;
	}

	
	@Override
	public int hashCode() {
		return cible == null ? 
			carte.toString().hashCode() : 
			carte.toString().hashCode() + cible.getNom().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof Coup)) return false;
		Coup toComp = ((Coup)obj);
		return (toComp.getCible() == null && cible == null) ? 
				toComp.getCarte().equals(carte) : 
				toComp.getCarte().equals(carte) && toComp.getCible().equals(cible);
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(carte);
	    sb.append(", Cible : ");
	    sb.append(cible != null ? cible.getNom() : "Aucune");
	    return sb.toString();
	}
	
	Boolean estValide(Joueur joueur) {
		return (!joueur.equals(cible) && (carte instanceof Attaque || carte instanceof DebutLimite));
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
