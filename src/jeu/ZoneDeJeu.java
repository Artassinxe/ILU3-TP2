package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Limite;

public class ZoneDeJeu {
	
	private List<Limite> pileLimite;
	private List<Bataille> pileBataille;
	private Collection<Borne> collectionBorne;
	private Set<Botte> ensembleBotte;
	
	public ZoneDeJeu() {
		this.pileLimite = new ArrayList<>();
		this.pileBataille = new ArrayList<>();
		this.collectionBorne = new HashSet<>();
		this.ensembleBotte = new HashSet<>();
	}
	
	public void ajouter(Limite limite) {
        pileLimite.add(limite);
    }

    public void ajouter(Bataille bataille) {
        pileBataille.add(bataille);
    }

    public void ajouter(Botte botte) {
        ensembleBotte.add(botte);
    }

    public void ajouter(Borne borne) {
        collectionBorne.add(borne);
    }
	
	/**
	 * @return the pileLimite
	 */
	public List<Limite> getPileLimite() {
		return pileLimite;
	}

	/**
	 * @param pileLimite the pileLimite to set
	 */
	public void setPileLimite(List<Limite> pileLimite) {
		this.pileLimite = pileLimite;
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
	 * @return the collectionBorne
	 */
	public Collection<Borne> getCollectionBorne() {
		return collectionBorne;
	}

	/**
	 * @param collectionBorne the collectionBorne to set
	 */
	public void setCollectionBorne(Collection<Borne> collectionBorne) {
		this.collectionBorne = collectionBorne;
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
}
