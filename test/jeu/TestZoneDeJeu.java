package jeu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cartes.*;

public class TestZoneDeJeu {

    private ZoneDeJeu zoneDeJeu;
    private Joueur joueur;

    @BeforeEach
    public void setUp() {
    	joueur = new Joueur("Anthony");
        zoneDeJeu = joueur.getZoneDeJeu();
    }
    
    @Test
    public void testDistanceParcourue() {

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

        assertEquals(175, joueur.donnerKmParcourus());
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
    
    @Test
    public void testSansLimite() {
        assertEquals(200, joueur.donnerLimitationVitesse());
    }

    @Test
    public void testAvecLimite() {
        zoneDeJeu.ajouter(new DebutLimite(1));
        assertEquals(50, joueur.donnerLimitationVitesse());
    }

    @Test
    public void testAvecFinLimite() {
        zoneDeJeu.ajouter(new FinLimite(1));
        assertEquals(200, joueur.donnerLimitationVitesse());
    }

    @Test
    public void testAvecBottePrioritaire() {
        zoneDeJeu.ajouter(Cartes.PRIORITAIRE);
        assertEquals(200, joueur.donnerLimitationVitesse());
    }
}
