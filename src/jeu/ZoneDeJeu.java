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
	    	return !estBloque() && ((Borne) carte).getKm() <= donnerLimitationVitesse() && sommeBorne() <= 1000;
	    } else if (carte instanceof DebutLimite) {
	        return !ensembleBotte.contains(Cartes.PRIORITAIRE) && donnerLimitationVitesse() == 200;
	    } else if (carte instanceof FinLimite) {
	        return !ensembleBotte.contains(Cartes.PRIORITAIRE) && donnerLimitationVitesse() == 50;
	    } else if (carte instanceof Bataille) {
	        return estDepotAutoriseePourBataille(carte);
	    }
	    return carte instanceof Botte;
	}
	
	private boolean estDepotAutoriseePourBataille(Carte carte) {
		Type carteType = ((Bataille) carte).getType();
		Bataille top;
        if (pileBataille.isEmpty()) {
        	top = ensembleBotte.contains(Cartes.PRIORITAIRE) || carte.equals(Cartes.FEU_ROUGE) ? Cartes.FEU_VERT : Cartes.FEU_ROUGE;
        } else {
        	top = getSommetBataille();
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
	    boolean isPrioritaire = ensembleBotte.contains(Cartes.PRIORITAIRE);
	    if (!pileBataille.isEmpty()) {
	        Carte sommet = getSommetBataille();
	        if (sommet instanceof Parade) {
	        	return !sommet.equals(Cartes.FEU_VERT) && !isPrioritaire;
	        }
	        if (sommet instanceof Attaque && isPrioritaire) {
	            return estBloquePourAttaque(sommet);
	        }
	        return true;
	    } else {
	        return !isPrioritaire;
	    }
	}

	private boolean estBloquePourAttaque(Carte sommet) {
	    if (sommet.equals(Cartes.FEU_ROUGE)) {
	        return false;
	    }
	    for (Botte botte : ensembleBotte) {
	        if (botte.getType() == ((Probleme) sommet).getType()) {
	            return false;
	        }
	    }
	    return true;
	}

	public int donnerLimitationVitesse() {
		return pileLimite.isEmpty() || getSommetLimite() instanceof FinLimite || ensembleBotte.contains(Cartes.PRIORITAIRE) ? 200 : 50;
	}
	
	public int donnerKmParcourus() {
		int distance = 0;
		for(Carte carte: collectionBorne) {
			if(carte instanceof Borne) {
				distance+=((Borne) carte).getKm();
			}
		}
		return distance;
	}
	
	protected boolean deposer(Carte carte) {
		if(carte instanceof Borne) {
			ajouter((Borne)carte);
			return true;
		}else if(carte instanceof Botte) {
			ajouter((Botte)carte);
			Bataille sommet = getSommetBataille();
			Type typeSommet = sommet.getType();
			if(sommet instanceof Attaque && ((Botte) carte).getType() == typeSommet) {
				pileBataille.remove(pileBataille.size()-1);
			}
			return true;
		}else if(carte instanceof DebutLimite) {
			ajouter((DebutLimite)carte);
			return true;
		}else if(carte instanceof FinLimite) {
			ajouter((FinLimite)carte);
			return true;
		}else if(carte instanceof Bataille) {
			ajouter((Bataille)carte);
			return true;
		}
		return false;
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
	
	private Limite getSommetLimite() {
		return pileLimite.get(pileLimite.size()-1);
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
	
	private Bataille getSommetBataille() {
		return pileBataille.get(pileBataille.size()-1);
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
