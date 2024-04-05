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
		List<Limite> pileLimite = zoneDeJeu.getPileLimite();
		Set<Botte> ensembleBotte = zoneDeJeu.getEnsembleBotte();
	    if (pileLimite.isEmpty() || (pileLimite.get(pileLimite.size() - 1) instanceof FinLimite) || ensembleBotte.contains(Cartes.PRIORITAIRE)) {
	        return 200;
	    } else {
	        return 50;
	    }
	}
	 
	public boolean estBloque() {
	    List<Bataille> pileBataille = zoneDeJeu.getPileBataille();
	    Set<Botte> ensembleBotte = zoneDeJeu.getEnsembleBotte();
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
    				for (Botte botte : zoneDeJeu.getEnsembleBotte()) {
    			        if (botte.getType() == ((Probleme) sommet).getType()) {
    			            return false;
    			        }
    			    }
	    		}
	    	}
	    	return true;
	    }else return !Boolean.TRUE.equals(isPrioritaire);
	}

	public void ajouter(Limite limite) {
        zoneDeJeu.ajouter(limite);
    }

    public void ajouter(Bataille bataille) {
        zoneDeJeu.ajouter(bataille);
    }

    public void ajouter(Botte botte) {
        zoneDeJeu.ajouter(botte);
    }

    public void ajouter(Borne borne) {
        zoneDeJeu.ajouter(borne);
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
