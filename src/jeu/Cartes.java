package jeu;

import cartes.*;

public interface Cartes {
	Botte PRIORITAIRE = new Botte(1, Type.VITESSE);
	Botte AS_DU_VOLANT = new Botte(1,Type.ACCIDENT);
	Parade FEU_VERT = new Parade(1, Type.FEU);
    Attaque FEU_ROUGE = new Attaque(1, Type.FEU);
    Parade REPARATION = new Parade(1,Type.ACCIDENT);
    Attaque ACCIDENT = new Attaque(1,Type.ACCIDENT);
    Parade ESSENCE = new Parade(1,Type.ESSENCE);
    Attaque PANNE_ESSENCE = new Attaque(1,Type.ESSENCE);
    DebutLimite LIMITE = new DebutLimite(1);
    FinLimite FIN_LIMITE = new FinLimite(1);
}
