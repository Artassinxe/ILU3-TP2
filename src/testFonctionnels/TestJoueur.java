package testFonctionnels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cartes.*;
import jeu.*;
import utils.Utils;

public class TestJoueur {
	public static void main(String[] args) {
		StringBuilder strBuilder = new StringBuilder();
		Joueur joueur = new Joueur("Anthony");
		
		Borne borne1 = new Borne(1, 25);
        Borne borne2 = new Borne(1, 25);
        Borne borne3 = new Borne(1, 25);
        Borne borne4 = new Borne(1, 50);
        Borne borne5 = new Borne(1, 50);
        
        joueur.deposer(borne1); 
        joueur.deposer(borne2);
        joueur.deposer(borne3);
        joueur.deposer(borne4);
        joueur.deposer(borne5);
        
        strBuilder.append("Distance parcourue : "+joueur.donnerKmParcourus());
        System.out.println(strBuilder.toString());
	}
}
