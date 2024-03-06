package cartes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cartes.*;

/**
 * @author antho
 *
 */
class TestCarte {

	@Test
    void testGetSetType() {
        Attaque carte1 = new Attaque(1, Type.FEU);
        assertEquals(Type.FEU, carte1.getType());
        carte1.setType(Type.CREVAISON);
        assertEquals(Type.CREVAISON, carte1.getType());
    }

    @Test
    void testEquals() {
        Attaque carte1 = new Attaque(1, Type.FEU);
        Attaque carte2 = new Attaque(2, Type.FEU);
        Parade carte3 = new Parade(3, Type.FEU);
        Parade carte4 = new Parade(4, Type.CREVAISON);
        Botte carte5 = new Botte(5, Type.CREVAISON);
        Botte carte6 = new Botte(5, Type.ESSENCE);
        DebutLimite carte7 = new DebutLimite(1);
        DebutLimite carte8 = new DebutLimite(2);
        FinLimite carte9 = new FinLimite(3);
        Borne carte10 = new Borne(4,5);
        Borne carte11 = new Borne(6,5);
        Borne carte12 = new Borne(6,6);

        assertEquals(false, carte1.equals(null));
        assertEquals(true, carte1.equals(carte1));
        assertEquals(true, carte1.equals(carte2));

        carte2.setType(Type.ESSENCE);
        assertEquals(false, carte1.equals(carte2));
        assertEquals(false, carte1.equals(carte3));
        assertEquals(false, carte4.equals(carte5));
        assertEquals(false, carte5.equals(carte6));
        
        assertEquals(true, carte7.equals(carte8));
        assertEquals(true, carte7.equals(carte7));
        assertEquals(false, carte7.equals(null));
        assertEquals(false, carte7.equals(carte9));
        
        assertEquals(true, carte10.equals(carte11));
        assertEquals(true, carte10.equals(carte10));
        assertEquals(false, carte10.equals(null));
        assertEquals(false, carte11.equals(carte7));
        assertEquals(false, carte11.equals(carte12));
    }
	
	

}
