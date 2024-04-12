package cartes;

import java.util.HashMap;
import java.util.Map;

public class Parade extends Bataille {

	public Parade(int nombreCarte, Type type) {
		super(nombreCarte, type);
	}

	private static final Map<Type, String> PARADES;

    static {
    	PARADES = new HashMap<>();
    	PARADES.put(Type.ACCIDENT, "Réparation");
    	PARADES.put(Type.CREVAISON, "Roue de secours");
    	PARADES.put(Type.ESSENCE, "Essence");
    	PARADES.put(Type.FEU, "Feu vert");
    	PARADES.put(Type.VITESSE, "Fin de limite de vitesse");
    }

    @Override
    public String toString() {
        return PARADES.get(getType());
    }


}
