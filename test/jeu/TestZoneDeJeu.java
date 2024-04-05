package jeu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cartes.Attaque;
import cartes.Parade;
import cartes.Type;

public class TestZoneDeJeu {

    private ZoneDeJeu zoneDeJeu;
    private Joueur joueur;

    @BeforeEach
    public void setUp() {
    	joueur = new Joueur("Anthony");
        zoneDeJeu = joueur.getZoneDeJeu();
    }

    @Test
    public void testEstBloque() {
    	
        // Ajouter un feu rouge
        zoneDeJeu.ajouter(Cartes.FEU_ROUGE);
        assertEquals(true, joueur.estBloque());

        // Ajouter un véhicule prioritaire
        zoneDeJeu.ajouter(Cartes.PRIORITAIRE);
        assertEquals(false, joueur.estBloque());

        // Ajouter un accident
        zoneDeJeu.ajouter(new Attaque(1, Type.ACCIDENT));
        assertEquals(true, joueur.estBloque());

        // Ajouter un as du volant
        zoneDeJeu.ajouter(new Parade(1, Type.ACCIDENT));
        assertEquals(false, joueur.estBloque());

        // Ajouter une panne d'essence
        zoneDeJeu.ajouter(new Attaque(1, Type.ESSENCE));
        assertEquals(true, joueur.estBloque());

        // Ajouter de l'essence
        zoneDeJeu.ajouter(new Parade(1, Type.ESSENCE));
        assertEquals(false, joueur.estBloque());

        // Effacer les bottes
        zoneDeJeu.getEnsembleBotte().clear();
        assertEquals(true, joueur.estBloque());

        // Ajouter un feu vert
        zoneDeJeu.ajouter(Cartes.FEU_VERT);
        assertEquals(false, joueur.estBloque());
    }
}
