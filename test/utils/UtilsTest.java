package utils;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.*;

class UtilsTest {

	@Test
	void test() {
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
		Utils.melanger(liste);
		assertEquals(0,liste.size());
	}

}
