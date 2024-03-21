package jeu;
import cartes.*;
import java.util.*;


public class Joueur {
	
	private String nom;
	private ArrayList<DebutLimite> piledebutLimite;
	private ArrayList<FinLimite> pileFinLimite;
	private ArrayList<Bataille> pileBataille;
	private ArrayList<Borne> pileBorne;
	private HashSet<Botte> ensembleBotte;
	
	public Joueur(String nom) {
		super();
		this.nom = nom;
		this.piledebutLimite = new ArrayList<>();
		this.pileFinLimite = new ArrayList<>();
		this.pileBataille = new ArrayList<>();
		this.pileBorne = new ArrayList<>();
		this.ensembleBotte = new HashSet<>();
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
	public ArrayList<DebutLimite> getPiledebutLimite() {
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
	public ArrayList<FinLimite> getPileFinLimite() {
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
	public ArrayList<Bataille> getPileBataille() {
		return pileBataille;
	}
	/**
	 * @param pileBataille the pileBataille to set
	 */
	public void setPileBataille(ArrayList<Bataille> pileBataille) {
		this.pileBataille = pileBataille;
	}
	/**
	 * @return the pileBorne
	 */
	public ArrayList<Borne> getPileBorne() {
		return pileBorne;
	}
	/**
	 * @param pileBorne the pileBorne to set
	 */
	public void setPileBorne(ArrayList<Borne> pileBorne) {
		this.pileBorne = pileBorne;
	}
	/**
	 * @return the ensembleBotte
	 */
	public HashSet<Botte> getEnsembleBotte() {
		return ensembleBotte;
	}
	/**
	 * @param ensembleBotte the ensembleBotte to set
	 */
	public void setEnsembleBotte(HashSet<Botte> ensembleBotte) {
		this.ensembleBotte = ensembleBotte;
	}
	
	
	

}
