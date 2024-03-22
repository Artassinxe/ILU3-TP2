package jeu;
import cartes.*;
import java.util.*;


public class Joueur {
	
	private String nom;
	private MainAsList main;
	private List<Limite> pileLimite;
	private List<Bataille> pileBataille;
	private Collection<Borne> collectionBorne;
	private Set<Botte> ensembleBotte;
	
	public Joueur(String nom) {
		super();
		this.nom = nom;
		this.main = new MainAsList();
		this.pileLimite = new ArrayList<>();
		this.pileBataille = new ArrayList<>();
		this.collectionBorne = new HashSet<>();
		this.ensembleBotte = new HashSet<>();
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
	
	public int getKm() {
		Collection<Borne> liste = collectionBorne;
		int distance = 0;
		for(Carte carte: liste) {
			if(carte instanceof Borne) {
				distance+=((Borne) carte).getKm();
			}
		}
		return distance;
	}
	
	
	 public int getLimite() {
		 Carte prio = new Botte(1,Type.VITESSE);
		 if(pileLimite.isEmpty() || ensembleBotte.contains(prio)) {
			 return 200;
		 }else if (pileLimite.get(0).equals(new FinLimite(0))) {
			 return 200;
		 }else return 50;
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
	
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Collection<Borne> getCollectionBorne() {
		return collectionBorne;
	}

	public void setCollectionBorne(Collection<Borne> collectionBorne) {
		this.collectionBorne = collectionBorne;
	}

	public void setMain(MainAsList main) {
		this.main = main;
	}
	
	/**
	 * @return the pileBataille
	 */
	public List<Bataille> getPileBataille() {
		return pileBataille;
	}
	/**
	 * @param pileBataille the pileBataille to set
	 */
	public void setPileBataille(List<Bataille> pileBataille) {
		this.pileBataille = pileBataille;
	}

	
	/**
	 * @return the ensembleBotte
	 */
	public Set<Botte> getEnsembleBotte() {
		return ensembleBotte;
	}
	/**
	 * @param ensembleBotte the ensembleBotte to set
	 */
	public void setEnsembleBotte(Set<Botte> ensembleBotte) {
		this.ensembleBotte = ensembleBotte;
	}

	public MainAsList getMain() {
		return main;
	}

	public List<DebutLimite> getPileLimite() {
		return pileLimite;
	}

	public void setPileLimite(List<DebutLimite> pileLimite) {
		this.pileLimite = pileLimite;
	}
	
	
	

}
