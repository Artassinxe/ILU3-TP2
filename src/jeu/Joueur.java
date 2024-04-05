package jeu;
import cartes.*;
import java.util.*;


public class Joueur {
	
	private String nom;
	private MainAsList main;
	private ZoneDeJeu zoneDeJeu;

	public Joueur(String nom) {
		super();
		this.nom = nom;
		this.main = new MainAsList();
		this.zoneDeJeu = new ZoneDeJeu();
	}
	
	public void donner(Joueur joueur, Carte carte) {
		MainAsList mainJoueur = joueur.getMain();
		main.jouer(carte);
		mainJoueur.prendre(carte);
	}
	
	public Carte prendreCarte(List<Carte> sabot) {
		if(sabot.isEmpty()) {
			return null;
		}
		Carte carte = sabot.remove(0);
		main.prendre(carte);
		return carte;
	}
	
	public void deposer(Borne borne) throws IllegalArgumentException {
	    if (borne instanceof Borne) {
	        Collection<Borne> liste = zoneDeJeu.getCollectionBorne();
	        liste.add(borne);
	    } else {
	        throw new IllegalArgumentException("L'objet passé en paramètre n'est pas une instance de Borne");
	    }
	}
	
	public int donnerKmParcourus() {
		Collection<Borne> liste = zoneDeJeu.getCollectionBorne();;
		int distance = 0;
		for(Carte carte: liste) {
			if(carte instanceof Borne) {
				distance+=((Borne) carte).getKm();
			}
		}
		return distance;
	}
	
	public int donnerLimitationVitesse() {
		List pileLimite = zoneDeJeu.getPileLimite();
		Set<Botte> ensembleBotte = zoneDeJeu.getEnsembleBotte();
	    if (pileLimite.isEmpty() || (pileLimite.get(0) instanceof FinLimite) || ensembleBotte.contains(Cartes.PRIORITAIRE)) {
	        return 200;
	    } else {
	        return 50;
	    }
	}
	 
	public boolean estBloque() {
		boolean estBloque = true;
//		 estBloque = false si une des conditions suivantes est validée
//		 la pile de bataille est vide et il est prioritaire,
//		 ● le sommet est une parade de type FEU,
//		 ● le sommet est une parade et il est prioritaire,
//		 ● le sommet est une attaque de type FEU et il est prioritaire,
//		 ● le sommet est une attaque d’un autre type pour lequel il a une botte et il est prioritaire.
		return estBloque;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Joueur) {
			Joueur joueur = (Joueur) obj;
			return Objects.equals(this.nom, joueur.getNom());
		}
		return false;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setMain(MainAsList main) {
		this.main = main;
	}

	public MainAsList getMain() {
		return main;
	}
	
	public ZoneDeJeu getZoneDeJeu() {
		return zoneDeJeu;
	}

	public void setZoneDeJeu(ZoneDeJeu zoneDeJeu) {
		this.zoneDeJeu = zoneDeJeu;
	}
	
	
	
	
	

}
