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
	
	public Set<Coup> coupsPossibles(Set<Joueur> participants) {
		HashSet<Coup> ensembleCoup = new HashSet<>();
		List<Carte> mainListe = main.getListe();
		for(Carte carte : mainListe) {
			for(Joueur participant : participants) {
				Coup coup = new Coup(carte,participant);
				if(Boolean.TRUE.equals(coup.estValide(this))) ensembleCoup.add(coup);
			}
		}
		return ensembleCoup;
	}
	
	public Set<Coup> coupsDefausse() {
		HashSet<Coup> ensembleCoup = new HashSet<>();
		List<Carte> mainListe = main.getListe();
		for(Carte carte : mainListe) {
			Coup coup = new Coup(carte,null);
			ensembleCoup.add(coup);
		}
		return ensembleCoup;
	}
	
	public Coup choisirCoup(Set<Joueur> participants) {
	    Set<Coup> coupsPossibles = coupsPossibles(participants);

	    if (!coupsPossibles.isEmpty()) {
	        return choisirCoupAleatoire(coupsPossibles);
	    } else {
	        Set<Coup> coupsDefausse = coupsDefausse();
	        return choisirCoupAleatoire(coupsDefausse);
	    }
	}

	private Coup choisirCoupAleatoire(Set<Coup> coups) {
	    int size = coups.size();
	    if (size == 0) {
	    	return null;
	    }
	    int item = new Random().nextInt(size);
	    int i = 0;
	    for (Coup coup : coups) {
	        if (i == item) {
	            return coup;
	        }
	        i++;
	    }
	    return null;
	}
	
	public void retirerDeLaMain(Carte carte) {
		main.jouer(carte);
	}
	
	public void donner(Joueur joueur, Carte carte) {
		MainAsList mainJoueur = joueur.getMain();
		main.jouer(carte);
		mainJoueur.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide()) {
			return null;
		}
		Carte carte = sabot.piocher();
		main.prendre(carte);
		return carte;
	}
	
	public void deposer(Borne borne) {
        Collection<Borne> liste = zoneDeJeu.getCollectionBorne();
        liste.add(borne);
	}
	
	public boolean deposer(Carte carte) {
		return zoneDeJeu.deposer(carte);
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
	public int hashCode() {
    	return nom.hashCode();
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
