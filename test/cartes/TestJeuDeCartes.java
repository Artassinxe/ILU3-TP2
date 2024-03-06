package cartes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestJeuDeCartes {

	@Test
	void test() {
		JeuDeCartes set = new JeuDeCartes();
		// Test nombre
		assertEquals(106,set.checkCount());
		assertEquals(20,set.checkCount(Type.FEU));
		assertEquals(10,set.checkCount(Type.ESSENCE));
		assertEquals(10,set.checkCount(Type.CREVAISON));
		assertEquals(10,set.checkCount(Type.ACCIDENT));
		assertEquals(14,set.checkCount(Attaque.class));
		assertEquals(32,set.checkCount(Parade.class));
		assertEquals(46,set.checkCount(Borne.class));
		assertEquals(4,set.checkCount(Botte.class));
		assertEquals(4,set.checkCount(DebutLimite.class));
		assertEquals(6,set.checkCount(FinLimite.class));
	}
}
