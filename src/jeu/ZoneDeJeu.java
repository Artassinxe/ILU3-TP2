package jeu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cartes.*;

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
	
	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Borne) {
	    	return !estBloque() && ((Borne) carte).getKm() < donnerLimitationVitesse() && sommeBorne() <= 1000;
	    } else if (carte instanceof DebutLimite) {
	        return !ensembleBotte.contains(Cartes.PRIORITAIRE) && donnerLimitationVitesse() == 200;
	    } else if (carte instanceof FinLimite) {
	        return !ensembleBotte.contains(Cartes.PRIORITAIRE) && donnerLimitationVitesse() == 50;
	    } else if (carte instanceof Bataille) {
	        return estDepotAutoriseeBatailleCase(carte);
	    }
	    return carte instanceof Botte;
	}
	
	private boolean estDepotAutoriseeBatailleCase(Carte carte) {
		Type carteType = ((Bataille) carte).getType();
		Bataille top;
        if (pileBataille.isEmpty()) {
        	top = ensembleBotte.contains(Cartes.PRIORITAIRE) || carte.equals(Cartes.FEU_ROUGE) ? Cartes.FEU_VERT : Cartes.FEU_ROUGE;
        } else {
        	top = pileBataille.get(pileBataille.size() - 1);
        }
        if (top instanceof Attaque && carte instanceof Parade) {
        	Type topType = top.getType();
        	return (carteType == topType) && !this.ensembleBotte.contains(new Botte(1, topType));
        }
        else if (top instanceof Parade && carte instanceof Attaque){
        	return !this.ensembleBotte.contains(new Botte(1, carteType));
        }
		return false;
	}
	
	private int sommeBorne() {
	    int sommeBorne = 0;
	    for (Borne borne : collectionBorne) {
	        sommeBorne += borne.getKm();
	    }
	    return sommeBorne;
	}
	
	public boolean estBloque() {
	    List<Bataille> pileBataille = this.getPileBataille();
	    Set<Botte> ensembleBotte = this.getEnsembleBotte();
	    Boolean isPrioritaire = ensembleBotte.contains(Cartes.PRIORITAIRE);
	    
	    if (!pileBataille.isEmpty()) {
	    	Carte sommet = pileBataille.get(pileBataille.size() - 1);
	    	
	    	if (sommet instanceof Parade) {
	    		return !(sommet.equals(Cartes.FEU_VERT) || Boolean.TRUE.equals(isPrioritaire));
	    	}
	    	if (sommet instanceof Attaque) {
	    		if (Boolean.TRUE.equals(isPrioritaire)) {
	    			if (sommet.equals(Cartes.FEU_ROUGE)) {
	    				return false;
	    			}
    				for (Botte botte : this.getEnsembleBotte()) {
    			        if (botte.getType() == ((Probleme) sommet).getType()) {
    			            return false;
    			        }
    			    }
	    		}
	    	}
	    	return true;
	    }else return !Boolean.TRUE.equals(isPrioritaire);
	}
	
	public int donnerLimitationVitesse() {
		List<Limite> pileLimite = this.getPileLimite();
		Set<Botte> ensembleBotte = this.getEnsembleBotte();
	    if (pileLimite.isEmpty() || (pileLimite.get(pileLimite.size() - 1) instanceof FinLimite) || ensembleBotte.contains(Cartes.PRIORITAIRE)) {
	        return 200;
	    } else {
	        return 50;
	    }
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
