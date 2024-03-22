package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import cartes.Carte;

public class MainAsList implements Main {
	
	private ArrayList<Carte> liste;
	
	public MainAsList() {
		this.liste = new ArrayList<>();
	}

	public ArrayList<Carte> getListe() {
		return liste;
	}

	public void setListe(ArrayList<Carte> liste) {
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

}
