package utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import cartes.Carte;
import cartes.JeuDeCartes;

class UtilsTest {

	@Test
	void testExtraire() {
		JeuDeCartes set = new JeuDeCartes();
		List<Carte> liste = set.getListeCartes();
		List<Carte> listeVide = new ArrayList<>();
		int oldSize = liste.size();
		Utils.extraire(liste);
		assertEquals(oldSize-1,liste.size());
		assertEquals(null,Utils.extraire(listeVide));
		Utils.extraireIterator(liste);
		assertEquals(oldSize-2,liste.size());
		assertEquals(null,Utils.extraireIterator(listeVide));
	}
	
	@Test
	void testMelanger() {
		JeuDeCartes set = new JeuDeCartes();
		assertEquals(true,set.checkCount());
		set.setListeCartes((ArrayList<Carte>) Utils.melanger(set.getListeCartes()));
		assertEquals(true,set.checkCount());
		Utils.extraire(set.getListeCartes());
		assertEquals(false,set.checkCount());
	}
	
	@Test
    void testVerifierMelange() {
		List<Integer> liste = new ArrayList<>();
        List<Integer> liste2 = new ArrayList<>();
        assertEquals(true,Utils.verifierMelange(liste, liste2));
        liste = Arrays.asList(0, 0, 0, 0, 0);
        liste2 = Arrays.asList(0, 0, 0, 0, 0);
        assertEquals(true,Utils.verifierMelange(liste, liste2));
        liste = Arrays.asList(0, 2, 0, 2, 0);
        liste2 = Arrays.asList(2, 2, 0, 0, 0);
        assertEquals(true,Utils.verifierMelange(liste, liste2));
        liste = Arrays.asList(0, 2, 0, 2, 0);
        liste2 = Arrays.asList(2, 2, 0);
        assertEquals(false,Utils.verifierMelange(liste, liste2));
        liste = Arrays.asList(0, 2, 0, 2, 0);
        liste2 = Arrays.asList(2, 2, 0, 2, 0);
        assertEquals(false,Utils.verifierMelange(liste, liste2));
    }
	
	@Test
    void testRassemblement() {
        List<Integer> liste = Arrays.asList(0, 0, 0, 0, 0);
        List<Integer> result = Arrays.asList(0, 0, 0, 0, 0);
        assertEquals(result, Utils.rassembler(liste));
        liste = Arrays.asList(0, 1, 2, 3, 4);
        result = Arrays.asList(0, 1, 2, 3, 4);
        assertEquals(result, Utils.rassembler(liste));
        liste = Arrays.asList(0, 0, 1, 1, 2, 2, 2, 1, 3);
        result = Arrays.asList(0, 0, 1, 1, 1, 2, 2, 2, 3);
        assertEquals(result, Utils.rassembler(liste));
        liste = Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3);
        result = Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3);
        assertEquals(result, Utils.rassembler(liste));
        liste = Arrays.asList(2, 0, 3, 1, 2, 3, 2);
        result = Arrays.asList(2, 2, 2, 0, 3, 3, 1);
        assertEquals(result, Utils.rassembler(liste));
    }
	
	@Test
    void testVerifierRassemblement() {
		assertEquals(true, Utils.verifierRassemblement(new ArrayList<>()));
        List<Integer> liste = Arrays.asList(0, 0, 0, 0, 0);
        assertEquals(true, Utils.verifierRassemblement(liste));
        liste = Arrays.asList(0, 1, 2, 3, 4);
        assertEquals(true, Utils.verifierRassemblement(liste));
        liste = Arrays.asList(0, 0, 1, 1, 2, 2, 2, 3, 3);
        assertEquals(true, Utils.verifierRassemblement(liste));
        liste = Arrays.asList(0, 0, 1, 1, 2, 2, 2, 1, 3);
        assertEquals(false, Utils.verifierRassemblement(liste)); 
        liste = Arrays.asList(2, 0, 1, 1, 2, 2, 2, 1, 2);
        assertEquals(false, Utils.verifierRassemblement(liste)); 
        liste = Arrays.asList(2, 0);
        assertEquals(true, Utils.verifierRassemblement(liste)); 
        liste = Arrays.asList(0);
        assertEquals(true, Utils.verifierRassemblement(liste)); 
        liste = Arrays.asList(0,0);
        assertEquals(true, Utils.verifierRassemblement(liste)); 
    }

}
