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
	
	boolean estDepotAutorise(Carte carte, Joueur joueur) {
		if (carte instanceof Borne) {
			int sommeBorne = 0;
			for(Borne borne : collectionBorne) {
				sommeBorne+=borne.getKm();
			}
			if (!this.estBloque() && ((Borne) carte).getKm() < this.donnerLimitationVitesse() && sommeBorne <= 1000) {
				return true;
			}
		}
		if (carte instanceof Botte) {
			return true;
		}
		if (carte instanceof DebutLimite) {
			if (!this.ensembleBotte.contains(Cartes.PRIORITAIRE) && this.donnerLimitationVitesse() == 200) {
				return true;
			}
		}
		if (carte instanceof FinLimite) {
			if (!this.ensembleBotte.contains(Cartes.PRIORITAIRE) && this.donnerLimitationVitesse() == 50) {
				return true;
			}
		}
		if (carte instanceof Bataille) {
			Bataille top;
			int pileBatailleSize = this.pileBataille.size();
			if (pileBatailleSize == 0 && (this.ensembleBotte.contains(Cartes.PRIORITAIRE) || carte.equals(Cartes.FEU_ROUGE))) {
				top = Cartes.FEU_VERT;
			}else {
				top = this.pileBataille.get(pileBatailleSize-1);
				if (top instanceof Attaque) {
					// à completer
				}
			}
			
		}
		return true;
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
