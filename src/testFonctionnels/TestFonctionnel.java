package testFonctionnels;

import cartes.Attaque;
import cartes.Botte;
import cartes.Parade;
import cartes.Type;
import jeu.Sabot;

public class TestFonctionnel {

	public static void main(String[] args) {
		Attaque accident = new Attaque(3, Type.ACCIDENT);
		Parade reparation = new Parade(3, Type.ACCIDENT);
		Botte asDuVolant = new Botte(1, Type.ACCIDENT);
		Sabot sabot = new Sabot(100);

		sabot.ajouterFamilleCarte(accident);
		sabot.ajouterFamilleCarte(reparation);
		sabot.ajouterFamilleCarte(asDuVolant);

		for (int i = 0; i < 7; i++) {
			System.out.println("je pioche " + sabot.piocher().toString() + "\n");
		}

	}
}
