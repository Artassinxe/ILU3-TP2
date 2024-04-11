package testFonctionnels;
import jeu.*;
import cartes.*;

public class TestJeu {

	public static void main(String[] args) {
        Jeu jeu = new Jeu();
        
        Joueur jack = new Joueur("Jack");
        Joueur bill = new Joueur("Bill");
        
        jeu.inscrire(jack);
        jeu.inscrire(bill);
        
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        jeu.remplirSabot(jeuDeCartes);
        
        jeu.distribuerCartes();
        jeu.jouerTour();

	}

}
