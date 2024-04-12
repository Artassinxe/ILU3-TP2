package testFonctionnels;
import jeu.*;
import cartes.*;

public class TestJeu {

	public static void main(String[] args) {
        Jeu jeu = new Jeu();
        
        Joueur jack = new Joueur("Jack");
        Joueur bill = new Joueur("Bill");
        Joueur luffy = new Joueur("Luffy");
        
        jeu.inscrire(jack);
        jeu.inscrire(bill);
        jeu.inscrire(luffy);
        
        JeuDeCartes jeuDeCartes = new JeuDeCartes();
        System.out.println(jeuDeCartes.toString());
        
        jeu.remplirSabot(jeuDeCartes);
        Sabot sabot = jeu.getSabot();
        System.out.println(sabot.toString());
 
        jeu.distribuerCartes();
        jeu.lancer();

	} 

}
