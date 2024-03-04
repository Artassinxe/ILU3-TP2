package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
	private Carte[] pioche;
	private int capacity;
	private int nbCartes = 0;
	private int nombreOperations = 0;

	public Sabot(int capacity) {
		this.pioche = new Carte[capacity];
		this.capacity = capacity;
	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}

	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private int nombreOperationsReference = nombreOperations;
		private boolean nextEffectue = false;

		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte carte = pioche[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			verificationConcurrence();
			if (nbCartes < 1 || !nextEffectue) {
				throw new IllegalArgumentException();
			}
			for (int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
				pioche[i] = pioche[i + 1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
		}

		private void verificationConcurrence() {
			if (nombreOperations != nombreOperationsReference)
				throw new ConcurrentModificationException();
		}
	}

	public Carte piocher() {
		Iterator<Carte> iterateur = iterator();
		Carte premiereCarte = iterateur.next();
		iterateur.remove();
		return premiereCarte;
	}

	public boolean estVide() {
		return (nbCartes == 0);
	}

	public void ajouterCarte(Carte carte) throws IllegalArgumentException {
		if (nbCartes + 1 > capacity) {
			throw new IllegalArgumentException("Capacité maximale atteinte, impossible d'ajouter une carte.");
		}
		pioche[nbCartes] = carte;
		nbCartes++;
		nombreOperations++;
	}

	public void ajouterFamilleCarte(Carte carte) {
		for (int i = 0; i < carte.nombreCarte; i++) {
			try {
				ajouterCarte(carte);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void ajouterFamilleCarte(Carte... cartes) {
		for (Carte carte : cartes) {
			try {
				ajouterCarte(carte);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNbCartes() {
		return nbCartes;
	}

	public void setNbCartes(int nbCartes) {
		this.nbCartes = nbCartes;
	}

	public Carte[] getPioche() {
		return pioche;
	}

	public void setPioche(Carte[] pioche) {
		this.pioche = pioche;
	}

}
