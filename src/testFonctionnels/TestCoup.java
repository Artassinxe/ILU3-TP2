package testFonctionnels;
import cartes.*;
import jeu.*;

public class TestCoup {

	public static void main(String[] args) {
		DebutLimite carte = new DebutLimite(1);
		FinLimite carte2 = new FinLimite(1);
		Joueur joueur = new Joueur("Anthony");
		Joueur joueur2 = new Joueur("Anthony");
		Coup coup1 = new Coup(carte2,joueur);
		Coup coup2 = new Coup(carte2,joueur2);
		System.out.println(coup1.hashCode());
		System.out.println(coup2.hashCode());
	}

}
