package cartes;

import java.util.HashMap;
import java.util.Map;

public class Attaque extends Bataille {

	public Attaque(int nombreCarte, Type type) {
		super(nombreCarte, type);
	}

	private static final Map<Type, String> ATTAQUES;

    static {
    	ATTAQUES = new HashMap<>();
    	ATTAQUES.put(Type.ACCIDENT, "Accident");
    	ATTAQUES.put(Type.CREVAISON, "Crevaison");
    	ATTAQUES.put(Type.ESSENCE, "Panne d'essence");
    	ATTAQUES.put(Type.FEU, "Feu rouge");
    	ATTAQUES.put(Type.VITESSE, "Limite de vitesse");
    }

    @Override
    public String toString() {
        return ATTAQUES.get(getType());
    }

}
