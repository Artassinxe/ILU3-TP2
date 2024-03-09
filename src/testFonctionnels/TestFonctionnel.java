package testFonctionnels;


import java.util.ArrayList;
import java.util.List;

import cartes.*;
import jeu.*;
import utils.*;

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
		
		JeuDeCartes set = new JeuDeCartes();
		System.out.println(set.toString());
		
		
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = jeu.getListeCartes();
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = Utils.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste mélangée sans erreur ? "
		+ Utils.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = Utils.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? " + Utils.verifierRassemblement(listeCartes));

	}
}
