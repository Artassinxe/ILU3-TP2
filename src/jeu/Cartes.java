package jeu;

import cartes.*;

public interface Cartes {
	Botte PRIORITAIRE = new Botte(1, Type.VITESSE);
    Attaque FEU_ROUGE = new Attaque(1, Type.FEU);
    Parade FEU_VERT = new Parade(1, Type.FEU);
}
