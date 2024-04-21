package testFonctionnels;
import jeu.*;
import cartes.*;

public class TestJeu {

	public static void main(String[] args) {
        Jeu jeu = new Jeu();
        
        Joueur jack = new Joueur("Jack");
        Joueur bill = new Joueur("Bill");
        Joueur luffy = new Joueur("Luffy");
        
        jeu.inscrire(jack,bill,luffy);
        
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        
        jeu.remplirSabot(jeuDeCartes);
        jeu.distribuerCartes();
        jeu.lancer();

	} 

}
