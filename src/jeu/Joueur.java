package jeu;
import cartes.*;
import java.util.*;


public class Joueur {
	
	private String nom;
	private MainAsList main;
	private List<DebutLimite> piledebutLimite;
	private List<FinLimite> pileFinLimite;
	private List<Bataille> pileBataille;
	public Collection<Borne> getCollectionBorne() {
		return collectionBorne;
	}

	public void setCollectionBorne(Collection<Borne> collectionBorne) {
		this.collectionBorne = collectionBorne;
	}

	public void setMain(MainAsList main) {
		this.main = main;
	}

	public void setPiledebutLimite(List<DebutLimite> piledebutLimite) {
		this.piledebutLimite = piledebutLimite;
	}

	public void setPileFinLimite(List<FinLimite> pileFinLimite) {
		this.pileFinLimite = pileFinLimite;
	}

	private Collection<Borne> collectionBorne;
	private Set<Botte> ensembleBotte;
	
	public Joueur(String nom) {
		super();
		this.nom = nom;
		this.main = new MainAsList();
		this.piledebutLimite = new ArrayList<>();
		this.pileFinLimite = new ArrayList<>();
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
	/**
	 * @return the piledebutLimite
	 */
	public List<DebutLimite> getPiledebutLimite() {
		return piledebutLimite;
	}
	/**
	 * @param piledebutLimite the piledebutLimite to set
	 */
	public void setPiledebutLimite(ArrayList<DebutLimite> piledebutLimite) {
		this.piledebutLimite = piledebutLimite;
	}
	/**
	 * @return the pileFinLimite
	 */
	public List<FinLimite> getPileFinLimite() {
		return pileFinLimite;
	}
	/**
	 * @param pileFinLimite the pileFinLimite to set
	 */
	public void setPileFinLimite(ArrayList<FinLimite> pileFinLimite) {
		this.pileFinLimite = pileFinLimite;
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
	
	
	

}
