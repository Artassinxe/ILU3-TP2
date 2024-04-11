package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import cartes.Carte;

public class MainAsList implements IMain {
	
	private List<Carte> liste;
	
	public MainAsList() {
		this.liste = new ArrayList<>();
	}

	public List<Carte> getListe() {
		return liste;
	}

	public void setListe(List<Carte> liste) {
		this.liste = liste;
	}

	@Override
	public void prendre(Carte carte) {
		liste.add(carte);
	}

	@Override
	public void jouer(Carte carte) {
		if(liste.contains(carte)) {
			liste.remove(carte);
		}
	}

	@Override
	public Iterator<Carte> iterator() {
		return this.liste.listIterator();
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("[");
	    for (int i = 0; i < liste.size(); i++) {
	        sb.append(liste.get(i));
	        if (i < liste.size() - 1) {
	            sb.append(", ");
	        }
	    }
	    sb.append("]");
	    return sb.toString();
	}


}
